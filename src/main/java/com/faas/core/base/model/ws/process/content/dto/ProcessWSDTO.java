package com.faas.core.base.model.ws.process.content.dto;

import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.db.process.details.flow.ProcessFlowDBModel;
import com.faas.core.base.model.db.process.details.inquiry.ProcessInquiryDBModel;

public class ProcessWSDTO {

    private ProcessDBModel process;
    private ProcessFlowDBModel processFlow;
    private ProcessInquiryDBModel processInquiry;

    public ProcessWSDTO() {
    }

    public ProcessWSDTO(ProcessDBModel process, ProcessFlowDBModel processFlow, ProcessInquiryDBModel processInquiry) {
        this.process = process;
        this.processFlow = processFlow;
        this.processInquiry = processInquiry;
    }

    public ProcessDBModel getProcess() {
        return process;
    }

    public void setProcess(ProcessDBModel process) {
        this.process = process;
    }

    public ProcessFlowDBModel getProcessFlow() {
        return processFlow;
    }

    public void setProcessFlow(ProcessFlowDBModel processFlow) {
        this.processFlow = processFlow;
    }

    public ProcessInquiryDBModel getProcessInquiry() {
        return processInquiry;
    }

    public void setProcessInquiry(ProcessInquiryDBModel processInquiry) {
        this.processInquiry = processInquiry;
    }
}
