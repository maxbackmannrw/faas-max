package com.faas.core.base.model.ws.utilz.content.dto;

public class SystemContentWSDTO {

    public boolean contentState;
    private String contentName;
    private String contentValue;

    public SystemContentWSDTO() {
    }

    public SystemContentWSDTO(String contentName, String contentValue, boolean contentState) {
        this.contentName = contentName;
        this.contentValue = contentValue;
        this.contentState = contentState;
    }

    public String getContentName() {
        return contentName;
    }

    public void setContentName(String contentName) {
        this.contentName = contentName;
    }

    public String getContentValue() {
        return contentValue;
    }

    public void setContentValue(String contentValue) {
        this.contentValue = contentValue;
    }

    public boolean isContentState() {
        return contentState;
    }

    public void setContentState(boolean contentState) {
        this.contentState = contentState;
    }
}
