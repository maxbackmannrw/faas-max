package com.faas.core.base.model.ws.channel.account;

import com.faas.core.base.model.ws.channel.account.dto.WappAccountWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class WappAccountWSModel {

    private GeneralWSModel general;
    private List<WappAccountWSDTO> wappAccounts;

    public WappAccountWSModel() {
    }

    public WappAccountWSModel(GeneralWSModel general, List<WappAccountWSDTO> wappAccounts) {
        this.general = general;
        this.wappAccounts = wappAccounts;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<WappAccountWSDTO> getWappAccounts() {
        return wappAccounts;
    }

    public void setWappAccounts(List<WappAccountWSDTO> wappAccounts) {
        this.wappAccounts = wappAccounts;
    }
}
