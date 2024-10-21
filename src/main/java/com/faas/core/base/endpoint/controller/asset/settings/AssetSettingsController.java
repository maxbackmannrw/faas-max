package com.faas.core.base.endpoint.controller.asset.settings;

import com.faas.core.base.middleware.asset.settings.AssetSettingsMiddleware;
import com.faas.core.base.model.ws.asset.settings.AssetTypeWSModel;
import com.faas.core.misc.config.AppConstant;
import com.faas.core.misc.config.BaseRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/base/asset/settings/")
public class AssetSettingsController {


    @Autowired
    AssetSettingsMiddleware assetSettingsMiddleware;


    @RequestMapping(value = BaseRoute.GET_ALL_ASSET_TYPES, method = RequestMethod.POST)
    public ResponseEntity<?> getAllAssetTypes(@RequestParam long userId) {

        AssetTypeWSModel response = assetSettingsMiddleware.getAllAssetTypes(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_ASSET_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> getAssetType(@RequestParam long userId,
                                          @RequestParam long typeId) {

        AssetTypeWSModel response = assetSettingsMiddleware.getAssetType(userId, typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_ASSET_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> createAssetType(@RequestParam long userId,
                                             @RequestParam String assetType,
                                             @RequestParam String description,
                                             @RequestParam String uploadUrl,
                                             @RequestParam String baseUrl,
                                             @RequestParam String baseType) {

        AssetTypeWSModel response = assetSettingsMiddleware.createAssetType(userId, assetType, description, uploadUrl, baseUrl, baseType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_ASSET_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> updateAssetType(@RequestParam long userId,
                                             @RequestParam long typeId,
                                             @RequestParam String assetType,
                                             @RequestParam String description,
                                             @RequestParam String uploadUrl,
                                             @RequestParam String baseUrl,
                                             @RequestParam String baseType) {

        AssetTypeWSModel response = assetSettingsMiddleware.updateAssetType(userId, typeId, assetType, description, uploadUrl, baseUrl, baseType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_ASSET_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> removeAssetType(@RequestParam long userId,
                                             @RequestParam long typeId) {

        AssetTypeWSModel response = assetSettingsMiddleware.removeAssetType(userId, typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
