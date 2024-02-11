package com.faas.core.api.endpoint.controller.operation.details.channel.message.push;

import com.faas.core.api.middleware.operation.details.channel.message.push.ApiOperationPushChannelMiddleware;
import com.faas.core.api.model.ws.operation.details.channel.message.push.ApiOperationPushChannelWSModel;
import com.faas.core.api.model.ws.operation.details.channel.message.push.ApiOperationPushTempWSModel;
import com.faas.core.api.model.ws.operation.details.channel.message.push.ApiOperationPushWSModel;
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





    @RequestMapping(value = ApiRoute.API_GET_OPERATION_PUSHES, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationPushes(@RequestParam long agentId,
                                                   @RequestParam String operationId) {

        ApiOperationPushWSModel response = apiOperationPushChannelMiddleware.apiGetOperationPushes(agentId,operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_PUSH, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationPush(@RequestParam long agentId,
                                                 @RequestParam String operationId,
                                                 @RequestParam String pushId) {

        ApiOperationPushWSModel response = apiOperationPushChannelMiddleware.apiGetOperationPush(agentId,operationId,pushId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_SEND_OPERATION_PUSH, method = RequestMethod.POST)
    public ResponseEntity<?> apiSendOperationPush(@RequestParam long agentId,
                                                  @RequestParam String operationId) {

        ApiOperationPushWSModel response = apiOperationPushChannelMiddleware.apiSendOperationPush(agentId,operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_UPDATE_OPERATION_PUSH, method = RequestMethod.POST)
    public ResponseEntity<?> apiUpdateOperationPush(@RequestParam long agentId,
                                                    @RequestParam String operationId) {

        ApiOperationPushWSModel response = apiOperationPushChannelMiddleware.apiUpdateOperationPush(agentId,operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_REMOVE_OPERATION_PUSH, method = RequestMethod.POST)
    public ResponseEntity<?> apiRemoveOperationPush(@RequestParam long agentId,
                                                    @RequestParam String operationId) {

        ApiOperationPushWSModel response = apiOperationPushChannelMiddleware.apiRemoveOperationPush(agentId,operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = ApiRoute.API_GET_OPERATION_PUSH_TEMPS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationPushTemps(@RequestParam long agentId,
                                                      @RequestParam String operationId) {

        ApiOperationPushTempWSModel response = apiOperationPushChannelMiddleware.apiGetOperationPushTemps(agentId,operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_PUSH_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationPushTemp(@RequestParam long agentId,
                                                     @RequestParam String operationId,
                                                     @RequestParam String pushTempId) {

        ApiOperationPushTempWSModel response = apiOperationPushChannelMiddleware.apiGetOperationPushTemp(agentId,operationId,pushTempId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
