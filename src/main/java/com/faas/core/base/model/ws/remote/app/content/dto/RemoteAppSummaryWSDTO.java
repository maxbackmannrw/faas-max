package com.faas.core.base.model.ws.remote.app.content.dto;

public class RemoteAppSummaryWSDTO {

    private long totalRemoteApps;
    private long newRemoteApps;
    private long readyRemoteApps;
    private long failedRemoteApps;

    public RemoteAppSummaryWSDTO() {
    }

    public RemoteAppSummaryWSDTO(long totalRemoteApps, long newRemoteApps, long readyRemoteApps, long failedRemoteApps) {
        this.totalRemoteApps = totalRemoteApps;
        this.newRemoteApps = newRemoteApps;
        this.readyRemoteApps = readyRemoteApps;
        this.failedRemoteApps = failedRemoteApps;
    }

    public long getTotalRemoteApps() {
        return totalRemoteApps;
    }

    public void setTotalRemoteApps(long totalRemoteApps) {
        this.totalRemoteApps = totalRemoteApps;
    }

    public long getNewRemoteApps() {
        return newRemoteApps;
    }

    public void setNewRemoteApps(long newRemoteApps) {
        this.newRemoteApps = newRemoteApps;
    }

    public long getReadyRemoteApps() {
        return readyRemoteApps;
    }

    public void setReadyRemoteApps(long readyRemoteApps) {
        this.readyRemoteApps = readyRemoteApps;
    }

    public long getFailedRemoteApps() {
        return failedRemoteApps;
    }

    public void setFailedRemoteApps(long failedRemoteApps) {
        this.failedRemoteApps = failedRemoteApps;
    }
}

