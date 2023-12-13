package com.faas.core.api.model.ws.operation.channel.message.wapp.dto;

import com.faas.core.api.model.ws.operation.channel.call.wapp.dto.ApiWappAccountWSDTO;
import com.faas.core.base.model.db.client.details.ClientPhoneDBModel;
import com.faas.core.base.model.db.operation.details.channel.OperationWappMessageDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessWappMessageTempDBModel;

import java.util.List;

public class ApiOperationWappMessageWSDTO {

    private ApiWappAccountWSDTO wappAccount;
    private List<ClientPhoneDBModel>phones;
    private List<OperationWappMessageDBModel>wappMessages;
    private List<ProcessWappMessageTempDBModel>wappTemps;

    public ApiOperationWappMessageWSDTO() {
    }

    public ApiOperationWappMessageWSDTO(ApiWappAccountWSDTO wappAccount, List<ClientPhoneDBModel> phones, List<OperationWappMessageDBModel> wappMessages, List<ProcessWappMessageTempDBModel> wappTemps) {
        this.wappAccount = wappAccount;
        this.phones = phones;
        this.wappMessages = wappMessages;
        this.wappTemps = wappTemps;
    }

    public ApiWappAccountWSDTO getWappAccount() {
        return wappAccount;
    }

    public void setWappAccount(ApiWappAccountWSDTO wappAccount) {
        this.wappAccount = wappAccount;
    }

    public List<ClientPhoneDBModel> getPhones() {
        return phones;
    }

    public void setPhones(List<ClientPhoneDBModel> phones) {
        this.phones = phones;
    }

    public List<OperationWappMessageDBModel> getWappMessages() {
        return wappMessages;
    }

    public void setWappMessages(List<OperationWappMessageDBModel> wappMessages) {
        this.wappMessages = wappMessages;
    }

    public List<ProcessWappMessageTempDBModel> getWappTemps() {
        return wappTemps;
    }

    public void setWappTemps(List<ProcessWappMessageTempDBModel> wappTemps) {
        this.wappTemps = wappTemps;
    }
}
