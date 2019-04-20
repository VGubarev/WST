package org.vladimirg.wst.lab5.client;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Instrument {
    private Integer id;
    private String MIC;
    private String ISIN;
    private Date validUntil;
    private Boolean derivative;

    public Integer getId() { return id; }

    public Instrument setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getMIC() {
        return MIC;
    }

    public Instrument setMIC(String MIC) {
        this.MIC = MIC;
        return this;
    }

    public String getISIN() {
        return ISIN;
    }

    public Instrument setISIN(String ISIN) {
        this.ISIN = ISIN;
        return this;
    }

    public Date getValidUntil() {
        return validUntil;
    }

    public Instrument setValidUntil(Date validUntil) {
        this.validUntil = validUntil;
        return this;
    }

    public Boolean getDerivative() {
        return derivative;
    }

    public Instrument setDerivative(Boolean derivative) {
        this.derivative = derivative;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("<instrument>: { ")
                .append("id=").append(id)
                .append(", MIC=").append(MIC)
                .append(", ISIN=").append(ISIN)
                .append(", Validity Date=").append(validUntil)
                .append(", derivative=").append(derivative)
                .append(" }");
        return builder.toString();
    }
}
