package org.vladimirg.wst.lab2;

import java.util.List;

public class UnknownFieldsException extends Exception {
    List<String> unknownFields;
    public UnknownFieldsException(List<String> unknown)
    {
        super();
        unknownFields = unknown;
    }

    public List<String> getUnknownFields() {
        return unknownFields;
    }
}
