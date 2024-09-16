package com.faas.core.data.ws.base.campaign.manager.operation;

import java.util.List;

public class CampaignOperationRequest {

    private long userId;
    private long agentId;
    private String campaignId;
    private List<Long> clientIds;

    public CampaignOperationRequest() {
    }

    public CampaignOperationRequest(long userId, long agentId, String campaignId, List<Long> clientIds) {
        this.userId = userId;
        this.agentId = agentId;
        this.campaignId = campaignId;
        this.clientIds = clientIds;
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

    public List<Long> getClientIds() {
        return clientIds;
    }

    public void setClientIds(List<Long> clientIds) {
        this.clientIds = clientIds;
    }
}
