package com.faas.core.base.model.ws.manager.inquiry.campaign;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.manager.inquiry.campaign.dto.InquiryCampaignWSDTO;

import java.util.List;

public class InquiryCampaignWSModel {

    private GeneralWSModel general;
    private List<InquiryCampaignWSDTO>campaigns;

    public InquiryCampaignWSModel() {
    }

    public InquiryCampaignWSModel(GeneralWSModel general, List<InquiryCampaignWSDTO> campaigns) {
        this.general = general;
        this.campaigns = campaigns;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<InquiryCampaignWSDTO> getCampaigns() {
        return campaigns;
    }

    public void setCampaigns(List<InquiryCampaignWSDTO> campaigns) {
        this.campaigns = campaigns;
    }
}
