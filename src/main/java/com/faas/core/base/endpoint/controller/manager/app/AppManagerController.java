package com.faas.core.base.endpoint.controller.manager.app;

import com.faas.core.base.middleware.manager.app.AppManagerMiddleware;
import com.faas.core.base.model.ws.manager.app.AppManagerCampaignWSModel;
import com.faas.core.base.model.ws.manager.app.AppManagerContentWSModel;
import com.faas.core.base.model.ws.manager.app.AppManagerOperationWSModel;
import com.faas.core.base.model.ws.manager.app.AppManagerWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/manager/app/")
public class AppManagerController {


    @Autowired
    AppManagerMiddleware appManagerMiddleware;


    @RequestMapping(value = BaseRoute. GET_APP_MANAGER, method = RequestMethod.POST)
    public ResponseEntity<?> getAppManager(@RequestParam long userId,
                                           @RequestParam int reqPage,
                                           @RequestParam int reqSize) {

        AppManagerWSModel response = appManagerMiddleware.getAppManager(userId,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute. GET_APP_MANAGER_CONTENT, method = RequestMethod.POST)
    public ResponseEntity<?> getAppManagerContent(@RequestParam long userId,
                                                  @RequestParam String category,
                                                  @RequestParam int reqPage,
                                                  @RequestParam int reqSize) {

        AppManagerContentWSModel response = appManagerMiddleware.getAppManagerContent(userId,category,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = BaseRoute.GET_APP_MANAGER_CAMPAIGNS, method = RequestMethod.POST)
    public ResponseEntity<?> getAppManagerCampaigns(@RequestParam long userId,
                                                    @RequestParam String category) {

        AppManagerCampaignWSModel response = appManagerMiddleware.getAppManagerCampaigns(userId,category);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_APP_MANAGER_CAMPAIGN, method = RequestMethod.POST)
    public ResponseEntity<?> getAppManagerCampaign(@RequestParam long userId,
                                                   @RequestParam String campaignId) {

        AppManagerCampaignWSModel response = appManagerMiddleware.getAppManagerCampaign(userId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = BaseRoute.GET_APP_MANAGER_OPERATIONS, method = RequestMethod.POST)
    public ResponseEntity<?> getAppManagerOperations(@RequestParam long userId,
                                                     @RequestParam String category,
                                                     @RequestParam int reqPage,
                                                     @RequestParam int reqSize) {

        AppManagerOperationWSModel response = appManagerMiddleware.getAppManagerOperations(userId,category,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_APP_MANAGER_OPERATIONS_BY_STATE, method = RequestMethod.POST)
    public ResponseEntity<?> getAppManagerOperationsByState(@RequestParam long userId,
                                                            @RequestParam String category,
                                                            @RequestParam String operationState,
                                                            @RequestParam int reqPage,
                                                            @RequestParam int reqSize) {

        AppManagerOperationWSModel response = appManagerMiddleware.getAppManagerOperationsByState(userId,category,operationState,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_APP_MANAGER_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> getAppManagerOperation(@RequestParam long userId,
                                                    @RequestParam long sessionId) {

        OperationWSModel response = appManagerMiddleware.getAppManagerOperation(userId,sessionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
