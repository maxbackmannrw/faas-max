
package com.faas.core.api.endpoint.controller.flow.content;

import com.faas.core.api.middleware.flow.content.ApiFlowMiddleware;
import com.faas.core.api.model.ws.flow.content.ApiAgentFlowWSModel;
import com.faas.core.api.model.ws.flow.content.ApiFlowWSModel;
import com.faas.core.api.model.ws.general.ApiSummaryWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/api/flow/")
public class ApiFlowController {


    @Autowired
    ApiFlowMiddleware apiFlowMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_AGENT_FLOWS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetAgentFlows(@RequestParam long agentId,
                                              @RequestParam int reqPage,
                                              @RequestParam int reqSize) {

        ApiAgentFlowWSModel response = apiFlowMiddleware.apiGetAgentFlows(agentId,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_CAMPAIGN_FLOWS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetCampaignFlows(@RequestParam long agentId,
                                                 @RequestParam String campaignId,
                                                 @RequestParam String flowState,
                                                 @RequestParam int reqPage,
                                                 @RequestParam int reqSize) {

        ApiFlowWSModel response = apiFlowMiddleware.apiGetCampaignFlows(agentId,campaignId,flowState,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_FLOWS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetFlows(@RequestParam long agentId,
                                         @RequestParam String flowState,
                                         @RequestParam int reqPage,
                                         @RequestParam int reqSize) {

        ApiFlowWSModel response = apiFlowMiddleware.apiGetFlows(agentId,flowState,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_FLOW, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetFlow(@RequestParam long agentId,
                                        @RequestParam long flowId,
                                        @RequestParam String campaignId) {

        ApiFlowWSModel response = apiFlowMiddleware.apiGetFlow(agentId,flowId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_UPDATE_FLOW, method = RequestMethod.POST)
    public ResponseEntity<?> apiUpdateFlow(@RequestParam long agentId,
                                           @RequestParam long flowId,
                                           @RequestParam String flowState) {

        ApiFlowWSModel response = apiFlowMiddleware.apiUpdateFlow(agentId,flowId,flowState);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_REMOVE_FLOW, method = RequestMethod.POST)
    public ResponseEntity<?> apiRemoveFlow(@RequestParam long agentId,
                                           @RequestParam long flowId) {

        ApiFlowWSModel response = apiFlowMiddleware.apiRemoveFlow(agentId,flowId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_FLOW_SUMMARY, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetFlowSummary(@RequestParam long agentId) {

        ApiSummaryWSModel response = apiFlowMiddleware.apiGetFlowSummary(agentId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
