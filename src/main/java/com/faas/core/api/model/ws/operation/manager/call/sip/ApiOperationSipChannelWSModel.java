package com.faas.core.api.model.ws.operation.manager.call.sip;

import com.faas.core.api.model.ws.operation.manager.call.sip.dto.ApiOperationSipChannelWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiOperationSipChannelWSModel {

    private GeneralWSModel general;
    private ApiOperationSipChannelWSDTO operationSipChannel;

    public ApiOperationSipChannelWSModel() {
    }

    public ApiOperationSipChannelWSModel(GeneralWSModel general, ApiOperationSipChannelWSDTO operationSipChannel) {
        this.general = general;
        this.operationSipChannel = operationSipChannel;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiOperationSipChannelWSDTO getOperationSipChannel() {
        return operationSipChannel;
    }

    public void setOperationSipChannel(ApiOperationSipChannelWSDTO operationSipChannel) {
        this.operationSipChannel = operationSipChannel;
    }
}
