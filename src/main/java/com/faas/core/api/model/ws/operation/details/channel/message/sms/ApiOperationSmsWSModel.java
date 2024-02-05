package com.faas.core.api.model.ws.operation.details.channel.message.sms;

import com.faas.core.api.model.ws.operation.details.channel.message.sms.dto.ApiOperationSmsWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiOperationSmsWSModel {

    private GeneralWSModel general;
    private List<ApiOperationSmsWSDTO> smsMessages;

    public ApiOperationSmsWSModel() {
    }

    public ApiOperationSmsWSModel(GeneralWSModel general, List<ApiOperationSmsWSDTO> smsMessages) {
        this.general = general;
        this.smsMessages = smsMessages;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiOperationSmsWSDTO> getSmsMessages() {
        return smsMessages;
    }

    public void setSmsMessages(List<ApiOperationSmsWSDTO> smsMessages) {
        this.smsMessages = smsMessages;
    }
}
