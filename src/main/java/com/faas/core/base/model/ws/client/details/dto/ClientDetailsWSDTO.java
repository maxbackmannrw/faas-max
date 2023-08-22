package com.faas.core.base.model.ws.client.details.dto;

import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.client.details.ClientAddressDBModel;
import com.faas.core.base.model.db.client.details.ClientDataDBModel;
import com.faas.core.base.model.db.client.details.ClientEmailDBModel;
import com.faas.core.base.model.db.client.details.ClientPhoneDBModel;

import java.util.List;


public class ClientDetailsWSDTO {

    private ClientDBModel client;
    private List<ClientDataDBModel>clientDatas;
    private List<ClientPhoneDBModel>clientPhones;
    private List<ClientAddressDBModel>clientAddresses;
    private List<ClientEmailDBModel>clientEmails;


    public ClientDetailsWSDTO() {
    }

    public ClientDetailsWSDTO(ClientDBModel client, List<ClientDataDBModel> clientDatas, List<ClientPhoneDBModel> clientPhones, List<ClientAddressDBModel> clientAddresses, List<ClientEmailDBModel> clientEmails) {
        this.client = client;
        this.clientDatas = clientDatas;
        this.clientPhones = clientPhones;
        this.clientAddresses = clientAddresses;
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

    public List<ClientPhoneDBModel> getClientPhones() {
        return clientPhones;
    }

    public void setClientPhones(List<ClientPhoneDBModel> clientPhones) {
        this.clientPhones = clientPhones;
    }

    public List<ClientAddressDBModel> getClientAddresses() {
        return clientAddresses;
    }

    public void setClientAddresses(List<ClientAddressDBModel> clientAddresses) {
        this.clientAddresses = clientAddresses;
    }

    public List<ClientEmailDBModel> getClientEmails() {
        return clientEmails;
    }

    public void setClientEmails(List<ClientEmailDBModel> clientEmails) {
        this.clientEmails = clientEmails;
    }
}
