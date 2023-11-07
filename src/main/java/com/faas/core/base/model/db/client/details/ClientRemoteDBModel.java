package com.faas.core.base.model.db.client.details;

import com.faas.core.base.model.db.client.details.dao.ClientRemoteDeviceDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "client_remote_table")
public class ClientRemoteDBModel {

    @Id
    private String id;
    private long clientId;
    private List<ClientRemoteDeviceDAO>remoteDevices;
    private long uDate;
    private long cDate;
    private int status;

    public ClientRemoteDBModel() {
    }

    public ClientRemoteDBModel(String id, long clientId, List<ClientRemoteDeviceDAO> remoteDevices, long uDate, long cDate, int status) {
        this.id = id;
        this.clientId = clientId;
        this.remoteDevices = remoteDevices;
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

    public List<ClientRemoteDeviceDAO> getRemoteDevices() {
        return remoteDevices;
    }

    public void setRemoteDevices(List<ClientRemoteDeviceDAO> remoteDevices) {
        this.remoteDevices = remoteDevices;
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
