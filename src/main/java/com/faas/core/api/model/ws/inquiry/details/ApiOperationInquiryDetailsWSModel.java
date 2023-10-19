package com.faas.core.api.model.ws.inquiry.details;

import com.faas.core.api.model.ws.inquiry.details.dto.ApiOperationInquiryDetailsWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiOperationInquiryDetailsWSModel {

    private GeneralWSModel general;
    private ApiOperationInquiryDetailsWSDTO operationInquiryDetails;

    public ApiOperationInquiryDetailsWSModel() {
    }

    public ApiOperationInquiryDetailsWSModel(GeneralWSModel general, ApiOperationInquiryDetailsWSDTO operationInquiryDetails) {
        this.general = general;
        this.operationInquiryDetails = operationInquiryDetails;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiOperationInquiryDetailsWSDTO getOperationInquiryDetails() {
        return operationInquiryDetails;
    }

    public void setOperationInquiryDetails(ApiOperationInquiryDetailsWSDTO operationInquiryDetails) {
        this.operationInquiryDetails = operationInquiryDetails;
    }
}
