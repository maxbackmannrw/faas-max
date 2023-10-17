package com.faas.core.api.endpoint.controller.operation.details.client;

import com.faas.core.api.middleware.operation.details.client.ApiOperationClientMiddleware;
import com.faas.core.api.model.ws.client.details.ApiClientOsIntWSModel;
import com.faas.core.api.model.ws.client.details.ApiClientDeviceWSModel;
import com.faas.core.api.model.ws.operation.details.client.ApiOperationClientWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/api/operation/details/client/")
public class ApiOperationClientController {


    @Autowired
    ApiOperationClientMiddleware apiOperationClientMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_CLIENT, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationClient(@RequestParam long agentId,
                                                   @RequestParam long sessionId,
                                                   @RequestParam long clientId) {

        ApiOperationClientWSModel response = apiOperationClientMiddleware.apiGetOperationClient(agentId,sessionId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = ApiRoute.API_GET_OPERATION_DEVICES, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationDevices(@RequestParam long agentId,
                                                    @RequestParam long sessionId,
                                                    @RequestParam long clientId,
                                                    @RequestParam String campaignId) {

        ApiClientDeviceWSModel response = apiOperationClientMiddleware.apiGetOperationDevices(agentId,sessionId,clientId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_OPERATION_DEVICE, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationDevice(@RequestParam long agentId,
                                                   @RequestParam long sessionId,
                                                   @RequestParam long clientId,
                                                   @RequestParam String campaignId) {

        ApiClientDeviceWSModel response = apiOperationClientMiddleware.apiGetOperationDevice(agentId,sessionId,clientId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_CLIENT_OS_INT, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetClientOsInt(@RequestParam long agentId,
                                               @RequestParam long sessionId,
                                               @RequestParam long clientId) {

        ApiClientOsIntWSModel response = apiOperationClientMiddleware.apiGetClientOsInt(agentId,sessionId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
