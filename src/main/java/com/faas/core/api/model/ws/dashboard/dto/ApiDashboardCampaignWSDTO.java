package com.faas.core.api.model.ws.dashboard.dto;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.process.content.ProcessDBModel;

public class ApiDashboardCampaignWSDTO {

    private CampaignDBModel campaign;
    private ProcessDBModel campaignProcess;

    public ApiDashboardCampaignWSDTO() {
    }

    public ApiDashboardCampaignWSDTO(CampaignDBModel campaign, ProcessDBModel campaignProcess) {
        this.campaign = campaign;
        this.campaignProcess = campaignProcess;
    }

    public CampaignDBModel getCampaign() {
        return campaign;
    }

    public void setCampaign(CampaignDBModel campaign) {
        this.campaign = campaign;
    }

    public ProcessDBModel getCampaignProcess() {
        return campaignProcess;
    }

    public void setCampaignProcess(ProcessDBModel campaignProcess) {
        this.campaignProcess = campaignProcess;
    }
}
