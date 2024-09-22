package com.faas.core.api.model.ws.general;

import com.faas.core.api.model.ws.general.dto.ApiSummaryWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiSummaryWSModel {

    private GeneralWSModel general;
    private List<ApiSummaryWSDTO> summaries;

    public ApiSummaryWSModel() {
    }

    public ApiSummaryWSModel(GeneralWSModel general, List<ApiSummaryWSDTO> summaries) {
        this.general = general;
        this.summaries = summaries;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiSummaryWSDTO> getSummaries() {
        return summaries;
    }

    public void setSummaries(List<ApiSummaryWSDTO> summaries) {
        this.summaries = summaries;
    }
}
