package com.faas.core.api.model.ws.operation.details.channel.call.wapp.dto;

import com.faas.core.base.model.db.client.details.content.dao.ClientPhoneDAO;
import com.faas.core.base.model.db.operation.details.channel.OperationWappCallDBModel;

import java.util.List;

public class ApiOperationCurrentWappCallWSDTO {

    private List<ClientPhoneDAO> clientPhones;
    private ApiOperationWappCallAccountWSDTO wappAccount;
    private OperationWappCallDBModel currentWappCall;

    public ApiOperationCurrentWappCallWSDTO() {
    }

    public ApiOperationCurrentWappCallWSDTO(List<ClientPhoneDAO> clientPhones, ApiOperationWappCallAccountWSDTO wappAccount, OperationWappCallDBModel currentWappCall) {
        this.clientPhones = clientPhones;
        this.wappAccount = wappAccount;
        this.currentWappCall = currentWappCall;
    }

    public List<ClientPhoneDAO> getClientPhones() {
        return clientPhones;
    }

    public void setClientPhones(List<ClientPhoneDAO> clientPhones) {
        this.clientPhones = clientPhones;
    }

    public ApiOperationWappCallAccountWSDTO getWappAccount() {
        return wappAccount;
    }

    public void setWappAccount(ApiOperationWappCallAccountWSDTO wappAccount) {
        this.wappAccount = wappAccount;
    }

    public OperationWappCallDBModel getCurrentWappCall() {
        return currentWappCall;
    }

    public void setCurrentWappCall(OperationWappCallDBModel currentWappCall) {
        this.currentWappCall = currentWappCall;
    }
}
