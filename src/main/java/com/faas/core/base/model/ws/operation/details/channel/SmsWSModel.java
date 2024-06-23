package com.faas.core.base.model.ws.operation.details.channel;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.operation.details.channel.dto.SmsWSDTO;

import java.util.List;

public class SmsWSModel {

    private GeneralWSModel general;
    private List<SmsWSDTO>operationSmss;

    public SmsWSModel() {
    }

    public SmsWSModel(GeneralWSModel general, List<SmsWSDTO> operationSmss) {
        this.general = general;
        this.operationSmss = operationSmss;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<SmsWSDTO> getOperationSmss() {
        return operationSmss;
    }

    public void setOperationSmss(List<SmsWSDTO> operationSmss) {
        this.operationSmss = operationSmss;
    }
}
