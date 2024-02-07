package com.faas.core.api.model.ws.operation.details.channel.message.email.dto;

import com.faas.core.base.model.db.client.details.content.dao.ClientEmailDAO;
import com.faas.core.base.model.db.operation.details.channel.OperationEmailMessageDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessEmailTempDBModel;

import java.util.List;

public class ApiOperationEmailChannelWSDTO {

    private ApiEmailAccountWSDTO emailAccount;
    private List<ClientEmailDAO> clientEmails;
    private List<OperationEmailMessageDBModel> operationEmails;
    private List<ProcessEmailTempDBModel>operationEmailTemps;

    public ApiOperationEmailChannelWSDTO() {
    }

    public ApiOperationEmailChannelWSDTO(ApiEmailAccountWSDTO emailAccount, List<ClientEmailDAO> clientEmails, List<OperationEmailMessageDBModel> operationEmails, List<ProcessEmailTempDBModel> operationEmailTemps) {
        this.emailAccount = emailAccount;
        this.clientEmails = clientEmails;
        this.operationEmails = operationEmails;
        this.operationEmailTemps = operationEmailTemps;
    }

    public ApiEmailAccountWSDTO getEmailAccount() {
        return emailAccount;
    }

    public void setEmailAccount(ApiEmailAccountWSDTO emailAccount) {
        this.emailAccount = emailAccount;
    }

    public List<ClientEmailDAO> getClientEmails() {
        return clientEmails;
    }

    public void setClientEmails(List<ClientEmailDAO> clientEmails) {
        this.clientEmails = clientEmails;
    }

    public List<OperationEmailMessageDBModel> getOperationEmails() {
        return operationEmails;
    }

    public void setOperationEmails(List<OperationEmailMessageDBModel> operationEmails) {
        this.operationEmails = operationEmails;
    }

    public List<ProcessEmailTempDBModel> getOperationEmailTemps() {
        return operationEmailTemps;
    }

    public void setOperationEmailTemps(List<ProcessEmailTempDBModel> operationEmailTemps) {
        this.operationEmailTemps = operationEmailTemps;
    }
}
