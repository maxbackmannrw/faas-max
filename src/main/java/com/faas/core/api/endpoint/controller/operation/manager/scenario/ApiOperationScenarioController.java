package com.faas.core.api.endpoint.controller.operation.manager.scenario;

import com.faas.core.api.middleware.operation.manager.scenario.ApiOperationScenarioMiddleware;
import com.faas.core.api.model.ws.operation.manager.scenario.ApiOperationScenarioWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/api/operation/manager/scenario/")
public class ApiOperationScenarioController {


    @Autowired
    ApiOperationScenarioMiddleware apiOperationScenarioMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_SCENARIOS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationScenarios(@RequestParam long agentId,
                                                      @RequestParam String operationId) {

        ApiOperationScenarioWSModel response = apiOperationScenarioMiddleware.apiGetOperationScenarios(agentId,operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_OPERATION_SCENARIO, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationScenario(@RequestParam long agentId,
                                                     @RequestParam String operationId,
                                                     @RequestParam String executionId) {

        ApiOperationScenarioWSModel response = apiOperationScenarioMiddleware.apiGetOperationScenario(agentId,operationId,executionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_EXECUTE_OPERATION_SCENARIO, method = RequestMethod.POST)
    public ResponseEntity<?> apiExecuteOperationScenario(@RequestParam long agentId,
                                                         @RequestParam String operationId,
                                                         @RequestParam String scenarioId) {

        ApiOperationScenarioWSModel response = apiOperationScenarioMiddleware.apiExecuteOperationScenario(agentId,operationId,scenarioId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_UPDATE_OPERATION_SCENARIO, method = RequestMethod.POST)
    public ResponseEntity<?> apiUpdateOperationScenario(@RequestParam long agentId,
                                                        @RequestParam String operationId,
                                                        @RequestParam String executionId) {

        ApiOperationScenarioWSModel response = apiOperationScenarioMiddleware.apiUpdateOperationScenario(agentId,operationId,executionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_REMOVE_OPERATION_SCENARIO, method = RequestMethod.POST)
    public ResponseEntity<?> apiRemoveOperationScenario(@RequestParam long agentId,
                                                        @RequestParam String operationId,
                                                        @RequestParam String executionId) {

        ApiOperationScenarioWSModel response = apiOperationScenarioMiddleware.apiRemoveOperationScenario(agentId,operationId,executionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
