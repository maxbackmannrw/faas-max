package com.faas.core.base.model.ws.campaign.manager.client.dto;

public class CampaignClientRequestDTO {

    private long userId;
    private long clientId;
    private String campaignId;

    public CampaignClientRequestDTO() {
    }

    public CampaignClientRequestDTO(long userId, long clientId, String campaignId) {
        this.userId = userId;
        this.clientId = clientId;
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

    public String getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
    }
}
