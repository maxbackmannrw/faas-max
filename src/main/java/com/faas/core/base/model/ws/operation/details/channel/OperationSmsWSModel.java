package com.faas.core.base.model.ws.operation.details.channel;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.operation.details.channel.dto.OperationSmsWSDTO;

import java.util.List;

public class OperationSmsWSModel {

    private GeneralWSModel general;
    private List<OperationSmsWSDTO>operationSmss;

    public OperationSmsWSModel() {
    }

    public OperationSmsWSModel(GeneralWSModel general, List<OperationSmsWSDTO> operationSmss) {
        this.general = general;
        this.operationSmss = operationSmss;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<OperationSmsWSDTO> getOperationSmss() {
        return operationSmss;
    }

    public void setOperationSmss(List<OperationSmsWSDTO> operationSmss) {
        this.operationSmss = operationSmss;
    }
}
