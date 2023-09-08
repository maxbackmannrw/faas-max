package com.faas.core.base.model.ws.client.session.content.dto;

public class SessionRequestDTO {

    private long userId;
    private String campaignId;
    private long clientId;
    private long agentId;

    public SessionRequestDTO() {
    }

    public SessionRequestDTO(long userId, String campaignId, long clientId, long agentId) {
        this.userId = userId;
        this.campaignId = campaignId;
        this.clientId = clientId;
        this.agentId = agentId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
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
}
