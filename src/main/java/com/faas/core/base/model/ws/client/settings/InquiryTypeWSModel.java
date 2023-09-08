package com.faas.core.base.model.ws.client.settings;

import com.faas.core.base.model.ws.client.settings.dto.InquiryTypeWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class InquiryTypeWSModel {

    private GeneralWSModel general;
    private List<InquiryTypeWSDTO>inquiryTypes;


    public InquiryTypeWSModel() {
    }

    public InquiryTypeWSModel(GeneralWSModel general, List<InquiryTypeWSDTO> inquiryTypes) {
        this.general = general;
        this.inquiryTypes = inquiryTypes;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<InquiryTypeWSDTO> getInquiryTypes() {
        return inquiryTypes;
    }

    public void setInquiryTypes(List<InquiryTypeWSDTO> inquiryTypes) {
        this.inquiryTypes = inquiryTypes;
    }
}
