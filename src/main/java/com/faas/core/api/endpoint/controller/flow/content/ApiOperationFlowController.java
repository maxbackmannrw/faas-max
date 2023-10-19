
package com.faas.core.api.endpoint.controller.flow.content;

import com.faas.core.api.middleware.flow.content.ApiOperationFlowMiddleware;
import com.faas.core.api.model.ws.flow.content.ApiAgentOperationFlowWSModel;
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
public class ApiOperationFlowController {


    @Autowired
    ApiOperationFlowMiddleware apiOperationFlowMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_AGENT_OPERATION_FLOWS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetAgentOperationFlows(@RequestParam long agentId,
                                                       @RequestParam int reqPage,
                                                       @RequestParam int reqSize) {

        ApiAgentOperationFlowWSModel response = apiOperationFlowMiddleware.apiGetAgentOperationFlows(agentId,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_CAMPAIGN_OPERATION_FLOWS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetCampaignOperationFlows(@RequestParam long agentId,
                                                          @RequestParam String campaignId,
                                                          @RequestParam String flowState,
                                                          @RequestParam int reqPage,
                                                          @RequestParam int reqSize) {

        ApiFlowWSModel response = apiOperationFlowMiddleware.apiGetCampaignOperationFlows(agentId,campaignId,flowState,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_FLOWS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationFlows(@RequestParam long agentId,
                                                  @RequestParam String flowState,
                                                  @RequestParam int reqPage,
                                                  @RequestParam int reqSize) {

        ApiFlowWSModel response = apiOperationFlowMiddleware.apiGetOperationFlows(agentId,flowState,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_FLOW, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationFlow(@RequestParam long agentId,
                                                 @RequestParam long flowId,
                                                 @RequestParam String campaignId) {

        ApiFlowWSModel response = apiOperationFlowMiddleware.apiGetOperationFlow(agentId,flowId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_UPDATE_OPERATION_FLOW, method = RequestMethod.POST)
    public ResponseEntity<?> apiUpdateOperationFlow(@RequestParam long agentId,
                                                    @RequestParam long flowId,
                                                    @RequestParam String flowState) {

        ApiFlowWSModel response = apiOperationFlowMiddleware.apiUpdateOperationFlow(agentId,flowId,flowState);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_REMOVE_OPERATION_FLOW, method = RequestMethod.POST)
    public ResponseEntity<?> apiRemoveOperationFlow(@RequestParam long agentId,
                                                    @RequestParam long flowId) {

        ApiFlowWSModel response = apiOperationFlowMiddleware.apiRemoveOperationFlow(agentId,flowId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_FLOW_SUMMARY, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationFlowSummary(@RequestParam long agentId) {

        ApiSummaryWSModel response = apiOperationFlowMiddleware.apiGetOperationFlowSummary(agentId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
