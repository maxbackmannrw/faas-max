package com.faas.core.api.endpoint.controller.dashboard;

import com.faas.core.api.middleware.dashboard.ApiDashboardMiddleware;
import com.faas.core.api.model.ws.campaign.content.ApiCampaignWSModel;
import com.faas.core.api.model.ws.dashboard.ApiDashContentWSModel;
import com.faas.core.api.model.ws.general.ApiSummaryWSModel;
import com.faas.core.api.model.ws.operation.content.ApiOperationListWSModel;
import com.faas.core.api.model.ws.operation.content.ApiValidateOperationWSModel;
import com.faas.core.api.model.ws.operation.content.ApiOperationWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/api/dashboard/")
public class ApiDashboardController {


    @Autowired
    ApiDashboardMiddleware apiDashboardMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_DASH_CONTENT, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetDashContent(@RequestParam long agentId,
                                               @RequestParam int reqPage,
                                               @RequestParam int reqSize) {

        ApiDashContentWSModel response = apiDashboardMiddleware.apiGetDashContent(agentId,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_DASH_OPERATIONS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetDashOperations(@RequestParam long agentId,
                                                  @RequestParam String operationCategory,
                                                  @RequestParam String operationState,
                                                  @RequestParam int reqPage,
                                                  @RequestParam int reqSize) {

        ApiOperationListWSModel response = apiDashboardMiddleware.apiGetDashOperations(agentId,operationCategory,operationState,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_DASH_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetDashOperation(@RequestParam long agentId,
                                                 @RequestParam String operationId) {

        ApiOperationWSModel response = apiDashboardMiddleware.apiGetDashOperation(agentId,operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_VALIDATE_DASH_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> apiValidateDashOperation(@RequestParam long agentId,
                                                      @RequestParam String operationId) {

        ApiValidateOperationWSModel response = apiDashboardMiddleware.apiValidateDashOperation(agentId, operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_DASH_CAMPAIGNS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetDashCampaigns(@RequestParam long agentId,
                                                 @RequestParam String campaignState) {

        ApiCampaignWSModel response = apiDashboardMiddleware.apiGetDashCampaigns(agentId,campaignState);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_DASH_SUMMARY, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetDashSummary(@RequestParam long agentId) {

        ApiSummaryWSModel response = apiDashboardMiddleware.apiGetDashSummary(agentId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
