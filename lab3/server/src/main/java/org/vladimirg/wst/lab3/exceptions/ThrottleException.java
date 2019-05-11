package org.vladimirg.wst.lab3.exceptions;

public class ThrottleException extends Exception {
    private final InstrumentServiceFault fault;

    public ThrottleException(String message, InstrumentServiceFault fault) {
        super(message);
        this.fault = fault;
    }

    public ThrottleException(String message, InstrumentServiceFault fault, Throwable cause) {
        super(message, cause);
        this.fault = fault;
    }

    public InstrumentServiceFault getFaultInfo() {
        return fault;
    }
}
