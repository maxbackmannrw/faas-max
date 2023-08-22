package com.faas.core.base.model.ws.channel.account.dto;

import com.faas.core.base.model.db.channel.account.EmailAccountDBModel;

public class EmailAccountWSDTO {

    private EmailAccountDBModel emailAccount;

    public EmailAccountWSDTO() {
    }

    public EmailAccountWSDTO(EmailAccountDBModel emailAccount) {
        this.emailAccount = emailAccount;
    }

    public EmailAccountDBModel getEmailAccount() {
        return emailAccount;
    }

    public void setEmailAccount(EmailAccountDBModel emailAccount) {
        this.emailAccount = emailAccount;
    }
}
