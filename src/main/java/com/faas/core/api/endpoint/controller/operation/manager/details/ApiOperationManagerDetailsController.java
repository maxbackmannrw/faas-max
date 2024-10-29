package com.faas.core.api.endpoint.controller.operation.manager.details;

import com.faas.core.api.middleware.operation.manager.details.ApiOperationManagerDetailsMiddleware;
import com.faas.core.api.model.ws.operation.manager.details.ApiOperationActivityWSModel;
import com.faas.core.api.model.ws.operation.manager.details.ApiOperationCampaignScriptWSModel;
import com.faas.core.api.model.ws.operation.manager.details.ApiOperationCampaignWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/api/operation/manager/details/")
public class ApiOperationManagerDetailsController {


    @Autowired
    ApiOperationManagerDetailsMiddleware apiOperationManagerDetailsMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_CAMPAIGN, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationCampaign(@RequestParam long agentId,
                                                     @RequestParam String campaignId) {

        ApiOperationCampaignWSModel response = apiOperationManagerDetailsMiddleware.apiGetOperationCampaign(agentId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_OPERATION_CAMPAIGN_SCRIPTS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationCampaignScripts(@RequestParam long agentId,
                                                            @RequestParam String campaignId) {

        ApiOperationCampaignScriptWSModel response = apiOperationManagerDetailsMiddleware.apiGetOperationCampaignScripts(agentId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_ACTIVITIES, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationActivities(@RequestParam long agentId,
                                                       @RequestParam String operationId) {

        ApiOperationActivityWSModel response = apiOperationManagerDetailsMiddleware.apiGetOperationActivities(agentId, operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_OPERATION_ACTIVITY, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationActivity(@RequestParam long agentId,
                                                     @RequestParam String operationId,
                                                     @RequestParam String activityId) {

        ApiOperationActivityWSModel response = apiOperationManagerDetailsMiddleware.apiGetOperationActivity(agentId, operationId, activityId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
