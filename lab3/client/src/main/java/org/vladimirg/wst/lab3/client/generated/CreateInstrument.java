
package org.vladimirg.wst.lab3.client.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for createInstrument complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="createInstrument">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="instrument" type="{http://lab3.wst.vladimirg.org/}fieldFilter" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createInstrument", propOrder = {
    "instrument"
})
public class CreateInstrument {

    protected FieldFilter instrument;

    /**
     * Gets the value of the instrument property.
     * 
     * @return
     *     possible object is
     *     {@link FieldFilter }
     *     
     */
    public FieldFilter getInstrument() {
        return instrument;
    }

    /**
     * Sets the value of the instrument property.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldFilter }
     *     
     */
    public void setInstrument(FieldFilter value) {
        this.instrument = value;
    }

}
