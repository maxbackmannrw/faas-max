package com.faas.core.data.ws.base.utilz.content.dto;

public class SystemInitWSDTO {

    public boolean initState;
    private String initName;
    private String initValue;

    public SystemInitWSDTO() {
    }

    public SystemInitWSDTO(String initName, String initValue, boolean initState) {
        this.initName = initName;
        this.initValue = initValue;
        this.initState = initState;
    }

    public String getInitName() {
        return initName;
    }

    public void setInitName(String initName) {
        this.initName = initName;
    }

    public String getInitValue() {
        return initValue;
    }

    public void setInitValue(String initValue) {
        this.initValue = initValue;
    }

    public boolean isInitState() {
        return initState;
    }

    public void setInitState(boolean initState) {
        this.initState = initState;
    }
}
