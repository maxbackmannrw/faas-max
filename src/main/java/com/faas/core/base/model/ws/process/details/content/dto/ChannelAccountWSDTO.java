package com.faas.core.base.model.ws.process.details.content.dto;

import com.faas.core.base.model.ws.channel.account.dto.EmailAccountWSDTO;
import com.faas.core.base.model.ws.channel.account.dto.PushAccountWSDTO;
import com.faas.core.base.model.ws.channel.account.dto.SmsAccountWSDTO;

import java.util.List;

public class ChannelAccountWSDTO {

    private List<SmsAccountWSDTO> smsAccounts;
    private List<EmailAccountWSDTO> emailAccounts;
    private List<PushAccountWSDTO> pushAccounts;

    public ChannelAccountWSDTO() {
    }

    public ChannelAccountWSDTO(List<SmsAccountWSDTO> smsAccounts, List<EmailAccountWSDTO> emailAccounts, List<PushAccountWSDTO> pushAccounts) {
        this.smsAccounts = smsAccounts;
        this.emailAccounts = emailAccounts;
        this.pushAccounts = pushAccounts;
    }

    public List<SmsAccountWSDTO> getSmsAccounts() {
        return smsAccounts;
    }

    public void setSmsAccounts(List<SmsAccountWSDTO> smsAccounts) {
        this.smsAccounts = smsAccounts;
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
