
package org.vladimirg.wst.lab2.client.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.vladimirg.wst.lab2.client.generated package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CreateInstrument_QNAME = new QName("http://lab2.wst.vladimirg.org/", "createInstrument");
    private final static QName _DeleteInstrumentResponse_QNAME = new QName("http://lab2.wst.vladimirg.org/", "deleteInstrumentResponse");
    private final static QName _UpdateInstrument_QNAME = new QName("http://lab2.wst.vladimirg.org/", "updateInstrument");
    private final static QName _UpdateInstrumentResponse_QNAME = new QName("http://lab2.wst.vladimirg.org/", "updateInstrumentResponse");
    private final static QName _UploadMessageResponse_QNAME = new QName("http://lab2.wst.vladimirg.org/", "uploadMessageResponse");
    private final static QName _DeleteInstrument_QNAME = new QName("http://lab2.wst.vladimirg.org/", "deleteInstrument");
    private final static QName _UploadMessage_QNAME = new QName("http://lab2.wst.vladimirg.org/", "uploadMessage");
    private final static QName _GetInstruments_QNAME = new QName("http://lab2.wst.vladimirg.org/", "getInstruments");
    private final static QName _CreateInstrumentResponse_QNAME = new QName("http://lab2.wst.vladimirg.org/", "createInstrumentResponse");
    private final static QName _GetInstrumentsResponse_QNAME = new QName("http://lab2.wst.vladimirg.org/", "getInstrumentsResponse");
    private final static QName _UploadMessageMessage_QNAME = new QName("", "message");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.vladimirg.wst.lab2.client.generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FieldFilter }
     * 
     */
    public FieldFilter createFieldFilter() {
        return new FieldFilter();
    }

    /**
     * Create an instance of {@link FieldFilter.Fields }
     * 
     */
    public FieldFilter.Fields createFieldFilterFields() {
        return new FieldFilter.Fields();
    }

    /**
     * Create an instance of {@link CreateInstrumentResponse }
     * 
     */
    public CreateInstrumentResponse createCreateInstrumentResponse() {
        return new CreateInstrumentResponse();
    }

    /**
     * Create an instance of {@link GetInstrumentsResponse }
     * 
     */
    public GetInstrumentsResponse createGetInstrumentsResponse() {
        return new GetInstrumentsResponse();
    }

    /**
     * Create an instance of {@link UploadMessage }
     * 
     */
    public UploadMessage createUploadMessage() {
        return new UploadMessage();
    }

    /**
     * Create an instance of {@link GetInstruments }
     * 
     */
    public GetInstruments createGetInstruments() {
        return new GetInstruments();
    }

    /**
     * Create an instance of {@link DeleteInstrument }
     * 
     */
    public DeleteInstrument createDeleteInstrument() {
        return new DeleteInstrument();
    }

    /**
     * Create an instance of {@link UpdateInstrument }
     * 
     */
    public UpdateInstrument createUpdateInstrument() {
        return new UpdateInstrument();
    }

    /**
     * Create an instance of {@link UpdateInstrumentResponse }
     * 
     */
    public UpdateInstrumentResponse createUpdateInstrumentResponse() {
        return new UpdateInstrumentResponse();
    }

    /**
     * Create an instance of {@link UploadMessageResponse }
     * 
     */
    public UploadMessageResponse createUploadMessageResponse() {
        return new UploadMessageResponse();
    }

    /**
     * Create an instance of {@link DeleteInstrumentResponse }
     * 
     */
    public DeleteInstrumentResponse createDeleteInstrumentResponse() {
        return new DeleteInstrumentResponse();
    }

    /**
     * Create an instance of {@link CreateInstrument }
     * 
     */
    public CreateInstrument createCreateInstrument() {
        return new CreateInstrument();
    }

    /**
     * Create an instance of {@link OperationStatus }
     * 
     */
    public OperationStatus createOperationStatus() {
        return new OperationStatus();
    }

    /**
     * Create an instance of {@link Instrument }
     * 
     */
    public Instrument createInstrument() {
        return new Instrument();
    }

    /**
     * Create an instance of {@link FieldFilter.Fields.Entry }
     * 
     */
    public FieldFilter.Fields.Entry createFieldFilterFieldsEntry() {
        return new FieldFilter.Fields.Entry();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateInstrument }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab2.wst.vladimirg.org/", name = "createInstrument")
    public JAXBElement<CreateInstrument> createCreateInstrument(CreateInstrument value) {
        return new JAXBElement<CreateInstrument>(_CreateInstrument_QNAME, CreateInstrument.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteInstrumentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab2.wst.vladimirg.org/", name = "deleteInstrumentResponse")
    public JAXBElement<DeleteInstrumentResponse> createDeleteInstrumentResponse(DeleteInstrumentResponse value) {
        return new JAXBElement<DeleteInstrumentResponse>(_DeleteInstrumentResponse_QNAME, DeleteInstrumentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateInstrument }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab2.wst.vladimirg.org/", name = "updateInstrument")
    public JAXBElement<UpdateInstrument> createUpdateInstrument(UpdateInstrument value) {
        return new JAXBElement<UpdateInstrument>(_UpdateInstrument_QNAME, UpdateInstrument.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateInstrumentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab2.wst.vladimirg.org/", name = "updateInstrumentResponse")
    public JAXBElement<UpdateInstrumentResponse> createUpdateInstrumentResponse(UpdateInstrumentResponse value) {
        return new JAXBElement<UpdateInstrumentResponse>(_UpdateInstrumentResponse_QNAME, UpdateInstrumentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UploadMessageResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab2.wst.vladimirg.org/", name = "uploadMessageResponse")
    public JAXBElement<UploadMessageResponse> createUploadMessageResponse(UploadMessageResponse value) {
        return new JAXBElement<UploadMessageResponse>(_UploadMessageResponse_QNAME, UploadMessageResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteInstrument }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab2.wst.vladimirg.org/", name = "deleteInstrument")
    public JAXBElement<DeleteInstrument> createDeleteInstrument(DeleteInstrument value) {
        return new JAXBElement<DeleteInstrument>(_DeleteInstrument_QNAME, DeleteInstrument.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UploadMessage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab2.wst.vladimirg.org/", name = "uploadMessage")
    public JAXBElement<UploadMessage> createUploadMessage(UploadMessage value) {
        return new JAXBElement<UploadMessage>(_UploadMessage_QNAME, UploadMessage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInstruments }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab2.wst.vladimirg.org/", name = "getInstruments")
    public JAXBElement<GetInstruments> createGetInstruments(GetInstruments value) {
        return new JAXBElement<GetInstruments>(_GetInstruments_QNAME, GetInstruments.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateInstrumentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab2.wst.vladimirg.org/", name = "createInstrumentResponse")
    public JAXBElement<CreateInstrumentResponse> createCreateInstrumentResponse(CreateInstrumentResponse value) {
        return new JAXBElement<CreateInstrumentResponse>(_CreateInstrumentResponse_QNAME, CreateInstrumentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInstrumentsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab2.wst.vladimirg.org/", name = "getInstrumentsResponse")
    public JAXBElement<GetInstrumentsResponse> createGetInstrumentsResponse(GetInstrumentsResponse value) {
        return new JAXBElement<GetInstrumentsResponse>(_GetInstrumentsResponse_QNAME, GetInstrumentsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "message", scope = UploadMessage.class)
    public JAXBElement<byte[]> createUploadMessageMessage(byte[] value) {
        return new JAXBElement<byte[]>(_UploadMessageMessage_QNAME, byte[].class, UploadMessage.class, ((byte[]) value));
    }

}
