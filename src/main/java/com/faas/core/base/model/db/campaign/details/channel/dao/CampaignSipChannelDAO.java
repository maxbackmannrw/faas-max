package com.faas.core.base.model.db.campaign.details.channel.dao;

public class CampaignSipChannelDAO {

    private String id;
    private String callerId;
    private String state;
    private long uDate;
    private long cDate;
    private int status;

    public CampaignSipChannelDAO() {
    }

    public CampaignSipChannelDAO(String id, String callerId, String state, long uDate, long cDate, int status) {
        this.id = id;
        this.callerId = callerId;
        this.state = state;
        this.uDate = uDate;
        this.cDate = cDate;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCallerId() {
        return callerId;
    }

    public void setCallerId(String callerId) {
        this.callerId = callerId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getuDate() {
        return uDate;
    }

    public void setuDate(long uDate) {
        this.uDate = uDate;
    }

    public long getcDate() {
        return cDate;
    }

    public void setcDate(long cDate) {
        this.cDate = cDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
