package com.faas.core.api.endpoint.controller.operation.scenario.process;

import com.faas.core.api.middleware.operation.scenario.process.ApiProcessScenarioMiddleware;
import com.faas.core.api.model.ws.operation.scenario.process.ApiProcessScenarioWSModel;
import com.faas.core.api.model.ws.operation.scenario.process.ApiScenarioElementWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/api/operation/scenario/process/")
public class ApiProcessScenarioController {


    @Autowired
    ApiProcessScenarioMiddleware apiProcessScenarioMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_PROCESS_SCENARIOS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetProcessScenarios(@RequestParam long agentId,
                                                    @RequestParam long sessionId,
                                                    @RequestParam String processId) {

        ApiProcessScenarioWSModel response = apiProcessScenarioMiddleware.apiGetProcessScenarios(agentId,sessionId,processId);

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

        ApiProcessScenarioWSModel response = apiProcessScenarioMiddleware.apiGetProcessScenario(agentId,sessionId,processId,scenarioId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = ApiRoute.API_GET_PROCESS_SCENARIO_ELEMENTS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetProcessScenarioElements(@RequestParam long agentId,
                                                           @RequestParam long sessionId,
                                                           @RequestParam String scenarioId) {

        ApiScenarioElementWSModel response = apiProcessScenarioMiddleware.apiGetProcessScenarioElements(agentId,sessionId,scenarioId);

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

        ApiScenarioElementWSModel response = apiProcessScenarioMiddleware.apiGetProcessScenarioElement(agentId,sessionId,scenarioId,elementId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
