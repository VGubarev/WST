package org.vladimirg.wst.lab2;

public class OperationStatus {
    public boolean success;
    public String error;

    public OperationStatus()
    {
        success = true;
        error = null;
    }

    public OperationStatus(boolean success, String error)
    {
        this.success = success;
        this.error = error;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getError() {
        return error;
    }
}
