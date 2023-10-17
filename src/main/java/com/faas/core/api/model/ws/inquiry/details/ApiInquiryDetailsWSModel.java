package com.faas.core.api.model.ws.inquiry.details;

import com.faas.core.api.model.ws.inquiry.details.dto.ApiInquiryDetailsWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiInquiryDetailsWSModel {

    private GeneralWSModel general;
    private ApiInquiryDetailsWSDTO inquiryDetails;

    public ApiInquiryDetailsWSModel() {
    }

    public ApiInquiryDetailsWSModel(GeneralWSModel general, ApiInquiryDetailsWSDTO inquiryDetails) {
        this.general = general;
        this.inquiryDetails = inquiryDetails;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiInquiryDetailsWSDTO getInquiryDetails() {
        return inquiryDetails;
    }

    public void setInquiryDetails(ApiInquiryDetailsWSDTO inquiryDetails) {
        this.inquiryDetails = inquiryDetails;
    }
}
