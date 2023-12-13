package com.faas.core.base.endpoint.controller.scenario.details;

import com.faas.core.base.middleware.scenario.details.ScenarioDetailsMiddleware;
import com.faas.core.base.model.ws.scenario.details.ScenarioDataWSModel;
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


    @RequestMapping(value = BaseRoute.GET_SCENARIO_DATAS, method = RequestMethod.POST)
    public ResponseEntity<?> getScenarioDatas(@RequestParam long userId,
                                              @RequestParam String scenarioId) {

        ScenarioDataWSModel response = scenarioDetailsMiddleware.getScenarioDatas(userId,scenarioId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_SCENARIO_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> getScenarioData(@RequestParam long userId,
                                             @RequestParam String scenarioId,
                                             @RequestParam String dataId) {

        ScenarioDataWSModel response = scenarioDetailsMiddleware.getScenarioData(userId,scenarioId,dataId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_SCENARIO_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> createScenarioData(@RequestParam long userId,
                                                @RequestParam String scenarioId,
                                                @RequestParam long typeId,
                                                @RequestParam String value) {

        ScenarioDataWSModel response = scenarioDetailsMiddleware.createScenarioData(userId,scenarioId,typeId,value);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_SCENARIO_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> updateScenarioData(@RequestParam long userId,
                                                @RequestParam String scenarioId,
                                                @RequestParam String dataId,
                                                @RequestParam long typeId,
                                                @RequestParam String value) {

        ScenarioDataWSModel response = scenarioDetailsMiddleware.updateScenarioData(userId,scenarioId,dataId,typeId,value);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_SCENARIO_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> removeScenarioData(@RequestParam long userId,
                                                @RequestParam String scenarioId,
                                                @RequestParam String dataId) {

        ScenarioDataWSModel response = scenarioDetailsMiddleware.removeScenarioData(userId,scenarioId,dataId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

}
