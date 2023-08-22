package com.faas.core.base.endpoint.controller.flow;

import com.faas.core.base.middleware.flow.FlowMiddleware;
import com.faas.core.base.model.ws.flow.FlowCampaignWSModel;
import com.faas.core.base.model.ws.flow.FlowWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/flow/")
public class FlowController {


    @Autowired
    FlowMiddleware flowMiddleware;


    @RequestMapping(value = BaseRoute.GET_FLOW_CAMPAIGNS, method = RequestMethod.POST)
    public ResponseEntity<?> getFlowCampaigns(@RequestParam long userId,
                                              @RequestParam int reqPage,
                                              @RequestParam int reqSize) {

        FlowCampaignWSModel response = flowMiddleware.getFlowCampaigns(userId,reqPage,reqSize);

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

        FlowCampaignWSModel response = flowMiddleware.getFlowCampaign(userId,campaignId,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = BaseRoute.GET_ALL_FLOWS, method = RequestMethod.POST)
    public ResponseEntity<?> getAllFlows(@RequestParam long userId,
                                         @RequestParam int reqPage,
                                         @RequestParam int reqSize) {

        FlowWSModel response = flowMiddleware.getAllFlows(userId,reqPage,reqSize);

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

        FlowWSModel response = flowMiddleware.getFlowsByState(userId,flowState,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_FLOW, method = RequestMethod.POST)
    public ResponseEntity<?> getFlow(@RequestParam long userId,
                                     @RequestParam long flowId,
                                     @RequestParam long clientId) {

        FlowWSModel response = flowMiddleware.getFlow(userId,flowId,clientId);

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

        FlowWSModel response = flowMiddleware.createFlow(userId,clientId,agentId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_FLOW, method = RequestMethod.POST)
    public ResponseEntity<?> updateFlow(@RequestParam long userId,
                                        @RequestParam long flowId,
                                        @RequestParam long clientId) {

        FlowWSModel response = flowMiddleware.updateFlow(userId,flowId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_FLOW, method = RequestMethod.POST)
    public ResponseEntity<?> removeFlow(@RequestParam long userId,
                                        @RequestParam long flowId,
                                        @RequestParam long clientId) {

        FlowWSModel response = flowMiddleware.removeFlow(userId,flowId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
