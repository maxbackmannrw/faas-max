package com.faas.core.base.model.ws.campaign.details.channel;

import com.faas.core.base.model.ws.campaign.details.channel.dto.CampaignSmsChannelWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class CampaignSmsChannelWSModel {

    private GeneralWSModel general;
    private CampaignSmsChannelWSDTO campaignSmsChannel;

    public CampaignSmsChannelWSModel() {
    }

    public CampaignSmsChannelWSModel(GeneralWSModel general, CampaignSmsChannelWSDTO campaignSmsChannel) {
        this.general = general;
        this.campaignSmsChannel = campaignSmsChannel;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public CampaignSmsChannelWSDTO getCampaignSmsChannel() {
        return campaignSmsChannel;
    }

    public void setCampaignSmsChannel(CampaignSmsChannelWSDTO campaignSmsChannel) {
        this.campaignSmsChannel = campaignSmsChannel;
    }
}
