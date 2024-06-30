package com.faas.core.base.model.ws.campaign.details.trigger;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.campaign.details.trigger.dto.CampaignSipTriggerWSDTO;

import java.util.List;

public class CampaignSipTriggerWSModel {

    private GeneralWSModel general;
    private List<CampaignSipTriggerWSDTO>campaignSipTriggers;

    public CampaignSipTriggerWSModel() {
    }

    public CampaignSipTriggerWSModel(GeneralWSModel general, List<CampaignSipTriggerWSDTO> campaignSipTriggers) {
        this.general = general;
        this.campaignSipTriggers = campaignSipTriggers;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<CampaignSipTriggerWSDTO> getCampaignSipTriggers() {
        return campaignSipTriggers;
    }

    public void setCampaignSipTriggers(List<CampaignSipTriggerWSDTO> campaignSipTriggers) {
        this.campaignSipTriggers = campaignSipTriggers;
    }
}
