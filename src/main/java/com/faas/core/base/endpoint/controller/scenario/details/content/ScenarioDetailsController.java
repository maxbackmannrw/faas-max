package com.faas.core.base.endpoint.controller.scenario.details.content;

import com.faas.core.base.middleware.scenario.details.content.ScenarioDetailsMiddleware;
import com.faas.core.base.model.ws.scenario.details.content.ScenarioVariableWSModel;
import com.faas.core.base.model.ws.scenario.details.element.content.ScenarioElementWSModel;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.BaseRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/base/scenario/details/")
public class ScenarioDetailsController {


    @Autowired
    ScenarioDetailsMiddleware scenarioDetailsMiddleware;



    @RequestMapping(value = BaseRoute.GET_SCENARIO_VARIABLES, method = RequestMethod.POST)
    public ResponseEntity<?> getScenarioVariables(@RequestParam long userId,
                                                  @RequestParam String scenarioId) {

        ScenarioVariableWSModel response = scenarioDetailsMiddleware.getScenarioVariables(userId,scenarioId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_SCENARIO_VARIABLE, method = RequestMethod.POST)
    public ResponseEntity<?> getScenarioVariable(@RequestParam long userId,
                                                 @RequestParam String scenarioId,
                                                 @RequestParam String variableId) {

        ScenarioVariableWSModel response = scenarioDetailsMiddleware.getScenarioVariable(userId,scenarioId,variableId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_SCENARIO_VARIABLE, method = RequestMethod.POST)
    public ResponseEntity<?> createScenarioVariable(@RequestParam long userId,
                                                    @RequestParam String scenarioId,
                                                    @RequestParam long typeId,
                                                    @RequestParam String value) {

        ScenarioVariableWSModel response = scenarioDetailsMiddleware.createScenarioVariable(userId,scenarioId,typeId,value);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_SCENARIO_VARIABLE, method = RequestMethod.POST)
    public ResponseEntity<?> updateScenarioVariable(@RequestParam long userId,
                                                    @RequestParam String scenarioId,
                                                    @RequestParam String variableId,
                                                    @RequestParam long typeId,
                                                    @RequestParam String value) {

        ScenarioVariableWSModel response = scenarioDetailsMiddleware.updateScenarioVariable(userId,scenarioId,variableId,typeId,value);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_SCENARIO_VARIABLE, method = RequestMethod.POST)
    public ResponseEntity<?> removeScenarioVariable(@RequestParam long userId,
                                                    @RequestParam String scenarioId,
                                                    @RequestParam String variableId) {

        ScenarioVariableWSModel response = scenarioDetailsMiddleware.removeScenarioVariable(userId,scenarioId,variableId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
