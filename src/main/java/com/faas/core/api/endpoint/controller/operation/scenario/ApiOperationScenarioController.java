package com.faas.core.api.endpoint.controller.operation.scenario;

import com.faas.core.api.middleware.operation.scenario.ApiOperationScenarioMiddleware;
import com.faas.core.api.model.ws.operation.scenario.content.ApiOperationScenarioWSModel;
import com.faas.core.api.model.ws.operation.scenario.content.ApiProcessScenarioElementWSModel;
import com.faas.core.api.model.ws.operation.scenario.content.ApiProcessScenarioWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/api/operation/scenario/")
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


    @RequestMapping(value = ApiRoute.API_GET_PROCESS_SCENARIO_ELEMENTS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetProcessScenarioElements(@RequestParam long agentId,
                                                           @RequestParam long sessionId,
                                                           @RequestParam String scenarioId) {

        ApiProcessScenarioElementWSModel response = apiOperationScenarioMiddleware.apiGetProcessScenarioElements(agentId,sessionId,scenarioId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_PROCESS_SCENARIO_ELEMENT, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetProcessScenarioElement(@RequestParam long agentId,
                                                          @RequestParam long sessionId,
                                                          @RequestParam String scenarioId,
                                                          @RequestParam String elementId) {

        ApiProcessScenarioElementWSModel response = apiOperationScenarioMiddleware.apiGetProcessScenarioElement(agentId,sessionId,scenarioId,elementId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
