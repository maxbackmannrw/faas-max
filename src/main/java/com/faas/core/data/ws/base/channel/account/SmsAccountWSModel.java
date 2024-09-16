package com.faas.core.data.ws.base.channel.account;

import com.faas.core.data.ws.base.channel.account.dto.SmsAccountWSDTO;
import com.faas.core.data.ws.base.general.GeneralWSModel;

import java.util.List;

public class SmsAccountWSModel {

    private GeneralWSModel general;
    private List<SmsAccountWSDTO> smsAccounts;

    public SmsAccountWSModel() {
    }

    public SmsAccountWSModel(GeneralWSModel general, List<SmsAccountWSDTO> smsAccounts) {
        this.general = general;
        this.smsAccounts = smsAccounts;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<SmsAccountWSDTO> getSmsAccounts() {
        return smsAccounts;
    }

    public void setSmsAccounts(List<SmsAccountWSDTO> smsAccounts) {
        this.smsAccounts = smsAccounts;
    }
}
