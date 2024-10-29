package com.faas.core.api.model.ws.operation.manager.channel.message.sms;

import com.faas.core.api.model.ws.operation.manager.channel.message.sms.dto.ApiOperationSmsWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiOperationSmsWSModel {

    private GeneralWSModel general;
    private List<ApiOperationSmsWSDTO> operationSmss;

    public ApiOperationSmsWSModel() {
    }

    public ApiOperationSmsWSModel(GeneralWSModel general, List<ApiOperationSmsWSDTO> operationSmss) {
        this.general = general;
        this.operationSmss = operationSmss;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiOperationSmsWSDTO> getOperationSmss() {
        return operationSmss;
    }

    public void setOperationSmss(List<ApiOperationSmsWSDTO> operationSmss) {
        this.operationSmss = operationSmss;
    }
}
