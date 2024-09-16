package com.faas.core.data.ws.api.operation.details.channel.message.email.dto;

import com.faas.core.data.db.campaign.details.temp.EmailTempDBModel;
import com.faas.core.data.db.client.details.dao.ClientEmailDAO;

import java.util.List;

public class ApiOperationEmailTempWSDTO {

    private List<ClientEmailDAO> clientEmails;
    private ApiOperationEmailAccountWSDTO emailAccount;
    private List<EmailTempDBModel> operationEmailTemps;

    public ApiOperationEmailTempWSDTO() {
    }

    public ApiOperationEmailTempWSDTO(List<ClientEmailDAO> clientEmails, ApiOperationEmailAccountWSDTO emailAccount, List<EmailTempDBModel> operationEmailTemps) {
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

    public ApiOperationEmailAccountWSDTO getEmailAccount() {
        return emailAccount;
    }

    public void setEmailAccount(ApiOperationEmailAccountWSDTO emailAccount) {
        this.emailAccount = emailAccount;
    }

    public List<EmailTempDBModel> getOperationEmailTemps() {
        return operationEmailTemps;
    }

    public void setOperationEmailTemps(List<EmailTempDBModel> operationEmailTemps) {
        this.operationEmailTemps = operationEmailTemps;
    }
}
