package com.faas.core.base.model.ws.client.inquiry;

import com.faas.core.base.model.ws.client.inquiry.dto.InquirySessionWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class InquirySessionWSModel {

    private GeneralWSModel general;
    private List<InquirySessionWSDTO> inquirySessions;

    public InquirySessionWSModel() {
    }

    public InquirySessionWSModel(GeneralWSModel general, List<InquirySessionWSDTO> inquirySessions) {
        this.general = general;
        this.inquirySessions = inquirySessions;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<InquirySessionWSDTO> getInquirySessions() {
        return inquirySessions;
    }

    public void setInquirySessions(List<InquirySessionWSDTO> inquirySessions) {
        this.inquirySessions = inquirySessions;
    }
}
