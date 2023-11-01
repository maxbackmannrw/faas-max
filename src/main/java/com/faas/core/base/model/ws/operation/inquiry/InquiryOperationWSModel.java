package com.faas.core.base.model.ws.operation.inquiry;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.operation.inquiry.dto.InquiryOperationWSDTO;

import java.util.List;

public class InquiryOperationWSModel {

    private GeneralWSModel general;
    private List<InquiryOperationWSDTO> inquiryOperations;

    public InquiryOperationWSModel() {
    }

    public InquiryOperationWSModel(GeneralWSModel general, List<InquiryOperationWSDTO> inquiryOperations) {
        this.general = general;
        this.inquiryOperations = inquiryOperations;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<InquiryOperationWSDTO> getInquiryOperations() {
        return inquiryOperations;
    }

    public void setInquiryOperations(List<InquiryOperationWSDTO> inquiryOperations) {
        this.inquiryOperations = inquiryOperations;
    }
}
