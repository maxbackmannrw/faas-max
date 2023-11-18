package com.faas.core.base.endpoint.controller.utils.system;

import com.faas.core.base.middleware.utils.system.UtilsSystemMiddleware;
import com.faas.core.base.model.ws.utils.system.SystemInfoWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/utils/system/")
public class UtilsSystemController {


    @Autowired
    UtilsSystemMiddleware utilsSystemMiddleware;


    @RequestMapping(value = BaseRoute.GET_SYSTEM_INFOS, method = RequestMethod.POST)
    public ResponseEntity<?> getSystemInfos(@RequestParam long userId) {

        SystemInfoWSModel response = utilsSystemMiddleware.getSystemInfos(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REPAIR_SYSTEM_INFO, method = RequestMethod.POST)
    public ResponseEntity<?> repairSystemInfo(@RequestParam long userId,
                                              @RequestParam String systemInfo) {

        SystemInfoWSModel response = utilsSystemMiddleware.repairSystemInfo(userId,systemInfo);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_SYSTEM_INFO, method = RequestMethod.POST)
    public ResponseEntity<?> removeSystemInfo(@RequestParam long userId,
                                              @RequestParam String systemInfo) {

        SystemInfoWSModel response = utilsSystemMiddleware.removeSystemInfo(userId,systemInfo);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
