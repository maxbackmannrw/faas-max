package com.faas.core.api.model.ws.campaign.details.content.dto;

import com.faas.core.api.model.ws.campaign.details.process.content.dto.ApiProcessWSDTO;
import com.faas.core.base.model.db.campaign.content.CampaignDBModel;

import java.util.List;

public class ApiCampaignDetailsWSDTO {

    private CampaignDBModel campaign;
    private List<ApiProcessWSDTO> processes;

    public ApiCampaignDetailsWSDTO() {
    }

    public ApiCampaignDetailsWSDTO(CampaignDBModel campaign, List<ApiProcessWSDTO> processes) {
        this.campaign = campaign;
        this.processes = processes;
    }

    public CampaignDBModel getCampaign() {
        return campaign;
    }

    public void setCampaign(CampaignDBModel campaign) {
        this.campaign = campaign;
    }

    public List<ApiProcessWSDTO> getProcesses() {
        return processes;
    }

    public void setProcesses(List<ApiProcessWSDTO> processes) {
        this.processes = processes;
    }
}
