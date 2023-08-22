package com.faas.core.api.endpoint.controller.operation.scenario.execution;

import com.faas.core.api.middleware.operation.scenario.execution.ApiScenarioExecutionMiddleware;
import com.faas.core.api.model.ws.operation.scenario.execution.ApiScenarioExecutionWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/api/operation/scenario/execution/")
public class ApiScenarioExecutionController {


    @Autowired
    ApiScenarioExecutionMiddleware apiScenarioExecutionMiddleware;


    @RequestMapping(value = ApiRoute.API_SCENARIO_EXECUTE, method = RequestMethod.POST)
    public ResponseEntity<?> apiScenarioExecute(@RequestParam long agentId,
                                                @RequestParam long sessionId,
                                                @RequestParam String processId,
                                                @RequestParam String scenarioId) {

        ApiScenarioExecutionWSModel response = apiScenarioExecutionMiddleware.apiScenarioExecute(agentId,sessionId,processId,scenarioId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_SCENARIO_EXECUTIONS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetScenarioExecutions(@RequestParam long agentId,
                                                      @RequestParam long sessionId,
                                                      @RequestParam String processId) {

        ApiScenarioExecutionWSModel response = apiScenarioExecutionMiddleware.apiGetScenarioExecutions(agentId,sessionId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_SCENARIO_EXECUTION, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetScenarioExecution(@RequestParam long agentId,
                                                     @RequestParam long sessionId,
                                                     @RequestParam String executionId) {

        ApiScenarioExecutionWSModel response = apiScenarioExecutionMiddleware.apiGetScenarioExecution(agentId,sessionId,executionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_UPDATE_SCENARIO_EXECUTION, method = RequestMethod.POST)
    public ResponseEntity<?> apiUpdateScenarioExecution(@RequestParam long agentId,
                                                        @RequestParam long sessionId,
                                                        @RequestParam String executionId) {

        ApiScenarioExecutionWSModel response = apiScenarioExecutionMiddleware.apiUpdateScenarioExecution(agentId,sessionId,executionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_REMOVE_SCENARIO_EXECUTION, method = RequestMethod.POST)
    public ResponseEntity<?> apiRemoveScenarioExecution(@RequestParam long agentId,
                                                        @RequestParam long sessionId,
                                                        @RequestParam long clientId,
                                                        @RequestParam String scenarioId) {

        ApiScenarioExecutionWSModel response = apiScenarioExecutionMiddleware.apiRemoveScenarioExecution(agentId,sessionId,clientId,scenarioId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
