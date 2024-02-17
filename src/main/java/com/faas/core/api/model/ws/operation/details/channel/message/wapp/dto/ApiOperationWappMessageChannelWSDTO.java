package com.faas.core.api.model.ws.operation.details.channel.message.wapp.dto;

import com.faas.core.base.model.db.client.details.content.dao.ClientPhoneDAO;
import com.faas.core.base.model.db.operation.details.channel.OperationWappMessageDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessWappMessageTempDBModel;

import java.util.List;

public class ApiOperationWappMessageChannelWSDTO {

    private List<ClientPhoneDAO> clientPhones;
    private ApiOperationWappMessageAccountWSDTO wappAccount;
    private List<ProcessWappMessageTempDBModel>operationWappMessageTemps;
    private List<OperationWappMessageDBModel>operationWappMessages;

    public ApiOperationWappMessageChannelWSDTO() {
    }

    public ApiOperationWappMessageChannelWSDTO(List<ClientPhoneDAO> clientPhones, ApiOperationWappMessageAccountWSDTO wappAccount, List<ProcessWappMessageTempDBModel> operationWappMessageTemps, List<OperationWappMessageDBModel> operationWappMessages) {
        this.clientPhones = clientPhones;
        this.wappAccount = wappAccount;
        this.operationWappMessageTemps = operationWappMessageTemps;
        this.operationWappMessages = operationWappMessages;
    }

    public List<ClientPhoneDAO> getClientPhones() {
        return clientPhones;
    }

    public void setClientPhones(List<ClientPhoneDAO> clientPhones) {
        this.clientPhones = clientPhones;
    }

    public ApiOperationWappMessageAccountWSDTO getWappAccount() {
        return wappAccount;
    }

    public void setWappAccount(ApiOperationWappMessageAccountWSDTO wappAccount) {
        this.wappAccount = wappAccount;
    }

    public List<ProcessWappMessageTempDBModel> getOperationWappMessageTemps() {
        return operationWappMessageTemps;
    }

    public void setOperationWappMessageTemps(List<ProcessWappMessageTempDBModel> operationWappMessageTemps) {
        this.operationWappMessageTemps = operationWappMessageTemps;
    }

    public List<OperationWappMessageDBModel> getOperationWappMessages() {
        return operationWappMessages;
    }

    public void setOperationWappMessages(List<OperationWappMessageDBModel> operationWappMessages) {
        this.operationWappMessages = operationWappMessages;
    }
}
