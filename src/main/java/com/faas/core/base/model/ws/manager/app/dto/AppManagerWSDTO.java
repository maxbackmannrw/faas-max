package com.faas.core.base.model.ws.manager.app.dto;

public class AppManagerWSDTO {

    private AppManagerContentWSDTO manualContent;
    private AppManagerContentWSDTO inquiryContent;
    private AppManagerContentWSDTO automaticContent;

    public AppManagerWSDTO() {
    }

    public AppManagerWSDTO(AppManagerContentWSDTO manualContent, AppManagerContentWSDTO inquiryContent, AppManagerContentWSDTO automaticContent) {
        this.manualContent = manualContent;
        this.inquiryContent = inquiryContent;
        this.automaticContent = automaticContent;
    }

    public AppManagerContentWSDTO getManualContent() {
        return manualContent;
    }

    public void setManualContent(AppManagerContentWSDTO manualContent) {
        this.manualContent = manualContent;
    }

    public AppManagerContentWSDTO getInquiryContent() {
        return inquiryContent;
    }

    public void setInquiryContent(AppManagerContentWSDTO inquiryContent) {
        this.inquiryContent = inquiryContent;
    }

    public AppManagerContentWSDTO getAutomaticContent() {
        return automaticContent;
    }

    public void setAutomaticContent(AppManagerContentWSDTO automaticContent) {
        this.automaticContent = automaticContent;
    }
}
