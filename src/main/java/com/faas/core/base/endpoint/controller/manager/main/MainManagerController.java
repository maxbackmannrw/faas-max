package com.faas.core.base.endpoint.controller.manager.main;

import com.faas.core.base.middleware.manager.main.MainManagerMiddleware;
import com.faas.core.base.model.ws.manager.main.MainManagerCampaignWSModel;
import com.faas.core.base.model.ws.manager.main.MainManagerContentWSModel;
import com.faas.core.base.model.ws.manager.main.MainManagerOperationWSModel;
import com.faas.core.base.model.ws.manager.main.MainManagerWSModel;
import com.faas.core.base.model.ws.operation.content.OperationWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/manager/main/")
public class MainManagerController {


    @Autowired
    MainManagerMiddleware mainManagerMiddleware;


    @RequestMapping(value = BaseRoute. GET_MAIN_MANAGER, method = RequestMethod.POST)
    public ResponseEntity<?> getMainManager(@RequestParam long userId,
                                            @RequestParam int reqPage,
                                            @RequestParam int reqSize) {

        MainManagerWSModel response = mainManagerMiddleware.getMainManager(userId,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute. GET_MAIN_MANAGER_CONTENT, method = RequestMethod.POST)
    public ResponseEntity<?> getMainManagerContent(@RequestParam long userId,
                                                   @RequestParam String category,
                                                   @RequestParam int reqPage,
                                                   @RequestParam int reqSize) {

        MainManagerContentWSModel response = mainManagerMiddleware.getMainManagerContent(userId,category,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = BaseRoute.GET_MAIN_MANAGER_CAMPAIGNS, method = RequestMethod.POST)
    public ResponseEntity<?> getMainManagerCampaigns(@RequestParam long userId,
                                                     @RequestParam String category) {

        MainManagerCampaignWSModel response = mainManagerMiddleware.getMainManagerCampaigns(userId,category);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_MAIN_MANAGER_CAMPAIGN, method = RequestMethod.POST)
    public ResponseEntity<?> getMainManagerCampaign(@RequestParam long userId,
                                                    @RequestParam String campaignId) {

        MainManagerCampaignWSModel response = mainManagerMiddleware.getMainManagerCampaign(userId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = BaseRoute.GET_MAIN_MANAGER_OPERATIONS, method = RequestMethod.POST)
    public ResponseEntity<?> getMainManagerOperations(@RequestParam long userId,
                                                      @RequestParam String category,
                                                      @RequestParam int reqPage,
                                                      @RequestParam int reqSize) {

        MainManagerOperationWSModel response = mainManagerMiddleware.getMainManagerOperations(userId,category,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_MAIN_MANAGER_OPERATIONS_BY_STATE, method = RequestMethod.POST)
    public ResponseEntity<?> getMainManagerOperationsByState(@RequestParam long userId,
                                                             @RequestParam String category,
                                                             @RequestParam String operationState,
                                                             @RequestParam int reqPage,
                                                             @RequestParam int reqSize) {

        MainManagerOperationWSModel response = mainManagerMiddleware.getMainManagerOperationsByState(userId,category,operationState,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_MAIN_MANAGER_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> getMainManagerOperation(@RequestParam long userId,
                                                     @RequestParam long sessionId) {

        OperationWSModel response = mainManagerMiddleware.getMainManagerOperation(userId,sessionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_MAIN_MANAGER_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> removeMainManagerOperation(@RequestParam long userId,
                                                        @RequestParam long sessionId) {

        OperationWSModel response = mainManagerMiddleware.removeMainManagerOperation(userId,sessionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
