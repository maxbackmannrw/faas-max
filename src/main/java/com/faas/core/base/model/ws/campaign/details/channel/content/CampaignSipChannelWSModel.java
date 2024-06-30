package com.faas.core.base.model.ws.campaign.details.channel.content;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.campaign.details.channel.content.dto.CampaignSipChannelWSDTO;

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
