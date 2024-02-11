package com.faas.core.api.model.ws.operation.details.channel.message.email.dto;

import com.faas.core.base.model.db.client.details.content.dao.ClientEmailDAO;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessEmailTempDBModel;

import java.util.List;

public class ApiOperationEmailTempWSDTO {

    private List<ClientEmailDAO> clientEmails;
    private ApiEmailAccountWSDTO emailAccount;
    private List<ProcessEmailTempDBModel>operationEmailTemps;

    public ApiOperationEmailTempWSDTO() {
    }

    public ApiOperationEmailTempWSDTO(List<ClientEmailDAO> clientEmails, ApiEmailAccountWSDTO emailAccount, List<ProcessEmailTempDBModel> operationEmailTemps) {
        this.clientEmails = clientEmails;
        this.emailAccount = emailAccount;
        this.operationEmailTemps = operationEmailTemps;
    }

    public List<ClientEmailDAO> getClientEmails() {
        return clientEmails;
    }

    public void setClientEmails(List<ClientEmailDAO> clientEmails) {
        this.clientEmails = clientEmails;
    }

    public ApiEmailAccountWSDTO getEmailAccount() {
        return emailAccount;
    }

    public void setEmailAccount(ApiEmailAccountWSDTO emailAccount) {
        this.emailAccount = emailAccount;
    }

    public List<ProcessEmailTempDBModel> getOperationEmailTemps() {
        return operationEmailTemps;
    }

    public void setOperationEmailTemps(List<ProcessEmailTempDBModel> operationEmailTemps) {
        this.operationEmailTemps = operationEmailTemps;
    }
}
