package com.faas.core.base.model.ws.utils.system.dto;

public class SystemInfoWSDTO {

    private String infoName;
    private String infoValue;
    public boolean infoState;

    public SystemInfoWSDTO() {
    }

    public SystemInfoWSDTO(String infoName, String infoValue, boolean infoState) {
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
