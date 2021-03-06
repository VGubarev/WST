
package org.vladimirg.wst.lab3.client.generated;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.7-b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "InstrumentWebService", targetNamespace = "http://lab3.wst.vladimirg.org/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface InstrumentWebService {


    /**
     * 
     * @param filter
     * @return
     *     returns java.util.List<org.vladimirg.wst.lab3.client.generated.Instrument>
     * @throws ThrottleException_Exception
     * @throws DatabaseFailureException_Exception
     * @throws UnknownFieldsException_Exception
     * @throws AuthenticationException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getInstruments", targetNamespace = "http://lab3.wst.vladimirg.org/", className = "org.vladimirg.wst.lab3.client.generated.GetInstruments")
    @ResponseWrapper(localName = "getInstrumentsResponse", targetNamespace = "http://lab3.wst.vladimirg.org/", className = "org.vladimirg.wst.lab3.client.generated.GetInstrumentsResponse")
    @Action(input = "http://lab3.wst.vladimirg.org/InstrumentWebService/getInstrumentsRequest", output = "http://lab3.wst.vladimirg.org/InstrumentWebService/getInstrumentsResponse", fault = {
        @FaultAction(className = UnknownFieldsException_Exception.class, value = "http://lab3.wst.vladimirg.org/InstrumentWebService/getInstruments/Fault/UnknownFieldsException"),
        @FaultAction(className = DatabaseFailureException_Exception.class, value = "http://lab3.wst.vladimirg.org/InstrumentWebService/getInstruments/Fault/DatabaseFailureException"),
        @FaultAction(className = ThrottleException_Exception.class, value = "http://lab3.wst.vladimirg.org/InstrumentWebService/getInstruments/Fault/ThrottleException"),
        @FaultAction(className = AuthenticationException_Exception.class, value = "http://lab3.wst.vladimirg.org/InstrumentWebService/getInstruments/Fault/AuthenticationException")
    })
    public List<Instrument> getInstruments(
        @WebParam(name = "filter", targetNamespace = "")
        FieldFilter filter)
        throws AuthenticationException_Exception, DatabaseFailureException_Exception, ThrottleException_Exception, UnknownFieldsException_Exception
    ;

    /**
     * 
     * @param instrument
     * @return
     *     returns java.lang.Integer
     * @throws ThrottleException_Exception
     * @throws DatabaseFailureException_Exception
     * @throws UnknownFieldsException_Exception
     * @throws AuthenticationException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "createInstrument", targetNamespace = "http://lab3.wst.vladimirg.org/", className = "org.vladimirg.wst.lab3.client.generated.CreateInstrument")
    @ResponseWrapper(localName = "createInstrumentResponse", targetNamespace = "http://lab3.wst.vladimirg.org/", className = "org.vladimirg.wst.lab3.client.generated.CreateInstrumentResponse")
    @Action(input = "http://lab3.wst.vladimirg.org/InstrumentWebService/createInstrumentRequest", output = "http://lab3.wst.vladimirg.org/InstrumentWebService/createInstrumentResponse", fault = {
        @FaultAction(className = UnknownFieldsException_Exception.class, value = "http://lab3.wst.vladimirg.org/InstrumentWebService/createInstrument/Fault/UnknownFieldsException"),
        @FaultAction(className = DatabaseFailureException_Exception.class, value = "http://lab3.wst.vladimirg.org/InstrumentWebService/createInstrument/Fault/DatabaseFailureException"),
        @FaultAction(className = ThrottleException_Exception.class, value = "http://lab3.wst.vladimirg.org/InstrumentWebService/createInstrument/Fault/ThrottleException"),
        @FaultAction(className = AuthenticationException_Exception.class, value = "http://lab3.wst.vladimirg.org/InstrumentWebService/createInstrument/Fault/AuthenticationException")
    })
    public Integer createInstrument(
        @WebParam(name = "instrument", targetNamespace = "")
        FieldFilter instrument)
        throws AuthenticationException_Exception, DatabaseFailureException_Exception, ThrottleException_Exception, UnknownFieldsException_Exception
    ;

    /**
     * 
     * @param filter
     * @return
     *     returns org.vladimirg.wst.lab3.client.generated.OperationStatus
     * @throws IllegalArgumentException_Exception
     * @throws ThrottleException_Exception
     * @throws DatabaseFailureException_Exception
     * @throws UnknownFieldsException_Exception
     * @throws AuthenticationException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "updateInstrument", targetNamespace = "http://lab3.wst.vladimirg.org/", className = "org.vladimirg.wst.lab3.client.generated.UpdateInstrument")
    @ResponseWrapper(localName = "updateInstrumentResponse", targetNamespace = "http://lab3.wst.vladimirg.org/", className = "org.vladimirg.wst.lab3.client.generated.UpdateInstrumentResponse")
    @Action(input = "http://lab3.wst.vladimirg.org/InstrumentWebService/updateInstrumentRequest", output = "http://lab3.wst.vladimirg.org/InstrumentWebService/updateInstrumentResponse", fault = {
        @FaultAction(className = UnknownFieldsException_Exception.class, value = "http://lab3.wst.vladimirg.org/InstrumentWebService/updateInstrument/Fault/UnknownFieldsException"),
        @FaultAction(className = DatabaseFailureException_Exception.class, value = "http://lab3.wst.vladimirg.org/InstrumentWebService/updateInstrument/Fault/DatabaseFailureException"),
        @FaultAction(className = IllegalArgumentException_Exception.class, value = "http://lab3.wst.vladimirg.org/InstrumentWebService/updateInstrument/Fault/IllegalArgumentException"),
        @FaultAction(className = ThrottleException_Exception.class, value = "http://lab3.wst.vladimirg.org/InstrumentWebService/updateInstrument/Fault/ThrottleException"),
        @FaultAction(className = AuthenticationException_Exception.class, value = "http://lab3.wst.vladimirg.org/InstrumentWebService/updateInstrument/Fault/AuthenticationException")
    })
    public OperationStatus updateInstrument(
        @WebParam(name = "filter", targetNamespace = "")
        FieldFilter filter)
        throws AuthenticationException_Exception, DatabaseFailureException_Exception, IllegalArgumentException_Exception, ThrottleException_Exception, UnknownFieldsException_Exception
    ;

    /**
     * 
     * @param filter
     * @return
     *     returns org.vladimirg.wst.lab3.client.generated.OperationStatus
     * @throws IllegalArgumentException_Exception
     * @throws ThrottleException_Exception
     * @throws DatabaseFailureException_Exception
     * @throws UnknownFieldsException_Exception
     * @throws AuthenticationException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "deleteInstrument", targetNamespace = "http://lab3.wst.vladimirg.org/", className = "org.vladimirg.wst.lab3.client.generated.DeleteInstrument")
    @ResponseWrapper(localName = "deleteInstrumentResponse", targetNamespace = "http://lab3.wst.vladimirg.org/", className = "org.vladimirg.wst.lab3.client.generated.DeleteInstrumentResponse")
    @Action(input = "http://lab3.wst.vladimirg.org/InstrumentWebService/deleteInstrumentRequest", output = "http://lab3.wst.vladimirg.org/InstrumentWebService/deleteInstrumentResponse", fault = {
        @FaultAction(className = UnknownFieldsException_Exception.class, value = "http://lab3.wst.vladimirg.org/InstrumentWebService/deleteInstrument/Fault/UnknownFieldsException"),
        @FaultAction(className = DatabaseFailureException_Exception.class, value = "http://lab3.wst.vladimirg.org/InstrumentWebService/deleteInstrument/Fault/DatabaseFailureException"),
        @FaultAction(className = IllegalArgumentException_Exception.class, value = "http://lab3.wst.vladimirg.org/InstrumentWebService/deleteInstrument/Fault/IllegalArgumentException"),
        @FaultAction(className = ThrottleException_Exception.class, value = "http://lab3.wst.vladimirg.org/InstrumentWebService/deleteInstrument/Fault/ThrottleException"),
        @FaultAction(className = AuthenticationException_Exception.class, value = "http://lab3.wst.vladimirg.org/InstrumentWebService/deleteInstrument/Fault/AuthenticationException")
    })
    public OperationStatus deleteInstrument(
        @WebParam(name = "filter", targetNamespace = "")
        FieldFilter filter)
        throws AuthenticationException_Exception, DatabaseFailureException_Exception, IllegalArgumentException_Exception, ThrottleException_Exception, UnknownFieldsException_Exception
    ;

}
