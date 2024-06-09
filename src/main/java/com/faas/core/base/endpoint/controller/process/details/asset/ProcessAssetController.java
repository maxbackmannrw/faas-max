package com.faas.core.base.endpoint.controller.process.details.asset;

import com.faas.core.base.middleware.process.details.asset.ProcessAssetMiddleware;
import com.faas.core.base.model.ws.process.details.assets.ProcessAssetWSModel;
import com.faas.core.utility.config.AppConstant;
import com.faas.core.utility.config.BaseRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/base/process/details/asset/")
public class ProcessAssetController {


    @Autowired
    ProcessAssetMiddleware processAssetMiddleware;


    @RequestMapping(value = BaseRoute.GET_PROCESS_ASSETS, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessAssets(@RequestParam long userId,
                                              @RequestParam String processId) {

        ProcessAssetWSModel response = processAssetMiddleware.getProcessAssets(userId, processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_PROCESS_ASSET, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessAsset(@RequestParam long userId,
                                             @RequestParam String processId) {

        ProcessAssetWSModel response = processAssetMiddleware.getProcessAsset(userId, processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_PROCESS_ASSET, method = RequestMethod.POST)
    public ResponseEntity<?> createProcessAsset(@RequestParam long userId,
                                                @RequestParam String processId) {

        ProcessAssetWSModel response = processAssetMiddleware.createProcessAsset(userId, processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_PROCESS_ASSET, method = RequestMethod.POST)
    public ResponseEntity<?> updateProcessAsset(@RequestParam long userId,
                                                @RequestParam String processId) {

        ProcessAssetWSModel response = processAssetMiddleware.updateProcessAsset(userId, processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = BaseRoute.REMOVE_PROCESS_ASSET, method = RequestMethod.POST)
    public ResponseEntity<?> removeProcessAsset(@RequestParam long userId,
                                                @RequestParam String processId) {

        ProcessAssetWSModel response = processAssetMiddleware.removeProcessAsset(userId, processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
