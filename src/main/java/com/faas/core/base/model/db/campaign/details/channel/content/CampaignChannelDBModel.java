package com.faas.core.base.model.db.campaign.details.channel.content;

import com.faas.core.base.model.db.campaign.details.channel.content.dao.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "campaign_channel_table")
public class CampaignChannelDBModel {

    @Id
    private String id;
    private String campaignId;
    private CampaignWappChannelDAO wappChannel;
    private CampaignSmsChannelDAO smsChannel;
    private CampaignSipChannelDAO sipChannel;
    private CampaignEmailChannelDAO emailChannel;
    private CampaignPushChannelDAO pushChannel;
    private long uDate;
    private long cDate;
    private int status;

    public CampaignChannelDBModel() {
    }

    public CampaignChannelDBModel(String id, String campaignId, CampaignWappChannelDAO wappChannel, CampaignSmsChannelDAO smsChannel, CampaignSipChannelDAO sipChannel, CampaignEmailChannelDAO emailChannel, CampaignPushChannelDAO pushChannel, long uDate, long cDate, int status) {
        this.id = id;
        this.campaignId = campaignId;
        this.wappChannel = wappChannel;
        this.smsChannel = smsChannel;
        this.sipChannel = sipChannel;
        this.emailChannel = emailChannel;
        this.pushChannel = pushChannel;
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

    public String getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
    }

    public CampaignWappChannelDAO getWappChannel() {
        return wappChannel;
    }

    public void setWappChannel(CampaignWappChannelDAO wappChannel) {
        this.wappChannel = wappChannel;
    }

    public CampaignSmsChannelDAO getSmsChannel() {
        return smsChannel;
    }

    public void setSmsChannel(CampaignSmsChannelDAO smsChannel) {
        this.smsChannel = smsChannel;
    }

    public CampaignSipChannelDAO getSipChannel() {
        return sipChannel;
    }

    public void setSipChannel(CampaignSipChannelDAO sipChannel) {
        this.sipChannel = sipChannel;
    }

    public CampaignEmailChannelDAO getEmailChannel() {
        return emailChannel;
    }

    public void setEmailChannel(CampaignEmailChannelDAO emailChannel) {
        this.emailChannel = emailChannel;
    }

    public CampaignPushChannelDAO getPushChannel() {
        return pushChannel;
    }

    public void setPushChannel(CampaignPushChannelDAO pushChannel) {
        this.pushChannel = pushChannel;
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
