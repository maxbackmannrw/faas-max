package com.faas.core.api.endpoint.controller.operation.details.channel.message.push;

import com.faas.core.api.middleware.operation.details.channel.message.push.ApiOperationPushChannelMiddleware;
import com.faas.core.api.model.ws.operation.details.channel.message.push.ApiOperationPushMessageWSModel;
import com.faas.core.api.model.ws.operation.details.channel.message.push.ApiPushMessageTempWSModel;
import com.faas.core.api.model.ws.operation.details.channel.message.push.ApiPushMessageWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/api/operation/details/channel/message/push/")
public class ApiOperationPushChannelController {


    @Autowired
    ApiOperationPushChannelMiddleware apiOperationPushChannelMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_PUSH_MESSAGE, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationPushMessage(@RequestParam long agentId,
                                                        @RequestParam long sessionId) {

        ApiOperationPushMessageWSModel response = apiOperationPushChannelMiddleware.apiGetOperationPushMessage(agentId,sessionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_PUSH_MESSAGES, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetPushMessages(@RequestParam long agentId,
                                                 @RequestParam long sessionId,
                                                 @RequestParam long pushId) {

        ApiPushMessageWSModel response = apiOperationPushChannelMiddleware.apiGetPushMessages(agentId,sessionId,pushId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_PUSH_MESSAGE, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetPushMessage(@RequestParam long agentId,
                                                @RequestParam long sessionId,
                                                @RequestParam long pushId) {

        ApiPushMessageWSModel response = apiOperationPushChannelMiddleware.apiGetPushMessage(agentId,sessionId,pushId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_SEND_PUSH_MESSAGE, method = RequestMethod.POST)
    public ResponseEntity<?> apiSendPushMessage(@RequestParam long agentId,
                                                  @RequestParam long sessionId) {

        ApiPushMessageWSModel response = apiOperationPushChannelMiddleware.apiSendPushMessage(agentId,sessionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_UPDATE_PUSH_MESSAGE, method = RequestMethod.POST)
    public ResponseEntity<?> apiUpdatePushMessage(@RequestParam long agentId,
                                                    @RequestParam long sessionId) {

        ApiPushMessageWSModel response = apiOperationPushChannelMiddleware.apiUpdatePushMessage(agentId,sessionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_REMOVE_PUSH_MESSAGE, method = RequestMethod.POST)
    public ResponseEntity<?> apiRemovePushMessage(@RequestParam long agentId,
                                                    @RequestParam long sessionId) {

        ApiPushMessageWSModel response = apiOperationPushChannelMiddleware.apiRemovePushMessage(agentId,sessionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = ApiRoute.API_GET_PUSH_MESSAGE_TEMPS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetPushMessageTemps(@RequestParam long agentId,
                                                  @RequestParam long sessionId) {

        ApiPushMessageTempWSModel response = apiOperationPushChannelMiddleware.apiGetPushMessageTemps(agentId,sessionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_PUSH_MESSAGE_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetPushMessageTemp(@RequestParam long agentId,
                                                    @RequestParam long sessionId) {

        ApiPushMessageTempWSModel response = apiOperationPushChannelMiddleware.apiGetPushMessageTemp(agentId,sessionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
