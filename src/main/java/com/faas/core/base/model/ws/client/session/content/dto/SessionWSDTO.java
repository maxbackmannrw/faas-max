package com.faas.core.base.model.ws.client.session.content.dto;

import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.client.details.*;
import com.faas.core.base.model.db.session.SessionDBModel;

import java.util.List;

public class SessionWSDTO {

    private SessionDBModel session;
    private ClientDBModel client;
    private List<ClientDataDBModel>clientDatas;
    private List<ClientNoteDBModel>clientNotes;
    private List<ClientAddressDBModel>clientAddresses;
    private List<ClientEmailDBModel>clientEmails;
    private List<ClientPhoneDBModel>clientPhones;

    public SessionWSDTO() {
    }

    public SessionWSDTO(SessionDBModel session, ClientDBModel client, List<ClientDataDBModel> clientDatas, List<ClientNoteDBModel> clientNotes, List<ClientAddressDBModel> clientAddresses, List<ClientEmailDBModel> clientEmails, List<ClientPhoneDBModel> clientPhones) {
        this.session = session;
        this.client = client;
        this.clientDatas = clientDatas;
        this.clientNotes = clientNotes;
        this.clientAddresses = clientAddresses;
        this.clientEmails = clientEmails;
        this.clientPhones = clientPhones;
    }

    public SessionDBModel getSession() {
        return session;
    }

    public void setSession(SessionDBModel session) {
        this.session = session;
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

    public List<ClientNoteDBModel> getClientNotes() {
        return clientNotes;
    }

    public void setClientNotes(List<ClientNoteDBModel> clientNotes) {
        this.clientNotes = clientNotes;
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

    public List<ClientPhoneDBModel> getClientPhones() {
        return clientPhones;
    }

    public void setClientPhones(List<ClientPhoneDBModel> clientPhones) {
        this.clientPhones = clientPhones;
    }
}
