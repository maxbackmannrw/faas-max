package com.faas.core.base.model.ws.process.details.inquiry;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.inquiry.dto.InquiryUrlWSDTO;

import java.util.List;

public class InquiryUrlWSModel {

    private GeneralWSModel general;
    private List<InquiryUrlWSDTO> inquiryUrls;

    public InquiryUrlWSModel() {
    }

    public InquiryUrlWSModel(GeneralWSModel general, List<InquiryUrlWSDTO> inquiryUrls) {
        this.general = general;
        this.inquiryUrls = inquiryUrls;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<InquiryUrlWSDTO> getInquiryUrls() {
        return inquiryUrls;
    }

    public void setInquiryUrls(List<InquiryUrlWSDTO> inquiryUrls) {
        this.inquiryUrls = inquiryUrls;
    }
}
