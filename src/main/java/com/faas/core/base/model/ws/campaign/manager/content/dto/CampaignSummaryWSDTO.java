package com.faas.core.base.model.ws.campaign.manager.content.dto;

public class CampaignSummaryWSDTO {

    private long readyOperationCount;
    private long activeOperationCount;
    private long totalOperationCount;
    private long totalAgentCount;

    public CampaignSummaryWSDTO() {
    }

    public CampaignSummaryWSDTO(long readyOperationCount, long activeOperationCount, long totalOperationCount, long totalAgentCount) {
        this.readyOperationCount = readyOperationCount;
        this.activeOperationCount = activeOperationCount;
        this.totalOperationCount = totalOperationCount;
        this.totalAgentCount = totalAgentCount;
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

    public long getTotalAgentCount() {
        return totalAgentCount;
    }

    public void setTotalAgentCount(long totalAgentCount) {
        this.totalAgentCount = totalAgentCount;
    }
}
