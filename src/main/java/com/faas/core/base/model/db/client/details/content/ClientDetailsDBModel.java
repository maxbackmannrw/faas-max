package com.faas.core.base.model.db.client.details.content;

import com.faas.core.base.model.db.client.details.content.dao.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "client_details_table")
public class ClientDetailsDBModel {

    @Id
    private String id;
    private long clientId;
    private List<ClientPhoneDAO>clientPhones;
    private List<ClientEmailDAO>clientEmails;
    private List<ClientAddressDAO>clientAddresses;
    private List<ClientNoteDAO>clientNotes;
    private List<ClientDataDAO>clientDatas;
    private long uDate;
    private long cDate;
    private int status;

    public ClientDetailsDBModel() {
    }

    public ClientDetailsDBModel(String id, long clientId, List<ClientPhoneDAO> clientPhones, List<ClientEmailDAO> clientEmails, List<ClientAddressDAO> clientAddresses, List<ClientNoteDAO> clientNotes, List<ClientDataDAO> clientDatas, long uDate, long cDate, int status) {
        this.id = id;
        this.clientId = clientId;
        this.clientPhones = clientPhones;
        this.clientEmails = clientEmails;
        this.clientAddresses = clientAddresses;
        this.clientNotes = clientNotes;
        this.clientDatas = clientDatas;
        this.uDate = uDate;
        this.cDate = cDate;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public List<ClientPhoneDAO> getClientPhones() {
        return clientPhones;
    }

    public void setClientPhones(List<ClientPhoneDAO> clientPhones) {
        this.clientPhones = clientPhones;
    }

    public List<ClientEmailDAO> getClientEmails() {
        return clientEmails;
    }

    public void setClientEmails(List<ClientEmailDAO> clientEmails) {
        this.clientEmails = clientEmails;
    }

    public List<ClientAddressDAO> getClientAddresses() {
        return clientAddresses;
    }

    public void setClientAddresses(List<ClientAddressDAO> clientAddresses) {
        this.clientAddresses = clientAddresses;
    }

    public List<ClientNoteDAO> getClientNotes() {
        return clientNotes;
    }

    public void setClientNotes(List<ClientNoteDAO> clientNotes) {
        this.clientNotes = clientNotes;
    }

    public List<ClientDataDAO> getClientDatas() {
        return clientDatas;
    }

    public void setClientDatas(List<ClientDataDAO> clientDatas) {
        this.clientDatas = clientDatas;
    }

    public long getuDate() {
        return uDate;
    }

    public void setuDate(long uDate) {
        this.uDate = uDate;
    }

    public long getcDate() {
        return cDate;
    }

    public void setcDate(long cDate) {
        this.cDate = cDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
