package com.faas.core.api.model.ws.operation.details.channel.call.wapp.dto;

import com.faas.core.base.model.db.client.details.content.dao.ClientPhoneDAO;
import com.faas.core.base.model.db.operation.details.channel.OperationWappCallDBModel;

import java.util.List;

public class ApiOperationWappCallChannelWSDTO {

    private List<ClientPhoneDAO> clientPhones;
    private ApiOperationWappCallAccountWSDTO wappAccount;
    private OperationWappCallDBModel activeWappCall;
    private List<OperationWappCallDBModel>recentWappCalls;

    public ApiOperationWappCallChannelWSDTO() {
    }

    public ApiOperationWappCallChannelWSDTO(ApiOperationWappCallAccountWSDTO wappAccount, List<ClientPhoneDAO> clientPhones, OperationWappCallDBModel activeWappCall, List<OperationWappCallDBModel> recentWappCalls) {
        this.wappAccount = wappAccount;
        this.clientPhones = clientPhones;
        this.activeWappCall = activeWappCall;
        this.recentWappCalls = recentWappCalls;
    }

    public ApiOperationWappCallAccountWSDTO getWappAccount() {
        return wappAccount;
    }

    public void setWappAccount(ApiOperationWappCallAccountWSDTO wappAccount) {
        this.wappAccount = wappAccount;
    }

    public List<ClientPhoneDAO> getClientPhones() {
        return clientPhones;
    }

    public void setClientPhones(List<ClientPhoneDAO> clientPhones) {
        this.clientPhones = clientPhones;
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
