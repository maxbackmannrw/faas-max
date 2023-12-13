package com.faas.core.base.endpoint.controller.scenario.element.content;

import com.faas.core.base.middleware.scenario.element.content.ScenarioElementMiddleware;
import com.faas.core.base.model.ws.scenario.element.ScenarioElementWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/scenario/element/")
public class ScenarioElementController {


    @Autowired
    ScenarioElementMiddleware scenarioElementMiddleware;


    @RequestMapping(value = BaseRoute.GET_SCENARIO_ELEMENTS, method = RequestMethod.POST)
    public ResponseEntity<?> getScenarioElements(@RequestParam long userId,
                                                 @RequestParam String scenarioId) {

        ScenarioElementWSModel response = scenarioElementMiddleware.getScenarioElements(userId,scenarioId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_SCENARIO_ELEMENT, method = RequestMethod.POST)
    public ResponseEntity<?> getScenarioElement(@RequestParam long userId,
                                                @RequestParam String scenarioId,
                                                @RequestParam String elementId) {

        ScenarioElementWSModel response = scenarioElementMiddleware.getScenarioElement(userId,scenarioId,elementId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_SCENARIO_ACTION, method = RequestMethod.POST)
    public ResponseEntity<?> createScenarioAction(@RequestParam long userId,
                                                  @RequestParam String scenarioId,
                                                  @RequestParam String element,
                                                  @RequestParam String elementType,
                                                  @RequestParam long actionId,
                                                  @RequestParam int order) {

        ScenarioElementWSModel response = scenarioElementMiddleware.createScenarioAction(userId,scenarioId,element,elementType,actionId,order);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_SCENARIO_AUTOMATION, method = RequestMethod.POST)
    public ResponseEntity<?> createScenarioAutomation(@RequestParam long userId,
                                                      @RequestParam String scenarioId,
                                                      @RequestParam String element,
                                                      @RequestParam String elementType,
                                                      @RequestParam long automationId,
                                                      @RequestParam int order) {

        ScenarioElementWSModel response = scenarioElementMiddleware.createScenarioAutomation(userId,scenarioId,element,elementType,automationId,order);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_SCENARIO_ACTION, method = RequestMethod.POST)
    public ResponseEntity<?> updateScenarioAction(@RequestParam long userId,
                                                  @RequestParam String scenarioId,
                                                  @RequestParam String elementId,
                                                  @RequestParam String element,
                                                  @RequestParam String elementType,
                                                  @RequestParam long actionId,
                                                  @RequestParam int order) {

        ScenarioElementWSModel response = scenarioElementMiddleware.updateScenarioAction(userId,scenarioId,elementId,element,elementType,actionId,order);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_SCENARIO_AUTOMATION, method = RequestMethod.POST)
    public ResponseEntity<?> updateScenarioAutomation(@RequestParam long userId,
                                                      @RequestParam String scenarioId,
                                                      @RequestParam String elementId,
                                                      @RequestParam String element,
                                                      @RequestParam String elementType,
                                                      @RequestParam long automationId,
                                                      @RequestParam int order) {

        ScenarioElementWSModel response = scenarioElementMiddleware.updateScenarioAutomation(userId,scenarioId,elementId,element,elementType,automationId,order);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_SCENARIO_ELEMENT, method = RequestMethod.POST)
    public ResponseEntity<?> removeScenarioElement(@RequestParam long userId,
                                                   @RequestParam String scenarioId,
                                                   @RequestParam String elementId) {

        ScenarioElementWSModel response = scenarioElementMiddleware.removeScenarioElement(userId,scenarioId,elementId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

}
