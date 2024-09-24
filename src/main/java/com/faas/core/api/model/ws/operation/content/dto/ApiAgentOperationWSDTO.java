package com.faas.core.api.model.ws.operation.content.dto;

import java.util.List;

public class ApiAgentOperationWSDTO {

    private List<ApiOperationWSDTO> manualOperations;
    private List<ApiOperationWSDTO> inquiryOperations;

    public ApiAgentOperationWSDTO() {
    }

    public ApiAgentOperationWSDTO(List<ApiOperationWSDTO> manualOperations, List<ApiOperationWSDTO> inquiryOperations) {
        this.manualOperations = manualOperations;
        this.inquiryOperations = inquiryOperations;
    }

    public List<ApiOperationWSDTO> getManualOperations() {
        return manualOperations;
    }

    public void setManualOperations(List<ApiOperationWSDTO> manualOperations) {
        this.manualOperations = manualOperations;
    }

    public List<ApiOperationWSDTO> getInquiryOperations() {
        return inquiryOperations;
    }

    public void setInquiryOperations(List<ApiOperationWSDTO> inquiryOperations) {
        this.inquiryOperations = inquiryOperations;
    }
}
