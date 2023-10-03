package com.faas.core.api.model.ws.operation.details.inquiry;

import com.faas.core.api.model.ws.operation.details.inquiry.dto.ApiOperationInquiryWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;


public class ApiOperationInquiryWSModel {

    private GeneralWSModel general;
    private List<ApiOperationInquiryWSDTO> operationInquiries;

    public ApiOperationInquiryWSModel() {
    }

    public ApiOperationInquiryWSModel(GeneralWSModel general, List<ApiOperationInquiryWSDTO> operationInquiries) {
        this.general = general;
        this.operationInquiries = operationInquiries;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiOperationInquiryWSDTO> getOperationInquiries() {
        return operationInquiries;
    }

    public void setOperationInquiries(List<ApiOperationInquiryWSDTO> operationInquiries) {
        this.operationInquiries = operationInquiries;
    }
}
