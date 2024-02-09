package com.faas.core.api.model.ws.operation.details.channel.message.email;

import com.faas.core.api.model.ws.operation.details.channel.message.email.dto.ApiOperationEmailTempWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiOperationEmailTempWSModel {

    private GeneralWSModel general;
    private List<ApiOperationEmailTempWSDTO>operationEmailTemps;

    public ApiOperationEmailTempWSModel() {
    }

    public ApiOperationEmailTempWSModel(GeneralWSModel general, List<ApiOperationEmailTempWSDTO> operationEmailTemps) {
        this.general = general;
        this.operationEmailTemps = operationEmailTemps;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiOperationEmailTempWSDTO> getOperationEmailTemps() {
        return operationEmailTemps;
    }

    public void setOperationEmailTemps(List<ApiOperationEmailTempWSDTO> operationEmailTemps) {
        this.operationEmailTemps = operationEmailTemps;
    }
}
