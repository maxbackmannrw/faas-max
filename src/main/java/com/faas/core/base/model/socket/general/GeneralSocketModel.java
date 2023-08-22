package com.faas.core.base.model.socket.general;

public class GeneralSocketModel {

    private int status;
    private String statusCode;
    private String operation;


    public GeneralSocketModel() {
    }

    public GeneralSocketModel(int status, String statusCode, String operation) {
        this.status = status;
        this.statusCode = statusCode;
        this.operation = operation;
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
