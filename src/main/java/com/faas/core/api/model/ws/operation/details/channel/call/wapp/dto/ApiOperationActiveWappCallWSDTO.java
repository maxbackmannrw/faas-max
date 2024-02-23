package com.faas.core.api.model.ws.operation.details.channel.call.wapp.dto;

import com.faas.core.base.model.db.client.details.content.dao.ClientPhoneDAO;
import com.faas.core.base.model.db.operation.details.channel.OperationWappCallDBModel;

import java.util.List;

public class ApiOperationActiveWappCallWSDTO {

    private List<ClientPhoneDAO> clientPhones;
    private ApiOperationWappCallAccountWSDTO wappAccount;
    private OperationWappCallDBModel activeWappCall;

    public ApiOperationActiveWappCallWSDTO() {
    }

    public ApiOperationActiveWappCallWSDTO(List<ClientPhoneDAO> clientPhones, ApiOperationWappCallAccountWSDTO wappAccount, OperationWappCallDBModel activeWappCall) {
        this.clientPhones = clientPhones;
        this.wappAccount = wappAccount;
        this.activeWappCall = activeWappCall;
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

    public OperationWappCallDBModel getActiveWappCall() {
        return activeWappCall;
    }

    public void setActiveWappCall(OperationWappCallDBModel activeWappCall) {
        this.activeWappCall = activeWappCall;
    }
}
