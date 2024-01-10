package com.faas.core.api.model.ws.campaign.details.dto;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;


public class ApiCampaignDetailsWSDTO {

    private CampaignDBModel campaign;
    private ApiCampaignProcessWSDTO campaignProcess;

    public ApiCampaignDetailsWSDTO() {
    }

    public ApiCampaignDetailsWSDTO(CampaignDBModel campaign, ApiCampaignProcessWSDTO campaignProcess) {
        this.campaign = campaign;
        this.campaignProcess = campaignProcess;
    }

    public CampaignDBModel getCampaign() {
        return campaign;
    }

    public void setCampaign(CampaignDBModel campaign) {
        this.campaign = campaign;
    }

    public ApiCampaignProcessWSDTO getCampaignProcess() {
        return campaignProcess;
    }

    public void setCampaignProcess(ApiCampaignProcessWSDTO campaignProcess) {
        this.campaignProcess = campaignProcess;
    }
}
