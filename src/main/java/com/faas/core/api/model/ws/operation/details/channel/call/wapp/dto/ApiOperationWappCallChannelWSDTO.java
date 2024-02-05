package com.faas.core.api.model.ws.operation.details.channel.call.wapp.dto;

import com.faas.core.base.model.db.operation.details.channel.OperationWappCallDBModel;

import java.util.List;

public class ApiOperationWappCallChannelWSDTO {

    private ApiWappCallAccountWSDTO wappCallAccount;
    private OperationWappCallDBModel activeWappCall;
    private List<OperationWappCallDBModel>recentWappCalls;

    public ApiOperationWappCallChannelWSDTO() {
    }

    public ApiOperationWappCallChannelWSDTO(ApiWappCallAccountWSDTO wappCallAccount, OperationWappCallDBModel activeWappCall, List<OperationWappCallDBModel> recentWappCalls) {
        this.wappCallAccount = wappCallAccount;
        this.activeWappCall = activeWappCall;
        this.recentWappCalls = recentWappCalls;
    }

    public ApiWappCallAccountWSDTO getWappCallAccount() {
        return wappCallAccount;
    }

    public void setWappCallAccount(ApiWappCallAccountWSDTO wappCallAccount) {
        this.wappCallAccount = wappCallAccount;
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
