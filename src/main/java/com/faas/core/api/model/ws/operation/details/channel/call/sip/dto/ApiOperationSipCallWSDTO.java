package com.faas.core.api.model.ws.operation.details.channel.call.sip.dto;

import com.faas.core.base.model.db.operation.details.channel.OperationSipCallDBModel;

import java.util.List;

public class ApiOperationSipCallWSDTO {

    private ApiSipAccountWSDTO sipAccount;
    private OperationSipCallDBModel currentSipCall;
    private List<OperationSipCallDBModel> recentSipCalls;

    public ApiOperationSipCallWSDTO() {
    }

    public ApiOperationSipCallWSDTO(ApiSipAccountWSDTO sipAccount, OperationSipCallDBModel currentSipCall, List<OperationSipCallDBModel> recentSipCalls) {
        this.sipAccount = sipAccount;
        this.currentSipCall = currentSipCall;
        this.recentSipCalls = recentSipCalls;
    }

    public ApiSipAccountWSDTO getSipAccount() {
        return sipAccount;
    }

    public void setSipAccount(ApiSipAccountWSDTO sipAccount) {
        this.sipAccount = sipAccount;
    }

    public OperationSipCallDBModel getCurrentSipCall() {
        return currentSipCall;
    }

    public void setCurrentSipCall(OperationSipCallDBModel currentSipCall) {
        this.currentSipCall = currentSipCall;
    }

    public List<OperationSipCallDBModel> getRecentSipCalls() {
        return recentSipCalls;
    }

    public void setRecentSipCalls(List<OperationSipCallDBModel> recentSipCalls) {
        this.recentSipCalls = recentSipCalls;
    }
}
