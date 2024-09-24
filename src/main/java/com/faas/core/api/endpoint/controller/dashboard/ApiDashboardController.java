package com.faas.core.api.endpoint.controller.dashboard;

import com.faas.core.api.middleware.dashboard.ApiDashboardMiddleware;
import com.faas.core.api.model.ws.campaign.content.ApiCampaignWSModel;
import com.faas.core.api.model.ws.dashboard.ApiDashboardContentWSModel;
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


    @RequestMapping(value = ApiRoute.API_GET_DASHBOARD_CONTENTS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetDashboardContents(@RequestParam long agentId,
                                                     @RequestParam int reqPage,
                                                     @RequestParam int reqSize) {

        ApiDashboardContentWSModel response = apiDashboardMiddleware.apiGetDashboardContents(agentId,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_DASHBOARD_OPERATIONS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetDashboardOperations(@RequestParam long agentId,
                                                       @RequestParam String operationCategory,
                                                       @RequestParam String operationState,
                                                       @RequestParam int reqPage,
                                                       @RequestParam int reqSize) {

        ApiOperationListWSModel response = apiDashboardMiddleware.apiGetDashboardOperations(agentId,operationCategory,operationState,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_DASHBOARD_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetDashboardOperation(@RequestParam long agentId,
                                                      @RequestParam String operationId) {

        ApiOperationWSModel response = apiDashboardMiddleware.apiGetDashboardOperation(agentId,operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_VALIDATE_DASHBOARD_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> apiValidateDashboardOperation(@RequestParam long agentId,
                                                           @RequestParam String operationId) {

        ApiValidateOperationWSModel response = apiDashboardMiddleware.apiValidateDashboardOperation(agentId, operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_DASHBOARD_CAMPAIGNS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetDashboardCampaigns(@RequestParam long agentId,
                                                      @RequestParam String campaignState) {

        ApiCampaignWSModel response = apiDashboardMiddleware.apiGetDashboardCampaigns(agentId,campaignState);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_DASHBOARD_CONTENT_SUMMARY, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetDashboardContentSummary(@RequestParam long agentId) {

        ApiSummaryWSModel response = apiDashboardMiddleware.apiGetDashboardContentSummary(agentId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
