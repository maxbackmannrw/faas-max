package com.faas.core.api.model.ws.client.device;

import com.faas.core.api.model.ws.client.device.dto.ApiClientDeviceWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiClientDeviceWSModel {

    private GeneralWSModel general;
    private List<ApiClientDeviceWSDTO>clientDevice;

    public ApiClientDeviceWSModel() {
    }

    public ApiClientDeviceWSModel(GeneralWSModel general, List<ApiClientDeviceWSDTO> clientDevice) {
        this.general = general;
        this.clientDevice = clientDevice;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiClientDeviceWSDTO> getClientDevice() {
        return clientDevice;
    }

    public void setClientDevice(List<ApiClientDeviceWSDTO> clientDevice) {
        this.clientDevice = clientDevice;
    }
}
