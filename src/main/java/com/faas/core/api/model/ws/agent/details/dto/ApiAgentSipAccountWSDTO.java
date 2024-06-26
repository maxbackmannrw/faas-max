package com.faas.core.api.model.ws.agent.details.dto;

import com.faas.core.base.model.db.campaign.details.channel.dao.CampaignSipChannelDAO;
import com.faas.core.base.model.db.user.details.dao.UserSipChannelDAO;

public class ApiAgentSipAccountWSDTO {

    private UserSipChannelDAO sipAccount;
    private CampaignSipChannelDAO sipChannel;

    public ApiAgentSipAccountWSDTO() {
    }

    public ApiAgentSipAccountWSDTO(UserSipChannelDAO sipAccount, CampaignSipChannelDAO sipChannel) {
        this.sipAccount = sipAccount;
        this.sipChannel = sipChannel;
    }

    public UserSipChannelDAO getSipAccount() {
        return sipAccount;
    }

    public void setSipAccount(UserSipChannelDAO sipAccount) {
        this.sipAccount = sipAccount;
    }

    public CampaignSipChannelDAO getSipChannel() {
        return sipChannel;
    }

    public void setSipChannel(CampaignSipChannelDAO sipChannel) {
        this.sipChannel = sipChannel;
    }
}
