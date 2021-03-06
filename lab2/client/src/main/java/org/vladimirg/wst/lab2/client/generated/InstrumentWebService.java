
package org.vladimirg.wst.lab2.client.generated;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.7-b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "InstrumentWebService", targetNamespace = "http://lab2.wst.vladimirg.org/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface InstrumentWebService {


    /**
     * 
     * @param filter
     * @return
     *     returns java.util.List<org.vladimirg.wst.lab2.client.generated.Instrument>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getInstruments", targetNamespace = "http://lab2.wst.vladimirg.org/", className = "org.vladimirg.wst.lab2.client.generated.GetInstruments")
    @ResponseWrapper(localName = "getInstrumentsResponse", targetNamespace = "http://lab2.wst.vladimirg.org/", className = "org.vladimirg.wst.lab2.client.generated.GetInstrumentsResponse")
    @Action(input = "http://lab2.wst.vladimirg.org/InstrumentWebService/getInstrumentsRequest", output = "http://lab2.wst.vladimirg.org/InstrumentWebService/getInstrumentsResponse")
    public List<Instrument> getInstruments(
        @WebParam(name = "filter", targetNamespace = "")
        FieldFilter filter);

    /**
     * 
     * @param instrument
     * @return
     *     returns java.lang.Integer
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "createInstrument", targetNamespace = "http://lab2.wst.vladimirg.org/", className = "org.vladimirg.wst.lab2.client.generated.CreateInstrument")
    @ResponseWrapper(localName = "createInstrumentResponse", targetNamespace = "http://lab2.wst.vladimirg.org/", className = "org.vladimirg.wst.lab2.client.generated.CreateInstrumentResponse")
    @Action(input = "http://lab2.wst.vladimirg.org/InstrumentWebService/createInstrumentRequest", output = "http://lab2.wst.vladimirg.org/InstrumentWebService/createInstrumentResponse")
    public Integer createInstrument(
        @WebParam(name = "instrument", targetNamespace = "")
        FieldFilter instrument);

    /**
     * 
     * @param filter
     * @return
     *     returns org.vladimirg.wst.lab2.client.generated.OperationStatus
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "updateInstrument", targetNamespace = "http://lab2.wst.vladimirg.org/", className = "org.vladimirg.wst.lab2.client.generated.UpdateInstrument")
    @ResponseWrapper(localName = "updateInstrumentResponse", targetNamespace = "http://lab2.wst.vladimirg.org/", className = "org.vladimirg.wst.lab2.client.generated.UpdateInstrumentResponse")
    @Action(input = "http://lab2.wst.vladimirg.org/InstrumentWebService/updateInstrumentRequest", output = "http://lab2.wst.vladimirg.org/InstrumentWebService/updateInstrumentResponse")
    public OperationStatus updateInstrument(
        @WebParam(name = "filter", targetNamespace = "")
        FieldFilter filter);

    /**
     * 
     * @param filter
     * @return
     *     returns org.vladimirg.wst.lab2.client.generated.OperationStatus
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "deleteInstrument", targetNamespace = "http://lab2.wst.vladimirg.org/", className = "org.vladimirg.wst.lab2.client.generated.DeleteInstrument")
    @ResponseWrapper(localName = "deleteInstrumentResponse", targetNamespace = "http://lab2.wst.vladimirg.org/", className = "org.vladimirg.wst.lab2.client.generated.DeleteInstrumentResponse")
    @Action(input = "http://lab2.wst.vladimirg.org/InstrumentWebService/deleteInstrumentRequest", output = "http://lab2.wst.vladimirg.org/InstrumentWebService/deleteInstrumentResponse")
    public OperationStatus deleteInstrument(
        @WebParam(name = "filter", targetNamespace = "")
        FieldFilter filter);

    /**
     * 
     * @param filter
     * @param message
     * @return
     *     returns org.vladimirg.wst.lab2.client.generated.OperationStatus
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "uploadMessage", targetNamespace = "http://lab2.wst.vladimirg.org/", className = "org.vladimirg.wst.lab2.client.generated.UploadMessage")
    @ResponseWrapper(localName = "uploadMessageResponse", targetNamespace = "http://lab2.wst.vladimirg.org/", className = "org.vladimirg.wst.lab2.client.generated.UploadMessageResponse")
    @Action(input = "http://lab2.wst.vladimirg.org/InstrumentWebService/uploadMessageRequest", output = "http://lab2.wst.vladimirg.org/InstrumentWebService/uploadMessageResponse")
    public OperationStatus uploadMessage(
        @WebParam(name = "filter", targetNamespace = "")
        FieldFilter filter,
        @WebParam(name = "message", targetNamespace = "")
        byte[] message);

}
