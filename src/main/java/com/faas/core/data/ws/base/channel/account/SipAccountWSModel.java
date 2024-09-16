package com.faas.core.data.ws.base.channel.account;

import com.faas.core.data.ws.base.channel.account.dto.SipAccountWSDTO;
import com.faas.core.data.ws.base.general.GeneralWSModel;

import java.util.List;

public class SipAccountWSModel {

    private GeneralWSModel general;
    private List<SipAccountWSDTO> sipAccounts;

    public SipAccountWSModel() {
    }

    public SipAccountWSModel(GeneralWSModel general, List<SipAccountWSDTO> sipAccounts) {
        this.general = general;
        this.sipAccounts = sipAccounts;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<SipAccountWSDTO> getSipAccounts() {
        return sipAccounts;
    }

    public void setSipAccounts(List<SipAccountWSDTO> sipAccounts) {
        this.sipAccounts = sipAccounts;
    }
}
