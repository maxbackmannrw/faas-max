package com.faas.core.api.model.ws.operation.details.channel.message.sms.dto;

import com.faas.core.base.model.db.client.details.content.dao.ClientPhoneDAO;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessSmsMessageTempDBModel;

import java.util.List;

public class ApiOperationSmsTempWSDTO {

    private List<ClientPhoneDAO> clientPhones;
    private ApiSmsAccountWSDTO smsAccount;
    private List<ProcessSmsMessageTempDBModel>operationSmsTemps;

    public ApiOperationSmsTempWSDTO() {
    }

    public ApiOperationSmsTempWSDTO(List<ClientPhoneDAO> clientPhones, ApiSmsAccountWSDTO smsAccount, List<ProcessSmsMessageTempDBModel> operationSmsTemps) {
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

    public ApiSmsAccountWSDTO getSmsAccount() {
        return smsAccount;
    }

    public void setSmsAccount(ApiSmsAccountWSDTO smsAccount) {
        this.smsAccount = smsAccount;
    }

    public List<ProcessSmsMessageTempDBModel> getOperationSmsTemps() {
        return operationSmsTemps;
    }

    public void setOperationSmsTemps(List<ProcessSmsMessageTempDBModel> operationSmsTemps) {
        this.operationSmsTemps = operationSmsTemps;
    }
}
