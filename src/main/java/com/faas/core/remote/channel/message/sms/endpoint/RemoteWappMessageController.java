package com.faas.core.remote.channel.message.sms.endpoint;

import com.faas.core.api.middleware.operation.channel.message.sms.ApiSmsMessageMiddleware;
import com.faas.core.api.model.ws.operation.channel.message.sms.ApiOperationSmsMessageWSModel;
import com.faas.core.api.model.ws.operation.channel.message.sms.ApiSmsMessageTempWSModel;
import com.faas.core.api.model.ws.operation.channel.message.sms.ApiSmsMessageWSModel;
import com.faas.core.remote.channel.message.sms.service.RemoteWappMessageService;
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

import java.io.IOException;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/remote/channel/message/wapp/")
public class RemoteWappMessageController {


    @Autowired
    RemoteWappMessageService remoteWappMessageService;


    @RequestMapping(value = RemoteRoute.API_GET_AGENT_SIP_ACCOUNT, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationSmsMessage(@RequestParam long agentId,
                                                       @RequestParam long sessionId) {

        ApiOperationSmsMessageWSModel response = remoteWappMessageService.apiGetOperationSmsMessageService(agentId,sessionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
