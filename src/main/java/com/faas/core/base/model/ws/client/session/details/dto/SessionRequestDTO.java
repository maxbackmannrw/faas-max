package com.faas.core.base.model.ws.client.session.details.dto;

public class SessionRequestDTO {

    private long userId;
    private long clientId;
    private long agentId;
    private String campaignId;

    public SessionRequestDTO() {
    }

    public SessionRequestDTO(long userId, long clientId, long agentId, String campaignId) {
        this.userId = userId;
        this.clientId = clientId;
        this.agentId = agentId;
        this.campaignId = campaignId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public long getAgentId() {
        return agentId;
    }

    public void setAgentId(long agentId) {
        this.agentId = agentId;
    }

    public String getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
    }
}
