package com.faas.core.base.endpoint.controller.utils.settings;

import com.faas.core.base.middleware.utils.settings.UtilsSettingsMiddleware;
import com.faas.core.base.model.ws.utils.settings.UtilSettingsWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/utils/settings/")
public class UtilsSettingsController {

    @Autowired
    UtilsSettingsMiddleware utilsSettingsMiddleware;


    @RequestMapping(value = BaseRoute.REMOVE_ALL_CLIENTS, method = RequestMethod.POST)
    public ResponseEntity<?> removeAllClients(@RequestParam long userId) {

        UtilSettingsWSModel response = utilsSettingsMiddleware.removeAllClients(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_ALL_SESSIONS, method = RequestMethod.POST)
    public ResponseEntity<?> removeAllSessions(@RequestParam long userId) {

        UtilSettingsWSModel response = utilsSettingsMiddleware.removeAllSessions(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_ALL_FLOWS, method = RequestMethod.POST)
    public ResponseEntity<?> removeAllFlows(@RequestParam long userId) {

        UtilSettingsWSModel response = utilsSettingsMiddleware.removeAllFlows(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_ALL_INQUIRIES, method = RequestMethod.POST)
    public ResponseEntity<?> removeAllInquiries(@RequestParam long userId) {

        UtilSettingsWSModel response = utilsSettingsMiddleware.removeAllInquiries(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_SELECTED_TABLES, method = RequestMethod.POST)
    public ResponseEntity<?> removeSelectedTables(@RequestParam long userId,
                                                  @RequestParam String selected) {

        UtilSettingsWSModel response = utilsSettingsMiddleware.removeSelectedTables(userId,selected);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CLEAN_SYSTEM_TABLES, method = RequestMethod.POST)
    public ResponseEntity<?> cleanSystemTables(@RequestParam long userId) {

        UtilSettingsWSModel response = utilsSettingsMiddleware.cleanSystemTables(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
