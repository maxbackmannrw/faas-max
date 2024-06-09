package com.faas.core.api.endpoint.controller.operation.details.channel.message.push;

import com.faas.core.api.middleware.operation.details.channel.message.push.ApiOperationPushMiddleware;
import com.faas.core.api.model.ws.operation.details.channel.message.push.ApiOperationPushAccountWSModel;
import com.faas.core.api.model.ws.operation.details.channel.message.push.ApiOperationPushChannelWSModel;
import com.faas.core.api.model.ws.operation.details.channel.message.push.ApiOperationPushTempWSModel;
import com.faas.core.api.model.ws.operation.details.channel.message.push.ApiOperationPushWSModel;
import com.faas.core.utility.config.ApiRoute;
import com.faas.core.utility.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/api/operation/details/channel/message/push/")
public class ApiOperationPushController {


    @Autowired
    ApiOperationPushMiddleware apiOperationPushMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_PUSH_CHANNEL, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationPushChannel(@RequestParam long agentId,
                                                        @RequestParam String operationId) {

        ApiOperationPushChannelWSModel response = apiOperationPushMiddleware.apiGetOperationPushChannel(agentId,operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_PUSH_ACCOUNT, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationPushAccount(@RequestParam long agentId,
                                                        @RequestParam String operationId) {

        ApiOperationPushAccountWSModel response = apiOperationPushMiddleware.apiGetOperationPushAccount(agentId,operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_PUSH_TEMPS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationPushTemps(@RequestParam long agentId,
                                                      @RequestParam String operationId) {

        ApiOperationPushTempWSModel response = apiOperationPushMiddleware.apiGetOperationPushTemps(agentId,operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_PUSH_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationPushTemp(@RequestParam long agentId,
                                                     @RequestParam String operationId,
                                                     @RequestParam String tempId) {

        ApiOperationPushTempWSModel response = apiOperationPushMiddleware.apiGetOperationPushTemp(agentId,operationId,tempId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_PUSHES, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationPushes(@RequestParam long agentId,
                                                   @RequestParam String operationId) {

        ApiOperationPushWSModel response = apiOperationPushMiddleware.apiGetOperationPushes(agentId,operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_OPERATION_PUSH, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationPush(@RequestParam long agentId,
                                                 @RequestParam String operationId,
                                                 @RequestParam String pushId) {

        ApiOperationPushWSModel response = apiOperationPushMiddleware.apiGetOperationPush(agentId,operationId,pushId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_SEND_OPERATION_PUSH, method = RequestMethod.POST)
    public ResponseEntity<?> apiSendOperationPush(@RequestParam long agentId,
                                                  @RequestParam String operationId,
                                                  @RequestParam String tempId,
                                                  @RequestParam String remoteAppId) {

        ApiOperationPushWSModel response = apiOperationPushMiddleware.apiSendOperationPush(agentId,operationId,tempId,remoteAppId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_UPDATE_OPERATION_PUSH, method = RequestMethod.POST)
    public ResponseEntity<?> apiUpdateOperationPush(@RequestParam long agentId,
                                                    @RequestParam String operationId,
                                                    @RequestParam String pushId,
                                                    @RequestParam String pushState) {

        ApiOperationPushWSModel response = apiOperationPushMiddleware.apiUpdateOperationPush(agentId,operationId,pushId,pushState);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_REMOVE_OPERATION_PUSH, method = RequestMethod.POST)
    public ResponseEntity<?> apiRemoveOperationPush(@RequestParam long agentId,
                                                    @RequestParam String operationId,
                                                    @RequestParam String pushId) {

        ApiOperationPushWSModel response = apiOperationPushMiddleware.apiRemoveOperationPush(agentId,operationId,pushId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }




}
