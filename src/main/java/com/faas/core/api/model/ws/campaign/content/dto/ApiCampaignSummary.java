package com.faas.core.api.model.ws.campaign.content.dto;


public class ApiCampaignSummary {

    private long readyOperationCount;
    private long activeOperationCount;
    private long totalOperationCount;

    public ApiCampaignSummary() {
    }

    public ApiCampaignSummary(long readyOperationCount, long activeOperationCount, long totalOperationCount) {
        this.readyOperationCount = readyOperationCount;
        this.activeOperationCount = activeOperationCount;
        this.totalOperationCount = totalOperationCount;
    }

    public long getReadyOperationCount() {
        return readyOperationCount;
    }

    public void setReadyOperationCount(long readyOperationCount) {
        this.readyOperationCount = readyOperationCount;
    }

    public long getActiveOperationCount() {
        return activeOperationCount;
    }

    public void setActiveOperationCount(long activeOperationCount) {
        this.activeOperationCount = activeOperationCount;
    }

    public long getTotalOperationCount() {
        return totalOperationCount;
    }

    public void setTotalOperationCount(long totalOperationCount) {
        this.totalOperationCount = totalOperationCount;
    }
}
