package com.faas.core.base.endpoint.controller.scenario.temp;

import com.faas.core.base.middleware.scenario.temp.ActionTempMiddleware;
import com.faas.core.base.model.ws.scenario.temp.action.ActionTempWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/scenario/temp/action/")
public class ActionTempController {


    @Autowired
    ActionTempMiddleware actionTempMiddleware;


    @RequestMapping(value = BaseRoute.GET_ACTION_TEMPS, method = RequestMethod.POST)
    public ResponseEntity<?> getActionTemps(@RequestParam long userId) {

        ActionTempWSModel response = actionTempMiddleware.getActionTemps(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_ACTION_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> getActionTemp(@RequestParam long userId,
                                           @RequestParam long tempId) {

        ActionTempWSModel response = actionTempMiddleware.getActionTemp(userId,tempId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_ACTION_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> createActionTemp(@RequestParam long userId,
                                              @RequestParam String actionTemp) {

        ActionTempWSModel response = actionTempMiddleware.createActionTemp(userId,actionTemp);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_ACTION_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> updateActionTemp(@RequestParam long userId,
                                              @RequestParam long tempId,
                                              @RequestParam String actionTemp) {

        ActionTempWSModel response = actionTempMiddleware.updateActionTemp(userId,tempId,actionTemp);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_ACTION_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> removeActionTemp(@RequestParam long userId,
                                              @RequestParam long tempId) {

        ActionTempWSModel response = actionTempMiddleware.removeActionTemp(userId,tempId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
