package com.faas.core.api.model.ws.asset;

import com.faas.core.api.model.ws.asset.dto.ApiAssetWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiAssetWSModel {

    private GeneralWSModel general;
    private List<ApiAssetWSDTO>assets;


    public ApiAssetWSModel() {
    }

    public ApiAssetWSModel(GeneralWSModel general, List<ApiAssetWSDTO> assets) {
        this.general = general;
        this.assets = assets;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiAssetWSDTO> getAssets() {
        return assets;
    }

    public void setAssets(List<ApiAssetWSDTO> assets) {
        this.assets = assets;
    }
}
