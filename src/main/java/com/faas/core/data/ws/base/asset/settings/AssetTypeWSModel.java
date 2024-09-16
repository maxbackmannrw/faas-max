package com.faas.core.data.ws.base.asset.settings;

import com.faas.core.data.ws.base.asset.settings.dto.AssetTypeWSDTO;
import com.faas.core.data.ws.base.general.GeneralWSModel;

import java.util.List;

public class AssetTypeWSModel {

    private GeneralWSModel general;
    private List<AssetTypeWSDTO> assetTypes;


    public AssetTypeWSModel() {
    }

    public AssetTypeWSModel(GeneralWSModel general, List<AssetTypeWSDTO> assetTypes) {
        this.general = general;
        this.assetTypes = assetTypes;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<AssetTypeWSDTO> getAssetTypes() {
        return assetTypes;
    }

    public void setAssetTypes(List<AssetTypeWSDTO> assetTypes) {
        this.assetTypes = assetTypes;
    }
}
