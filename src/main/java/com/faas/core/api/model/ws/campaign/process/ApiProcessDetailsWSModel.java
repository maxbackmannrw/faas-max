package com.faas.core.api.model.ws.campaign.process;

import com.faas.core.api.model.ws.campaign.process.dto.ApiProcessDetailsWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiProcessDetailsWSModel {

    private GeneralWSModel general;
    private List<ApiProcessDetailsWSDTO> processDetails;


    public ApiProcessDetailsWSModel() {
    }

    public ApiProcessDetailsWSModel(GeneralWSModel general, List<ApiProcessDetailsWSDTO> processDetails) {
        this.general = general;
        this.processDetails = processDetails;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiProcessDetailsWSDTO> getProcessDetails() {
        return processDetails;
    }

    public void setProcessDetails(List<ApiProcessDetailsWSDTO> processDetails) {
        this.processDetails = processDetails;
    }
}
