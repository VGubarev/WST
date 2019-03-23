
package org.vladimirg.wst.lab3.client.generated;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.7-b01 
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "IllegalArgumentException", targetNamespace = "http://lab3.wst.vladimirg.org/")
public class IllegalArgumentException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private IllegalArgumentException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public IllegalArgumentException_Exception(String message, IllegalArgumentException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public IllegalArgumentException_Exception(String message, IllegalArgumentException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: org.vladimirg.wst.lab3.client.generated.IllegalArgumentException
     */
    public IllegalArgumentException getFaultInfo() {
        return faultInfo;
    }

}
