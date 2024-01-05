package com.faas.core.api.endpoint.controller.dashboard;

import com.faas.core.api.middleware.dashboard.ApiDashboardMiddleware;
import com.faas.core.api.model.ws.campaign.content.ApiCampaignWSModel;
import com.faas.core.api.model.ws.dashboard.ApiDashboardWSModel;
import com.faas.core.api.model.ws.general.ApiSummaryWSModel;
import com.faas.core.api.model.ws.operation.content.ApiOperationListWSModel;
import com.faas.core.utils.config.ApiRoute;
import com.faas.core.utils.config.AppConstant;
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


    @RequestMapping(value = ApiRoute.API_GET_DASHBOARD, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetDashboard(@RequestParam long agentId,
                                             @RequestParam int reqPage,
                                             @RequestParam int reqSize) {

        ApiDashboardWSModel response = apiDashboardMiddleware.apiGetDashboard(agentId,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_DASHBOARD_OPERATIONS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetDashboardOperations(@RequestParam long agentId,
                                                       @RequestParam String operationType,
                                                       @RequestParam String operationState,
                                                       @RequestParam int reqPage,
                                                       @RequestParam int reqSize) {

        ApiOperationListWSModel response = apiDashboardMiddleware.apiGetDashboardOperations(agentId,operationType,operationState,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_DASHBOARD_CAMPAIGNS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetDashboardCampaigns(@RequestParam long agentId) {

        ApiCampaignWSModel response = apiDashboardMiddleware.apiGetDashboardCampaigns(agentId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_DASHBOARD_SUMMARY, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetDashboardSummary(@RequestParam long agentId) {

        ApiSummaryWSModel response = apiDashboardMiddleware.apiGetDashboardSummary(agentId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

}
