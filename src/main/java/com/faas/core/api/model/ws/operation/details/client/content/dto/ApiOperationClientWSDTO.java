package com.faas.core.api.model.ws.operation.details.client.content.dto;

import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.client.details.*;

import java.util.List;

public class ApiOperationClientWSDTO {

    private ClientDBModel client;
    private List<ClientDataDBModel> clientDatas;
    private List<ClientAddressDBModel>clientAddresses;
    private List<ClientPhoneDBModel>clientPhones;
    private List<ClientEmailDBModel>clientEmails;

    public ApiOperationClientWSDTO() {
    }

    public ApiOperationClientWSDTO(ClientDBModel client, List<ClientDataDBModel> clientDatas, List<ClientAddressDBModel> clientAddresses, List<ClientPhoneDBModel> clientPhones, List<ClientEmailDBModel> clientEmails) {
        this.client = client;
        this.clientDatas = clientDatas;
        this.clientAddresses = clientAddresses;
        this.clientPhones = clientPhones;
        this.clientEmails = clientEmails;
    }

    public ClientDBModel getClient() {
        return client;
    }

    public void setClient(ClientDBModel client) {
        this.client = client;
    }

    public List<ClientDataDBModel> getClientDatas() {
        return clientDatas;
    }

    public void setClientDatas(List<ClientDataDBModel> clientDatas) {
        this.clientDatas = clientDatas;
    }

    public List<ClientAddressDBModel> getClientAddresses() {
        return clientAddresses;
    }

    public void setClientAddresses(List<ClientAddressDBModel> clientAddresses) {
        this.clientAddresses = clientAddresses;
    }

    public List<ClientPhoneDBModel> getClientPhones() {
        return clientPhones;
    }

    public void setClientPhones(List<ClientPhoneDBModel> clientPhones) {
        this.clientPhones = clientPhones;
    }

    public List<ClientEmailDBModel> getClientEmails() {
        return clientEmails;
    }

    public void setClientEmails(List<ClientEmailDBModel> clientEmails) {
        this.clientEmails = clientEmails;
    }
}
