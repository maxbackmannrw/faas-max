package com.faas.core.api.model.ws.operation.channel.call.wapp.dto;

import com.faas.core.base.model.db.client.details.ClientPhoneDBModel;
import com.faas.core.base.model.db.operation.details.channel.OperationWappCallDBModel;

import java.util.List;

public class ApiOperationWappCallWSDTO {

    private ApiWappAccountWSDTO wappAccount;
    private List<ClientPhoneDBModel>clientPhones;
    private OperationWappCallDBModel currentWappCall;
    private List<OperationWappCallDBModel>recentWappCalls;

    public ApiOperationWappCallWSDTO() {
    }

    public ApiOperationWappCallWSDTO(ApiWappAccountWSDTO wappAccount, List<ClientPhoneDBModel> clientPhones, OperationWappCallDBModel currentWappCall, List<OperationWappCallDBModel> recentWappCalls) {
        this.wappAccount = wappAccount;
        this.clientPhones = clientPhones;
        this.currentWappCall = currentWappCall;
        this.recentWappCalls = recentWappCalls;
    }

    public ApiWappAccountWSDTO getWappAccount() {
        return wappAccount;
    }

    public void setWappAccount(ApiWappAccountWSDTO wappAccount) {
        this.wappAccount = wappAccount;
    }

    public List<ClientPhoneDBModel> getClientPhones() {
        return clientPhones;
    }

    public void setClientPhones(List<ClientPhoneDBModel> clientPhones) {
        this.clientPhones = clientPhones;
    }

    public OperationWappCallDBModel getCurrentWappCall() {
        return currentWappCall;
    }

    public void setCurrentWappCall(OperationWappCallDBModel currentWappCall) {
        this.currentWappCall = currentWappCall;
    }

    public List<OperationWappCallDBModel> getRecentWappCalls() {
        return recentWappCalls;
    }

    public void setRecentWappCalls(List<OperationWappCallDBModel> recentWappCalls) {
        this.recentWappCalls = recentWappCalls;
    }
}
