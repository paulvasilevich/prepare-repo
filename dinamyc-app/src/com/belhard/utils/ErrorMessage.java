package com.belhard.utils;

public class ErrorMessage {

    private  String errorName;

    private  String errorDescription;

    public  String getErrorName() {
        return errorName;
    }

    public  void setErrorName(String errorName) {
        this.errorName = errorName;
    }

    public  String getErrorDescription() {
        return errorDescription;
    }

    public  void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public ErrorMessage() {
    }

    public ErrorMessage(String errorName, String errorDescription) {
        this.errorName = errorName;
        this.errorDescription = errorDescription;
    }
}
