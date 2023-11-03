package com.faas.core.base.model.ws.manager.inquiry.operation;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.manager.inquiry.operation.dto.InquiryOperationListWSDTO;

public class InquiryOperationListWSModel {

    private GeneralWSModel general;
    private InquiryOperationListWSDTO operationList;

    public InquiryOperationListWSModel() {
    }

    public InquiryOperationListWSModel(GeneralWSModel general, InquiryOperationListWSDTO operationList) {
        this.general = general;
        this.operationList = operationList;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public InquiryOperationListWSDTO getOperationList() {
        return operationList;
    }

    public void setOperationList(InquiryOperationListWSDTO operationList) {
        this.operationList = operationList;
    }
}
