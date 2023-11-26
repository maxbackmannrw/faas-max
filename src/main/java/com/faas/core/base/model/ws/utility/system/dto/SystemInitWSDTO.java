package com.faas.core.base.model.ws.utility.system.dto;

public class SystemInitWSDTO {

    private String infoName;
    private String infoValue;
    public boolean infoState;

    public SystemInitWSDTO() {
    }

    public SystemInitWSDTO(String infoName, String infoValue, boolean infoState) {
        this.infoName = infoName;
        this.infoValue = infoValue;
        this.infoState = infoState;
    }

    public String getInfoName() {
        return infoName;
    }

    public void setInfoName(String infoName) {
        this.infoName = infoName;
    }

    public String getInfoValue() {
        return infoValue;
    }

    public void setInfoValue(String infoValue) {
        this.infoValue = infoValue;
    }

    public boolean isInfoState() {
        return infoState;
    }

    public void setInfoState(boolean infoState) {
        this.infoState = infoState;
    }
}
