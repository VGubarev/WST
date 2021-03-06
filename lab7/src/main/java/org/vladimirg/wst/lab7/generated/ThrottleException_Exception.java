
package org.vladimirg.wst.lab7.generated;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "ThrottleException", targetNamespace = "http://lab3.wst.vladimirg.org/")
public class ThrottleException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private ThrottleException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public ThrottleException_Exception(String message, ThrottleException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public ThrottleException_Exception(String message, ThrottleException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: org.vladimirg.wst.lab7.generated.ThrottleException
     */
    public ThrottleException getFaultInfo() {
        return faultInfo;
    }

}
