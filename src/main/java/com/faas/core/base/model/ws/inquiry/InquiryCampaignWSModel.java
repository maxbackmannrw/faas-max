package com.faas.core.base.model.ws.inquiry;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.inquiry.dto.InquiryCampaignWSDTO;

import java.util.List;

public class InquiryCampaignWSModel {

    private GeneralWSModel general;
    private List<InquiryCampaignWSDTO>inquiryCampaigns;

    public InquiryCampaignWSModel() {
    }

    public InquiryCampaignWSModel(GeneralWSModel general, List<InquiryCampaignWSDTO> inquiryCampaigns) {
        this.general = general;
        this.inquiryCampaigns = inquiryCampaigns;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<InquiryCampaignWSDTO> getInquiryCampaigns() {
        return inquiryCampaigns;
    }

    public void setInquiryCampaigns(List<InquiryCampaignWSDTO> inquiryCampaigns) {
        this.inquiryCampaigns = inquiryCampaigns;
    }
}
