package com.faas.core.base.model.ws.process.details.channel.temp.dto;


import java.util.List;

public class ProcessTempWSDTO {

    private List<EmailTempWSDTO> emailTemps;
    private List<PushTempWSDTO>pushTemps;
    private List<SmsMessageTempWSDTO>smsMessageTemps;
    private List<WappMessageTempWSDTO>wappMessageTemps;

    public ProcessTempWSDTO() {
    }

    public ProcessTempWSDTO(List<EmailTempWSDTO> emailTemps, List<PushTempWSDTO> pushTemps, List<SmsMessageTempWSDTO> smsMessageTemps, List<WappMessageTempWSDTO> wappMessageTemps) {
        this.emailTemps = emailTemps;
        this.pushTemps = pushTemps;
        this.smsMessageTemps = smsMessageTemps;
        this.wappMessageTemps = wappMessageTemps;
    }

    public List<EmailTempWSDTO> getEmailTemps() {
        return emailTemps;
    }

    public void setEmailTemps(List<EmailTempWSDTO> emailTemps) {
        this.emailTemps = emailTemps;
    }

    public List<PushTempWSDTO> getPushTemps() {
        return pushTemps;
    }

    public void setPushTemps(List<PushTempWSDTO> pushTemps) {
        this.pushTemps = pushTemps;
    }

    public List<SmsMessageTempWSDTO> getSmsMessageTemps() {
        return smsMessageTemps;
    }

    public void setSmsMessageTemps(List<SmsMessageTempWSDTO> smsMessageTemps) {
        this.smsMessageTemps = smsMessageTemps;
    }

    public List<WappMessageTempWSDTO> getWappMessageTemps() {
        return wappMessageTemps;
    }

    public void setWappMessageTemps(List<WappMessageTempWSDTO> wappMessageTemps) {
        this.wappMessageTemps = wappMessageTemps;
    }
}
