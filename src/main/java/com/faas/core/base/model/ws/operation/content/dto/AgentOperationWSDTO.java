package com.faas.core.base.model.ws.operation.content.dto;

public class AgentOperationWSDTO {

    private OperationListWSDTO manualOperations;
    private OperationListWSDTO inquiryOperations;
    private OperationListWSDTO automaticOperations;

    public AgentOperationWSDTO() {
    }

    public AgentOperationWSDTO(OperationListWSDTO manualOperations, OperationListWSDTO inquiryOperations, OperationListWSDTO automaticOperations) {
        this.manualOperations = manualOperations;
        this.inquiryOperations = inquiryOperations;
        this.automaticOperations = automaticOperations;
    }

    public OperationListWSDTO getManualOperations() {
        return manualOperations;
    }

    public void setManualOperations(OperationListWSDTO manualOperations) {
        this.manualOperations = manualOperations;
    }

    public OperationListWSDTO getInquiryOperations() {
        return inquiryOperations;
    }

    public void setInquiryOperations(OperationListWSDTO inquiryOperations) {
        this.inquiryOperations = inquiryOperations;
    }

    public OperationListWSDTO getAutomaticOperations() {
        return automaticOperations;
    }

    public void setAutomaticOperations(OperationListWSDTO automaticOperations) {
        this.automaticOperations = automaticOperations;
    }
}
