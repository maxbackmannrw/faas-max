package com.faas.core.api.model.ws.operation.channel.message.wapp.dto;

import com.faas.core.api.model.ws.operation.channel.call.wapp.dto.ApiWappAccountWSDTO;
import com.faas.core.base.model.db.client.details.ClientPhoneDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessWappMessageTempDBModel;

import java.util.List;

public class ApiWappMessageTempWSDTO {

    private ApiWappAccountWSDTO wappAccount;
    private List<ClientPhoneDBModel> phones;
    private List<ProcessWappMessageTempDBModel>wappTemps;

    public ApiWappMessageTempWSDTO() {
    }

    public ApiWappMessageTempWSDTO(ApiWappAccountWSDTO wappAccount, List<ClientPhoneDBModel> phones, List<ProcessWappMessageTempDBModel> wappTemps) {
        this.wappAccount = wappAccount;
        this.phones = phones;
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

    public List<ProcessWappMessageTempDBModel> getWappTemps() {
        return wappTemps;
    }

    public void setWappTemps(List<ProcessWappMessageTempDBModel> wappTemps) {
        this.wappTemps = wappTemps;
    }
}
