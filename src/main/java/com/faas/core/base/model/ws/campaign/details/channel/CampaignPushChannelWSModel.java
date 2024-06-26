package com.faas.core.base.model.ws.campaign.details.channel;

import com.faas.core.base.model.ws.campaign.details.channel.dto.CampaignPushChannelWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class CampaignPushChannelWSModel {

    private GeneralWSModel general;
    private CampaignPushChannelWSDTO campaignPushChannel;

    public CampaignPushChannelWSModel() {
    }

    public CampaignPushChannelWSModel(GeneralWSModel general, CampaignPushChannelWSDTO campaignPushChannel) {
        this.general = general;
        this.campaignPushChannel = campaignPushChannel;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public CampaignPushChannelWSDTO getCampaignPushChannel() {
        return campaignPushChannel;
    }

    public void setCampaignPushChannel(CampaignPushChannelWSDTO campaignPushChannel) {
        this.campaignPushChannel = campaignPushChannel;
    }
}
