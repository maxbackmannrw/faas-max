package com.faas.core.api.model.ws.operation.details.channel.call.wapp;

import com.faas.core.api.model.ws.operation.details.channel.call.wapp.dto.ApiOperationWappCallAccountWSDTO;
import com.faas.core.base.model.db.client.details.content.dao.ClientPhoneDAO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiOperationWappCallAccountWSModel {

    private GeneralWSModel general;
    private List<ClientPhoneDAO> clientPhones;
    private ApiOperationWappCallAccountWSDTO  wappCallAccount;

    public ApiOperationWappCallAccountWSModel() {
    }

    public ApiOperationWappCallAccountWSModel(GeneralWSModel general, List<ClientPhoneDAO> clientPhones, ApiOperationWappCallAccountWSDTO wappCallAccount) {
        this.general = general;
        this.clientPhones = clientPhones;
        this.wappCallAccount = wappCallAccount;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ClientPhoneDAO> getClientPhones() {
        return clientPhones;
    }

    public void setClientPhones(List<ClientPhoneDAO> clientPhones) {
        this.clientPhones = clientPhones;
    }

    public ApiOperationWappCallAccountWSDTO getWappCallAccount() {
        return wappCallAccount;
    }

    public void setWappCallAccount(ApiOperationWappCallAccountWSDTO wappCallAccount) {
        this.wappCallAccount = wappCallAccount;
    }
}
