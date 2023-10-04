package com.faas.core.base.model.ws.operation.inquiry;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.operation.inquiry.dto.OperationInquiryWSDTO;

import java.util.List;

public class OperationInquiryWSModel {

    private GeneralWSModel general;
    private List<OperationInquiryWSDTO> operationInquiries;

    public OperationInquiryWSModel() {
    }

    public OperationInquiryWSModel(GeneralWSModel general, List<OperationInquiryWSDTO> operationInquiries) {
        this.general = general;
        this.operationInquiries = operationInquiries;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<OperationInquiryWSDTO> getOperationInquiries() {
        return operationInquiries;
    }

    public void setOperationInquiries(List<OperationInquiryWSDTO> operationInquiries) {
        this.operationInquiries = operationInquiries;
    }
}
