package com.faas.core.api.endpoint.controller.operation.manager.campaign;

import com.faas.core.api.middleware.operation.manager.campaign.ApiOperationCampaignMiddleware;
import com.faas.core.api.model.ws.operation.manager.campaign.ApiOperationCampaignScriptWSModel;
import com.faas.core.api.model.ws.operation.manager.campaign.ApiOperationCampaignWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/api/operation/manager/campaign/")
public class ApiOperationCampaignController {


    @Autowired
    ApiOperationCampaignMiddleware apiOperationCampaignMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_CAMPAIGN, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationCampaign(@RequestParam long agentId,
                                                     @RequestParam String campaignId) {

        ApiOperationCampaignWSModel response = apiOperationCampaignMiddleware.apiGetOperationCampaign(agentId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_OPERATION_CAMPAIGN_SCRIPTS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationCampaignScripts(@RequestParam long agentId,
                                                            @RequestParam String campaignId) {

        ApiOperationCampaignScriptWSModel response = apiOperationCampaignMiddleware.apiGetOperationCampaignScripts(agentId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

}
