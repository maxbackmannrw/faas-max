package com.faas.core.base.endpoint.controller.scenario.details.element.details;

import com.faas.core.base.middleware.scenario.details.element.details.ScenarioElementDetailsMiddleware;
import com.faas.core.base.model.ws.scenario.details.element.details.ElementVariableWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/scenario/element/details/")
public class ScenarioElementDetailsController {


    @Autowired
    ScenarioElementDetailsMiddleware scenarioElementDetailsMiddleware;


    @RequestMapping(value = BaseRoute.GET_ELEMENT_VARIABLES, method = RequestMethod.POST)
    public ResponseEntity<?> getElementVariables(@RequestParam long userId,
                                                 @RequestParam String scenarioId,
                                                 @RequestParam String elementId) {

        ElementVariableWSModel response = scenarioElementDetailsMiddleware.getElementVariables(userId,scenarioId,elementId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_ELEMENT_VARIABLE, method = RequestMethod.POST)
    public ResponseEntity<?> getElementVariable(@RequestParam long userId,
                                                @RequestParam String scenarioId,
                                                @RequestParam String elementId,
                                                @RequestParam String variableId) {

        ElementVariableWSModel response = scenarioElementDetailsMiddleware.getElementVariable(userId,scenarioId,elementId,variableId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_ELEMENT_VARIABLE, method = RequestMethod.POST)
    public ResponseEntity<?> createElementVariable(@RequestParam long userId,
                                                   @RequestParam String scenarioId,
                                                   @RequestParam String elementId,
                                                   @RequestParam long typeId,
                                                   @RequestParam String value) {

        ElementVariableWSModel response = scenarioElementDetailsMiddleware.createElementVariable(userId,scenarioId,elementId,typeId,value);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_ELEMENT_VARIABLE, method = RequestMethod.POST)
    public ResponseEntity<?> updateElementVariable(@RequestParam long userId,
                                                   @RequestParam String scenarioId,
                                                   @RequestParam String elementId,
                                                   @RequestParam String variableId,
                                                   @RequestParam long typeId,
                                                   @RequestParam String value) {

        ElementVariableWSModel response = scenarioElementDetailsMiddleware.updateElementVariable(userId,scenarioId,elementId,variableId,typeId,value);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_ELEMENT_VARIABLE, method = RequestMethod.POST)
    public ResponseEntity<?> removeElementVariable(@RequestParam long userId,
                                                   @RequestParam String scenarioId,
                                                   @RequestParam String elementId,
                                                   @RequestParam String variableId) {

        ElementVariableWSModel response = scenarioElementDetailsMiddleware.removeElementVariable(userId,scenarioId,elementId,variableId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
