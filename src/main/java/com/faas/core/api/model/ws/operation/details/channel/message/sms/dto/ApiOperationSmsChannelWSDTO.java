package com.faas.core.api.model.ws.operation.details.channel.message.sms.dto;

import com.faas.core.base.model.db.client.details.content.dao.ClientPhoneDAO;
import com.faas.core.base.model.db.operation.details.channel.OperationSmsMessageDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessSmsMessageTempDBModel;

import java.util.List;

public class ApiOperationSmsChannelWSDTO {

    private ApiSmsAccountWSDTO smsAccount;
    private List<ClientPhoneDAO> clientPhones;
    private List<OperationSmsMessageDBModel>operationSmss;
    private List<ProcessSmsMessageTempDBModel>operationSmsTemps;

    public ApiOperationSmsChannelWSDTO() {
    }

    public ApiOperationSmsChannelWSDTO(ApiSmsAccountWSDTO smsAccount, List<ClientPhoneDAO> clientPhones, List<OperationSmsMessageDBModel> operationSmss, List<ProcessSmsMessageTempDBModel> operationSmsTemps) {
        this.smsAccount = smsAccount;
        this.clientPhones = clientPhones;
        this.operationSmss = operationSmss;
        this.operationSmsTemps = operationSmsTemps;
    }

    public ApiSmsAccountWSDTO getSmsAccount() {
        return smsAccount;
    }

    public void setSmsAccount(ApiSmsAccountWSDTO smsAccount) {
        this.smsAccount = smsAccount;
    }

    public List<ClientPhoneDAO> getClientPhones() {
        return clientPhones;
    }

    public void setClientPhones(List<ClientPhoneDAO> clientPhones) {
        this.clientPhones = clientPhones;
    }

    public List<OperationSmsMessageDBModel> getOperationSmss() {
        return operationSmss;
    }

    public void setOperationSmss(List<OperationSmsMessageDBModel> operationSmss) {
        this.operationSmss = operationSmss;
    }

    public List<ProcessSmsMessageTempDBModel> getOperationSmsTemps() {
        return operationSmsTemps;
    }

    public void setOperationSmsTemps(List<ProcessSmsMessageTempDBModel> operationSmsTemps) {
        this.operationSmsTemps = operationSmsTemps;
    }
}
