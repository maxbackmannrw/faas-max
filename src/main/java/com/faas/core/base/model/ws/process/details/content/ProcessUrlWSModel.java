package com.faas.core.base.model.ws.process.details.content;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.content.dto.ProcessUrlWSDTO;

import java.util.List;

public class ProcessUrlWSModel {

    private GeneralWSModel general;
    private List<ProcessUrlWSDTO>processUrls;

    public ProcessUrlWSModel() {
    }

    public ProcessUrlWSModel(GeneralWSModel general, List<ProcessUrlWSDTO> processUrls) {
        this.general = general;
        this.processUrls = processUrls;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ProcessUrlWSDTO> getProcessUrls() {
        return processUrls;
    }

    public void setProcessUrls(List<ProcessUrlWSDTO> processUrls) {
        this.processUrls = processUrls;
    }
}
