package com.faas.core.base.endpoint.controller.scenario.details.element.content;

import com.faas.core.base.middleware.scenario.details.element.content.ScenarioElementMiddleware;
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


    @RequestMapping(value = BaseRoute.CREATE_SCENARIO_ELEMENT, method = RequestMethod.POST)
    public ResponseEntity<?> createScenarioElement(@RequestParam long userId,
                                                   @RequestParam String scenarioId,
                                                   @RequestParam String element,
                                                   @RequestParam String elementType,
                                                   @RequestParam long tempId,
                                                   @RequestParam int elementOrder) {

        ScenarioElementWSModel response = scenarioElementMiddleware.createScenarioElement(userId,scenarioId,element,elementType,tempId,elementOrder);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_SCENARIO_ELEMENT, method = RequestMethod.POST)
    public ResponseEntity<?> updateScenarioElement(@RequestParam long userId,
                                                   @RequestParam String scenarioId,
                                                   @RequestParam String elementId,
                                                   @RequestParam String element,
                                                   @RequestParam String elementType,
                                                   @RequestParam long tempId,
                                                   @RequestParam int elementOrder) {

        ScenarioElementWSModel response = scenarioElementMiddleware.updateScenarioElement(userId,scenarioId,elementId,element,elementType,tempId,elementOrder);

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
