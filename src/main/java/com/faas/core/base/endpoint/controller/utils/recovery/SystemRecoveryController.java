package com.faas.core.base.endpoint.controller.utils.recovery;

import com.faas.core.base.middleware.utils.recovery.SystemRecoveryMiddleware;
import com.faas.core.base.model.ws.utils.recovery.SystemUtilityWSModel;
import com.faas.core.base.model.ws.utils.recovery.InitSystemUtilityWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/utils/recovery/")
public class SystemRecoveryController {


    @Autowired
    SystemRecoveryMiddleware systemRecoveryMiddleware;


    @RequestMapping(value = BaseRoute.INIT_SYSTEM_UTILITY, method = RequestMethod.POST)
    public ResponseEntity<?> initSystemUtility(@RequestParam String initType) {

        InitSystemUtilityWSModel response = systemRecoveryMiddleware.initSystemUtility(initType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_SYSTEM_UTILITIES, method = RequestMethod.POST)
    public ResponseEntity<?> getSystemUtilities(@RequestParam long userId) {

        SystemUtilityWSModel response = systemRecoveryMiddleware.getSystemUtilities(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REPAIR_SYSTEM_UTILITY, method = RequestMethod.POST)
    public ResponseEntity<?> repairSystemUtility(@RequestParam long userId,
                                                 @RequestParam String repairType) {

        SystemUtilityWSModel response = systemRecoveryMiddleware.repairSystemUtility(userId,repairType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_SYSTEM_UTILITY, method = RequestMethod.POST)
    public ResponseEntity<?> removeSystemUtility(@RequestParam long userId,
                                                 @RequestParam String removeType) {

        SystemUtilityWSModel response = systemRecoveryMiddleware.removeSystemUtility(userId,removeType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
