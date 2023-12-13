package com.faas.core.base.model.ws.process.details.flow;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.flow.dto.ProcessFlowDataWSDTO;

import java.util.List;

public class ProcessFlowDataWSModel {

    private GeneralWSModel general;
    private List<ProcessFlowDataWSDTO>flowDatas;

    public ProcessFlowDataWSModel() {
    }

    public ProcessFlowDataWSModel(GeneralWSModel general, List<ProcessFlowDataWSDTO> flowDatas) {
        this.general = general;
        this.flowDatas = flowDatas;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ProcessFlowDataWSDTO> getFlowDatas() {
        return flowDatas;
    }

    public void setFlowDatas(List<ProcessFlowDataWSDTO> flowDatas) {
        this.flowDatas = flowDatas;
    }
}
