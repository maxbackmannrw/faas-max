package com.faas.core.api.model.ws.operation.details.channel.call.sip;

import com.faas.core.api.model.ws.operation.details.channel.call.sip.dto.ApiOperationSipAccountWSDTO;
import com.faas.core.base.model.db.client.details.content.dao.ClientPhoneDAO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiOperationSipAccountWSModel {

    private GeneralWSModel general;
    private List<ClientPhoneDAO> clientPhones;
    private ApiOperationSipAccountWSDTO sipAccount;

    public ApiOperationSipAccountWSModel() {
    }

    public ApiOperationSipAccountWSModel(GeneralWSModel general, List<ClientPhoneDAO> clientPhones, ApiOperationSipAccountWSDTO sipAccount) {
        this.general = general;
        this.clientPhones = clientPhones;
        this.sipAccount = sipAccount;
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

    public ApiOperationSipAccountWSDTO getSipAccount() {
        return sipAccount;
    }

    public void setSipAccount(ApiOperationSipAccountWSDTO sipAccount) {
        this.sipAccount = sipAccount;
    }
}
