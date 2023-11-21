package com.faas.core.base.model.ws.operation.inquiry.content;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.operation.inquiry.content.dto.InquiryManagerWSDTO;

public class InquiryManagerWSModel {

    private GeneralWSModel general;
    private InquiryManagerWSDTO inquiryManager;

    public InquiryManagerWSModel() {
    }

    public InquiryManagerWSModel(GeneralWSModel general, InquiryManagerWSDTO inquiryManager) {
        this.general = general;
        this.inquiryManager = inquiryManager;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public InquiryManagerWSDTO getInquiryManager() {
        return inquiryManager;
    }

    public void setInquiryManager(InquiryManagerWSDTO inquiryManager) {
        this.inquiryManager = inquiryManager;
    }
}
