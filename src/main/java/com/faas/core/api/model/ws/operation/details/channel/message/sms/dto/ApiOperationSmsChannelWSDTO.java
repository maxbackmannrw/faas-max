package com.faas.core.api.model.ws.operation.details.channel.message.sms.dto;

import com.faas.core.base.model.db.client.details.content.dao.ClientPhoneDAO;
import com.faas.core.base.model.db.operation.details.channel.OperationSmsMessageDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessSmsTempDBModel;

import java.util.List;

public class ApiOperationSmsChannelWSDTO {

    private List<ClientPhoneDAO> clientPhones;
    private ApiOperationSmsAccountWSDTO smsAccount;
    private List<ProcessSmsTempDBModel>operationSmsTemps;
    private List<OperationSmsMessageDBModel>operationSmss;

    public ApiOperationSmsChannelWSDTO() {
    }

    public ApiOperationSmsChannelWSDTO(List<ClientPhoneDAO> clientPhones, ApiOperationSmsAccountWSDTO smsAccount, List<ProcessSmsTempDBModel> operationSmsTemps, List<OperationSmsMessageDBModel> operationSmss) {
        this.clientPhones = clientPhones;
        this.smsAccount = smsAccount;
        this.operationSmsTemps = operationSmsTemps;
        this.operationSmss = operationSmss;
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

    public List<ProcessSmsTempDBModel> getOperationSmsTemps() {
        return operationSmsTemps;
    }

    public void setOperationSmsTemps(List<ProcessSmsTempDBModel> operationSmsTemps) {
        this.operationSmsTemps = operationSmsTemps;
    }

    public List<OperationSmsMessageDBModel> getOperationSmss() {
        return operationSmss;
    }

    public void setOperationSmss(List<OperationSmsMessageDBModel> operationSmss) {
        this.operationSmss = operationSmss;
    }
}
