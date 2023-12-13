package com.faas.core.base.model.ws.process.details.channel.temp.dto;


import java.util.List;

public class ProcessTempWSDTO {

    private List<ProcessEmailTempWSDTO> emailTemps;
    private List<ProcessPushTempWSDTO>pushTemps;
    private List<ProcessSmsMessageTempWSDTO>smsMessageTemps;
    private List<ProcessWappMessageTempWSDTO>wappMessageTemps;

    public ProcessTempWSDTO() {
    }

    public ProcessTempWSDTO(List<ProcessEmailTempWSDTO> emailTemps, List<ProcessPushTempWSDTO> pushTemps, List<ProcessSmsMessageTempWSDTO> smsMessageTemps, List<ProcessWappMessageTempWSDTO> wappMessageTemps) {
        this.emailTemps = emailTemps;
        this.pushTemps = pushTemps;
        this.smsMessageTemps = smsMessageTemps;
        this.wappMessageTemps = wappMessageTemps;
    }

    public List<ProcessEmailTempWSDTO> getEmailTemps() {
        return emailTemps;
    }

    public void setEmailTemps(List<ProcessEmailTempWSDTO> emailTemps) {
        this.emailTemps = emailTemps;
    }

    public List<ProcessPushTempWSDTO> getPushTemps() {
        return pushTemps;
    }

    public void setPushTemps(List<ProcessPushTempWSDTO> pushTemps) {
        this.pushTemps = pushTemps;
    }

    public List<ProcessSmsMessageTempWSDTO> getSmsMessageTemps() {
        return smsMessageTemps;
    }

    public void setSmsMessageTemps(List<ProcessSmsMessageTempWSDTO> smsMessageTemps) {
        this.smsMessageTemps = smsMessageTemps;
    }

    public List<ProcessWappMessageTempWSDTO> getWappMessageTemps() {
        return wappMessageTemps;
    }

    public void setWappMessageTemps(List<ProcessWappMessageTempWSDTO> wappMessageTemps) {
        this.wappMessageTemps = wappMessageTemps;
    }
}
