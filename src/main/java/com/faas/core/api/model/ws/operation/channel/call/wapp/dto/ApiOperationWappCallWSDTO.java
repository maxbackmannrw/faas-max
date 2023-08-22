package com.faas.core.api.model.ws.operation.channel.call.wapp.dto;

import com.faas.core.base.model.db.client.details.ClientPhoneDBModel;
import com.faas.core.base.model.db.operation.channel.WappCallDBModel;

import java.util.List;

public class ApiOperationWappCallWSDTO {

    private ApiWappAccountWSDTO wappAccount;
    private List<ClientPhoneDBModel>clientPhones;
    private WappCallDBModel currentWappCall;
    private List<WappCallDBModel>recentWappCalls;

    public ApiOperationWappCallWSDTO() {
    }

    public ApiOperationWappCallWSDTO(ApiWappAccountWSDTO wappAccount, List<ClientPhoneDBModel> clientPhones, WappCallDBModel currentWappCall, List<WappCallDBModel> recentWappCalls) {
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

    public WappCallDBModel getCurrentWappCall() {
        return currentWappCall;
    }

    public void setCurrentWappCall(WappCallDBModel currentWappCall) {
        this.currentWappCall = currentWappCall;
    }

    public List<WappCallDBModel> getRecentWappCalls() {
        return recentWappCalls;
    }

    public void setRecentWappCalls(List<WappCallDBModel> recentWappCalls) {
        this.recentWappCalls = recentWappCalls;
    }
}
