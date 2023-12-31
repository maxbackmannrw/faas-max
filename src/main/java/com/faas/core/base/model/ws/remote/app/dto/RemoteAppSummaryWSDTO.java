package com.faas.core.base.model.ws.remote.app.dto;

public class RemoteAppSummaryWSDTO {

    private long totalRemoteApps;
    private long waitingRemoteApps;
    private long readyRemoteApps;
    private long failedRemoteApps;

    public RemoteAppSummaryWSDTO() {
    }

    public RemoteAppSummaryWSDTO(long totalRemoteApps, long waitingRemoteApps, long readyRemoteApps, long failedRemoteApps) {
        this.totalRemoteApps = totalRemoteApps;
        this.waitingRemoteApps = waitingRemoteApps;
        this.readyRemoteApps = readyRemoteApps;
        this.failedRemoteApps = failedRemoteApps;
    }

    public long getTotalRemoteApps() {
        return totalRemoteApps;
    }

    public void setTotalRemoteApps(long totalRemoteApps) {
        this.totalRemoteApps = totalRemoteApps;
    }

    public long getWaitingRemoteApps() {
        return waitingRemoteApps;
    }

    public void setWaitingRemoteApps(long waitingRemoteApps) {
        this.waitingRemoteApps = waitingRemoteApps;
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

