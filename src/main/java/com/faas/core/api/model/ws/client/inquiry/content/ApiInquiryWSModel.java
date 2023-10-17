package com.faas.core.api.model.ws.client.inquiry.content;

import com.faas.core.api.model.ws.client.inquiry.content.dto.ApiInquiryWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiInquiryWSModel {

    private GeneralWSModel general;
    private ApiInquiryWSDTO inquiry;

    public ApiInquiryWSModel() {
    }

    public ApiInquiryWSModel(GeneralWSModel general, ApiInquiryWSDTO inquiry) {
        this.general = general;
        this.inquiry = inquiry;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiInquiryWSDTO getInquiry() {
        return inquiry;
    }

    public void setInquiry(ApiInquiryWSDTO inquiry) {
        this.inquiry = inquiry;
    }
}
