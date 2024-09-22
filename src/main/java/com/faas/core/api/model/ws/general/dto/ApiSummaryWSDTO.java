package com.faas.core.api.model.ws.general.dto;

public class ApiSummaryWSDTO {

    private String summaryType;
    private String summaryValue;

    public ApiSummaryWSDTO() {
    }

    public ApiSummaryWSDTO(String summaryType, String summaryValue) {
        this.summaryType = summaryType;
        this.summaryValue = summaryValue;
    }

    public String getSummaryType() {
        return summaryType;
    }

    public void setSummaryType(String summaryType) {
        this.summaryType = summaryType;
    }

    public String getSummaryValue() {
        return summaryValue;
    }

    public void setSummaryValue(String summaryValue) {
        this.summaryValue = summaryValue;
    }
}
