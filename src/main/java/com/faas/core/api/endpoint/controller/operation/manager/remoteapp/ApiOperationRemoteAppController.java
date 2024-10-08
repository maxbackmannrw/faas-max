package com.faas.core.api.endpoint.controller.operation.manager.remoteapp;

import com.faas.core.api.middleware.operation.manager.remoteapp.ApiOperationRemoteAppMiddleware;
import com.faas.core.api.model.ws.operation.manager.remoteapp.ApiOperationRemoteAppWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/api/operation/manager/remoteapp/")
public class ApiOperationRemoteAppController {


    @Autowired
    ApiOperationRemoteAppMiddleware apiOperationRemoteAppMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_REMOTE_APPS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationRemoteApps(@RequestParam long agentId,
                                                       @RequestParam String operationId) {

        ApiOperationRemoteAppWSModel response = apiOperationRemoteAppMiddleware.apiGetOperationRemoteApps(agentId, operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_OPERATION_REMOTE_APP, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationRemoteApp(@RequestParam long agentId,
                                                      @RequestParam String operationId,
                                                      @RequestParam String clientRemoteId) {

        ApiOperationRemoteAppWSModel response = apiOperationRemoteAppMiddleware.apiGetOperationRemoteApp(agentId, operationId, clientRemoteId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
