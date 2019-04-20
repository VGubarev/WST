package org.vladimirg.wst.lab5.standalone.exceptions;

public class IllegalArgumentException extends Exception {
    private static final long serialVersionUID = -6647544772732631047L;
    public static IllegalArgumentException DEFAULT_INSTANCE = new
            IllegalArgumentException("Invalid argument");
    public IllegalArgumentException(String message) {
        super(message);
    }
}
