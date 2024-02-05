package com.faas.core.api.model.ws.operation.details.channel.message.sms;

import com.faas.core.api.model.ws.operation.details.channel.message.sms.dto.ApiOperationSmsChannelWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;


public class ApiOperationSmsChannelWSModel {

    private GeneralWSModel general;
    private ApiOperationSmsChannelWSDTO operationSmsMessage;

    public ApiOperationSmsChannelWSModel() {
    }

    public ApiOperationSmsChannelWSModel(GeneralWSModel general, ApiOperationSmsChannelWSDTO operationSmsMessage) {
        this.general = general;
        this.operationSmsMessage = operationSmsMessage;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiOperationSmsChannelWSDTO getOperationSmsMessage() {
        return operationSmsMessage;
    }

    public void setOperationSmsMessage(ApiOperationSmsChannelWSDTO operationSmsMessage) {
        this.operationSmsMessage = operationSmsMessage;
    }
}
