package com.faas.core.api.endpoint.controller.operation.details.scenario;

import com.faas.core.api.middleware.operation.details.scenario.ApiOperationScenarioMiddleware;
import com.faas.core.api.model.ws.operation.details.scenario.ApiOperationScenarioWSModel;
import com.faas.core.api.model.ws.operation.details.scenario.ApiProcessScenarioElementWSModel;
import com.faas.core.api.model.ws.operation.details.scenario.ApiProcessScenarioWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/api/operation/details/scenario/")
public class ApiOperationScenarioController {


    @Autowired
    ApiOperationScenarioMiddleware apiOperationScenarioMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_SCENARIOS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationScenarios(@RequestParam long agentId,
                                                      @RequestParam long sessionId,
                                                      @RequestParam String processId) {

        ApiOperationScenarioWSModel response = apiOperationScenarioMiddleware.apiGetOperationScenarios(agentId,sessionId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_SCENARIO, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationScenario(@RequestParam long agentId,
                                                     @RequestParam long sessionId,
                                                     @RequestParam String executeId) {

        ApiOperationScenarioWSModel response = apiOperationScenarioMiddleware.apiGetOperationScenario(agentId,sessionId,executeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_EXECUTE_OPERATION_SCENARIO, method = RequestMethod.POST)
    public ResponseEntity<?> apiExecuteOperationScenario(@RequestParam long agentId,
                                                         @RequestParam long sessionId,
                                                         @RequestParam String processId,
                                                         @RequestParam String scenarioId) {

        ApiOperationScenarioWSModel response = apiOperationScenarioMiddleware.apiExecuteOperationScenario(agentId,sessionId,processId,scenarioId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_UPDATE_OPERATION_SCENARIO, method = RequestMethod.POST)
    public ResponseEntity<?> apiUpdateOperationScenario(@RequestParam long agentId,
                                                        @RequestParam long sessionId,
                                                        @RequestParam String executeId) {

        ApiOperationScenarioWSModel response = apiOperationScenarioMiddleware.apiUpdateOperationScenario(agentId,sessionId,executeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_REMOVE_OPERATION_SCENARIO, method = RequestMethod.POST)
    public ResponseEntity<?> apiRemoveOperationScenario(@RequestParam long agentId,
                                                        @RequestParam long sessionId,
                                                        @RequestParam String executeId) {

        ApiOperationScenarioWSModel response = apiOperationScenarioMiddleware.apiRemoveOperationScenario(agentId,sessionId,executeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_PROCESS_SCENARIOS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetProcessScenarios(@RequestParam long agentId,
                                                    @RequestParam long sessionId,
                                                    @RequestParam String processId) {

        ApiProcessScenarioWSModel response = apiOperationScenarioMiddleware.apiGetProcessScenarios(agentId,sessionId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_PROCESS_SCENARIO, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetProcessScenario(@RequestParam long agentId,
                                                   @RequestParam long sessionId,
                                                   @RequestParam String processId,
                                                   @RequestParam String scenarioId) {

        ApiProcessScenarioWSModel response = apiOperationScenarioMiddleware.apiGetProcessScenario(agentId,sessionId,processId,scenarioId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }




}
