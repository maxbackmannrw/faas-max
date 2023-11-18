package com.faas.core.base.endpoint.controller.utils.restore;

import com.faas.core.base.middleware.utils.restore.UtilsRestoreMiddleware;
import com.faas.core.base.model.ws.utils.restore.UtilSettingsWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/utils/restore/")
public class UtilsRestoreController {


    @Autowired
    UtilsRestoreMiddleware utilsRestoreMiddleware;


    @RequestMapping(value = BaseRoute.GET_ALL_SYSTEM_SETTINGS, method = RequestMethod.POST)
    public ResponseEntity<?> getAllSystemSettings(@RequestParam long userId) {

        UtilSettingsWSModel response = utilsRestoreMiddleware.getAllSystemSettings(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REPAIR_SYSTEM_SETTINGS, method = RequestMethod.POST)
    public ResponseEntity<?> repairSystemSettings(@RequestParam long userId,
                                                  @RequestParam String systemSettings) {

        UtilSettingsWSModel response = utilsRestoreMiddleware.repairSystemSettings(userId,systemSettings);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_SYSTEM_SETTINGS, method = RequestMethod.POST)
    public ResponseEntity<?> removeSystemSettings(@RequestParam long userId,
                                                  @RequestParam String systemSettings) {

        UtilSettingsWSModel response = utilsRestoreMiddleware.removeSystemSettings(userId,systemSettings);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
