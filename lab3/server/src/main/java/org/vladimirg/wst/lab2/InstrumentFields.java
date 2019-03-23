package org.vladimirg.wst.lab2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class InstrumentFields {
    private static List<String> validFields = Arrays.asList("ID", "MIC", "ISIN", "validUntil", "derivative");

    public static List<String> getValidFields()
    {
        return validFields;
    }

    private Integer id = null;
    private String MIC = null;
    private String ISIN = null;
    private Date date = null;
    private Boolean derivative = null;

    public InstrumentFields(FieldFilter fieldFilter) throws UnknownFieldsException {
        List<String> unknownFields = fieldFilter.validate(validFields);
        if (!unknownFields.isEmpty()) {
            throw new UnknownFieldsException(unknownFields);
        }
        if (fieldFilter.hasField("ID"))
            id = Integer.parseInt(fieldFilter.getField("ID"));
        if (fieldFilter.hasField("MIC"))
            MIC = fieldFilter.getField("MIC");;
        if (fieldFilter.hasField("ISIN"))
            ISIN = fieldFilter.getField("ISIN");
        if (fieldFilter.hasField("validUntil"))
            try {
                date = (new SimpleDateFormat("yyyy/MM/dd hh:mm:ss Z")).parse(fieldFilter.getField("validUntil"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        if (fieldFilter.hasField("derivative"))
            derivative = Boolean.getBoolean(fieldFilter.getField("derivative"));
    }

    public Integer getId() {
        return id;
    }

    public String getMIC() {
        return MIC;
    }

    public String getISIN() {
        return ISIN;
    }

    public Date getDate() {
        return date;
    }

    public Boolean isDerivative() {
        return derivative;
    }
}
