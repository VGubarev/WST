package org.vladimirg.wst.lab4.standalone.exceptions;

import java.util.List;

public class UnknownFieldsException extends Exception {
    private final InstrumentServiceFault fault;

    public UnknownFieldsException(String message, InstrumentServiceFault fault) {
        super(message);
        this.fault = fault;
    }

    public UnknownFieldsException(String message, InstrumentServiceFault fault, Throwable cause) {
        super(message, cause);
        this.fault = fault;
    }

    public InstrumentServiceFault getFaultInfo() {
        return fault;
    }
}
