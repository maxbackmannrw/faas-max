package com.faas.core.api.model.ws.operation.channel.message.email.dto;

import com.faas.core.base.model.db.client.details.ClientEmailDBModel;
import com.faas.core.base.model.db.operation.details.channel.OperationEmailMessageDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessEmailTempDBModel;

import java.util.List;

public class ApiOperationEmailWSDTO {

    private ApiEmailAccountWSDTO emailAccount;
    private List<ClientEmailDBModel>emails;
    private List<OperationEmailMessageDBModel> emailMessages;
    private List<ProcessEmailTempDBModel>emailTemps;

    public ApiOperationEmailWSDTO() {
    }

    public ApiOperationEmailWSDTO(ApiEmailAccountWSDTO emailAccount, List<ClientEmailDBModel> emails, List<OperationEmailMessageDBModel> emailMessages, List<ProcessEmailTempDBModel> emailTemps) {
        this.emailAccount = emailAccount;
        this.emails = emails;
        this.emailMessages = emailMessages;
        this.emailTemps = emailTemps;
    }

    public ApiEmailAccountWSDTO getEmailAccount() {
        return emailAccount;
    }

    public void setEmailAccount(ApiEmailAccountWSDTO emailAccount) {
        this.emailAccount = emailAccount;
    }

    public List<ClientEmailDBModel> getEmails() {
        return emails;
    }

    public void setEmails(List<ClientEmailDBModel> emails) {
        this.emails = emails;
    }

    public List<OperationEmailMessageDBModel> getEmailMessages() {
        return emailMessages;
    }

    public void setEmailMessages(List<OperationEmailMessageDBModel> emailMessages) {
        this.emailMessages = emailMessages;
    }

    public List<ProcessEmailTempDBModel> getEmailTemps() {
        return emailTemps;
    }

    public void setEmailTemps(List<ProcessEmailTempDBModel> emailTemps) {
        this.emailTemps = emailTemps;
    }
}
