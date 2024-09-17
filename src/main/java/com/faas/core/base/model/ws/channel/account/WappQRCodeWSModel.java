package com.faas.core.base.model.ws.channel.account;

import com.faas.core.base.model.ws.channel.account.dto.WappQRCodeWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class WappQRCodeWSModel {

    private GeneralWSModel general;
    private WappQRCodeWSDTO wappQRCode;

    public WappQRCodeWSModel() {
    }

    public WappQRCodeWSModel(GeneralWSModel general, WappQRCodeWSDTO wappQRCode) {
        this.general = general;
        this.wappQRCode = wappQRCode;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public WappQRCodeWSDTO getWappQRCode() {
        return wappQRCode;
    }

    public void setWappQRCode(WappQRCodeWSDTO wappQRCode) {
        this.wappQRCode = wappQRCode;
    }
}
