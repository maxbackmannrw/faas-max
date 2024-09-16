package com.faas.core.data.ws.api.asset.dto;

import com.faas.core.data.db.asset.content.AssetDBModel;

public class ApiAssetWSDTO {

    private AssetDBModel asset;

    public ApiAssetWSDTO() {
    }

    public ApiAssetWSDTO(AssetDBModel asset) {
        this.asset = asset;
    }

    public AssetDBModel getAsset() {
        return asset;
    }

    public void setAsset(AssetDBModel asset) {
        this.asset = asset;
    }
}
