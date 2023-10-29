package com.faas.core.base.model.ws.operation.details.channel;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.operation.details.channel.dto.OperationSmsMessageWSDTO;

import java.util.List;

public class OperationSmsMessageWSModel {

    private GeneralWSModel general;
    private List<OperationSmsMessageWSDTO>smsMessages;

    public OperationSmsMessageWSModel() {
    }

    public OperationSmsMessageWSModel(GeneralWSModel general, List<OperationSmsMessageWSDTO> smsMessages) {
        this.general = general;
        this.smsMessages = smsMessages;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<OperationSmsMessageWSDTO> getSmsMessages() {
        return smsMessages;
    }

    public void setSmsMessages(List<OperationSmsMessageWSDTO> smsMessages) {
        this.smsMessages = smsMessages;
    }
}
