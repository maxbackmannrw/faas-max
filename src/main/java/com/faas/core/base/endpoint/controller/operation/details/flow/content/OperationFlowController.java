package com.faas.core.base.endpoint.controller.operation.details.flow.content;

import com.faas.core.base.middleware.operation.details.flow.content.OperationFlowMiddleware;
import com.faas.core.base.model.ws.operation.flow.OperationFlowCampaignWSModel;
import com.faas.core.base.model.ws.operation.flow.OperationFlowWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/operation/flow/")
public class OperationFlowController {


    @Autowired
    OperationFlowMiddleware operationFlowMiddleware;


    @RequestMapping(value = BaseRoute.GET_OPERATION_FLOW_CAMPAIGNS, method = RequestMethod.POST)
    public ResponseEntity<?> getOperationFlowCampaigns(@RequestParam long userId,
                                                       @RequestParam int reqPage,
                                                       @RequestParam int reqSize) {

        OperationFlowCampaignWSModel response = operationFlowMiddleware.getOperationFlowCampaigns(userId,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_OPERATION_FLOW_CAMPAIGN, method = RequestMethod.POST)
    public ResponseEntity<?> getOperationFlowCampaign(@RequestParam long userId,
                                                      @RequestParam String campaignId,
                                                      @RequestParam int reqPage,
                                                      @RequestParam int reqSize) {

        OperationFlowCampaignWSModel response = operationFlowMiddleware.getOperationFlowCampaign(userId,campaignId,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = BaseRoute.GET_ALL_OPERATION_FLOWS, method = RequestMethod.POST)
    public ResponseEntity<?> getAllOperationFlows(@RequestParam long userId,
                                                  @RequestParam int reqPage,
                                                  @RequestParam int reqSize) {

        OperationFlowWSModel response = operationFlowMiddleware.getAllOperationFlows(userId,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_OPERATION_FLOWS_BY_STATE, method = RequestMethod.POST)
    public ResponseEntity<?> getOperationFlowsByState(@RequestParam long userId,
                                                      @RequestParam String flowState,
                                                      @RequestParam int reqPage,
                                                      @RequestParam int reqSize) {

        OperationFlowWSModel response = operationFlowMiddleware.getOperationFlowsByState(userId,flowState,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_OPERATION_FLOW, method = RequestMethod.POST)
    public ResponseEntity<?> getOperationFlow(@RequestParam long userId,
                                              @RequestParam long flowId,
                                              @RequestParam long clientId) {

        OperationFlowWSModel response = operationFlowMiddleware.getOperationFlow(userId,flowId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_OPERATION_FLOW, method = RequestMethod.POST)
    public ResponseEntity<?> createOperationFlow(@RequestParam long userId,
                                                 @RequestParam long clientId,
                                                 @RequestParam long agentId,
                                                 @RequestParam String campaignId) {

        OperationFlowWSModel response = operationFlowMiddleware.createOperationFlow(userId,clientId,agentId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_OPERATION_FLOW, method = RequestMethod.POST)
    public ResponseEntity<?> updateOperationFlow(@RequestParam long userId,
                                                 @RequestParam long flowId,
                                                 @RequestParam long clientId) {

        OperationFlowWSModel response = operationFlowMiddleware.updateOperationFlow(userId,flowId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_OPERATION_FLOW, method = RequestMethod.POST)
    public ResponseEntity<?> removeOperationFlow(@RequestParam long userId,
                                                 @RequestParam long flowId,
                                                 @RequestParam long clientId) {

        OperationFlowWSModel response = operationFlowMiddleware.removeOperationFlow(userId,flowId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
