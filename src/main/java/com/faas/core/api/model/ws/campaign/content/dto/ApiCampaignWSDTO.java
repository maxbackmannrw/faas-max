package com.faas.core.api.model.ws.campaign.content.dto;

import com.faas.core.api.model.ws.general.ApiSummaryWSDTO;
import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.process.content.ProcessDBModel;

import java.util.List;

public class ApiCampaignWSDTO {

    private CampaignDBModel campaign;
    private ProcessDBModel campaignProcess;
    private List<ApiSummaryWSDTO> summaries;

    public ApiCampaignWSDTO() {
    }

    public ApiCampaignWSDTO(CampaignDBModel campaign, ProcessDBModel campaignProcess, List<ApiSummaryWSDTO> summaries) {
        this.campaign = campaign;
        this.campaignProcess = campaignProcess;
        this.summaries = summaries;
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

    public List<ApiSummaryWSDTO> getSummaries() {
        return summaries;
    }

    public void setSummaries(List<ApiSummaryWSDTO> summaries) {
        this.summaries = summaries;
    }
}
