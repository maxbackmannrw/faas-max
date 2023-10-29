package com.faas.core.base.model.ws.operation.details.inquiry;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.operation.details.inquiry.dto.InquiryOperationWSDTO;

import java.util.List;

public class InquiryOperationWSModel {

    private GeneralWSModel general;
    private List<InquiryOperationWSDTO> operationInquiries;

    public InquiryOperationWSModel() {
    }

    public InquiryOperationWSModel(GeneralWSModel general, List<InquiryOperationWSDTO> operationInquiries) {
        this.general = general;
        this.operationInquiries = operationInquiries;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<InquiryOperationWSDTO> getOperationInquiries() {
        return operationInquiries;
    }

    public void setOperationInquiries(List<InquiryOperationWSDTO> operationInquiries) {
        this.operationInquiries = operationInquiries;
    }
}
