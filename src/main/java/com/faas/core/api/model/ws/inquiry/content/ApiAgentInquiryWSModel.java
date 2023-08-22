package com.faas.core.api.model.ws.inquiry.content;

import com.faas.core.api.model.ws.inquiry.content.dto.ApiAgentInquiryWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiAgentInquiryWSModel {

    private GeneralWSModel general;
    private ApiAgentInquiryWSDTO agentInquiry;

    public ApiAgentInquiryWSModel() {
    }

    public ApiAgentInquiryWSModel(GeneralWSModel general, ApiAgentInquiryWSDTO agentInquiry) {
        this.general = general;
        this.agentInquiry = agentInquiry;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiAgentInquiryWSDTO getAgentInquiry() {
        return agentInquiry;
    }

    public void setAgentInquiry(ApiAgentInquiryWSDTO agentInquiry) {
        this.agentInquiry = agentInquiry;
    }
}
