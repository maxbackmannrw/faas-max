package com.faas.core.api.model.ws.client.inquiry.content;

import com.faas.core.api.model.ws.client.inquiry.content.dto.ApiClientInquiryWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiClientInquiryWSModel {

    private GeneralWSModel general;
    private ApiClientInquiryWSDTO clientInquiry;

    public ApiClientInquiryWSModel() {
    }

    public ApiClientInquiryWSModel(GeneralWSModel general, ApiClientInquiryWSDTO clientInquiry) {
        this.general = general;
        this.clientInquiry = clientInquiry;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiClientInquiryWSDTO getClientInquiry() {
        return clientInquiry;
    }

    public void setClientInquiry(ApiClientInquiryWSDTO clientInquiry) {
        this.clientInquiry = clientInquiry;
    }
}
