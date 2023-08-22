package com.faas.core.base.endpoint.controller.automation.content;

import com.faas.core.base.middleware.automation.content.AutomationTempMiddleware;
import com.faas.core.base.model.ws.automation.content.AutomationTempWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/automation/temp/")
public class AutomationTempController {


    @Autowired
    AutomationTempMiddleware automationTempMiddleware;


    @RequestMapping(value = BaseRoute.GET_AUTOMATION_TEMPS, method = RequestMethod.POST)
    public ResponseEntity<?> getAutomationTemps(@RequestParam long userId) {

        AutomationTempWSModel response = automationTempMiddleware.getAutomationTemps(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_AUTOMATION_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> getAutomationTemp(@RequestParam long userId,
                                               @RequestParam long tempId) {

        AutomationTempWSModel response = automationTempMiddleware.getAutomationTemp(userId,tempId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_AUTOMATION_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> createAutomationTemp(@RequestParam long userId,
                                                  @RequestParam String automationTemp,
                                                  @RequestParam long typeId) {

        AutomationTempWSModel response = automationTempMiddleware.createAutomationTemp(userId,automationTemp,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_AUTOMATION_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> updateAutomationTemp(@RequestParam long userId,
                                                  @RequestParam long tempId,
                                                  @RequestParam String automationTemp,
                                                  @RequestParam long typeId) {

        AutomationTempWSModel response = automationTempMiddleware.updateAutomationTemp(userId,tempId,automationTemp,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_AUTOMATION_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> removeAutomationTemp(@RequestParam long userId,
                                                  @RequestParam long tempId) {

        AutomationTempWSModel response = automationTempMiddleware.removeAutomationTemp(userId,tempId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
