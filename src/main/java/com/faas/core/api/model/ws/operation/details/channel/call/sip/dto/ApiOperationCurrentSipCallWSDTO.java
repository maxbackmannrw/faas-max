package com.faas.core.api.model.ws.operation.details.channel.call.sip.dto;

import com.faas.core.base.model.db.client.details.content.dao.ClientPhoneDAO;
import com.faas.core.base.model.db.operation.details.channel.OperationSipCallDBModel;

import java.util.List;

public class ApiOperationCurrentSipCallWSDTO {

    private List<ClientPhoneDAO> clientPhones;
    private ApiOperationSipAccountWSDTO sipAccount;
    private OperationSipCallDBModel activeSipCall;

    public ApiOperationCurrentSipCallWSDTO() {
    }

    public ApiOperationCurrentSipCallWSDTO(List<ClientPhoneDAO> clientPhones, ApiOperationSipAccountWSDTO sipAccount, OperationSipCallDBModel activeSipCall) {
        this.clientPhones = clientPhones;
        this.sipAccount = sipAccount;
        this.activeSipCall = activeSipCall;
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
}
