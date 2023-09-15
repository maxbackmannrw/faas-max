package com.faas.core.base.model.ws.process.details.inquiry;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.inquiry.dto.InquiryDataWSDTO;

import java.util.List;

public class InquiryDataWSModel {

    private GeneralWSModel general;
    private List<InquiryDataWSDTO> inquiryDatas;

    public InquiryDataWSModel() {
    }

    public InquiryDataWSModel(GeneralWSModel general, List<InquiryDataWSDTO> inquiryDatas) {
        this.general = general;
        this.inquiryDatas = inquiryDatas;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<InquiryDataWSDTO> getInquiryDatas() {
        return inquiryDatas;
    }

    public void setInquiryDatas(List<InquiryDataWSDTO> inquiryDatas) {
        this.inquiryDatas = inquiryDatas;
    }
}
