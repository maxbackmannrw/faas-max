package com.faas.core.base.model.ws.channel.account.dto;

import com.faas.core.data.db.channel.account.SipAccountDBModel;

public class SipAccountWSDTO {

    private SipAccountDBModel sipAccount;

    public SipAccountWSDTO() {
    }

    public SipAccountWSDTO(SipAccountDBModel sipAccount) {
        this.sipAccount = sipAccount;
    }

    public SipAccountDBModel getSipAccount() {
        return sipAccount;
    }

    public void setSipAccount(SipAccountDBModel sipAccount) {
        this.sipAccount = sipAccount;
    }
}
