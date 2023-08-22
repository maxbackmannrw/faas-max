package com.faas.core.base.model.ws.channel.account.dto;


public class WappQRCodeWSDTO {

    private String qrCodeStatus;
    public String qrCodeInBase64;

    public WappQRCodeWSDTO() {
    }

    public WappQRCodeWSDTO(String qrCodeStatus, String qrCodeInBase64) {
        this.qrCodeStatus = qrCodeStatus;
        this.qrCodeInBase64 = qrCodeInBase64;
    }

    public String getQrCodeStatus() {
        return qrCodeStatus;
    }

    public void setQrCodeStatus(String qrCodeStatus) {
        this.qrCodeStatus = qrCodeStatus;
    }

    public String getQrCodeInBase64() {
        return qrCodeInBase64;
    }

    public void setQrCodeInBase64(String qrCodeInBase64) {
        this.qrCodeInBase64 = qrCodeInBase64;
    }
}
