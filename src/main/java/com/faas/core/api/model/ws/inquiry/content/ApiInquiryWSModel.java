package com.faas.core.api.model.ws.inquiry.content;

import com.faas.core.api.model.ws.inquiry.content.dto.ApiInquiryWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiInquiryWSModel {

    private GeneralWSModel general;
    private List<ApiInquiryWSDTO> inquiries;

    public ApiInquiryWSModel() {
    }

    public ApiInquiryWSModel(GeneralWSModel general, List<ApiInquiryWSDTO> inquiries) {
        this.general = general;
        this.inquiries = inquiries;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiInquiryWSDTO> getInquiries() {
        return inquiries;
    }

    public void setInquiries(List<ApiInquiryWSDTO> inquiries) {
        this.inquiries = inquiries;
    }
}
