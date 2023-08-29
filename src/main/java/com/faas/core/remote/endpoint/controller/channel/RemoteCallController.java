package com.faas.core.remote.endpoint.controller.channel;

import com.faas.core.api.middleware.operation.channel.message.sms.ApiSmsMessageMiddleware;
import com.faas.core.api.model.ws.operation.channel.message.sms.ApiOperationSmsMessageWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/remote/channel/call/")
public class RemoteCallController {


    @Autowired
    ApiSmsMessageMiddleware apiSmsMessageMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_SMS_MESSAGE, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationSmsMessage(@RequestParam long agentId,
                                                       @RequestParam long sessionId) {

        ApiOperationSmsMessageWSModel response = apiSmsMessageMiddleware.apiGetOperationSmsMessage(agentId,sessionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }




}
