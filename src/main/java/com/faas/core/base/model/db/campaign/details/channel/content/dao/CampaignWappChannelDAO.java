package com.faas.core.base.model.db.campaign.details.channel.content.dao;

public class CampaignWappChannelDAO {

    private String id;
    private String callState;
    private String messageState;
    private long uDate;
    private long cDate;
    private int status;

    public CampaignWappChannelDAO() {
    }

    public CampaignWappChannelDAO(String id, String callState, String messageState, long uDate, long cDate, int status) {
        this.id = id;
        this.callState = callState;
        this.messageState = messageState;
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

    public String getCallState() {
        return callState;
    }

    public void setCallState(String callState) {
        this.callState = callState;
    }

    public String getMessageState() {
        return messageState;
    }

    public void setMessageState(String messageState) {
        this.messageState = messageState;
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
