package com.faas.core.base.model.ws.process.details.content;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.content.dto.ProcessDataWSDTO;

import java.util.List;

public class ProcessDataWSModel {

    private GeneralWSModel general;
    private List<ProcessDataWSDTO>processDatas;

    public ProcessDataWSModel() {
    }

    public ProcessDataWSModel(GeneralWSModel general, List<ProcessDataWSDTO> processDatas) {
        this.general = general;
        this.processDatas = processDatas;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ProcessDataWSDTO> getProcessDatas() {
        return processDatas;
    }

    public void setProcessDatas(List<ProcessDataWSDTO> processDatas) {
        this.processDatas = processDatas;
    }
}
