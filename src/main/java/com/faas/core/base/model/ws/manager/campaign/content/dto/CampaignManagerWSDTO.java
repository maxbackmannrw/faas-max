package com.faas.core.base.model.ws.manager.campaign.content.dto;

import com.faas.core.base.model.ws.manager.campaign.details.automatic.dto.AutomaticCampaignWSDTO;
import com.faas.core.base.model.ws.manager.campaign.details.inquiry.dto.InquiryCampaignWSDTO;
import com.faas.core.base.model.ws.manager.campaign.details.manual.dto.ManualCampaignWSDTO;

import java.util.List;

public class CampaignManagerWSDTO {

    private List<ManualCampaignWSDTO>manualCampaigns;
    private List<InquiryCampaignWSDTO>inquiryCampaigns;
    private List<AutomaticCampaignWSDTO>automaticCampaigns;

    public CampaignManagerWSDTO() {
    }

    public CampaignManagerWSDTO(List<ManualCampaignWSDTO> manualCampaigns, List<InquiryCampaignWSDTO> inquiryCampaigns, List<AutomaticCampaignWSDTO> automaticCampaigns) {
        this.manualCampaigns = manualCampaigns;
        this.inquiryCampaigns = inquiryCampaigns;
        this.automaticCampaigns = automaticCampaigns;
    }

    public List<ManualCampaignWSDTO> getManualCampaigns() {
        return manualCampaigns;
    }

    public void setManualCampaigns(List<ManualCampaignWSDTO> manualCampaigns) {
        this.manualCampaigns = manualCampaigns;
    }

    public List<InquiryCampaignWSDTO> getInquiryCampaigns() {
        return inquiryCampaigns;
    }

    public void setInquiryCampaigns(List<InquiryCampaignWSDTO> inquiryCampaigns) {
        this.inquiryCampaigns = inquiryCampaigns;
    }

    public List<AutomaticCampaignWSDTO> getAutomaticCampaigns() {
        return automaticCampaigns;
    }

    public void setAutomaticCampaigns(List<AutomaticCampaignWSDTO> automaticCampaigns) {
        this.automaticCampaigns = automaticCampaigns;
    }
}
