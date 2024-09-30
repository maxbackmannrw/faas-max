package com.faas.core.api.model.ws.operation.manager.channel.call.sip.dto;

import com.faas.core.data.db.client.details.dao.ClientPhoneDAO;
import com.faas.core.data.db.operation.details.channel.OperationSipCallDBModel;

import java.util.List;

public class ApiOperationSipChannelWSDTO {

    private List<ClientPhoneDAO> clientPhones;
    private ApiOperationSipAccountWSDTO sipAccount;
    private OperationSipCallDBModel activeSipCall;
    private List<OperationSipCallDBModel> recentSipCalls;

    public ApiOperationSipChannelWSDTO() {
    }

    public ApiOperationSipChannelWSDTO(List<ClientPhoneDAO> clientPhones, ApiOperationSipAccountWSDTO sipAccount, OperationSipCallDBModel activeSipCall, List<OperationSipCallDBModel> recentSipCalls) {
        this.clientPhones = clientPhones;
        this.sipAccount = sipAccount;
        this.activeSipCall = activeSipCall;
        this.recentSipCalls = recentSipCalls;
    }

    public List<ClientPhoneDAO> getClientPhones() {
        return clientPhones;
    }

    public void setClientPhones(List<ClientPhoneDAO> clientPhones) {
        this.clientPhones = clientPhones;
    }

    public ApiOperationSipAccountWSDTO getSipAccount() {
        return sipAccount;
    }

    public void setSipAccount(ApiOperationSipAccountWSDTO sipAccount) {
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
