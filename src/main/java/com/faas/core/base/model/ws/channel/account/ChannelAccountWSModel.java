package com.faas.core.base.model.ws.channel.account;

import com.faas.core.base.model.ws.channel.account.dto.*;
import com.faas.core.base.model.ws.general.GeneralWSModel;


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
