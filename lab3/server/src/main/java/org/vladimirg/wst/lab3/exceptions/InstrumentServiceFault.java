package org.vladimirg.wst.lab3.exceptions;

public class InstrumentServiceFault {
    private static final String DEFAULT_MESSAGE = "Instrument identifier cannot be null or empty";

    protected String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static InstrumentServiceFault defaultInstance() {
        InstrumentServiceFault fault = new InstrumentServiceFault();
        fault.message = DEFAULT_MESSAGE;
        return fault;
    }
}
