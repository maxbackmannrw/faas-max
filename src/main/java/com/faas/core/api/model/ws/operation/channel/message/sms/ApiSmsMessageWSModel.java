package com.faas.core.api.model.ws.operation.channel.message.sms;

import com.faas.core.api.model.ws.operation.channel.message.sms.dto.ApiSmsMessageWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiSmsMessageWSModel {

    private GeneralWSModel general;
    private List<ApiSmsMessageWSDTO> smsMessages;

    public ApiSmsMessageWSModel() {
    }

    public ApiSmsMessageWSModel(GeneralWSModel general, List<ApiSmsMessageWSDTO> smsMessages) {
        this.general = general;
        this.smsMessages = smsMessages;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiSmsMessageWSDTO> getSmsMessages() {
        return smsMessages;
    }

    public void setSmsMessages(List<ApiSmsMessageWSDTO> smsMessages) {
        this.smsMessages = smsMessages;
    }
}
