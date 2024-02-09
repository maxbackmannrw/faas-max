package com.faas.core.api.model.ws.operation.details.channel.message.sms;

import com.faas.core.api.model.ws.operation.details.channel.message.sms.dto.ApiOperationSmsTempWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiOperationSmsTempWSModel {

    private GeneralWSModel general;
    private List<ApiOperationSmsTempWSDTO> operationSmsTemps;

    public ApiOperationSmsTempWSModel() {
    }

    public ApiOperationSmsTempWSModel(GeneralWSModel general, List<ApiOperationSmsTempWSDTO> operationSmsTemps) {
        this.general = general;
        this.operationSmsTemps = operationSmsTemps;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiOperationSmsTempWSDTO> getOperationSmsTemps() {
        return operationSmsTemps;
    }

    public void setOperationSmsTemps(List<ApiOperationSmsTempWSDTO> operationSmsTemps) {
        this.operationSmsTemps = operationSmsTemps;
    }
}
