package com.faas.core.base.model.ws.process.details.content.dto;

import com.faas.core.base.model.db.process.content.dao.ProcessAssetDAO;

public class ProcessAssetWSDTO {

    private ProcessAssetDAO processAsset;

    public ProcessAssetWSDTO() {
    }

    public ProcessAssetWSDTO(ProcessAssetDAO processAsset) {
        this.processAsset = processAsset;
    }

    public ProcessAssetDAO getProcessAsset() {
        return processAsset;
    }

    public void setProcessAsset(ProcessAssetDAO processAsset) {
        this.processAsset = processAsset;
    }
}
