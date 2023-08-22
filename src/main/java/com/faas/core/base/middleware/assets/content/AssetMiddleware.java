package com.faas.core.base.middleware.assets.content;

import com.faas.core.base.framework.assets.content.AssetFramework;
import com.faas.core.base.model.db.assets.content.AssetDBModel;
import com.faas.core.base.model.ws.assets.content.AssetWSModel;
import com.faas.core.base.model.ws.assets.content.dto.AssetWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.repo.assets.content.AssetRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class AssetMiddleware {


    @Autowired
    AssetFramework assetFramework;

    @Autowired
    AssetRepository assetRepository;

    @Autowired
    AppUtils appUtils;


    public AssetWSModel getAssetsByType(long userId, String assetType) {

        AssetWSModel response = new AssetWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<AssetWSDTO> assetWSDTOS = new ArrayList<>();

        List<AssetDBModel> assetDBModels = assetRepository.findByAssetType(assetType);
        if (assetDBModels.size() > 0) {
            for (AssetDBModel assetDBModel : assetDBModels) {
                assetWSDTOS.add(assetFramework.fillAssetWSDTO(assetDBModel));
            }
        }

        response.setAssets(assetWSDTOS);
        general.setOperation("getAssetsByType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public AssetWSModel getAsset(long userId, long assetId) {

        AssetWSModel response = new AssetWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<AssetWSDTO> assetWSDTOS = new ArrayList<>();

        Optional<AssetDBModel> assetDBModel = assetRepository.findById(assetId);
        if (assetDBModel.isPresent()) {
            assetWSDTOS.add(assetFramework.fillAssetWSDTO(assetDBModel.get()));
        }

        response.setAssets(assetWSDTOS);
        general.setOperation("getAsset");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public AssetWSModel createAsset(long userId, String asset, long assetTypeId) {

        AssetWSModel response = new AssetWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<AssetWSDTO> assetWSDTOS = new ArrayList<>();

        AssetDBModel assetDBModel = assetFramework.createAssetService(asset, assetTypeId);
        if (assetDBModel != null) {
            assetWSDTOS.add(assetFramework.fillAssetWSDTO(assetDBModel));
        }

        response.setAssets(assetWSDTOS);
        general.setOperation("createAsset");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public AssetWSModel updateAsset(long userId, long assetId, String asset, long assetTypeId) {

        AssetWSModel response = new AssetWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<AssetWSDTO> assetWSDTOS = new ArrayList<>();

        AssetDBModel assetDBModel = assetFramework.updateAssetService(assetId, asset, assetTypeId);
        if (assetDBModel != null) {
            assetWSDTOS.add(assetFramework.fillAssetWSDTO(assetDBModel));
        }

        response.setAssets(assetWSDTOS);
        general.setOperation("updateAsset");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public AssetWSModel removeAsset(long userId, long assetId) {

        AssetWSModel response = new AssetWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<AssetWSDTO> assetWSDTOS = new ArrayList<>();

        AssetDBModel assetDBModel = assetFramework.removeAssetService(assetId);
        if (assetDBModel != null) {
            assetWSDTOS.add(assetFramework.fillAssetWSDTO(assetDBModel));
        }

        response.setAssets(assetWSDTOS);
        general.setOperation("removeAsset");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
