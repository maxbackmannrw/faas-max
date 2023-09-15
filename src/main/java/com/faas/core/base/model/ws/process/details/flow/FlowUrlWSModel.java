package com.faas.core.base.model.ws.process.details.flow;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.flow.dto.FlowUrlWSDTO;
import com.faas.core.base.model.ws.process.details.flow.dto.ProcessFlowWSDTO;

import java.util.List;

public class FlowUrlWSModel {

    private GeneralWSModel general;
    private List<FlowUrlWSDTO>flowUrls;

    public FlowUrlWSModel() {
    }

    public FlowUrlWSModel(GeneralWSModel general, List<FlowUrlWSDTO> flowUrls) {
        this.general = general;
        this.flowUrls = flowUrls;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<FlowUrlWSDTO> getFlowUrls() {
        return flowUrls;
    }

    public void setFlowUrls(List<FlowUrlWSDTO> flowUrls) {
        this.flowUrls = flowUrls;
    }
}
