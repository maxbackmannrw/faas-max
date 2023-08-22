package com.faas.core.base.model.ws.process.details.channel.content.dto;

public class ProcessChannelWSDTO {

    private ProcessWappChannelWSDTO wappChannel;
    private ProcessSipChannelWSDTO sipChannel;
    private ProcessSmsChannelWSDTO smsChannel;
    private ProcessEmailChannelWSDTO emailChannel;
    private ProcessPushChannelWSDTO pushChannel;

    public ProcessChannelWSDTO() {
    }

    public ProcessChannelWSDTO(ProcessWappChannelWSDTO wappChannel, ProcessSipChannelWSDTO sipChannel, ProcessSmsChannelWSDTO smsChannel, ProcessEmailChannelWSDTO emailChannel, ProcessPushChannelWSDTO pushChannel) {
        this.wappChannel = wappChannel;
        this.sipChannel = sipChannel;
        this.smsChannel = smsChannel;
        this.emailChannel = emailChannel;
        this.pushChannel = pushChannel;
    }

    public ProcessWappChannelWSDTO getWappChannel() {
        return wappChannel;
    }

    public void setWappChannel(ProcessWappChannelWSDTO wappChannel) {
        this.wappChannel = wappChannel;
    }

    public ProcessSipChannelWSDTO getSipChannel() {
        return sipChannel;
    }

    public void setSipChannel(ProcessSipChannelWSDTO sipChannel) {
        this.sipChannel = sipChannel;
    }

    public ProcessSmsChannelWSDTO getSmsChannel() {
        return smsChannel;
    }

    public void setSmsChannel(ProcessSmsChannelWSDTO smsChannel) {
        this.smsChannel = smsChannel;
    }

    public ProcessEmailChannelWSDTO getEmailChannel() {
        return emailChannel;
    }

    public void setEmailChannel(ProcessEmailChannelWSDTO emailChannel) {
        this.emailChannel = emailChannel;
    }

    public ProcessPushChannelWSDTO getPushChannel() {
        return pushChannel;
    }

    public void setPushChannel(ProcessPushChannelWSDTO pushChannel) {
        this.pushChannel = pushChannel;
    }
}
