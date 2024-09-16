package com.faas.core.data.ws.base.channel.account.dto;

import com.faas.core.data.db.channel.account.SmsAccountDBModel;

public class SmsAccountWSDTO {

    private SmsAccountDBModel smsAccount;

    public SmsAccountWSDTO() {
    }

    public SmsAccountWSDTO(SmsAccountDBModel smsAccount) {
        this.smsAccount = smsAccount;
    }

    public SmsAccountDBModel getSmsAccount() {
        return smsAccount;
    }

    public void setSmsAccount(SmsAccountDBModel smsAccount) {
        this.smsAccount = smsAccount;
    }
}
