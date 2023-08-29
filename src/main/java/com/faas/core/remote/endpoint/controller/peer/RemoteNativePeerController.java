package com.faas.core.remote.endpoint.controller.peer;

import com.faas.core.api.middleware.operation.channel.message.sms.ApiSmsMessageMiddleware;
import com.faas.core.api.model.ws.operation.channel.message.sms.ApiOperationSmsMessageWSModel;
import com.faas.core.utils.config.ApiRoute;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.RemoteRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/remote/peer/native/")
public class RemoteNativePeerController {


    @Autowired
    ApiSmsMessageMiddleware apiSmsMessageMiddleware;

    @RequestMapping(value = RemoteRoute.API_GET_AGENT_SIP_ACCOUNT, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationSmsMessage(@RequestParam long agentId,
                                                       @RequestParam long sessionId) {

        ApiOperationSmsMessageWSModel response = apiSmsMessageMiddleware.apiGetOperationSmsMessage(agentId,sessionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }




}
