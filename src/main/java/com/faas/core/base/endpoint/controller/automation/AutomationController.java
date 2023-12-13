package com.faas.core.base.endpoint.controller.automation;

import com.faas.core.base.middleware.automation.AutomationMiddleware;
import com.faas.core.base.model.ws.automation.AutomationWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/automation/")
public class AutomationController {


    @Autowired
    AutomationMiddleware automationMiddleware;


    @RequestMapping(value = BaseRoute.GET_AUTOMATIONS, method = RequestMethod.POST)
    public ResponseEntity<?> getAutomations(@RequestParam long userId) {

        AutomationWSModel response = automationMiddleware.getAutomations(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_AUTOMATION, method = RequestMethod.POST)
    public ResponseEntity<?> getAutomation(@RequestParam long userId,
                                           @RequestParam long automationId) {

        AutomationWSModel response = automationMiddleware.getAutomation(userId,automationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_AUTOMATION, method = RequestMethod.POST)
    public ResponseEntity<?> createAutomation(@RequestParam long userId,
                                              @RequestParam String automation,
                                              @RequestParam long typeId) {

        AutomationWSModel response = automationMiddleware.createAutomation(userId,automation,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_AUTOMATION, method = RequestMethod.POST)
    public ResponseEntity<?> updateAutomation(@RequestParam long userId,
                                              @RequestParam long automationId,
                                              @RequestParam String automation,
                                              @RequestParam long typeId) {

        AutomationWSModel response = automationMiddleware.updateAutomation(userId,automationId,automation,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_AUTOMATION, method = RequestMethod.POST)
    public ResponseEntity<?> removeAutomation(@RequestParam long userId,
                                              @RequestParam long automationId) {

        AutomationWSModel response = automationMiddleware.removeAutomation(userId,automationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
