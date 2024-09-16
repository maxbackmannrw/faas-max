package com.faas.core.data.ws.base.channel.account.dto;

import com.faas.core.data.db.channel.account.PushAccountDBModel;

public class PushAccountWSDTO {

    private PushAccountDBModel pushAccount;

    public PushAccountWSDTO() {
    }

    public PushAccountWSDTO(PushAccountDBModel pushAccount) {
        this.pushAccount = pushAccount;
    }

    public PushAccountDBModel getPushAccount() {
        return pushAccount;
    }

    public void setPushAccount(PushAccountDBModel pushAccount) {
        this.pushAccount = pushAccount;
    }
}
