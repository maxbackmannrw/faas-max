package com.faas.core.base.model.ws.manager.inquiry;

import com.faas.core.base.model.ws.manager.inquiry.dto.OperationInquirySessionWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class OperationInquirySessionWSModel {

    private GeneralWSModel general;
    private List<OperationInquirySessionWSDTO> inquirySessions;

    public OperationInquirySessionWSModel() {
    }

    public OperationInquirySessionWSModel(GeneralWSModel general, List<OperationInquirySessionWSDTO> inquirySessions) {
        this.general = general;
        this.inquirySessions = inquirySessions;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<OperationInquirySessionWSDTO> getInquirySessions() {
        return inquirySessions;
    }

    public void setInquirySessions(List<OperationInquirySessionWSDTO> inquirySessions) {
        this.inquirySessions = inquirySessions;
    }
}
