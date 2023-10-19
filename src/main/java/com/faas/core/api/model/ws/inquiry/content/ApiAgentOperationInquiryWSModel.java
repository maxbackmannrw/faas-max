package com.faas.core.api.model.ws.inquiry.content;

import com.faas.core.api.model.ws.inquiry.content.dto.ApiAgentOperationInquiryWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiAgentOperationInquiryWSModel {

    private GeneralWSModel general;
    private ApiAgentOperationInquiryWSDTO agentOperationInquiry;

    public ApiAgentOperationInquiryWSModel() {
    }

    public ApiAgentOperationInquiryWSModel(GeneralWSModel general, ApiAgentOperationInquiryWSDTO agentOperationInquiry) {
        this.general = general;
        this.agentOperationInquiry = agentOperationInquiry;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiAgentOperationInquiryWSDTO getAgentOperationInquiry() {
        return agentOperationInquiry;
    }

    public void setAgentOperationInquiry(ApiAgentOperationInquiryWSDTO agentOperationInquiry) {
        this.agentOperationInquiry = agentOperationInquiry;
    }
}
