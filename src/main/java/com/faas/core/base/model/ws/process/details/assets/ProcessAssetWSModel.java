package com.faas.core.base.model.ws.process.details.assets;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.assets.dto.ProcessAssetWSDTO;

import java.util.List;

public class ProcessAssetWSModel {

    private GeneralWSModel general;
    private List<ProcessAssetWSDTO>processAssets;


    public ProcessAssetWSModel() {
    }

    public ProcessAssetWSModel(GeneralWSModel general, List<ProcessAssetWSDTO> processAssets) {
        this.general = general;
        this.processAssets = processAssets;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ProcessAssetWSDTO> getProcessAssets() {
        return processAssets;
    }

    public void setProcessAssets(List<ProcessAssetWSDTO> processAssets) {
        this.processAssets = processAssets;
    }
}
