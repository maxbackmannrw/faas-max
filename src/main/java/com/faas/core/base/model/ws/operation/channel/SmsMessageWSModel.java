package com.faas.core.base.model.ws.operation.channel;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.operation.channel.dto.SmsMessageWSDTO;

import java.util.List;

public class SmsMessageWSModel {

    private GeneralWSModel general;
    private List<SmsMessageWSDTO>smsMessages;

    public SmsMessageWSModel() {
    }

    public SmsMessageWSModel(GeneralWSModel general, List<SmsMessageWSDTO> smsMessages) {
        this.general = general;
        this.smsMessages = smsMessages;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<SmsMessageWSDTO> getSmsMessages() {
        return smsMessages;
    }

    public void setSmsMessages(List<SmsMessageWSDTO> smsMessages) {
        this.smsMessages = smsMessages;
    }
}
