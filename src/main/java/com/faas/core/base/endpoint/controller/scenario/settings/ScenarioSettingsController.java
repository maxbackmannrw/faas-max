package com.faas.core.base.endpoint.controller.scenario.settings;

import com.faas.core.base.middleware.scenario.settings.ScenarioSettingsMiddleware;
import com.faas.core.base.model.ws.scenario.settings.ScenarioTypeWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/scenario/settings/")
public class ScenarioSettingsController {

    @Autowired
    ScenarioSettingsMiddleware scenarioSettingsMiddleware;


    @RequestMapping(value = BaseRoute.GET_SCENARIO_TYPES, method = RequestMethod.POST)
    public ResponseEntity<?> getScenarioTypes(@RequestParam long userId) {

        ScenarioTypeWSModel response = scenarioSettingsMiddleware.getScenarioTypes(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_SCENARIO_TYPES_BY_BASE_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> getScenarioTypesByBaseType(@RequestParam long userId,
                                                        @RequestParam String baseType) {

        ScenarioTypeWSModel response = scenarioSettingsMiddleware.getScenarioTypesByBaseType(userId,baseType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_SCENARIO_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> getScenarioType(@RequestParam long userId,
                                             @RequestParam long scenarioTypeId) {

        ScenarioTypeWSModel response = scenarioSettingsMiddleware.getScenarioType(userId,scenarioTypeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_SCENARIO_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> createScenarioType(@RequestParam long userId,
                                                @RequestParam String scenarioType,
                                                @RequestParam String baseType) {

        ScenarioTypeWSModel response = scenarioSettingsMiddleware.createScenarioType(userId,scenarioType,baseType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_SCENARIO_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> updateScenarioType(@RequestParam long userId,
                                                @RequestParam long scenarioTypeId,
                                                @RequestParam String scenarioType,
                                                @RequestParam String baseType) {

        ScenarioTypeWSModel response = scenarioSettingsMiddleware.updateScenarioType(userId,scenarioTypeId,scenarioType,baseType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_SCENARIO_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> removeScenarioType(@RequestParam long userId,
                                                @RequestParam long scenarioTypeId) {

        ScenarioTypeWSModel response = scenarioSettingsMiddleware.removeScenarioType(userId,scenarioTypeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
