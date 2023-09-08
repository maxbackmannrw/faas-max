package com.faas.core.base.endpoint.controller.client.flow.content;

import com.faas.core.base.middleware.client.flow.content.ClientFlowMiddleware;
import com.faas.core.base.model.ws.client.flow.FlowCampaignWSModel;
import com.faas.core.base.model.ws.client.flow.ClientFlowWSModel;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.BaseRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/base/client/flow/")
public class ClientFlowController {


    @Autowired
    ClientFlowMiddleware clientFlowMiddleware;


    @RequestMapping(value = BaseRoute.GET_FLOW_CAMPAIGNS, method = RequestMethod.POST)
    public ResponseEntity<?> getFlowCampaigns(@RequestParam long userId,
                                              @RequestParam int reqPage,
                                              @RequestParam int reqSize) {

        FlowCampaignWSModel response = clientFlowMiddleware.getFlowCampaigns(userId,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_FLOW_CAMPAIGN, method = RequestMethod.POST)
    public ResponseEntity<?> getFlowCampaign(@RequestParam long userId,
                                             @RequestParam String campaignId,
                                             @RequestParam int reqPage,
                                             @RequestParam int reqSize) {

        FlowCampaignWSModel response = clientFlowMiddleware.getFlowCampaign(userId,campaignId,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = BaseRoute.GET_ALL_FLOWS, method = RequestMethod.POST)
    public ResponseEntity<?> getAllFlows(@RequestParam long userId,
                                         @RequestParam int reqPage,
                                         @RequestParam int reqSize) {

        ClientFlowWSModel response = clientFlowMiddleware.getAllFlows(userId,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_FLOWS_BY_STATE, method = RequestMethod.POST)
    public ResponseEntity<?> getFlowsByState(@RequestParam long userId,
                                             @RequestParam String flowState,
                                             @RequestParam int reqPage,
                                             @RequestParam int reqSize) {

        ClientFlowWSModel response = clientFlowMiddleware.getFlowsByState(userId,flowState,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_FLOW, method = RequestMethod.POST)
    public ResponseEntity<?> getFlow(@RequestParam long userId,
                                     @RequestParam long flowId,
                                     @RequestParam long clientId) {

        ClientFlowWSModel response = clientFlowMiddleware.getFlow(userId,flowId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_FLOW, method = RequestMethod.POST)
    public ResponseEntity<?> createFlow(@RequestParam long userId,
                                        @RequestParam long clientId,
                                        @RequestParam long agentId,
                                        @RequestParam String campaignId) {

        ClientFlowWSModel response = clientFlowMiddleware.createFlow(userId,clientId,agentId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_FLOW, method = RequestMethod.POST)
    public ResponseEntity<?> updateFlow(@RequestParam long userId,
                                        @RequestParam long flowId,
                                        @RequestParam long clientId) {

        ClientFlowWSModel response = clientFlowMiddleware.updateFlow(userId,flowId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_FLOW, method = RequestMethod.POST)
    public ResponseEntity<?> removeFlow(@RequestParam long userId,
                                        @RequestParam long flowId,
                                        @RequestParam long clientId) {

        ClientFlowWSModel response = clientFlowMiddleware.removeFlow(userId,flowId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
