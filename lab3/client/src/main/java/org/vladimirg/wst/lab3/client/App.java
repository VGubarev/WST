package org.vladimirg.wst.lab3.client;

import org.vladimirg.wst.lab3.client.generated.*;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@SuppressWarnings("Duplicates")
public class App {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:8080/InstrumentService?wsdl");
        InstrumentService personService = new InstrumentService(url);

        {
            System.out.println("Get all instruments");
            FieldFilter filter = new FieldFilter();
            List<Instrument> instruments = null;
            try {
                instruments = personService.getInstrumentWebServicePort().getInstruments(filter);
                instruments.forEach(instrument -> System.out.println(getStringFromInstrument(instrument)));
            } catch (DatabaseFailureException_Exception | UnknownFieldsException_Exception | ThrottleException_Exception e) {
                System.out.println(e.getMessage());
            }
        }

        {
            System.out.println("Get instruments from London Stock Exchange");
            FieldFilter filter = new FieldFilter();
            FieldFilter.Fields fields = new FieldFilter.Fields();
            FieldFilter.Fields.Entry entry = new FieldFilter.Fields.Entry();
            entry.setKey("MIC");
            entry.setValue("XLON");
            fields.getEntry().add(entry);
            filter.setFields(fields);
            try {
                List<Instrument> instruments = personService.getInstrumentWebServicePort().getInstruments(filter);
                instruments.forEach(instrument -> System.out.println(getStringFromInstrument(instrument)));
            } catch (DatabaseFailureException_Exception | UnknownFieldsException_Exception | ThrottleException_Exception e) {
                System.out.println(e.getMessage());
            }
        }


        {
            System.out.println("Test exceptions");
            FieldFilter filter = new FieldFilter();
            FieldFilter.Fields fields = new FieldFilter.Fields();
            FieldFilter.Fields.Entry entry = new FieldFilter.Fields.Entry();
            entry.setKey("INVALIDFIELD");
            entry.setValue("XLON");
            fields.getEntry().add(entry);
            filter.setFields(fields);
            try {
                List<Instrument> instruments = personService.getInstrumentWebServicePort().getInstruments(filter);
                instruments.forEach(instrument -> System.out.println(getStringFromInstrument(instrument)));
            } catch (DatabaseFailureException_Exception | UnknownFieldsException_Exception | ThrottleException_Exception e) {
                System.out.println(e.getMessage());
            }
        }

        Integer res = -1;
        {
            System.out.println("Insert instrument");
            FieldFilter instrument = new FieldFilter();
            FieldFilter.Fields fields = new FieldFilter.Fields();

            {
                FieldFilter.Fields.Entry entry = new FieldFilter.Fields.Entry();
                entry.setKey("MIC");
                entry.setValue("XHON");
                fields.getEntry().add(entry);
            }
            {
                FieldFilter.Fields.Entry entry = new FieldFilter.Fields.Entry();
                entry.setKey("ISIN");
                entry.setValue("FAFAFAF");
                fields.getEntry().add(entry);
            }
            {
                FieldFilter.Fields.Entry entry = new FieldFilter.Fields.Entry();
                entry.setKey("validUntil");
                entry.setValue("2035/12/11 05:06:07 +0000");
                fields.getEntry().add(entry);
            }
            {
                FieldFilter.Fields.Entry entry = new FieldFilter.Fields.Entry();
                entry.setKey("derivative");
                entry.setValue("false");
                fields.getEntry().add(entry);
            }

            instrument.setFields(fields);
            try {
                res = personService.getInstrumentWebServicePort().createInstrument(instrument);
                System.out.println("Inserted instrument with ID=" + res);
            } catch (DatabaseFailureException_Exception | UnknownFieldsException_Exception | ThrottleException_Exception e) {
                System.out.println(e.getMessage());
            }
        }

        {
            System.out.println("Get all instruments");
            FieldFilter filter = new FieldFilter();
            try {
                List<Instrument> instruments = personService.getInstrumentWebServicePort().getInstruments(filter);

                instruments.forEach(instrument -> System.out.println(getStringFromInstrument(instrument)));
            } catch (DatabaseFailureException_Exception | UnknownFieldsException_Exception | ThrottleException_Exception e) {
                System.out.println(e.getMessage());
            }
        }

        {
            System.out.println("Update instrument");
            FieldFilter instrument = new FieldFilter();
            FieldFilter.Fields fields = new FieldFilter.Fields();

            {
                FieldFilter.Fields.Entry entry = new FieldFilter.Fields.Entry();
                entry.setKey("ID");
                entry.setValue(res.toString());
                fields.getEntry().add(entry);
            }
            {
                FieldFilter.Fields.Entry entry = new FieldFilter.Fields.Entry();
                entry.setKey("MIC");
                entry.setValue("XABC");
                fields.getEntry().add(entry);
            }

            instrument.setFields(fields);
            try {
                OperationStatus status = personService.getInstrumentWebServicePort().updateInstrument(instrument);
                System.out.println("Updated instrument with ID=" + res + ", status=" + printStatus(status));
            } catch (DatabaseFailureException_Exception | UnknownFieldsException_Exception | IllegalArgumentException_Exception | ThrottleException_Exception e) {
                System.out.println(e.getMessage());
            }
        }

        {
            System.out.println("Get all instruments");
            FieldFilter filter = new FieldFilter();
            try {
                List<Instrument> instruments = personService.getInstrumentWebServicePort().getInstruments(filter);

                instruments.forEach(instrument -> System.out.println(getStringFromInstrument(instrument)));
            } catch (DatabaseFailureException_Exception | UnknownFieldsException_Exception | ThrottleException_Exception e) {
                System.out.println(e.getMessage());
            }
        }

        {
            System.out.println("Delete instrument");
            FieldFilter instrument = new FieldFilter();
            FieldFilter.Fields fields = new FieldFilter.Fields();

            {
                FieldFilter.Fields.Entry entry = new FieldFilter.Fields.Entry();
                entry.setKey("ID");
                entry.setValue(res.toString());
                fields.getEntry().add(entry);
            }

            instrument.setFields(fields);
            try {
                OperationStatus status = personService.getInstrumentWebServicePort().deleteInstrument(instrument);
                System.out.println("Deleted instrument with ID=" + res + ", status=" + printStatus(status));
            } catch (DatabaseFailureException_Exception | UnknownFieldsException_Exception | IllegalArgumentException_Exception | ThrottleException_Exception e) {
                System.out.println(e.getMessage());
            }
        }

        {
            System.out.println("Get all instruments");
            FieldFilter filter = new FieldFilter();
            try {
                List<Instrument> instruments = personService.getInstrumentWebServicePort().getInstruments(filter);

                instruments.forEach(instrument -> System.out.println(getStringFromInstrument(instrument)));
            } catch (DatabaseFailureException_Exception | UnknownFieldsException_Exception | ThrottleException_Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static String printStatus(OperationStatus status) {
        return "[success=" + status.isSuccess() + (status.getError() != null ? ", text=" + status.getError() : "") + "]";
    }

    private static String getStringFromInstrument(Instrument instrument) {
        StringBuilder builder = new StringBuilder();
        builder.append("<instrument>: { ")
                .append("id=").append(instrument.getId())
                .append(", MIC=").append(instrument.getMIC())
                .append(", ISIN=").append(instrument.getISIN())
                .append(", Valid until=").append(instrument.getValidUntil())
                .append(", derivative=").append(instrument.isDerivative())
                .append(" }");
        return builder.toString();
    }
}
