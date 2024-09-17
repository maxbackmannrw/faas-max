package com.faas.core.base.model.ws.dashboard.inquiry;

import com.faas.core.base.model.ws.dashboard.inquiry.dto.DashboardInquiryWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class DashboardInquiryWSModel {

    private GeneralWSModel general;
    private List<DashboardInquiryWSDTO> inquiries;

    public DashboardInquiryWSModel() {
    }

    public DashboardInquiryWSModel(GeneralWSModel general, List<DashboardInquiryWSDTO> inquiries) {
        this.general = general;
        this.inquiries = inquiries;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<DashboardInquiryWSDTO> getInquiries() {
        return inquiries;
    }

    public void setInquiries(List<DashboardInquiryWSDTO> inquiries) {
        this.inquiries = inquiries;
    }
}
