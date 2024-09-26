package com.faas.core.api.model.ws.operation.channel.message.dto;

import com.faas.core.data.db.campaign.details.temp.WappMessageTempDBModel;
import com.faas.core.data.db.client.details.dao.ClientPhoneDAO;

import java.util.List;

public class ApiOperationWappMessageTempWSDTO {

    private List<ClientPhoneDAO> clientPhones;
    private ApiOperationWappMessageAccountWSDTO wappAccount;
    private List<WappMessageTempDBModel> operationWappMessageTemps;

    public ApiOperationWappMessageTempWSDTO() {
    }

    public ApiOperationWappMessageTempWSDTO(List<ClientPhoneDAO> clientPhones, ApiOperationWappMessageAccountWSDTO wappAccount, List<WappMessageTempDBModel> operationWappMessageTemps) {
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

    public ApiOperationWappMessageAccountWSDTO getWappAccount() {
        return wappAccount;
    }

    public void setWappAccount(ApiOperationWappMessageAccountWSDTO wappAccount) {
        this.wappAccount = wappAccount;
    }

    public List<WappMessageTempDBModel> getOperationWappMessageTemps() {
        return operationWappMessageTemps;
    }

    public void setOperationWappMessageTemps(List<WappMessageTempDBModel> operationWappMessageTemps) {
        this.operationWappMessageTemps = operationWappMessageTemps;
    }
}
