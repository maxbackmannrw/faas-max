package com.faas.core.base.model.ws.asset.content.dto;

import com.faas.core.base.model.db.asset.content.AssetDBModel;

public class AssetWSDTO {

    private AssetDBModel asset;

    public AssetWSDTO() {
    }

    public AssetWSDTO(AssetDBModel asset) {
        this.asset = asset;
    }

    public AssetDBModel getAsset() {
        return asset;
    }

    public void setAsset(AssetDBModel asset) {
        this.asset = asset;
    }
}
