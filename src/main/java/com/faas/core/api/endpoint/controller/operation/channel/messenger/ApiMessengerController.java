package com.faas.core.api.endpoint.controller.operation.channel.messenger;

import com.faas.core.api.middleware.operation.channel.messenger.ApiMessengerMiddleware;
import com.faas.core.api.model.ws.operation.channel.messenger.ApiOperationMessengerWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/api/operation/channel/messenger/")
public class ApiMessengerController {


    @Autowired
    ApiMessengerMiddleware apiMessengerMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_MESSENGER, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationMessenger(@RequestParam long agentId,
                                                       @RequestParam long sessionId) {

        ApiOperationMessengerWSModel response = apiMessengerMiddleware.apiGetOperationMessenger(agentId,sessionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
