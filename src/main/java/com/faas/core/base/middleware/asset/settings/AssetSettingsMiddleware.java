package com.faas.core.base.middleware.asset.settings;

import com.faas.core.base.framework.asset.settings.AssetSettingsFramework;
import com.faas.core.base.model.db.asset.settings.AssetTypeDBModel;
import com.faas.core.base.model.ws.asset.settings.AssetTypeWSModel;
import com.faas.core.base.model.ws.asset.settings.dto.AssetTypeWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.repo.asset.settings.AssetTypeRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class AssetSettingsMiddleware {


    @Autowired
    AssetSettingsFramework assetSettingsFramework;

    @Autowired
    AssetTypeRepository assetTypeRepository;

    @Autowired
    AppUtils appUtils;


    public AssetTypeWSModel getAllAssetTypes(long userId) {

        AssetTypeWSModel response = new AssetTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<AssetTypeWSDTO> assetTypeWSDTOS = new ArrayList<>();

        List<AssetTypeDBModel> assetTypeDBModels = assetTypeRepository.findByStatus(1);
        for (AssetTypeDBModel assetTypeDBModel : assetTypeDBModels) {
            assetTypeWSDTOS.add(assetSettingsFramework.fillAssetTypeWSDTO(assetTypeDBModel));
        }

        response.setAssetTypes(assetTypeWSDTOS);
        general.setOperation("getAllAssetTypes");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public AssetTypeWSModel getAssetType(long userId, long typeId) {

        AssetTypeWSModel response = new AssetTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<AssetTypeWSDTO> assetTypeWSDTOS = new ArrayList<>();

        Optional<AssetTypeDBModel> assetTypeDBModel = assetTypeRepository.findById(typeId);
        if (assetTypeDBModel.isPresent()){
            assetTypeWSDTOS.add(assetSettingsFramework.fillAssetTypeWSDTO(assetTypeDBModel.get()));
        }

        response.setAssetTypes(assetTypeWSDTOS);
        general.setOperation("getAssetType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public AssetTypeWSModel createAssetType(long userId,String assetType,String description,String uploadUrl,String baseUrl,String baseType) {

        AssetTypeWSModel response = new AssetTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<AssetTypeWSDTO> assetTypeWSDTOS = new ArrayList<>();

        AssetTypeDBModel assetTypeDBModel = assetSettingsFramework.createAssetTypeService(assetType,description,uploadUrl,baseUrl,baseType);
        if (assetTypeDBModel != null) {
            assetTypeWSDTOS.add(assetSettingsFramework.fillAssetTypeWSDTO(assetTypeDBModel));
        }

        response.setAssetTypes(assetTypeWSDTOS);
        general.setOperation("createAssetType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public AssetTypeWSModel updateAssetType(long userId,long typeId,String assetType,String description,String uploadUrl,String baseUrl,String baseType) {

        AssetTypeWSModel response = new AssetTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<AssetTypeWSDTO> assetTypeWSDTOS = new ArrayList<>();

        AssetTypeDBModel assetTypeDBModel = assetSettingsFramework.updateAssetTypeService(typeId,assetType,description,uploadUrl,baseUrl,baseType);
        if (assetTypeDBModel != null) {
            assetTypeWSDTOS.add(assetSettingsFramework.fillAssetTypeWSDTO(assetTypeDBModel));
        }

        response.setAssetTypes(assetTypeWSDTOS);
        general.setOperation("updateAssetType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public AssetTypeWSModel removeAssetType(long userId, long typeId) {

        AssetTypeWSModel response = new AssetTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<AssetTypeWSDTO> assetTypeWSDTOS = new ArrayList<>();

        AssetTypeDBModel assetTypeDBModel = assetSettingsFramework.removeAssetTypeService(typeId);
        if (assetTypeDBModel != null) {
            assetTypeWSDTOS.add(assetSettingsFramework.fillAssetTypeWSDTO(assetTypeDBModel));
        }

        response.setAssetTypes(assetTypeWSDTOS);
        general.setOperation("removeAssetType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
