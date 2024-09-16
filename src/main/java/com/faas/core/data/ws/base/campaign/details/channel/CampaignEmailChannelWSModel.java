package com.faas.core.data.ws.base.campaign.details.channel;

import com.faas.core.data.ws.base.campaign.details.channel.dto.CampaignEmailChannelWSDTO;
import com.faas.core.data.ws.base.general.GeneralWSModel;

public class CampaignEmailChannelWSModel {

    private GeneralWSModel general;
    private CampaignEmailChannelWSDTO campaignEmailChannel;

    public CampaignEmailChannelWSModel() {
    }

    public CampaignEmailChannelWSModel(GeneralWSModel general, CampaignEmailChannelWSDTO campaignEmailChannel) {
        this.general = general;
        this.campaignEmailChannel = campaignEmailChannel;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public CampaignEmailChannelWSDTO getCampaignEmailChannel() {
        return campaignEmailChannel;
    }

    public void setCampaignEmailChannel(CampaignEmailChannelWSDTO campaignEmailChannel) {
        this.campaignEmailChannel = campaignEmailChannel;
    }
}
