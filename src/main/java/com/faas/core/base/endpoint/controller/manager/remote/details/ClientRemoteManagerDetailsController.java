package com.faas.core.base.endpoint.controller.manager.remote.details;

import com.faas.core.base.middleware.manager.remote.details.ClientRemoteManagerDetailsMiddleware;
import com.faas.core.base.model.ws.manager.main.MainManagerOperationWSModel;
import com.faas.core.utility.config.AppConstant;
import com.faas.core.utility.config.BaseRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/base/manager/remote/client/details/")
public class ClientRemoteManagerDetailsController {


    @Autowired
    ClientRemoteManagerDetailsMiddleware clientRemoteManagerDetailsMiddleware;


    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> getAppManager(@RequestParam long userId,
                                           @RequestParam int reqPage,
                                           @RequestParam int reqSize) {

        MainManagerOperationWSModel response = clientRemoteManagerDetailsMiddleware.getAppManager(userId,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
