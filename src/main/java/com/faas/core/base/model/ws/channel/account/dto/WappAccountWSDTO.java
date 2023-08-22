package com.faas.core.base.model.ws.channel.account.dto;

import com.faas.core.base.model.db.channel.account.WappAccountDBModel;

public class WappAccountWSDTO {

    private WappAccountDBModel wappAccount;

    public WappAccountWSDTO() {
    }

    public WappAccountWSDTO(WappAccountDBModel wappAccount) {
        this.wappAccount = wappAccount;
    }

    public WappAccountDBModel getWappAccount() {
        return wappAccount;
    }

    public void setWappAccount(WappAccountDBModel wappAccount) {
        this.wappAccount = wappAccount;
    }
}
