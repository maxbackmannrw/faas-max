package com.faas.core.base.model.ws.manager.client.content.dto;

import com.faas.core.base.model.db.client.details.dao.ClientRemoteDeviceDAO;

public class ClientRemoteDeviceWSDTO {

    private ClientRemoteDeviceDAO remoteDevice;

    public ClientRemoteDeviceWSDTO() {
    }

    public ClientRemoteDeviceWSDTO(ClientRemoteDeviceDAO remoteDevice) {
        this.remoteDevice = remoteDevice;
    }

    public ClientRemoteDeviceDAO getRemoteDevice() {
        return remoteDevice;
    }

    public void setRemoteDevice(ClientRemoteDeviceDAO remoteDevice) {
        this.remoteDevice = remoteDevice;
    }
}

