package com.faas.core.base.model.ws.operation.channel;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.operation.channel.dto.WappMessageWSDTO;

import java.util.List;

public class WappMessageWSModel {

    private GeneralWSModel general;
    private List<WappMessageWSDTO>wappMessages;

    public WappMessageWSModel() {
    }

    public WappMessageWSModel(GeneralWSModel general, List<WappMessageWSDTO> wappMessages) {
        this.general = general;
        this.wappMessages = wappMessages;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<WappMessageWSDTO> getWappMessages() {
        return wappMessages;
    }

    public void setWappMessages(List<WappMessageWSDTO> wappMessages) {
        this.wappMessages = wappMessages;
    }
}
