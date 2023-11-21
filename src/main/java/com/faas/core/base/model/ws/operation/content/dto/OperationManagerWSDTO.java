package com.faas.core.base.model.ws.operation.content.dto;

import com.faas.core.base.model.ws.operation.automatic.content.dto.AutomaticManagerWSDTO;
import com.faas.core.base.model.ws.operation.inquiry.content.dto.InquiryManagerWSDTO;
import com.faas.core.base.model.ws.operation.manual.content.dto.ManualManagerWSDTO;

public class OperationManagerWSDTO {

    private ManualManagerWSDTO manualManager;
    private InquiryManagerWSDTO inquiryManager;
    private AutomaticManagerWSDTO automaticManager;

    public OperationManagerWSDTO() {
    }

    public OperationManagerWSDTO(ManualManagerWSDTO manualManager, InquiryManagerWSDTO inquiryManager, AutomaticManagerWSDTO automaticManager) {
        this.manualManager = manualManager;
        this.inquiryManager = inquiryManager;
        this.automaticManager = automaticManager;
    }

    public ManualManagerWSDTO getManualManager() {
        return manualManager;
    }

    public void setManualManager(ManualManagerWSDTO manualManager) {
        this.manualManager = manualManager;
    }

    public InquiryManagerWSDTO getInquiryManager() {
        return inquiryManager;
    }

    public void setInquiryManager(InquiryManagerWSDTO inquiryManager) {
        this.inquiryManager = inquiryManager;
    }

    public AutomaticManagerWSDTO getAutomaticManager() {
        return automaticManager;
    }

    public void setAutomaticManager(AutomaticManagerWSDTO automaticManager) {
        this.automaticManager = automaticManager;
    }
}
