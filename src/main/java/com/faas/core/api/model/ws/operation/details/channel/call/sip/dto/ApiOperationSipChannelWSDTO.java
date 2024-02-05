package com.faas.core.api.model.ws.operation.details.channel.call.sip.dto;

import com.faas.core.base.model.db.operation.details.channel.OperationSipCallDBModel;

import java.util.List;

public class ApiOperationSipChannelWSDTO {

    private ApiSipAccountWSDTO sipAccount;
    private OperationSipCallDBModel activeSipCall;
    private List<OperationSipCallDBModel> recentSipCalls;

    public ApiOperationSipChannelWSDTO() {
    }

    public ApiOperationSipChannelWSDTO(ApiSipAccountWSDTO sipAccount, OperationSipCallDBModel activeSipCall, List<OperationSipCallDBModel> recentSipCalls) {
        this.sipAccount = sipAccount;
        this.activeSipCall = activeSipCall;
        this.recentSipCalls = recentSipCalls;
    }

    public ApiSipAccountWSDTO getSipAccount() {
        return sipAccount;
    }

    public void setSipAccount(ApiSipAccountWSDTO sipAccount) {
        this.sipAccount = sipAccount;
    }

    public OperationSipCallDBModel getActiveSipCall() {
        return activeSipCall;
    }

    public void setActiveSipCall(OperationSipCallDBModel activeSipCall) {
        this.activeSipCall = activeSipCall;
    }

    public List<OperationSipCallDBModel> getRecentSipCalls() {
        return recentSipCalls;
    }

    public void setRecentSipCalls(List<OperationSipCallDBModel> recentSipCalls) {
        this.recentSipCalls = recentSipCalls;
    }
}
