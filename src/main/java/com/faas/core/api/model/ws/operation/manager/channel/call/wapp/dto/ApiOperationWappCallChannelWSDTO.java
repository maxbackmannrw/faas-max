package com.faas.core.api.model.ws.operation.manager.channel.call.wapp.dto;

import com.faas.core.data.db.client.details.dao.ClientPhoneDAO;
import com.faas.core.data.db.operation.details.channel.OperationWappCallDBModel;

import java.util.List;

public class ApiOperationWappCallChannelWSDTO {

    private List<ClientPhoneDAO> clientPhones;
    private ApiOperationWappCallAccountWSDTO wappAccount;
    private OperationWappCallDBModel activeWappCall;
    private List<OperationWappCallDBModel> recentWappCalls;

    public ApiOperationWappCallChannelWSDTO() {
    }

    public ApiOperationWappCallChannelWSDTO(List<ClientPhoneDAO> clientPhones, ApiOperationWappCallAccountWSDTO wappAccount, OperationWappCallDBModel activeWappCall, List<OperationWappCallDBModel> recentWappCalls) {
        this.clientPhones = clientPhones;
        this.wappAccount = wappAccount;
        this.activeWappCall = activeWappCall;
        this.recentWappCalls = recentWappCalls;
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

    public List<OperationWappCallDBModel> getRecentWappCalls() {
        return recentWappCalls;
    }

    public void setRecentWappCalls(List<OperationWappCallDBModel> recentWappCalls) {
        this.recentWappCalls = recentWappCalls;
    }
}
