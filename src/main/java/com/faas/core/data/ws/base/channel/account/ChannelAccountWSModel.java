package com.faas.core.data.ws.base.channel.account;

import com.faas.core.data.ws.base.channel.account.dto.ChannelAccountWSDTO;
import com.faas.core.data.ws.base.general.GeneralWSModel;


public class ChannelAccountWSModel {

    private GeneralWSModel general;
    private ChannelAccountWSDTO channelAccounts;

    public ChannelAccountWSModel() {
    }

    public ChannelAccountWSModel(GeneralWSModel general, ChannelAccountWSDTO channelAccounts) {
        this.general = general;
        this.channelAccounts = channelAccounts;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ChannelAccountWSDTO getChannelAccounts() {
        return channelAccounts;
    }

    public void setChannelAccounts(ChannelAccountWSDTO channelAccounts) {
        this.channelAccounts = channelAccounts;
    }
}
