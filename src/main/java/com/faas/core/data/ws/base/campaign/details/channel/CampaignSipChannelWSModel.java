package com.faas.core.data.ws.base.campaign.details.channel;

import com.faas.core.data.ws.base.campaign.details.channel.dto.CampaignSipChannelWSDTO;
import com.faas.core.data.ws.base.general.GeneralWSModel;

public class CampaignSipChannelWSModel {

    private GeneralWSModel general;
    private CampaignSipChannelWSDTO campaignSipChannel;

    public CampaignSipChannelWSModel() {
    }

    public CampaignSipChannelWSModel(GeneralWSModel general, CampaignSipChannelWSDTO campaignSipChannel) {
        this.general = general;
        this.campaignSipChannel = campaignSipChannel;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public CampaignSipChannelWSDTO getCampaignSipChannel() {
        return campaignSipChannel;
    }

    public void setCampaignSipChannel(CampaignSipChannelWSDTO campaignSipChannel) {
        this.campaignSipChannel = campaignSipChannel;
    }
}
