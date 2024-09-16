package com.faas.core.data.ws.base.asset.settings.dto;

import com.faas.core.data.db.asset.settings.AssetTypeDBModel;

public class AssetTypeWSDTO {

    private AssetTypeDBModel assetType;

    public AssetTypeWSDTO() {
    }

    public AssetTypeWSDTO(AssetTypeDBModel assetType) {
        this.assetType = assetType;
    }

    public AssetTypeDBModel getAssetType() {
        return assetType;
    }

    public void setAssetType(AssetTypeDBModel assetType) {
        this.assetType = assetType;
    }
}
