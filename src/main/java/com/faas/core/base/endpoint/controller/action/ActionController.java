package com.faas.core.base.endpoint.controller.action;

import com.faas.core.base.middleware.action.ActionMiddleware;
import com.faas.core.base.model.ws.action.ActionWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/action/")
public class ActionController {


    @Autowired
    ActionMiddleware actionMiddleware;


    @RequestMapping(value = BaseRoute.GET_ACTIONS, method = RequestMethod.POST)
    public ResponseEntity<?> getActions(@RequestParam long userId) {

        ActionWSModel response = actionMiddleware.getActions(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_ACTION, method = RequestMethod.POST)
    public ResponseEntity<?> getAction(@RequestParam long userId,
                                       @RequestParam long actionId) {

        ActionWSModel response = actionMiddleware.getAction(userId,actionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_ACTION, method = RequestMethod.POST)
    public ResponseEntity<?> createAction(@RequestParam long userId,
                                          @RequestParam String action) {

        ActionWSModel response = actionMiddleware.createAction(userId,action);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_ACTION, method = RequestMethod.POST)
    public ResponseEntity<?> updateAction(@RequestParam long userId,
                                          @RequestParam long actionId,
                                          @RequestParam String action) {

        ActionWSModel response = actionMiddleware.updateAction(userId,actionId,action);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_ACTION, method = RequestMethod.POST)
    public ResponseEntity<?> removeAction(@RequestParam long userId,
                                          @RequestParam long actionId) {

        ActionWSModel response = actionMiddleware.removeAction(userId,actionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
