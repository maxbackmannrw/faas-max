package com.faas.core.base.framework.asset.settings;

import com.faas.core.base.model.db.asset.settings.AssetTypeDBModel;
import com.faas.core.base.model.ws.asset.settings.dto.AssetTypeWSDTO;
import com.faas.core.base.repo.asset.settings.AssetTypeRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AssetSettingsFramework {


    @Autowired
    AssetTypeRepository assetTypeRepository;

    @Autowired
    AppUtils appUtils;


    public AssetTypeWSDTO fillAssetTypeWSDTO(AssetTypeDBModel assetTypeDBModel) {

        AssetTypeWSDTO assetTypeWSDTO = new AssetTypeWSDTO();
        assetTypeWSDTO.setAssetType(assetTypeDBModel);
        return assetTypeWSDTO;
    }


    public AssetTypeDBModel createAssetTypeService(String assetType,String description,String uploadUrl,String baseUrl,String baseType) {

        AssetTypeDBModel assetTypeDBModel = new AssetTypeDBModel();
        assetTypeDBModel.setAssetType(assetType);
        assetTypeDBModel.setDescription(description);
        assetTypeDBModel.setUploadUrl(uploadUrl);
        assetTypeDBModel.setBaseUrl(baseUrl);
        assetTypeDBModel.setBaseType(baseType);
        assetTypeDBModel.setuDate(appUtils.getCurrentTimeStamp());
        assetTypeDBModel.setcDate(appUtils.getCurrentTimeStamp());
        assetTypeDBModel.setStatus(1);

        return assetTypeRepository.save(assetTypeDBModel);
    }

    public AssetTypeDBModel updateAssetTypeService(long typeId,String assetType,String description,String uploadUrl,String baseUrl,String baseType) {

        Optional<AssetTypeDBModel> assetTypeDBModel = assetTypeRepository.findById(typeId);
        if (assetTypeDBModel.isPresent()) {
            assetTypeDBModel.get().setAssetType(assetType);
            assetTypeDBModel.get().setDescription(description);
            assetTypeDBModel.get().setUploadUrl(uploadUrl);
            assetTypeDBModel.get().setBaseUrl(baseUrl);
            assetTypeDBModel.get().setBaseType(baseType);
            assetTypeDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            assetTypeDBModel.get().setStatus(1);;

            return assetTypeRepository.save(assetTypeDBModel.get());
        }
        return null;
    }


    public AssetTypeDBModel removeAssetTypeService(long typeId) {

        Optional<AssetTypeDBModel> assetTypeDBModel = assetTypeRepository.findById(typeId);
        if (assetTypeDBModel.isPresent()) {
            assetTypeRepository.delete(assetTypeDBModel.get());
            return assetTypeDBModel.get();
        }
        return null;
    }



}
