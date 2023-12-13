package com.faas.core.base.endpoint.controller.scenario.element.details;

import com.faas.core.base.middleware.scenario.element.details.ScenarioElementDetailsMiddleware;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/scenario/element/details/")
public class ScenarioElementDetailsController {


    @Autowired
    ScenarioElementDetailsMiddleware scenarioElementDetailsMiddleware;


    @RequestMapping(value = BaseRoute.GET_SCENARIO_ACTION_DATAS, method = RequestMethod.POST)
    public ResponseEntity<?> getScenarioActionDatas(@RequestParam long userId,
                                                    @RequestParam String scenarioId,
                                                    @RequestParam String elementId) {

        ScenarioDataWSModel response = scenarioElementDetailsMiddleware.getScenarioActionDatas(userId,scenarioId,elementId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_SCENARIO_ACTION_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> getScenarioActionData(@RequestParam long userId,
                                                   @RequestParam String scenarioId,
                                                   @RequestParam String elementId,
                                                   @RequestParam String dataId) {

        ScenarioDataWSModel response = scenarioElementDetailsMiddleware.getScenarioActionData(userId,scenarioId,elementId,dataId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_SCENARIO_ACTION_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> createScenarioActionData(@RequestParam long userId,
                                                      @RequestParam String scenarioId,
                                                      @RequestParam String elementId,
                                                      @RequestParam long typeId,
                                                      @RequestParam String value) {

        ScenarioDataWSModel response = scenarioElementDetailsMiddleware.createScenarioActionData(userId,scenarioId,elementId,typeId,value);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_SCENARIO_ACTION_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> updateScenarioActionData(@RequestParam long userId,
                                                      @RequestParam String scenarioId,
                                                      @RequestParam String elementId,
                                                      @RequestParam String dataId,
                                                      @RequestParam long typeId,
                                                      @RequestParam String value) {

        ScenarioDataWSModel response = scenarioElementDetailsMiddleware.updateScenarioActionData(userId,scenarioId,elementId,dataId,typeId,value);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_SCENARIO_ACTION_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> removeScenarioActionData(@RequestParam long userId,
                                                      @RequestParam String scenarioId,
                                                      @RequestParam String elementId,
                                                      @RequestParam String dataId) {

        ScenarioDataWSModel response = scenarioElementDetailsMiddleware.removeScenarioActionData(userId,scenarioId,elementId,dataId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_SCENARIO_AUTOMATION_DATAS, method = RequestMethod.POST)
    public ResponseEntity<?> getScenarioAutomationDatas(@RequestParam long userId,
                                                        @RequestParam String scenarioId,
                                                        @RequestParam String elementId) {

        ScenarioDataWSModel response = scenarioElementDetailsMiddleware.getScenarioAutomationDatas(userId,scenarioId,elementId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_SCENARIO_AUTOMATION_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> getScenarioAutomationData(@RequestParam long userId,
                                                       @RequestParam String scenarioId,
                                                       @RequestParam String elementId,
                                                       @RequestParam String dataId) {

        ScenarioDataWSModel response = scenarioElementDetailsMiddleware.getScenarioAutomationData(userId,scenarioId,elementId,dataId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_SCENARIO_AUTOMATION_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> createScenarioAutomationData(@RequestParam long userId,
                                                          @RequestParam String scenarioId,
                                                          @RequestParam String elementId,
                                                          @RequestParam long typeId,
                                                          @RequestParam String value) {

        ScenarioDataWSModel response = scenarioElementDetailsMiddleware.createScenarioAutomationData(userId,scenarioId,elementId,typeId,value);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_SCENARIO_AUTOMATION_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> updateScenarioAutomationData(@RequestParam long userId,
                                                          @RequestParam String scenarioId,
                                                          @RequestParam String elementId,
                                                          @RequestParam String dataId,
                                                          @RequestParam long typeId,
                                                          @RequestParam String value) {

        ScenarioDataWSModel response = scenarioElementDetailsMiddleware.updateScenarioAutomationData(userId,scenarioId,elementId,dataId,typeId,value);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_SCENARIO_AUTOMATION_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> removeScenarioAutomationData(@RequestParam long userId,
                                                          @RequestParam String scenarioId,
                                                          @RequestParam String elementId,
                                                          @RequestParam String dataId) {

        ScenarioDataWSModel response = scenarioElementDetailsMiddleware.removeScenarioAutomationData(userId,scenarioId,elementId,dataId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
