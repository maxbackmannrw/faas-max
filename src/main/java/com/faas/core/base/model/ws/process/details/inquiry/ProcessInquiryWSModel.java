package com.faas.core.base.model.ws.process.details.inquiry;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.inquiry.dto.ProcessInquiryWSDTO;


public class ProcessInquiryWSModel {

    private GeneralWSModel general;
    private ProcessInquiryWSDTO processInquiry;

    public ProcessInquiryWSModel() {
    }

    public ProcessInquiryWSModel(GeneralWSModel general, ProcessInquiryWSDTO processInquiry) {
        this.general = general;
        this.processInquiry = processInquiry;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ProcessInquiryWSDTO getProcessInquiry() {
        return processInquiry;
    }

    public void setProcessInquiry(ProcessInquiryWSDTO processInquiry) {
        this.processInquiry = processInquiry;
    }
}
