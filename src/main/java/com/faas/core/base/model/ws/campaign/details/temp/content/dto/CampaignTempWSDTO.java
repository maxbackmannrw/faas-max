package com.faas.core.base.model.ws.campaign.details.temp.content.dto;

import com.faas.core.base.model.ws.campaign.details.temp.details.dto.CampaignEmailTempWSDTO;
import com.faas.core.base.model.ws.campaign.details.temp.details.dto.CampaignPushTempWSDTO;
import com.faas.core.base.model.ws.campaign.details.temp.details.dto.CampaignSmsTempWSDTO;
import com.faas.core.base.model.ws.campaign.details.temp.details.dto.CampaignWappMessageTempWSDTO;

import java.util.List;

public class CampaignTempWSDTO {

    private List<CampaignEmailTempWSDTO> campaignEmailTemps;
    private List<CampaignPushTempWSDTO> campaignPushTemps;
    private List<CampaignSmsTempWSDTO> campaignSmsTemps;
    private List<CampaignWappMessageTempWSDTO> campaignWappMessageTemps;

    public CampaignTempWSDTO() {
    }

    public CampaignTempWSDTO(List<CampaignEmailTempWSDTO> campaignEmailTemps, List<CampaignPushTempWSDTO> campaignPushTemps, List<CampaignSmsTempWSDTO> campaignSmsTemps, List<CampaignWappMessageTempWSDTO> campaignWappMessageTemps) {
        this.campaignEmailTemps = campaignEmailTemps;
        this.campaignPushTemps = campaignPushTemps;
        this.campaignSmsTemps = campaignSmsTemps;
        this.campaignWappMessageTemps = campaignWappMessageTemps;
    }

    public List<CampaignEmailTempWSDTO> getCampaignEmailTemps() {
        return campaignEmailTemps;
    }

    public void setCampaignEmailTemps(List<CampaignEmailTempWSDTO> campaignEmailTemps) {
        this.campaignEmailTemps = campaignEmailTemps;
    }

    public List<CampaignPushTempWSDTO> getCampaignPushTemps() {
        return campaignPushTemps;
    }

    public void setCampaignPushTemps(List<CampaignPushTempWSDTO> campaignPushTemps) {
        this.campaignPushTemps = campaignPushTemps;
    }

    public List<CampaignSmsTempWSDTO> getCampaignSmsTemps() {
        return campaignSmsTemps;
    }

    public void setCampaignSmsTemps(List<CampaignSmsTempWSDTO> campaignSmsTemps) {
        this.campaignSmsTemps = campaignSmsTemps;
    }

    public List<CampaignWappMessageTempWSDTO> getCampaignWappMessageTemps() {
        return campaignWappMessageTemps;
    }

    public void setCampaignWappMessageTemps(List<CampaignWappMessageTempWSDTO> campaignWappMessageTemps) {
        this.campaignWappMessageTemps = campaignWappMessageTemps;
    }
}
