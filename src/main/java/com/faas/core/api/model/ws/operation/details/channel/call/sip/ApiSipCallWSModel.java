package com.faas.core.api.model.ws.operation.details.channel.call.sip;

import com.faas.core.api.model.ws.operation.details.channel.call.sip.dto.ApiSipCallWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;


public class ApiSipCallWSModel {

    private GeneralWSModel general;
    private List<ApiSipCallWSDTO>sipCalls;

    public ApiSipCallWSModel() {
    }

    public ApiSipCallWSModel(GeneralWSModel general, List<ApiSipCallWSDTO> sipCalls) {
        this.general = general;
        this.sipCalls = sipCalls;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiSipCallWSDTO> getSipCalls() {
        return sipCalls;
    }

    public void setSipCalls(List<ApiSipCallWSDTO> sipCalls) {
        this.sipCalls = sipCalls;
    }
}
