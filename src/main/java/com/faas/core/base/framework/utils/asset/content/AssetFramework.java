package com.faas.core.base.framework.utils.asset.content;

import com.faas.core.base.model.db.utils.asset.content.AssetDBModel;
import com.faas.core.base.model.ws.utils.asset.content.dto.AssetWSDTO;
import com.faas.core.base.repo.utils.asset.content.AssetRepository;
import com.faas.core.base.repo.utils.asset.settings.AssetTypeRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AssetFramework {


    @Autowired
    AssetRepository assetRepository;

    @Autowired
    AssetTypeRepository assetTypeRepository;

    @Autowired
    AppUtils appUtils;


    public AssetWSDTO fillAssetWSDTO(AssetDBModel assetDBModel) {

        AssetWSDTO assetWSDTO = new AssetWSDTO();
        assetWSDTO.setAsset(assetDBModel);
        return assetWSDTO;
    }


    public AssetDBModel createAssetService(String asset, long assetTypeId) {


        AssetDBModel assetDBModel = new AssetDBModel();
        assetDBModel.setuDate(appUtils.getCurrentTimeStamp());
        assetDBModel.setcDate(appUtils.getCurrentTimeStamp());
        assetDBModel.setStatus(1);

        return assetRepository.save(assetDBModel);
    }


    public AssetDBModel updateAssetService(long assetId, String asset, long assetTypeId) {

        Optional<AssetDBModel> assetDBModel = assetRepository.findById(assetId);

        return null;
    }


    public AssetDBModel removeAssetService(long assetId) {

        Optional<AssetDBModel> assetDBModel = assetRepository.findById(assetId);
        if (assetDBModel.isPresent()) {
            assetRepository.delete(assetDBModel.get());
            return assetDBModel.get();
        }
        return null;
    }


}
