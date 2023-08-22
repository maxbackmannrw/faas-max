package com.faas.core.base.endpoint.controller.automation.settings;

import com.faas.core.base.middleware.automation.settings.AutomationSettingsMiddleware;
import com.faas.core.base.model.ws.automation.settings.AutomationTypeWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/automation/settings/")
public class AutomationSettingsController {


    @Autowired
    AutomationSettingsMiddleware automationSettingsMiddleware;


    @RequestMapping(value = BaseRoute.GET_AUTOMATION_TYPES, method = RequestMethod.POST)
    public ResponseEntity<?> getAutomationTypes(@RequestParam long userId) {

        AutomationTypeWSModel response = automationSettingsMiddleware.getAutomationTypes(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_AUTOMATION_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> getAutomationType(@RequestParam long userId,
                                               @RequestParam long typeId) {

        AutomationTypeWSModel response = automationSettingsMiddleware.getAutomationType(userId,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_AUTOMATION_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> createAutomationType(@RequestParam long userId,
                                                  @RequestParam String automationType,
                                                  @RequestParam String baseType) {

        AutomationTypeWSModel response = automationSettingsMiddleware.createAutomationType(userId,automationType,baseType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_AUTOMATION_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> updateAutomationType(@RequestParam long userId,
                                                  @RequestParam long typeId,
                                                  @RequestParam String automationType,
                                                  @RequestParam String baseType) {

        AutomationTypeWSModel response = automationSettingsMiddleware.updateAutomationType(userId,typeId,automationType,baseType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_AUTOMATION_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> removeAutomationType(@RequestParam long userId,
                                                  @RequestParam long typeId) {

        AutomationTypeWSModel response = automationSettingsMiddleware.removeAutomationType(userId,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
