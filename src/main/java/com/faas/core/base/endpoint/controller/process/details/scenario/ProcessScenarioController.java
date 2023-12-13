package com.faas.core.base.endpoint.controller.process.details.scenario;

import com.faas.core.base.middleware.process.details.scenario.ProcessScenarioMiddleware;
import com.faas.core.base.model.ws.process.details.scenario.ProcessScenarioDataWSModel;
import com.faas.core.base.model.ws.process.details.scenario.ProcessScenarioWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/process/details/scenario/")
public class ProcessScenarioController {


    @Autowired
    ProcessScenarioMiddleware processScenarioMiddleware;


    @RequestMapping(value = BaseRoute.GET_PROCESS_SCENARIOS, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessScenarios(@RequestParam long userId,
                                                 @RequestParam String processId) {

        ProcessScenarioWSModel response = processScenarioMiddleware.getProcessScenarios(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_PROCESS_SCENARIO, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessScenario(@RequestParam long userId,
                                                @RequestParam String processId,
                                                @RequestParam String scenarioId) {

        ProcessScenarioWSModel response = processScenarioMiddleware.getProcessScenario(userId,processId,scenarioId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_PROCESS_SCENARIO, method = RequestMethod.POST)
    public ResponseEntity<?> createProcessScenario(@RequestParam long userId,
                                                   @RequestParam String processId,
                                                   @RequestParam String scenarioId,
                                                   @RequestParam int order) {

        ProcessScenarioWSModel response = processScenarioMiddleware.createProcessScenario(userId,processId,scenarioId,order);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_PROCESS_SCENARIO, method = RequestMethod.POST)
    public ResponseEntity<?> removeProcessScenario(@RequestParam long userId,
                                                   @RequestParam String processId,
                                                   @RequestParam String scenarioId) {

        ProcessScenarioWSModel response = processScenarioMiddleware.removeProcessScenario(userId,processId,scenarioId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_PROCESS_SCENARIO_DATAS, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessScenarioDatas(@RequestParam long userId,
                                                     @RequestParam String processId,
                                                     @RequestParam String scenarioId) {

        ProcessScenarioDataWSModel response = processScenarioMiddleware.getProcessScenarioDatas(userId,processId,scenarioId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_PROCESS_SCENARIO_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessScenarioData(@RequestParam long userId,
                                                    @RequestParam String processId,
                                                    @RequestParam String scenarioId,
                                                    @RequestParam String dataId) {

        ProcessScenarioDataWSModel response = processScenarioMiddleware.getProcessScenarioData(userId,processId,scenarioId,dataId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_PROCESS_SCENARIO_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> createProcessScenarioData(@RequestParam long userId,
                                                       @RequestParam String processId,
                                                       @RequestParam String scenarioId,
                                                       @RequestParam long typeId,
                                                       @RequestParam String value) {

        ProcessScenarioDataWSModel response = processScenarioMiddleware.createProcessScenarioData(userId,processId,scenarioId,typeId,value);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_PROCESS_SCENARIO_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> updateProcessScenarioData(@RequestParam long userId,
                                                       @RequestParam String processId,
                                                       @RequestParam String scenarioId,
                                                       @RequestParam String dataId,
                                                       @RequestParam long typeId,
                                                       @RequestParam String value) {

        ProcessScenarioDataWSModel response = processScenarioMiddleware.updateProcessScenarioData(userId,processId,scenarioId,dataId,typeId,value);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_PROCESS_SCENARIO_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> removeProcessScenarioData(@RequestParam long userId,
                                                       @RequestParam String processId,
                                                       @RequestParam String scenarioId,
                                                       @RequestParam String dataId) {

        ProcessScenarioDataWSModel response = processScenarioMiddleware.removeProcessScenarioData(userId,processId,scenarioId,dataId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
