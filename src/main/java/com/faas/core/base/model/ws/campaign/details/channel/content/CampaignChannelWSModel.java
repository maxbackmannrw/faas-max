package com.faas.core.base.model.ws.campaign.details.channel.content;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.campaign.details.channel.content.dto.CampaignChannelWSDTO;

public class CampaignChannelWSModel {

    private GeneralWSModel general;
    private CampaignChannelWSDTO campaignChannel;

    public CampaignChannelWSModel() {
    }

    public CampaignChannelWSModel(GeneralWSModel general, CampaignChannelWSDTO campaignChannel) {
        this.general = general;
        this.campaignChannel = campaignChannel;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public CampaignChannelWSDTO getCampaignChannel() {
        return campaignChannel;
    }

    public void setCampaignChannel(CampaignChannelWSDTO campaignChannel) {
        this.campaignChannel = campaignChannel;
    }
}
