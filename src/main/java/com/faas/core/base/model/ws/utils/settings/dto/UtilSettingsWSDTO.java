package com.faas.core.base.model.ws.utils.settings.dto;

public class UtilSettingsWSDTO {

    private String settingsName;
    private String settingsValue;
    public boolean settingsState;

    public UtilSettingsWSDTO() {
    }

    public UtilSettingsWSDTO(String settingsName, String settingsValue, boolean settingsState) {
        this.settingsName = settingsName;
        this.settingsValue = settingsValue;
        this.settingsState = settingsState;
    }

    public String getSettingsName() {
        return settingsName;
    }

    public void setSettingsName(String settingsName) {
        this.settingsName = settingsName;
    }

    public String getSettingsValue() {
        return settingsValue;
    }

    public void setSettingsValue(String settingsValue) {
        this.settingsValue = settingsValue;
    }

    public boolean isSettingsState() {
        return settingsState;
    }

    public void setSettingsState(boolean settingsState) {
        this.settingsState = settingsState;
    }
}
