package com.faas.core.api.model.ws.operation.details.channel.message.wapp.dto;

import com.faas.core.base.model.db.client.details.content.dao.ClientPhoneDAO;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessWappMessageTempDBModel;

import java.util.List;

public class ApiOperationWappMessageTempWSDTO {

    private List<ClientPhoneDAO> clientPhones;
    private ApiWappMessageAccountWSDTO wappAccount;
    private List<ProcessWappMessageTempDBModel>operationWappMessageTemps;

    public ApiOperationWappMessageTempWSDTO() {
    }

    public ApiOperationWappMessageTempWSDTO(List<ClientPhoneDAO> clientPhones, ApiWappMessageAccountWSDTO wappAccount, List<ProcessWappMessageTempDBModel> operationWappMessageTemps) {
        this.clientPhones = clientPhones;
        this.wappAccount = wappAccount;
        this.operationWappMessageTemps = operationWappMessageTemps;
    }

    public List<ClientPhoneDAO> getClientPhones() {
        return clientPhones;
    }

    public void setClientPhones(List<ClientPhoneDAO> clientPhones) {
        this.clientPhones = clientPhones;
    }

    public ApiWappMessageAccountWSDTO getWappAccount() {
        return wappAccount;
    }

    public void setWappAccount(ApiWappMessageAccountWSDTO wappAccount) {
        this.wappAccount = wappAccount;
    }

    public List<ProcessWappMessageTempDBModel> getOperationWappMessageTemps() {
        return operationWappMessageTemps;
    }

    public void setOperationWappMessageTemps(List<ProcessWappMessageTempDBModel> operationWappMessageTemps) {
        this.operationWappMessageTemps = operationWappMessageTemps;
    }
}
