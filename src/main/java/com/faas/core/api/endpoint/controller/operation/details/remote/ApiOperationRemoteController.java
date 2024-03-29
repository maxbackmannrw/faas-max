package com.faas.core.api.endpoint.controller.operation.details.remote;

import com.faas.core.api.middleware.operation.details.remote.ApiOperationRemoteMiddleware;
import com.faas.core.api.model.ws.operation.details.remote.ApiOperationClientRemoteWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/api/operation/details/remote/")
public class ApiOperationRemoteController {


    @Autowired
    ApiOperationRemoteMiddleware apiOperationRemoteMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_CLIENT_REMOTES, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationClientRemotes(@RequestParam long agentId,
                                                          @RequestParam String operationId) {

        ApiOperationClientRemoteWSModel response = apiOperationRemoteMiddleware.apiGetOperationClientRemotes(agentId,operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_OPERATION_CLIENT_REMOTE, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationClientRemote(@RequestParam long agentId,
                                                         @RequestParam String operationId,
                                                         @RequestParam String clientRemoteId) {

        ApiOperationClientRemoteWSModel response = apiOperationRemoteMiddleware.apiGetOperationClientRemote(agentId,operationId,clientRemoteId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}