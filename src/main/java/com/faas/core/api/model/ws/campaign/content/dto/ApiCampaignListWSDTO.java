package com.faas.core.api.model.ws.campaign.content.dto;

import java.util.List;

public class ApiCampaignListWSDTO {

    private List<ApiCampaignWSDTO> manualCampaigns;
    private List<ApiCampaignWSDTO> inquiryCampaigns;

    public ApiCampaignListWSDTO() {
    }

    public ApiCampaignListWSDTO(List<ApiCampaignWSDTO> manualCampaigns, List<ApiCampaignWSDTO> inquiryCampaigns) {
        this.manualCampaigns = manualCampaigns;
        this.inquiryCampaigns = inquiryCampaigns;
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
}
