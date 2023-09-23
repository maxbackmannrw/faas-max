package com.faas.core.base.model.ws.general;

public class GeneralWSModel {

    private int statusCode;
    private String status;
    private String operation;
    private String result;

    public GeneralWSModel() {
    }

    public GeneralWSModel(int statusCode, String status, String operation, String result) {
        this.statusCode = statusCode;
        this.status = status;
        this.operation = operation;
        this.result = result;
    }


    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
