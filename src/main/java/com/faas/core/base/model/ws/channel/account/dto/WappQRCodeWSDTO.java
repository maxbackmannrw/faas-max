package com.faas.core.base.model.ws.channel.account.dto;

public class WappQRCodeWSDTO {

    public String qrcode;

    public WappQRCodeWSDTO() {
    }

    public WappQRCodeWSDTO(String qrcode) {
        this.qrcode = qrcode;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }
}
