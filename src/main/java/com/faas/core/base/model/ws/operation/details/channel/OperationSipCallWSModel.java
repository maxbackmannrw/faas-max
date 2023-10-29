package com.faas.core.base.model.ws.operation.details.channel;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.operation.details.channel.dto.OperationSipCallWSDTO;

import java.util.List;

public class OperationSipCallWSModel {

    private GeneralWSModel general;
    private List<OperationSipCallWSDTO>sipCalls;

    public OperationSipCallWSModel() {
    }

    public OperationSipCallWSModel(GeneralWSModel general, List<OperationSipCallWSDTO> sipCalls) {
        this.general = general;
        this.sipCalls = sipCalls;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<OperationSipCallWSDTO> getSipCalls() {
        return sipCalls;
    }

    public void setSipCalls(List<OperationSipCallWSDTO> sipCalls) {
        this.sipCalls = sipCalls;
    }
}
