package com.faas.core.base.endpoint.controller.utility.system;

import com.faas.core.base.middleware.utility.system.UtilitySystemMiddleware;
import com.faas.core.base.model.ws.utility.system.SystemInfoWSModel;
import com.faas.core.base.model.ws.utility.system.SystemInitWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/utility/system/")
public class UtilitySystemController {


    @Autowired
    UtilitySystemMiddleware utilitySystemMiddleware;


    @RequestMapping(value = BaseRoute.GET_SYSTEM_INFOS, method = RequestMethod.POST)
    public ResponseEntity<?> getSystemInfos(@RequestParam long userId) {

        SystemInfoWSModel response = utilitySystemMiddleware.getSystemInfos(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.INITIALIZE_SYSTEM, method = RequestMethod.POST)
    public ResponseEntity<?> initializeSystem(@RequestParam String initType) {

        SystemInitWSModel response = utilitySystemMiddleware.initializeSystem(initType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REPAIR_SYSTEM_INFO, method = RequestMethod.POST)
    public ResponseEntity<?> repairSystemInfo(@RequestParam long userId,
                                              @RequestParam String systemInfo) {

        SystemInfoWSModel response = utilitySystemMiddleware.repairSystemInfo(userId,systemInfo);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_SYSTEM_INFO, method = RequestMethod.POST)
    public ResponseEntity<?> removeSystemInfo(@RequestParam long userId,
                                              @RequestParam String systemInfo) {

        SystemInfoWSModel response = utilitySystemMiddleware.removeSystemInfo(userId,systemInfo);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
