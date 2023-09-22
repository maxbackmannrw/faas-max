package com.faas.core.base.model.db.client.inquiry;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "client_inquiry_table")
public class ClientInquiryDBModel {

    @Id
    private String id;
    private long sessionId;
    private long clientId;
    private String inquiryState;
    private long uDate;
    private long cDate;
    private int status;

    public ClientInquiryDBModel() {
    }

    public ClientInquiryDBModel(String id, long sessionId, long clientId, String inquiryState, long uDate, long cDate, int status) {
        this.id = id;
        this.sessionId = sessionId;
        this.clientId = clientId;
        this.inquiryState = inquiryState;
        this.uDate = uDate;
        this.cDate = cDate;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getSessionId() {
        return sessionId;
    }

    public void setSessionId(long sessionId) {
        this.sessionId = sessionId;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public String getInquiryState() {
        return inquiryState;
    }

    public void setInquiryState(String inquiryState) {
        this.inquiryState = inquiryState;
    }

    public long getuDate() {
        return uDate;
    }

    public void setuDate(long uDate) {
        this.uDate = uDate;
    }

    public long getcDate() {
        return cDate;
    }

    public void setcDate(long cDate) {
        this.cDate = cDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
