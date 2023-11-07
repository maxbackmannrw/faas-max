package com.faas.core.base.model.ws.manager.client.content;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.manager.client.content.dto.ClientRemoteDeviceWSDTO;
import com.faas.core.base.model.ws.manager.client.content.dto.ClientRemoteWSDTO;

import java.util.List;

public class ClientRemoteDeviceWSModel {

    private GeneralWSModel general;
    private List<ClientRemoteDeviceWSDTO>remoteDevices;

    public ClientRemoteDeviceWSModel() {
    }

    public ClientRemoteDeviceWSModel(GeneralWSModel general, List<ClientRemoteDeviceWSDTO> remoteDevices) {
        this.general = general;
        this.remoteDevices = remoteDevices;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ClientRemoteDeviceWSDTO> getRemoteDevices() {
        return remoteDevices;
    }

    public void setRemoteDevices(List<ClientRemoteDeviceWSDTO> remoteDevices) {
        this.remoteDevices = remoteDevices;
    }
}
