package com.faas.core.base.model.ws.utils.asset.content;

import com.faas.core.base.model.ws.utils.asset.content.dto.AssetWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class AssetWSModel {

    private GeneralWSModel general;
    private List<AssetWSDTO> assets;


    public AssetWSModel() {
    }

    public AssetWSModel(GeneralWSModel general, List<AssetWSDTO> assets) {
        this.general = general;
        this.assets = assets;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<AssetWSDTO> getAssets() {
        return assets;
    }

    public void setAssets(List<AssetWSDTO> assets) {
        this.assets = assets;
    }
}
