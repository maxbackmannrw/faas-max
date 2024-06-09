package com.faas.core.base.endpoint.controller.scenario.content;

import com.faas.core.base.middleware.scenario.content.ScenarioMiddleware;
import com.faas.core.base.model.ws.scenario.content.ScenarioWSModel;
import com.faas.core.utility.config.AppConstant;
import com.faas.core.utility.config.BaseRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/base/scenario/")
public class ScenarioController {


    @Autowired
    ScenarioMiddleware scenarioMiddleware;


    @RequestMapping(value = BaseRoute.GET_SCENARIOS, method = RequestMethod.POST)
    public ResponseEntity<?> getScenarios(@RequestParam long userId) {

        ScenarioWSModel response = scenarioMiddleware.getScenarios(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_SCENARIOS_BY_BASE_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> getScenariosByBaseType(@RequestParam long userId,
                                                    @RequestParam String baseType) {

        ScenarioWSModel response = scenarioMiddleware.getScenariosByBaseType(userId,baseType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_SCENARIO, method = RequestMethod.POST)
    public ResponseEntity<?> getScenario(@RequestParam long userId,
                                         @RequestParam String scenarioId) {

        ScenarioWSModel response = scenarioMiddleware.getScenario(userId,scenarioId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_SCENARIO, method = RequestMethod.POST)
    public ResponseEntity<?> createScenario(@RequestParam long userId,
                                            @RequestParam String scenario,
                                            @RequestParam String scenarioDesc,
                                            @RequestParam long typeId) {

        ScenarioWSModel response = scenarioMiddleware.createScenario(userId,scenario,scenarioDesc,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_SCENARIO, method = RequestMethod.POST)
    public ResponseEntity<?> updateScenario(@RequestParam long userId,
                                            @RequestParam String scenarioId,
                                            @RequestParam String scenario,
                                            @RequestParam String scenarioDesc,
                                            @RequestParam long typeId) {

        ScenarioWSModel response = scenarioMiddleware.updateScenario(userId,scenarioId,scenario,scenarioDesc,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_SCENARIO, method = RequestMethod.POST)
    public ResponseEntity<?> removeScenario(@RequestParam long userId,
                                            @RequestParam String scenarioId) {

        ScenarioWSModel response = scenarioMiddleware.removeScenario(userId,scenarioId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
