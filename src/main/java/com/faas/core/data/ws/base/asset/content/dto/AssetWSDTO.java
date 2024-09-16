package com.faas.core.data.ws.base.asset.content.dto;

import com.faas.core.data.db.asset.content.AssetDBModel;

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
