package com.faas.core.base.model.ws.remoteapp.content.dto;

public class RemoteAppSummaryWSDTO {

    private long totalConnCount;
    private long waitingConnCount;
    private long activeConnCount;
    private long failedConnCount;

    public RemoteAppSummaryWSDTO() {
    }

    public RemoteAppSummaryWSDTO(long totalConnCount, long waitingConnCount, long activeConnCount, long failedConnCount) {
        this.totalConnCount = totalConnCount;
        this.waitingConnCount = waitingConnCount;
        this.activeConnCount = activeConnCount;
        this.failedConnCount = failedConnCount;
    }

    public long getTotalConnCount() {
        return totalConnCount;
    }

    public void setTotalConnCount(long totalConnCount) {
        this.totalConnCount = totalConnCount;
    }

    public long getWaitingConnCount() {
        return waitingConnCount;
    }

    public void setWaitingConnCount(long waitingConnCount) {
        this.waitingConnCount = waitingConnCount;
    }

    public long getActiveConnCount() {
        return activeConnCount;
    }

    public void setActiveConnCount(long activeConnCount) {
        this.activeConnCount = activeConnCount;
    }

    public long getFailedConnCount() {
        return failedConnCount;
    }

    public void setFailedConnCount(long failedConnCount) {
        this.failedConnCount = failedConnCount;
    }
}

