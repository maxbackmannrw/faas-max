package com.faas.core.base.model.ws.channel.account.dto;


import java.util.List;

public class ChannelAccountWSDTO {

    private List<SipAccountWSDTO>sipAccounts;
    private List<SmsAccountWSDTO>smsAccounts;
    private List<WappAccountWSDTO>wappAccounts;
    private List<EmailAccountWSDTO>emailAccounts;
    private List<PushAccountWSDTO>pushAccounts;

    public ChannelAccountWSDTO() {
    }

    public ChannelAccountWSDTO(List<SipAccountWSDTO> sipAccounts, List<SmsAccountWSDTO> smsAccounts, List<WappAccountWSDTO> wappAccounts, List<EmailAccountWSDTO> emailAccounts, List<PushAccountWSDTO> pushAccounts) {
        this.sipAccounts = sipAccounts;
        this.smsAccounts = smsAccounts;
        this.wappAccounts = wappAccounts;
        this.emailAccounts = emailAccounts;
        this.pushAccounts = pushAccounts;
    }

    public List<SipAccountWSDTO> getSipAccounts() {
        return sipAccounts;
    }

    public void setSipAccounts(List<SipAccountWSDTO> sipAccounts) {
        this.sipAccounts = sipAccounts;
    }

    public List<SmsAccountWSDTO> getSmsAccounts() {
        return smsAccounts;
    }

    public void setSmsAccounts(List<SmsAccountWSDTO> smsAccounts) {
        this.smsAccounts = smsAccounts;
    }

    public List<WappAccountWSDTO> getWappAccounts() {
        return wappAccounts;
    }

    public void setWappAccounts(List<WappAccountWSDTO> wappAccounts) {
        this.wappAccounts = wappAccounts;
    }

    public List<EmailAccountWSDTO> getEmailAccounts() {
        return emailAccounts;
    }

    public void setEmailAccounts(List<EmailAccountWSDTO> emailAccounts) {
        this.emailAccounts = emailAccounts;
    }

    public List<PushAccountWSDTO> getPushAccounts() {
        return pushAccounts;
    }

    public void setPushAccounts(List<PushAccountWSDTO> pushAccounts) {
        this.pushAccounts = pushAccounts;
    }
}
