package com.faas.core.base.model.ws.utils.settings.dto;

public class UtilSettingsWSDTO {

    private boolean result;

    public UtilSettingsWSDTO() {
    }

    public UtilSettingsWSDTO(boolean result) {
        this.result = result;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
