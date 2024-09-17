package com.faas.core.api.endpoint.controller.asset;

import com.faas.core.api.middleware.asset.ApiAssetMiddleware;
import com.faas.core.api.model.ws.asset.ApiAssetWSModel;
import com.faas.core.misc.config.ApiRoute;
import com.faas.core.misc.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/api/asset/")
public class ApiAssetController {


    @Autowired
    ApiAssetMiddleware apiAssetMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_AGENT_ASSETS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetAgentAssets(@RequestParam long agentId) {

        ApiAssetWSModel response = apiAssetMiddleware.apiGetAgentAssets(agentId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_AGENT_ASSET, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetAgentAsset(@RequestParam long agentId) {

        ApiAssetWSModel response = apiAssetMiddleware.apiGetAgentAsset(agentId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_CAMPAIGN_ASSETS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetCampaignAssets(@RequestParam long agentId) {

        ApiAssetWSModel response = apiAssetMiddleware.apiGetCampaignAssets(agentId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_CAMPAIGN_ASSET, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetCampaignAsset(@RequestParam long agentId) {

        ApiAssetWSModel response = apiAssetMiddleware.apiGetCampaignAsset(agentId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
