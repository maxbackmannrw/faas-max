package com.faas.core.base.endpoint.controller.asset.content;

import com.faas.core.base.middleware.asset.content.AssetMiddleware;
import com.faas.core.base.model.ws.asset.content.AssetWSModel;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.BaseRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/base/asset/")
public class AssetController {


    @Autowired
    AssetMiddleware assetMiddleware;


    @RequestMapping(value = BaseRoute.GET_ASSETS_BY_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> getAssetsByType(@RequestParam long userId,
                                             @RequestParam String assetType) {

        AssetWSModel response = assetMiddleware.getAssetsByType(userId, assetType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_ASSET, method = RequestMethod.POST)
    public ResponseEntity<?> getAsset(@RequestParam long userId,
                                      @RequestParam long assetId) {

        AssetWSModel response = assetMiddleware.getAsset(userId, assetId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_ASSET, method = RequestMethod.POST)
    public ResponseEntity<?> createAsset(@RequestParam long userId,
                                         @RequestParam String asset,
                                         @RequestParam long assetTypeId) {

        AssetWSModel response = assetMiddleware.createAsset(userId, asset, assetTypeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_ASSET, method = RequestMethod.POST)
    public ResponseEntity<?> updateAsset(@RequestParam long userId,
                                         @RequestParam long assetId,
                                         @RequestParam String asset,
                                         @RequestParam long assetTypeId) {

        AssetWSModel response = assetMiddleware.updateAsset(userId, assetId, asset, assetTypeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_ASSET, method = RequestMethod.POST)
    public ResponseEntity<?> removeAsset(@RequestParam long userId,
                                         @RequestParam long assetId) {

        AssetWSModel response = assetMiddleware.removeAsset(userId, assetId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
