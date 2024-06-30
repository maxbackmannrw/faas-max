package com.faas.core.base.model.ws.campaign.details.channel.content.dto;

public class CampaignChannelWSDTO {

    private CampaignWappChannelWSDTO wappChannel;
    private CampaignSipChannelWSDTO sipChannel;
    private CampaignSmsChannelWSDTO smsChannel;
    private CampaignEmailChannelWSDTO emailChannel;
    private CampaignPushChannelWSDTO pushChannel;

    public CampaignChannelWSDTO() {
    }

    public CampaignChannelWSDTO(CampaignWappChannelWSDTO wappChannel, CampaignSipChannelWSDTO sipChannel, CampaignSmsChannelWSDTO smsChannel, CampaignEmailChannelWSDTO emailChannel, CampaignPushChannelWSDTO pushChannel) {
        this.wappChannel = wappChannel;
        this.sipChannel = sipChannel;
        this.smsChannel = smsChannel;
        this.emailChannel = emailChannel;
        this.pushChannel = pushChannel;
    }

    public CampaignWappChannelWSDTO getWappChannel() {
        return wappChannel;
    }

    public void setWappChannel(CampaignWappChannelWSDTO wappChannel) {
        this.wappChannel = wappChannel;
    }

    public CampaignSipChannelWSDTO getSipChannel() {
        return sipChannel;
    }

    public void setSipChannel(CampaignSipChannelWSDTO sipChannel) {
        this.sipChannel = sipChannel;
    }

    public CampaignSmsChannelWSDTO getSmsChannel() {
        return smsChannel;
    }

    public void setSmsChannel(CampaignSmsChannelWSDTO smsChannel) {
        this.smsChannel = smsChannel;
    }

    public CampaignEmailChannelWSDTO getEmailChannel() {
        return emailChannel;
    }

    public void setEmailChannel(CampaignEmailChannelWSDTO emailChannel) {
        this.emailChannel = emailChannel;
    }

    public CampaignPushChannelWSDTO getPushChannel() {
        return pushChannel;
    }

    public void setPushChannel(CampaignPushChannelWSDTO pushChannel) {
        this.pushChannel = pushChannel;
    }
}
