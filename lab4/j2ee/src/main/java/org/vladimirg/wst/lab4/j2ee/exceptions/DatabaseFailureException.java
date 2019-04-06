package org.vladimirg.wst.lab4.j2ee.exceptions;

public class DatabaseFailureException extends Exception {
    private final InstrumentServiceFault fault;

    public DatabaseFailureException(String message, InstrumentServiceFault fault) {
        super(message);
        this.fault = fault;
    }

    public DatabaseFailureException(String message, InstrumentServiceFault fault, Throwable cause) {
        super(message, cause);
        this.fault = fault;
    }

    public InstrumentServiceFault getFaultInfo() {
        return fault;
    }
}
