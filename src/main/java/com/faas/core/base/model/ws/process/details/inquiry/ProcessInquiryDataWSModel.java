package com.faas.core.base.model.ws.process.details.inquiry;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.inquiry.dto.ProcessInquiryDataWSDTO;

import java.util.List;

public class ProcessInquiryDataWSModel {

    private GeneralWSModel general;
    private List<ProcessInquiryDataWSDTO> inquiryDatas;

    public ProcessInquiryDataWSModel() {
    }

    public ProcessInquiryDataWSModel(GeneralWSModel general, List<ProcessInquiryDataWSDTO> inquiryDatas) {
        this.general = general;
        this.inquiryDatas = inquiryDatas;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ProcessInquiryDataWSDTO> getInquiryDatas() {
        return inquiryDatas;
    }

    public void setInquiryDatas(List<ProcessInquiryDataWSDTO> inquiryDatas) {
        this.inquiryDatas = inquiryDatas;
    }
}
