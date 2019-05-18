package org.vladimirg.wst.lab7;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.juddi.api_v3.AccessPointType;
import org.apache.juddi.v3.client.UDDIConstants;
import org.apache.juddi.v3.client.config.UDDIClerk;
import org.apache.juddi.v3.client.config.UDDIClient;
import org.apache.juddi.v3.client.mapping.ServiceLocator;
import org.apache.juddi.v3.client.transport.TransportException;
import org.uddi.api_v3.*;
import org.uddi.v3_service.UDDIInquiryPortType;
import org.uddi.v3_service.UDDISecurityPortType;
import org.vladimirg.wst.lab7.generated.*;
import org.w3c.dom.Document;

import javax.xml.bind.JAXB;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;
import java.io.File;
import java.net.URL;
import java.net.URLConnection;
import java.rmi.RemoteException;
import java.util.*;

import static java.lang.System.exit;

public class JUDDIConnector {
    private UDDIInquiryPortType inquiry;
    private UDDISecurityPortType security;
    private UDDIClerk clerk;

    public JUDDIConnector(String pathToUddiSettings) {
        try {
            UDDIClient uddiClient = new UDDIClient(pathToUddiSettings);
            this.clerk = uddiClient.getClerk("default");

            security = uddiClient.getTransport("default").getUDDISecurityService();
            inquiry = uddiClient.getTransport("default").getUDDIInquiryService();

            if (clerk == null)
                throw new Exception("the clerk wasn't found, check the config file!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private BusinessEntity registerBusiness(String businessName) {
        BusinessEntity businessEntity = new BusinessEntity();
        businessEntity.getName().add(getName(businessName, "En"));
        businessEntity.getDescription().add(getDescription(businessName, "En"));
        BusinessEntity register = clerk.register(businessEntity);
        if (register == null) {
            System.out.println("Error register of business");
            return null;
        }
        String businessKey = register.getBusinessKey();
        System.out.println("business key:  " + businessKey);
        return register;
    }

    private BusinessService registerService(String businessKey, String servName, String URL) {
        BindingTemplate bindingTemplate = new BindingTemplate();
        AccessPoint accessPoint = new AccessPoint();
        accessPoint.setUseType(AccessPointType.END_POINT.toString());
        accessPoint.setValue(URL);
        bindingTemplate.setAccessPoint(accessPoint);

        BindingTemplates bindingTemplates = new BindingTemplates();
        bindingTemplate = UDDIClient.addSOAPtModels(bindingTemplate);
        bindingTemplates.getBindingTemplate().add(bindingTemplate);

        BusinessService businessService = new BusinessService();
        businessService.getName().add(getName(servName, "En"));
        businessService.getDescription().add(getDescription(servName, "En"));
        businessService.setBusinessKey(businessKey);
        businessService.setBindingTemplates(bindingTemplates);

        return clerk.register(businessService);
    }


    public Pair<String, String> publish(String businessName,
                                        String serviceName,
                                        String URL) {
        try {
            BusinessEntity businessEntity = this.registerBusiness(businessName);
            if (businessEntity == null) {
                System.out.println("Error register of business");
                exit(1);
            }

            BusinessService svc = registerService(businessEntity.getBusinessKey(),
                    serviceName,
                    URL);
            if (svc == null) {
                System.out.println("Unrecognized error in business registration");
                exit(1);
            }

            String serviceKey = svc.getServiceKey();
            System.out.println(String.format("ServiceKey %s for service %s", serviceKey, serviceName));

            System.out.println("Service registration is successful.");
            return new ImmutablePair<String, String>(businessEntity.getBusinessKey(), serviceKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private Name getName(String name,
                         String lang) {
        Name busName = new Name();
        busName.setValue(name);
        busName.setLang(lang);
        return busName;
    }

    private Description getDescription(String descr, String lang) {
        Description description = new Description();
        description.setValue(descr);
        description.setLang(lang);
        return description;
    }

    public void removeBusiness(String businessKey) {
        clerk.unRegisterBusiness(businessKey);
    }

    public void findAndCall(String serviceKey) {
        ServiceLocator serviceLocator = new ServiceLocator(clerk);
        try {
            String endpoint = serviceLocator.lookupEndpoint(serviceKey);
            InstrumentService instrumentService = new InstrumentService();
            InstrumentWebService port = instrumentService.getInstrumentWebServicePort();
            Map<String, Object> requestContext = ((BindingProvider) port).getRequestContext();
            requestContext.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpoint);
            Map<String, List<String>> headers = new HashMap<String, List<String>>();
            List<String> credentials = new ArrayList<String>();
            credentials.add(new String(Base64.getEncoder().encode(new String("admin:admin").getBytes())));
            headers.put("Authorization", credentials);
            requestContext.put(MessageContext.HTTP_REQUEST_HEADERS, headers);
            List<Instrument> instruments = port.getInstruments(new FieldFilter());
            System.out.println("Service reply");
            instruments.forEach(instrument -> System.out.println(getStringFromInstrument(instrument)));
            serviceLocator.shutdown();

        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (ConfigurationException e) {
            e.printStackTrace();
        } catch (TransportException e) {
            e.printStackTrace();
        } catch (DatabaseFailureException_Exception e) {
            e.printStackTrace();
        } catch (UnknownFieldsException_Exception e) {
            e.printStackTrace();
        } catch (AuthenticationException_Exception e) {
            e.printStackTrace();
        } catch (ThrottleException_Exception e) {
            e.printStackTrace();
        }
    }

    private static String getStringFromInstrument(Instrument instrument) {
        StringBuilder builder = new StringBuilder();
        builder.append("<instrument>: { ")
                .append("id=").append(instrument.getId())
                .append(", MIC=").append(instrument.getMIC())
                .append(", ISIN=").append(instrument.getISIN())
                .append(", Valid until=").append(instrument.getValidUntil())
                .append(", derivative=").append(instrument.isDerivative())
                .append(" }");
        return builder.toString();
    }
}