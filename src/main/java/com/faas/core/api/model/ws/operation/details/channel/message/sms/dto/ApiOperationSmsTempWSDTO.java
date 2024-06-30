package com.faas.core.api.model.ws.operation.details.channel.message.sms.dto;

import com.faas.core.base.model.db.client.details.dao.ClientPhoneDAO;
import com.faas.core.base.model.db.campaign.details.channel.temp.SmsTempDBModel;

import java.util.List;

public class ApiOperationSmsTempWSDTO {

    private List<ClientPhoneDAO> clientPhones;
    private ApiOperationSmsAccountWSDTO smsAccount;
    private List<SmsTempDBModel>operationSmsTemps;

    public ApiOperationSmsTempWSDTO() {
    }

    public ApiOperationSmsTempWSDTO(List<ClientPhoneDAO> clientPhones, ApiOperationSmsAccountWSDTO smsAccount, List<SmsTempDBModel> operationSmsTemps) {
        this.clientPhones = clientPhones;
        this.smsAccount = smsAccount;
        this.operationSmsTemps = operationSmsTemps;
    }

    public List<ClientPhoneDAO> getClientPhones() {
        return clientPhones;
    }

    public void setClientPhones(List<ClientPhoneDAO> clientPhones) {
        this.clientPhones = clientPhones;
    }

    public ApiOperationSmsAccountWSDTO getSmsAccount() {
        return smsAccount;
    }

    public void setSmsAccount(ApiOperationSmsAccountWSDTO smsAccount) {
        this.smsAccount = smsAccount;
    }

    public List<SmsTempDBModel> getOperationSmsTemps() {
        return operationSmsTemps;
    }

    public void setOperationSmsTemps(List<SmsTempDBModel> operationSmsTemps) {
        this.operationSmsTemps = operationSmsTemps;
    }
}
