
package com.vladimirg.wst.lab1_ee.client.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.vladimirg.wst.lab1_ee.client.generated package. 
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

    private final static QName _SQLException_QNAME = new QName("http://lab1_ee.wst.vladimirg.com/", "SQLException");
    private final static QName _GetAllInstruments_QNAME = new QName("http://lab1_ee.wst.vladimirg.com/", "getAllInstruments");
    private final static QName _GetInstruments_QNAME = new QName("http://lab1_ee.wst.vladimirg.com/", "getInstruments");
    private final static QName _GetInstrumentsResponse_QNAME = new QName("http://lab1_ee.wst.vladimirg.com/", "getInstrumentsResponse");
    private final static QName _GetAllInstrumentsResponse_QNAME = new QName("http://lab1_ee.wst.vladimirg.com/", "getAllInstrumentsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.vladimirg.wst.lab1_ee.client.generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAllInstrumentsResponse }
     * 
     */
    public GetAllInstrumentsResponse createGetAllInstrumentsResponse() {
        return new GetAllInstrumentsResponse();
    }

    /**
     * Create an instance of {@link GetInstrumentsResponse }
     * 
     */
    public GetInstrumentsResponse createGetInstrumentsResponse() {
        return new GetInstrumentsResponse();
    }

    /**
     * Create an instance of {@link GetAllInstruments }
     * 
     */
    public GetAllInstruments createGetAllInstruments() {
        return new GetAllInstruments();
    }

    /**
     * Create an instance of {@link GetInstruments }
     * 
     */
    public GetInstruments createGetInstruments() {
        return new GetInstruments();
    }

    /**
     * Create an instance of {@link SQLException }
     * 
     */
    public SQLException createSQLException() {
        return new SQLException();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link Throwable }
     * 
     */
    public Throwable createThrowable() {
        return new Throwable();
    }

    /**
     * Create an instance of {@link Instrument }
     * 
     */
    public Instrument createInstrument() {
        return new Instrument();
    }

    /**
     * Create an instance of {@link SqlException }
     * 
     */
    public SqlException createSqlException() {
        return new SqlException();
    }

    /**
     * Create an instance of {@link StackTraceElement }
     * 
     */
    public StackTraceElement createStackTraceElement() {
        return new StackTraceElement();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SQLException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab1_ee.wst.vladimirg.com/", name = "SQLException")
    public JAXBElement<SQLException> createSQLException(SQLException value) {
        return new JAXBElement<SQLException>(_SQLException_QNAME, SQLException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllInstruments }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab1_ee.wst.vladimirg.com/", name = "getAllInstruments")
    public JAXBElement<GetAllInstruments> createGetAllInstruments(GetAllInstruments value) {
        return new JAXBElement<GetAllInstruments>(_GetAllInstruments_QNAME, GetAllInstruments.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInstruments }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab1_ee.wst.vladimirg.com/", name = "getInstruments")
    public JAXBElement<GetInstruments> createGetInstruments(GetInstruments value) {
        return new JAXBElement<GetInstruments>(_GetInstruments_QNAME, GetInstruments.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInstrumentsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab1_ee.wst.vladimirg.com/", name = "getInstrumentsResponse")
    public JAXBElement<GetInstrumentsResponse> createGetInstrumentsResponse(GetInstrumentsResponse value) {
        return new JAXBElement<GetInstrumentsResponse>(_GetInstrumentsResponse_QNAME, GetInstrumentsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllInstrumentsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab1_ee.wst.vladimirg.com/", name = "getAllInstrumentsResponse")
    public JAXBElement<GetAllInstrumentsResponse> createGetAllInstrumentsResponse(GetAllInstrumentsResponse value) {
        return new JAXBElement<GetAllInstrumentsResponse>(_GetAllInstrumentsResponse_QNAME, GetAllInstrumentsResponse.class, null, value);
    }

}
