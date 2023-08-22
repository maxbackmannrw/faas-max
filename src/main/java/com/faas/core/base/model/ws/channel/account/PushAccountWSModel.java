package com.faas.core.base.model.ws.channel.account;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.channel.account.dto.PushAccountWSDTO;

import java.util.List;

public class PushAccountWSModel {

    private GeneralWSModel general;
    private List<PushAccountWSDTO>pushAccounts;

    public PushAccountWSModel() {
    }

    public PushAccountWSModel(GeneralWSModel general, List<PushAccountWSDTO> pushAccounts) {
        this.general = general;
        this.pushAccounts = pushAccounts;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<PushAccountWSDTO> getPushAccounts() {
        return pushAccounts;
    }

    public void setPushAccounts(List<PushAccountWSDTO> pushAccounts) {
        this.pushAccounts = pushAccounts;
    }
}
