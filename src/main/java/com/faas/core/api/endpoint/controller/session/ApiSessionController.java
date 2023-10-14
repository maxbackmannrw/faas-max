package com.faas.core.api.endpoint.controller.session;

import com.faas.core.api.middleware.session.ApiSessionMiddleware;
import com.faas.core.api.model.ws.session.ApiSessionDetailsWSModel;
import com.faas.core.api.model.ws.general.ApiSummaryWSModel;
import com.faas.core.api.model.ws.session.ApiAgentSessionWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/api/session/")
public class ApiSessionController {


    @Autowired
    ApiSessionMiddleware apiSessionMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_AGENT_SESSION, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetAgentSession(@RequestParam long agentId,
                                                @RequestParam int reqPage,
                                                @RequestParam int reqSize) {

        ApiAgentSessionWSModel response = apiSessionMiddleware.apiGetAgentSession(agentId,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_CAMPAIGN_SESSIONS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetCampaignSessions(@RequestParam long agentId,
                                                    @RequestParam String campaignId,
                                                    @RequestParam String sessionState,
                                                    @RequestParam int reqPage,
                                                    @RequestParam int reqSize) {

        ApiSessionWSModel response = apiSessionMiddleware.apiGetCampaignSessions(agentId,campaignId,sessionState,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_SESSIONS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetSessions(@RequestParam long agentId,
                                            @RequestParam String sessionState,
                                            @RequestParam int reqPage,
                                            @RequestParam int reqSize) {

        ApiSessionWSModel response = apiSessionMiddleware.apiGetSessions(agentId,sessionState,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_SESSION, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetSession(@RequestParam long agentId,
                                           @RequestParam long sessionId) {

        ApiSessionWSModel response = apiSessionMiddleware.apiGetSession(agentId,sessionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_SESSION_DETAILS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetSessionDetails(@RequestParam long agentId,
                                                  @RequestParam long sessionId) {

        ApiSessionDetailsWSModel response = apiSessionMiddleware.apiGetSessionDetails(agentId,sessionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_SESSION_SUMMARY, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetSessionSummary(@RequestParam long agentId) {

        ApiSummaryWSModel response = apiSessionMiddleware.apiGetSessionSummary(agentId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}