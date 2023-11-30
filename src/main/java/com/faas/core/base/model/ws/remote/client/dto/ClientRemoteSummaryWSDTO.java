package com.faas.core.base.model.ws.remote.client.dto;

public class ClientRemoteSummaryWSDTO {

    private long totalRemote;
    private long readyRemote;
    private long activeRemote;
    private long terminatedRemote;

    public ClientRemoteSummaryWSDTO() {
    }

    public ClientRemoteSummaryWSDTO(long totalRemote, long readyRemote, long activeRemote, long terminatedRemote) {
        this.totalRemote = totalRemote;
        this.readyRemote = readyRemote;
        this.activeRemote = activeRemote;
        this.terminatedRemote = terminatedRemote;
    }

    public long getTotalRemote() {
        return totalRemote;
    }

    public void setTotalRemote(long totalRemote) {
        this.totalRemote = totalRemote;
    }

    public long getReadyRemote() {
        return readyRemote;
    }

    public void setReadyRemote(long readyRemote) {
        this.readyRemote = readyRemote;
    }

    public long getActiveRemote() {
        return activeRemote;
    }

    public void setActiveRemote(long activeRemote) {
        this.activeRemote = activeRemote;
    }

    public long getTerminatedRemote() {
        return terminatedRemote;
    }

    public void setTerminatedRemote(long terminatedRemote) {
        this.terminatedRemote = terminatedRemote;
    }
}

