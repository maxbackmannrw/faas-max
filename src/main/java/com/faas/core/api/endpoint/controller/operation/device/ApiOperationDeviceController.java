package com.faas.core.api.endpoint.controller.operation.device;

import com.faas.core.api.middleware.operation.device.ApiOperationDeviceMiddleware;
import com.faas.core.api.model.ws.client.device.ApiClientDeviceWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/api/operation/device/")
public class ApiOperationDeviceController {


    @Autowired
    ApiOperationDeviceMiddleware apiOperationDeviceMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_DEVICES, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationDevices(@RequestParam long agentId,
                                                    @RequestParam long sessionId,
                                                    @RequestParam long clientId,
                                                    @RequestParam String campaignId) {

        ApiClientDeviceWSModel response = apiOperationDeviceMiddleware.apiGetOperationDevices(agentId,sessionId,clientId,campaignId);

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

        ApiClientDeviceWSModel response = apiOperationDeviceMiddleware.apiGetOperationDevice(agentId,sessionId,clientId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_CREATE_OPERATION_DEVICE, method = RequestMethod.POST)
    public ResponseEntity<?> apiCreateOperationDevice(@RequestParam long agentId,
                                                      @RequestParam long sessionId,
                                                      @RequestParam long clientId,
                                                      @RequestParam String campaignId) {

        ApiClientDeviceWSModel response = apiOperationDeviceMiddleware.apiCreateOperationDevice(agentId,sessionId,clientId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_UPDATE_OPERATION_DEVICE, method = RequestMethod.POST)
    public ResponseEntity<?> apiUpdateOperationDevice(@RequestParam long agentId,
                                                      @RequestParam long sessionId,
                                                      @RequestParam long clientId,
                                                      @RequestParam String campaignId) {

        ApiClientDeviceWSModel response = apiOperationDeviceMiddleware.apiUpdateOperationDevice(agentId,sessionId,clientId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_REMOVE_OPERATION_DEVICE, method = RequestMethod.POST)
    public ResponseEntity<?> apiRemoveOperationDevice(@RequestParam long agentId,
                                                      @RequestParam long sessionId,
                                                      @RequestParam long clientId,
                                                      @RequestParam String campaignId) {

        ApiClientDeviceWSModel response = apiOperationDeviceMiddleware.apiRemoveOperationDevice(agentId,sessionId,clientId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

}
