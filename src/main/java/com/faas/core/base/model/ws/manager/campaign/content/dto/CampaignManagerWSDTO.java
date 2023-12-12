package com.faas.core.base.model.ws.manager.campaign.content.dto;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.process.content.ProcessDBModel;

public class CampaignManagerWSDTO {

    private CampaignDBModel campaign;
    private ProcessDBModel campaignProcess;

    public CampaignManagerWSDTO() {
    }

    public CampaignManagerWSDTO(CampaignDBModel campaign, ProcessDBModel campaignProcess) {
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
