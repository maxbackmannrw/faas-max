package com.faas.core.base.model.ws.operation.channel;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.operation.channel.dto.WappCallWSDTO;

import java.util.List;

public class WappCallWSModel {

    private GeneralWSModel general;
    private List<WappCallWSDTO>wappCalls;

    public WappCallWSModel() {
    }

    public WappCallWSModel(GeneralWSModel general, List<WappCallWSDTO> wappCalls) {
        this.general = general;
        this.wappCalls = wappCalls;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<WappCallWSDTO> getWappCalls() {
        return wappCalls;
    }

    public void setWappCalls(List<WappCallWSDTO> wappCalls) {
        this.wappCalls = wappCalls;
    }
}
