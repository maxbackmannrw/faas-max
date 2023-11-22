package com.faas.core.base.model.ws.process.details.trigger;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.trigger.dto.SmsMessageTriggerWSDTO;

import java.util.List;

public class SmsMessageTriggerWSModel {

    private GeneralWSModel general;
    private List<SmsMessageTriggerWSDTO>smsMessageTriggers;

    public SmsMessageTriggerWSModel() {
    }

    public SmsMessageTriggerWSModel(GeneralWSModel general, List<SmsMessageTriggerWSDTO> smsMessageTriggers) {
        this.general = general;
        this.smsMessageTriggers = smsMessageTriggers;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<SmsMessageTriggerWSDTO> getSmsMessageTriggers() {
        return smsMessageTriggers;
    }

    public void setSmsMessageTriggers(List<SmsMessageTriggerWSDTO> smsMessageTriggers) {
        this.smsMessageTriggers = smsMessageTriggers;
    }
}
