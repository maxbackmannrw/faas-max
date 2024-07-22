package com.faas.core.base.model.ws.remoteapp.content.dto;

public class RemoteAppSummaryWSDTO {

    private long totalClientRemotes;
    private long newClientRemotes;
    private long readyClientRemotes;
    private long failedClientRemotes;

    public RemoteAppSummaryWSDTO() {
    }

    public RemoteAppSummaryWSDTO(long totalClientRemotes, long newClientRemotes, long readyClientRemotes, long failedClientRemotes) {
        this.totalClientRemotes = totalClientRemotes;
        this.newClientRemotes = newClientRemotes;
        this.readyClientRemotes = readyClientRemotes;
        this.failedClientRemotes = failedClientRemotes;
    }

    public long getTotalClientRemotes() {
        return totalClientRemotes;
    }

    public void setTotalClientRemotes(long totalClientRemotes) {
        this.totalClientRemotes = totalClientRemotes;
    }

    public long getNewClientRemotes() {
        return newClientRemotes;
    }

    public void setNewClientRemotes(long newClientRemotes) {
        this.newClientRemotes = newClientRemotes;
    }

    public long getReadyClientRemotes() {
        return readyClientRemotes;
    }

    public void setReadyClientRemotes(long readyClientRemotes) {
        this.readyClientRemotes = readyClientRemotes;
    }

    public long getFailedClientRemotes() {
        return failedClientRemotes;
    }

    public void setFailedClientRemotes(long failedClientRemotes) {
        this.failedClientRemotes = failedClientRemotes;
    }
}

