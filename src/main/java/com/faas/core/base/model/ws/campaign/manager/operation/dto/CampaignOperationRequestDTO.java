package com.faas.core.base.model.ws.campaign.manager.operation.dto;

public class CampaignOperationRequestDTO {

    private long userId;
    private long agentId;
    private String campaignId;
    private long clientId;

    public CampaignOperationRequestDTO() {
    }

    public CampaignOperationRequestDTO(long userId, long agentId, String campaignId, long clientId) {
        this.userId = userId;
        this.agentId = agentId;
        this.campaignId = campaignId;
        this.clientId = clientId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }
}
