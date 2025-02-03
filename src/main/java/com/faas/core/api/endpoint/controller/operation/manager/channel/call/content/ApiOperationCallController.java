package com.faas.core.api.endpoint.controller.operation.manager.channel.call.content;

import com.faas.core.api.middleware.operation.manager.channel.call.content.ApiOperationCallMiddleware;
import com.faas.core.api.model.ws.operation.manager.channel.call.content.ApiOperationCallChannelWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/api/operation/manager/call/")
public class ApiOperationCallController {


    @Autowired
    ApiOperationCallMiddleware apiOperationCallMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_CALL_CHANNEL, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationCallChannel(@RequestParam long agentId,
                                                        @RequestParam String operationId) {

        ApiOperationCallChannelWSModel response = apiOperationCallMiddleware.apiGetOperationCallChannel(agentId, operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
