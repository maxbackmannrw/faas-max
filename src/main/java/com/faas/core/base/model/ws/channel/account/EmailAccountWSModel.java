package com.faas.core.base.model.ws.channel.account;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.channel.account.dto.EmailAccountWSDTO;

import java.util.List;

public class EmailAccountWSModel {

    private GeneralWSModel general;
    private List<EmailAccountWSDTO>emailAccounts;

    public EmailAccountWSModel() {
    }

    public EmailAccountWSModel(GeneralWSModel general, List<EmailAccountWSDTO> emailAccounts) {
        this.general = general;
        this.emailAccounts = emailAccounts;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<EmailAccountWSDTO> getEmailAccounts() {
        return emailAccounts;
    }

    public void setEmailAccounts(List<EmailAccountWSDTO> emailAccounts) {
        this.emailAccounts = emailAccounts;
    }
}
