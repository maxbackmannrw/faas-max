package com.faas.core.api.model.ws.operation.device;

import com.faas.core.api.model.ws.operation.device.dto.ApiOperationDeviceWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;


public class ApiOperationDeviceWSModel {

    private GeneralWSModel general;
    private List<ApiOperationDeviceWSDTO> operationDevices;

    public ApiOperationDeviceWSModel() {
    }

    public ApiOperationDeviceWSModel(GeneralWSModel general, List<ApiOperationDeviceWSDTO> operationDevices) {
        this.general = general;
        this.operationDevices = operationDevices;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiOperationDeviceWSDTO> getOperationDevices() {
        return operationDevices;
    }

    public void setOperationDevices(List<ApiOperationDeviceWSDTO> operationDevices) {
        this.operationDevices = operationDevices;
    }
}
