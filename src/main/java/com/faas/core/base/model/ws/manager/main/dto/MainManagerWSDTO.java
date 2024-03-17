package com.faas.core.base.model.ws.manager.main.dto;

public class MainManagerWSDTO {

    private MainManagerContentWSDTO manualContent;
    private MainManagerContentWSDTO inquiryContent;
    private MainManagerContentWSDTO automaticContent;

    public MainManagerWSDTO() {
    }

    public MainManagerWSDTO(MainManagerContentWSDTO manualContent, MainManagerContentWSDTO inquiryContent, MainManagerContentWSDTO automaticContent) {
        this.manualContent = manualContent;
        this.inquiryContent = inquiryContent;
        this.automaticContent = automaticContent;
    }

    public MainManagerContentWSDTO getManualContent() {
        return manualContent;
    }

    public void setManualContent(MainManagerContentWSDTO manualContent) {
        this.manualContent = manualContent;
    }

    public MainManagerContentWSDTO getInquiryContent() {
        return inquiryContent;
    }

    public void setInquiryContent(MainManagerContentWSDTO inquiryContent) {
        this.inquiryContent = inquiryContent;
    }

    public MainManagerContentWSDTO getAutomaticContent() {
        return automaticContent;
    }

    public void setAutomaticContent(MainManagerContentWSDTO automaticContent) {
        this.automaticContent = automaticContent;
    }
}
