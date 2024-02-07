package com.faas.core.api.model.ws.operation.details.channel.message.wapp.dto;

import com.faas.core.base.model.db.client.details.content.dao.ClientPhoneDAO;
import com.faas.core.base.model.db.operation.details.channel.OperationWappMessageDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessWappMessageTempDBModel;

import java.util.List;

public class ApiOperationWappMessageChannelWSDTO {

    private ApiWappMessageAccountWSDTO wappAccount;
    private List<ClientPhoneDAO> clientPhones;
    private List<OperationWappMessageDBModel>operationWappMessages;
    private List<ProcessWappMessageTempDBModel>operationWappMessageTemps;

    public ApiOperationWappMessageChannelWSDTO() {
    }

    public ApiOperationWappMessageChannelWSDTO(ApiWappMessageAccountWSDTO wappAccount, List<ClientPhoneDAO> clientPhones, List<OperationWappMessageDBModel> operationWappMessages, List<ProcessWappMessageTempDBModel> operationWappMessageTemps) {
        this.wappAccount = wappAccount;
        this.clientPhones = clientPhones;
        this.operationWappMessages = operationWappMessages;
        this.operationWappMessageTemps = operationWappMessageTemps;
    }

    public ApiWappMessageAccountWSDTO getWappAccount() {
        return wappAccount;
    }

    public void setWappAccount(ApiWappMessageAccountWSDTO wappAccount) {
        this.wappAccount = wappAccount;
    }

    public List<ClientPhoneDAO> getClientPhones() {
        return clientPhones;
    }

    public void setClientPhones(List<ClientPhoneDAO> clientPhones) {
        this.clientPhones = clientPhones;
    }

    public List<OperationWappMessageDBModel> getOperationWappMessages() {
        return operationWappMessages;
    }

    public void setOperationWappMessages(List<OperationWappMessageDBModel> operationWappMessages) {
        this.operationWappMessages = operationWappMessages;
    }

    public List<ProcessWappMessageTempDBModel> getOperationWappMessageTemps() {
        return operationWappMessageTemps;
    }

    public void setOperationWappMessageTemps(List<ProcessWappMessageTempDBModel> operationWappMessageTemps) {
        this.operationWappMessageTemps = operationWappMessageTemps;
    }
}
