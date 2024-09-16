package com.faas.core.data.ws.api.agent.details.dto;

public class ApiAgentInfoWSDTO {

    private long readySession;
    private long activeSession;
    private long readyInquiry;
    private long activeInquiry;

    public ApiAgentInfoWSDTO() {
    }

    public ApiAgentInfoWSDTO(long readySession, long activeSession, long readyInquiry, long activeInquiry) {
        this.readySession = readySession;
        this.activeSession = activeSession;
        this.readyInquiry = readyInquiry;
        this.activeInquiry = activeInquiry;
    }

    public long getReadySession() {
        return readySession;
    }

    public void setReadySession(long readySession) {
        this.readySession = readySession;
    }

    public long getActiveSession() {
        return activeSession;
    }

    public void setActiveSession(long activeSession) {
        this.activeSession = activeSession;
    }

    public long getReadyInquiry() {
        return readyInquiry;
    }

    public void setReadyInquiry(long readyInquiry) {
        this.readyInquiry = readyInquiry;
    }

    public long getActiveInquiry() {
        return activeInquiry;
    }

    public void setActiveInquiry(long activeInquiry) {
        this.activeInquiry = activeInquiry;
    }
}
