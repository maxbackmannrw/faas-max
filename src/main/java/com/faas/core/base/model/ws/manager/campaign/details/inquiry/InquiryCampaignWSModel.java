package com.faas.core.base.model.ws.manager.campaign.details.inquiry;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.manager.campaign.content.dto.OperationCampaignWSDTO;

import java.util.List;

public class InquiryCampaignWSModel {

    private GeneralWSModel general;
    private List<OperationCampaignWSDTO>campaigns;

    public InquiryCampaignWSModel() {
    }

    public InquiryCampaignWSModel(GeneralWSModel general, List<OperationCampaignWSDTO> campaigns) {
        this.general = general;
        this.campaigns = campaigns;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<OperationCampaignWSDTO> getCampaigns() {
        return campaigns;
    }

    public void setCampaigns(List<OperationCampaignWSDTO> campaigns) {
        this.campaigns = campaigns;
    }
}
