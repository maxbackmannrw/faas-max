package com.faas.core.api.model.ws.operation.details.channel.message.email.dto;

import com.faas.core.base.model.db.client.details.dao.ClientEmailDAO;
import com.faas.core.base.model.db.operation.details.channel.OperationEmailDBModel;
import com.faas.core.base.model.db.campaign.details.channel.temp.EmailTempDBModel;

import java.util.List;

public class ApiOperationEmailChannelWSDTO {

    private List<ClientEmailDAO> clientEmails;
    private ApiOperationEmailAccountWSDTO emailAccount;
    private List<EmailTempDBModel>operationEmailTemps;
    private List<OperationEmailDBModel> operationEmails;

    public ApiOperationEmailChannelWSDTO() {
    }

    public ApiOperationEmailChannelWSDTO(List<ClientEmailDAO> clientEmails, ApiOperationEmailAccountWSDTO emailAccount, List<EmailTempDBModel> operationEmailTemps, List<OperationEmailDBModel> operationEmails) {
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

    public List<EmailTempDBModel> getOperationEmailTemps() {
        return operationEmailTemps;
    }

    public void setOperationEmailTemps(List<EmailTempDBModel> operationEmailTemps) {
        this.operationEmailTemps = operationEmailTemps;
    }

    public List<OperationEmailDBModel> getOperationEmails() {
        return operationEmails;
    }

    public void setOperationEmails(List<OperationEmailDBModel> operationEmails) {
        this.operationEmails = operationEmails;
    }
}
