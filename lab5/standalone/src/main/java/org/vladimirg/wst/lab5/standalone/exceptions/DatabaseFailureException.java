package org.vladimirg.wst.lab5.standalone.exceptions;

public class DatabaseFailureException extends Exception {
    private static final long serialVersionUID = -6647544772732631047L;
    public static DatabaseFailureException DEFAULT_INSTANCE = new
            DatabaseFailureException("Database failure");
    public DatabaseFailureException(String message) {
        super(message);
    }
}
