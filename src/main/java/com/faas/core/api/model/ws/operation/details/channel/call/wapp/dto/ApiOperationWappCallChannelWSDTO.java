package com.faas.core.api.model.ws.operation.details.channel.call.wapp.dto;

import com.faas.core.base.model.db.operation.details.channel.OperationWappCallDBModel;

import java.util.List;

public class ApiOperationWappCallChannelWSDTO {

    private ApiWappAccountWSDTO wappAccount;
    private OperationWappCallDBModel currentWappCall;
    private List<OperationWappCallDBModel>recentWappCalls;

    public ApiOperationWappCallChannelWSDTO() {
    }

    public ApiOperationWappCallChannelWSDTO(ApiWappAccountWSDTO wappAccount, OperationWappCallDBModel currentWappCall, List<OperationWappCallDBModel> recentWappCalls) {
        this.wappAccount = wappAccount;
        this.currentWappCall = currentWappCall;
        this.recentWappCalls = recentWappCalls;
    }

    public ApiWappAccountWSDTO getWappAccount() {
        return wappAccount;
    }

    public void setWappAccount(ApiWappAccountWSDTO wappAccount) {
        this.wappAccount = wappAccount;
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
