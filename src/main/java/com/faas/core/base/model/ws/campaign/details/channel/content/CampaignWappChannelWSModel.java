package com.faas.core.base.model.ws.campaign.details.channel.content;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.campaign.details.channel.content.dto.CampaignWappChannelWSDTO;

public class CampaignWappChannelWSModel {

    private GeneralWSModel general;
    private CampaignWappChannelWSDTO campaignWappChannel;

    public CampaignWappChannelWSModel() {
    }

    public CampaignWappChannelWSModel(GeneralWSModel general, CampaignWappChannelWSDTO campaignWappChannel) {
        this.general = general;
        this.campaignWappChannel = campaignWappChannel;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public CampaignWappChannelWSDTO getCampaignWappChannel() {
        return campaignWappChannel;
    }

    public void setCampaignWappChannel(CampaignWappChannelWSDTO campaignWappChannel) {
        this.campaignWappChannel = campaignWappChannel;
    }
}
