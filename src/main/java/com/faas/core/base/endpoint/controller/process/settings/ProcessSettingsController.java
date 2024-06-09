package com.faas.core.base.endpoint.controller.process.settings;

import com.faas.core.base.middleware.process.settings.ProcessSettingsMiddleware;
import com.faas.core.base.model.ws.process.settings.ProcessTypeWSModel;
import com.faas.core.base.model.ws.process.settings.TriggerTypeWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/process/settings/")
public class ProcessSettingsController {


    @Autowired
    ProcessSettingsMiddleware processSettingsMiddleware;


    @RequestMapping(value = BaseRoute.GET_ALL_PROCESS_TYPES, method = RequestMethod.POST)
    public ResponseEntity<?> getAllProcessTypes(@RequestParam long userId) {

        ProcessTypeWSModel response = processSettingsMiddleware.getAllProcessTypes(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_PROCESS_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessType(@RequestParam long userId,
                                            @RequestParam long typeId) {

        ProcessTypeWSModel response = processSettingsMiddleware.getProcessType(userId, typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_PROCESS_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> createProcessType(@RequestParam long userId,
                                               @RequestParam String processType) {

        ProcessTypeWSModel response = processSettingsMiddleware.createProcessType(userId,processType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_PROCESS_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> updateProcessType(@RequestParam long userId,
                                               @RequestParam long typeId,
                                               @RequestParam String processType) {

        ProcessTypeWSModel response = processSettingsMiddleware.updateProcessType(userId,typeId,processType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_PROCESS_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> removeProcessType(@RequestParam long userId,
                                               @RequestParam long typeId) {

        ProcessTypeWSModel response = processSettingsMiddleware.removeProcessType(userId, typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = BaseRoute.GET_ALL_TRIGGER_TYPES, method = RequestMethod.POST)
    public ResponseEntity<?> getAllTriggerTypes(@RequestParam long userId) {

        TriggerTypeWSModel response = processSettingsMiddleware.getAllTriggerTypes(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_TRIGGER_TYPES_BY_BASE, method = RequestMethod.POST)
    public ResponseEntity<?> getTriggerTypesByBase(@RequestParam long userId,
                                                   @RequestParam String baseType) {

        TriggerTypeWSModel response = processSettingsMiddleware.getTriggerTypesByBase(userId,baseType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_TRIGGER_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> getTriggerType(@RequestParam long userId,
                                            @RequestParam long typeId) {

        TriggerTypeWSModel response = processSettingsMiddleware.getTriggerType(userId,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_TRIGGER_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> createTriggerType(@RequestParam long userId,
                                               @RequestParam String triggerType,
                                               @RequestParam String baseType) {

        TriggerTypeWSModel response = processSettingsMiddleware.createTriggerType(userId,triggerType,baseType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_TRIGGER_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> updateTriggerType(@RequestParam long userId,
                                               @RequestParam long typeId,
                                               @RequestParam String triggerType,
                                               @RequestParam String baseType) {

        TriggerTypeWSModel response = processSettingsMiddleware.updateTriggerType(userId,typeId,triggerType,baseType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_TRIGGER_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> removeTriggerType(@RequestParam long userId,
                                               @RequestParam long typeId) {

        TriggerTypeWSModel response = processSettingsMiddleware.removeTriggerType(userId,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
