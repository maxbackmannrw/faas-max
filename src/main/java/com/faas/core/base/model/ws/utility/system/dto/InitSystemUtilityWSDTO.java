package com.faas.core.base.model.ws.utility.system.dto;

public class InitSystemUtilityWSDTO {

    private String utilityName;
    private String utilityValue;
    public boolean utilityState;

    public InitSystemUtilityWSDTO() {
    }

    public InitSystemUtilityWSDTO(String utilityName, String utilityValue, boolean utilityState) {
        this.utilityName = utilityName;
        this.utilityValue = utilityValue;
        this.utilityState = utilityState;
    }

    public String getUtilityName() {
        return utilityName;
    }

    public void setUtilityName(String utilityName) {
        this.utilityName = utilityName;
    }

    public String getUtilityValue() {
        return utilityValue;
    }

    public void setUtilityValue(String utilityValue) {
        this.utilityValue = utilityValue;
    }

    public boolean isUtilityState() {
        return utilityState;
    }

    public void setUtilityState(boolean utilityState) {
        this.utilityState = utilityState;
    }
}
