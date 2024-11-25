package com.faas.core.api.endpoint.controller.operation.manager.activity;

import com.faas.core.api.middleware.operation.manager.activity.ApiOperationActivityMiddleware;
import com.faas.core.api.model.ws.operation.manager.activity.ApiOperationActivityWSModel;
import com.faas.core.misc.config.ApiRoute;
import com.faas.core.misc.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/api/operation/manager/activity/")
public class ApiOperationActivityController {


    @Autowired
    ApiOperationActivityMiddleware apiOperationActivityMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_ACTIVITIES, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationActivities(@RequestParam long agentId,
                                                       @RequestParam String operationId) {

        ApiOperationActivityWSModel response = apiOperationActivityMiddleware.apiGetOperationActivities(agentId, operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_OPERATION_ACTIVITY, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationActivity(@RequestParam long agentId,
                                                     @RequestParam String operationId,
                                                     @RequestParam String activityId) {

        ApiOperationActivityWSModel response = apiOperationActivityMiddleware.apiGetOperationActivity(agentId, operationId, activityId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
