package com.faas.core.api.endpoint.controller.operation.details.channel.content;

import com.faas.core.api.middleware.operation.details.channel.call.sip.ApiOperationSipChannelMiddleware;
import com.faas.core.api.middleware.operation.details.channel.content.ApiOperationChannelMiddleware;
import com.faas.core.api.model.ws.operation.details.channel.call.sip.ApiOperationSipCallWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/api/operation/details/channel/")
public class ApiOperationChannelController {


    @Autowired
    ApiOperationChannelMiddleware apiOperationChannelMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_SIP_CALL, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationChannel(@RequestParam long agentId,
                                                    @RequestParam long sessionId,
                                                    @RequestParam long clientId) {

        ApiOperationSipCallWSModel response = apiOperationChannelMiddleware.apiGetOperationChannel(agentId,sessionId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }




}
