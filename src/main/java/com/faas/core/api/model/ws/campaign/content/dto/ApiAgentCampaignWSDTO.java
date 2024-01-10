package com.faas.core.api.model.ws.campaign.content.dto;

import java.util.List;

public class ApiAgentCampaignWSDTO {

    private List<ApiCampaignWSDTO> manualCampaigns;
    private List<ApiCampaignWSDTO> inquiryCampaigns;
    private List<ApiCampaignWSDTO> automaticCampaigns;

    public ApiAgentCampaignWSDTO() {
    }

    public ApiAgentCampaignWSDTO(List<ApiCampaignWSDTO> manualCampaigns, List<ApiCampaignWSDTO> inquiryCampaigns, List<ApiCampaignWSDTO> automaticCampaigns) {
        this.manualCampaigns = manualCampaigns;
        this.inquiryCampaigns = inquiryCampaigns;
        this.automaticCampaigns = automaticCampaigns;
    }

    public List<ApiCampaignWSDTO> getManualCampaigns() {
        return manualCampaigns;
    }

    public void setManualCampaigns(List<ApiCampaignWSDTO> manualCampaigns) {
        this.manualCampaigns = manualCampaigns;
    }

    public List<ApiCampaignWSDTO> getInquiryCampaigns() {
        return inquiryCampaigns;
    }

    public void setInquiryCampaigns(List<ApiCampaignWSDTO> inquiryCampaigns) {
        this.inquiryCampaigns = inquiryCampaigns;
    }

    public List<ApiCampaignWSDTO> getAutomaticCampaigns() {
        return automaticCampaigns;
    }

    public void setAutomaticCampaigns(List<ApiCampaignWSDTO> automaticCampaigns) {
        this.automaticCampaigns = automaticCampaigns;
    }
}
