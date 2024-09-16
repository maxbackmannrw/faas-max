package com.faas.core.data.ws.base.campaign.details.channel;

import com.faas.core.data.ws.base.campaign.details.channel.dto.CampaignChannelWSDTO;
import com.faas.core.data.ws.base.general.GeneralWSModel;

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
