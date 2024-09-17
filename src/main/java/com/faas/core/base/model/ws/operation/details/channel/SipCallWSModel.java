package com.faas.core.base.model.ws.operation.details.channel;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.operation.details.channel.dto.SipCallWSDTO;

import java.util.List;

public class SipCallWSModel {

    private GeneralWSModel general;
    private List<SipCallWSDTO> operationSipCalls;

    public SipCallWSModel() {
    }

    public SipCallWSModel(GeneralWSModel general, List<SipCallWSDTO> operationSipCalls) {
        this.general = general;
        this.operationSipCalls = operationSipCalls;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<SipCallWSDTO> getOperationSipCalls() {
        return operationSipCalls;
    }

    public void setOperationSipCalls(List<SipCallWSDTO> operationSipCalls) {
        this.operationSipCalls = operationSipCalls;
    }
}
