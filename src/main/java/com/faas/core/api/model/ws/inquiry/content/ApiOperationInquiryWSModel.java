package com.faas.core.api.model.ws.inquiry.content;

import com.faas.core.api.model.ws.inquiry.content.dto.ApiOperationInquiryWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiOperationInquiryWSModel {

    private GeneralWSModel general;
    private ApiOperationInquiryWSDTO operationInquiry;

    public ApiOperationInquiryWSModel() {
    }

    public ApiOperationInquiryWSModel(GeneralWSModel general, ApiOperationInquiryWSDTO operationInquiry) {
        this.general = general;
        this.operationInquiry = operationInquiry;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiOperationInquiryWSDTO getOperationInquiry() {
        return operationInquiry;
    }

    public void setOperationInquiry(ApiOperationInquiryWSDTO operationInquiry) {
        this.operationInquiry = operationInquiry;
    }
}
