package com.faas.core.api.model.ws.client.device;

import com.faas.core.api.model.ws.client.device.dto.ApiClientDeviceWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiClientDeviceWSModel {

    private GeneralWSModel general;
    private List<ApiClientDeviceWSDTO>clientDevices;

    public ApiClientDeviceWSModel() {
    }

    public ApiClientDeviceWSModel(GeneralWSModel general, List<ApiClientDeviceWSDTO> clientDevices) {
        this.general = general;
        this.clientDevices = clientDevices;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiClientDeviceWSDTO> getClientDevices() {
        return clientDevices;
    }

    public void setClientDevices(List<ApiClientDeviceWSDTO> clientDevices) {
        this.clientDevices = clientDevices;
    }
}
