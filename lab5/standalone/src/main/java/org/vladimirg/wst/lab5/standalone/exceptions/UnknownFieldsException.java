package org.vladimirg.wst.lab5.standalone.exceptions;

import java.util.List;

public class UnknownFieldsException extends Exception {
    private static final long serialVersionUID = -6647544772732631047L;
    public static UnknownFieldsException DEFAULT_INSTANCE = new
            UnknownFieldsException("Invalid argument");
    public UnknownFieldsException(String message) {
        super(message);
    }
}
