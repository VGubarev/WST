package org.vladimirg.wst.lab2;

import java.util.Arrays;
import java.util.Date;

public class Instrument {
    private Integer id;
    private String MIC;
    private String ISIN;
    private Date validUntil;
    private Boolean derivative;
    private byte[] message;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMIC() {
        return MIC;
    }

    public void setMIC(String MIC) {
        this.MIC = MIC;
    }

    public String getISIN() {
        return ISIN;
    }

    public void setISIN(String ISIN) {
        this.ISIN = ISIN;
    }

    public Date getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(Date validUntil) {
        this.validUntil = validUntil;
    }

    public Boolean getDerivative() {
        return derivative;
    }

    public void setDerivative(Boolean derivative) {
        this.derivative = derivative;
    }

    public byte[] getMessage() { return message; }

    public void setMessage(byte[] message) { this.message = message; }

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
