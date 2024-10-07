package com.faas.core.api.endpoint.controller.operation.manager.details;

import com.faas.core.api.middleware.operation.manager.details.ApiOperationManagerDetailsMiddleware;
import com.faas.core.api.model.ws.operation.content.ApiOperationWSModel;
import com.faas.core.misc.config.ApiRoute;
import com.faas.core.misc.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/api/operation/manager/details/")
public class ApiOperationManagerDetailsController {


    @Autowired
    ApiOperationManagerDetailsMiddleware apiOperationManagerDetailsMiddleware;


    @RequestMapping(value = ApiRoute.API_START_OPERATION_MANAGER, method = RequestMethod.POST)
    public ResponseEntity<?> apiStartOperationManager(@RequestParam long agentId,
                                                      @RequestParam String operationId) {

        ApiOperationWSModel response = apiOperationManagerDetailsMiddleware.apiStartOperationManager(agentId, operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_COMPLETE_OPERATION_MANAGER, method = RequestMethod.POST)
    public ResponseEntity<?> apiCompleteOperationManager(@RequestParam long agentId,
                                                         @RequestParam String operationId,
                                                         @RequestParam String operationResult) {

        ApiOperationWSModel response = apiOperationManagerDetailsMiddleware.apiCompleteOperationManager(agentId, operationId, operationResult);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_SWITCH_OPERATION_MANAGERS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetSwitchOperationManagers(@RequestParam long agentId,
                                                           @RequestParam String operationId) {

        ApiOperationWSModel response = apiOperationManagerDetailsMiddleware.apiGetSwitchOperationManagers(agentId, operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_SWITCH_OPERATION_MANAGER, method = RequestMethod.POST)
    public ResponseEntity<?> apiSwitchOperationManager(@RequestParam long agentId,
                                                       @RequestParam String operationId,
                                                       @RequestParam String selectedId) {

        ApiOperationWSModel response = apiOperationManagerDetailsMiddleware.apiSwitchOperationManager(agentId, operationId, selectedId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
