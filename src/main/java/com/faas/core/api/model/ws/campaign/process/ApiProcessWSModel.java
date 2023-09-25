package com.faas.core.api.model.ws.campaign.process;

import com.faas.core.api.model.ws.campaign.process.dto.ApiProcessWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiProcessWSModel {

    private GeneralWSModel general;
    private List<ApiProcessWSDTO>processes;


    public ApiProcessWSModel() {
    }

    public ApiProcessWSModel(GeneralWSModel general, List<ApiProcessWSDTO> processes) {
        this.general = general;
        this.processes = processes;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiProcessWSDTO> getProcesses() {
        return processes;
    }

    public void setProcesses(List<ApiProcessWSDTO> processes) {
        this.processes = processes;
    }
}
