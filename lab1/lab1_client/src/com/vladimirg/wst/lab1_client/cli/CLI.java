package com.vladimirg.wst.lab1_client.cli;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import com.vladimirg.wst.lab1_client.Instrument;
import com.vladimirg.wst.lab1_client.InstrumentService;
import com.vladimirg.wst.lab1_client.SQLException_Exception;

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

public class CLI {
    public static void main(String[] args) throws MalformedURLException, SQLException_Exception, ParseException, DatatypeConfigurationException {
        URL url = new URL("http://localhost:8080/InstrumentService?wsdl");
        InstrumentService personService = new InstrumentService(url);

        System.out.println("Get all instruments");
        List<Instrument> instruments = personService.getInstrumentWebServicePort().getAllInstruments();
        instruments.forEach(instrument -> System.out.println(getStringFromInstrument(instrument)));

        System.out.println("Get instruments from London Stock Exchange");
        instruments = personService.getInstrumentWebServicePort().getInstruments(null, "XLON", null, null, null);
        instruments.forEach(instrument -> System.out.println(getStringFromInstrument(instrument)));

        System.out.println("Get instruments valid until 2019 March, 15");
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = format.parse("2019-03-15 10:00:00");

        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);

        XMLGregorianCalendar xmlGregCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
        instruments = personService.getInstrumentWebServicePort().getInstruments(null, null, null, xmlGregCal, null);
        instruments.forEach(instrument -> System.out.println(getStringFromInstrument(instrument)));
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
