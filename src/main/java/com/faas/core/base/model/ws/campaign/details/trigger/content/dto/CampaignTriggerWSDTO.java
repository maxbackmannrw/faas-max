package com.faas.core.base.model.ws.campaign.details.trigger.content.dto;

import com.faas.core.base.model.ws.campaign.details.trigger.details.dto.*;

import java.util.List;

public class CampaignTriggerWSDTO {

    private List<CampaignAITriggerWSDTO> campaignAITriggers;
    private List<CampaignEmailTriggerWSDTO>campaignEmailTriggers;
    private List<CampaignSipTriggerWSDTO>campaignSipTriggers;
    private List<CampaignSmsTriggerWSDTO>campaignSmsTriggers;
    private List<CampaignWappCallTriggerWSDTO>campaignWappCallTriggers;
    private List<CampaignWappMessageTriggerWSDTO>campaignWappMessageTriggers;

    public CampaignTriggerWSDTO() {
    }

    public CampaignTriggerWSDTO(List<CampaignAITriggerWSDTO> campaignAITriggers, List<CampaignEmailTriggerWSDTO> campaignEmailTriggers, List<CampaignSipTriggerWSDTO> campaignSipTriggers, List<CampaignSmsTriggerWSDTO> campaignSmsTriggers, List<CampaignWappCallTriggerWSDTO> campaignWappCallTriggers, List<CampaignWappMessageTriggerWSDTO> campaignWappMessageTriggers) {
        this.campaignAITriggers = campaignAITriggers;
        this.campaignEmailTriggers = campaignEmailTriggers;
        this.campaignSipTriggers = campaignSipTriggers;
        this.campaignSmsTriggers = campaignSmsTriggers;
        this.campaignWappCallTriggers = campaignWappCallTriggers;
        this.campaignWappMessageTriggers = campaignWappMessageTriggers;
    }

    public List<CampaignAITriggerWSDTO> getCampaignAITriggers() {
        return campaignAITriggers;
    }

    public void setCampaignAITriggers(List<CampaignAITriggerWSDTO> campaignAITriggers) {
        this.campaignAITriggers = campaignAITriggers;
    }

    public List<CampaignEmailTriggerWSDTO> getCampaignEmailTriggers() {
        return campaignEmailTriggers;
    }

    public void setCampaignEmailTriggers(List<CampaignEmailTriggerWSDTO> campaignEmailTriggers) {
        this.campaignEmailTriggers = campaignEmailTriggers;
    }

    public List<CampaignSipTriggerWSDTO> getCampaignSipTriggers() {
        return campaignSipTriggers;
    }

    public void setCampaignSipTriggers(List<CampaignSipTriggerWSDTO> campaignSipTriggers) {
        this.campaignSipTriggers = campaignSipTriggers;
    }

    public List<CampaignSmsTriggerWSDTO> getCampaignSmsTriggers() {
        return campaignSmsTriggers;
    }

    public void setCampaignSmsTriggers(List<CampaignSmsTriggerWSDTO> campaignSmsTriggers) {
        this.campaignSmsTriggers = campaignSmsTriggers;
    }

    public List<CampaignWappCallTriggerWSDTO> getCampaignWappCallTriggers() {
        return campaignWappCallTriggers;
    }

    public void setCampaignWappCallTriggers(List<CampaignWappCallTriggerWSDTO> campaignWappCallTriggers) {
        this.campaignWappCallTriggers = campaignWappCallTriggers;
    }

    public List<CampaignWappMessageTriggerWSDTO> getCampaignWappMessageTriggers() {
        return campaignWappMessageTriggers;
    }

    public void setCampaignWappMessageTriggers(List<CampaignWappMessageTriggerWSDTO> campaignWappMessageTriggers) {
        this.campaignWappMessageTriggers = campaignWappMessageTriggers;
    }
}
