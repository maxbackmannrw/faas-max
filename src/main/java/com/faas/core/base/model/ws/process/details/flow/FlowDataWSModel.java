package com.faas.core.base.model.ws.process.details.flow;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.flow.dto.FlowDataWSDTO;
import com.faas.core.base.model.ws.process.details.flow.dto.ProcessFlowWSDTO;

import java.util.List;

public class FlowDataWSModel {

    private GeneralWSModel general;
    private List<FlowDataWSDTO>flowDatas;

    public FlowDataWSModel() {
    }

    public FlowDataWSModel(GeneralWSModel general, List<FlowDataWSDTO> flowDatas) {
        this.general = general;
        this.flowDatas = flowDatas;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<FlowDataWSDTO> getFlowDatas() {
        return flowDatas;
    }

    public void setFlowDatas(List<FlowDataWSDTO> flowDatas) {
        this.flowDatas = flowDatas;
    }
}
