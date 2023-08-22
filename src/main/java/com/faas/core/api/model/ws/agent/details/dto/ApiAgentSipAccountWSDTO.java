package com.faas.core.api.model.ws.agent.details.dto;

import com.faas.core.base.model.db.process.details.channel.content.ProcessSipChannelDBModel;
import com.faas.core.base.model.db.user.details.dao.UserSipChannelDAO;

public class ApiAgentSipAccountWSDTO {

    private UserSipChannelDAO sipAccount;
    private ProcessSipChannelDBModel sipChannel;

    public ApiAgentSipAccountWSDTO() {
    }

    public ApiAgentSipAccountWSDTO(UserSipChannelDAO sipAccount, ProcessSipChannelDBModel sipChannel) {
        this.sipAccount = sipAccount;
        this.sipChannel = sipChannel;
    }

    public UserSipChannelDAO getSipAccount() {
        return sipAccount;
    }

    public void setSipAccount(UserSipChannelDAO sipAccount) {
        this.sipAccount = sipAccount;
    }

    public ProcessSipChannelDBModel getSipChannel() {
        return sipChannel;
    }

    public void setSipChannel(ProcessSipChannelDBModel sipChannel) {
        this.sipChannel = sipChannel;
    }
}
