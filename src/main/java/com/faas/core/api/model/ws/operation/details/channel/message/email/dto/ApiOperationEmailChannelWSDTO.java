package com.faas.core.api.model.ws.operation.details.channel.message.email.dto;

import com.faas.core.base.model.db.client.details.content.dao.ClientEmailDAO;
import com.faas.core.base.model.db.operation.details.channel.OperationEmailMessageDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessEmailTempDBModel;

import java.util.List;

public class ApiOperationEmailChannelWSDTO {

    private List<ClientEmailDAO> clientEmails;
    private ApiOperationEmailAccountWSDTO emailAccount;
    private List<ProcessEmailTempDBModel>operationEmailTemps;
    private List<OperationEmailMessageDBModel> operationEmails;

    public ApiOperationEmailChannelWSDTO() {
    }

    public ApiOperationEmailChannelWSDTO(List<ClientEmailDAO> clientEmails, ApiOperationEmailAccountWSDTO emailAccount, List<ProcessEmailTempDBModel> operationEmailTemps, List<OperationEmailMessageDBModel> operationEmails) {
        this.clientEmails = clientEmails;
        this.emailAccount = emailAccount;
        this.operationEmailTemps = operationEmailTemps;
        this.operationEmails = operationEmails;
    }

    public List<ClientEmailDAO> getClientEmails() {
        return clientEmails;
    }

    public void setClientEmails(List<ClientEmailDAO> clientEmails) {
        this.clientEmails = clientEmails;
    }

    public ApiOperationEmailAccountWSDTO getEmailAccount() {
        return emailAccount;
    }

    public void setEmailAccount(ApiOperationEmailAccountWSDTO emailAccount) {
        this.emailAccount = emailAccount;
    }

    public List<ProcessEmailTempDBModel> getOperationEmailTemps() {
        return operationEmailTemps;
    }

    public void setOperationEmailTemps(List<ProcessEmailTempDBModel> operationEmailTemps) {
        this.operationEmailTemps = operationEmailTemps;
    }

    public List<OperationEmailMessageDBModel> getOperationEmails() {
        return operationEmails;
    }

    public void setOperationEmails(List<OperationEmailMessageDBModel> operationEmails) {
        this.operationEmails = operationEmails;
    }
}
