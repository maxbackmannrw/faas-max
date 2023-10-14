package com.faas.core.api.endpoint.controller.dashboard;

import com.faas.core.api.middleware.dashboard.ApiDashboardMiddleware;
import com.faas.core.api.model.ws.campaign.content.ApiCampaignWSModel;
import com.faas.core.api.model.ws.dashboard.ApiDashboardWSModel;
import com.faas.core.api.model.ws.general.ApiSummaryWSModel;
import com.faas.core.api.model.ws.inquiry.content.ApiInquiryWSModel;
import com.faas.core.api.model.ws.session.ApiSessionWSModel;
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

    @RequestMapping(value = ApiRoute.API_GET_DASH_SESSIONS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetDashSessions(@RequestParam long agentId,
                                                @RequestParam String sessionType,
                                                @RequestParam String sessionState,
                                                @RequestParam int reqPage,
                                                @RequestParam int reqSize) {

        ApiSessionWSModel response = apiDashboardMiddleware.apiGetDashSessions(agentId,sessionType,sessionState,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_DASH_INQUIRIES, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetDashInquiries(@RequestParam long agentId,
                                                 @RequestParam String inquiryState,
                                                 @RequestParam int reqPage,
                                                 @RequestParam int reqSize) {

        ApiInquiryWSModel response = apiDashboardMiddleware.apiGetDashInquiries(agentId,inquiryState,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_DASH_CAMPAIGNS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetDashCampaigns(@RequestParam long agentId) {

        ApiCampaignWSModel response = apiDashboardMiddleware.apiGetDashCampaigns(agentId);

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
