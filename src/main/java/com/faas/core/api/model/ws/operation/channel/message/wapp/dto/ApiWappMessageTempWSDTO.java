package com.faas.core.api.model.ws.operation.channel.message.wapp.dto;

import com.faas.core.api.model.ws.operation.channel.call.wapp.dto.ApiWappAccountWSDTO;
import com.faas.core.base.model.db.client.details.ClientPhoneDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.WappMessageTempDBModel;

import java.util.List;

public class ApiWappMessageTempWSDTO {

    private ApiWappAccountWSDTO wappAccount;
    private List<ClientPhoneDBModel> phones;
    private List<WappMessageTempDBModel>wappTemps;

    public ApiWappMessageTempWSDTO() {
    }

    public ApiWappMessageTempWSDTO(ApiWappAccountWSDTO wappAccount, List<ClientPhoneDBModel> phones, List<WappMessageTempDBModel> wappTemps) {
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

    public List<WappMessageTempDBModel> getWappTemps() {
        return wappTemps;
    }

    public void setWappTemps(List<WappMessageTempDBModel> wappTemps) {
        this.wappTemps = wappTemps;
    }
}
