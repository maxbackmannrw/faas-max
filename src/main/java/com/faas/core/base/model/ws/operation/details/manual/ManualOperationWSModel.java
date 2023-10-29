package com.faas.core.base.model.ws.operation.details.manual;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.operation.details.inquiry.dto.InquiryOperationWSDTO;

import java.util.List;

public class ManualOperationWSModel {

    private GeneralWSModel general;
    private List<InquiryOperationWSDTO> operationInquiries;

    public ManualOperationWSModel() {
    }

    public ManualOperationWSModel(GeneralWSModel general, List<InquiryOperationWSDTO> operationInquiries) {
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
