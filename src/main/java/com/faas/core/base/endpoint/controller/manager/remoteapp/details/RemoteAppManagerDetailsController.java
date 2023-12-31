package com.faas.core.base.endpoint.controller.manager.remoteapp.details;

import com.faas.core.base.middleware.manager.remoteapp.details.RemoteAppManagerDetailsMiddleware;
import com.faas.core.base.model.ws.manager.app.AppManagerOperationWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/manager/remote/app/details/")
public class RemoteAppManagerDetailsController {


    @Autowired
    RemoteAppManagerDetailsMiddleware remoteAppManagerDetailsMiddleware;


    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> getAppManager(@RequestParam long userId,
                                           @RequestParam int reqPage,
                                           @RequestParam int reqSize) {

        AppManagerOperationWSModel response = remoteAppManagerDetailsMiddleware.getAppManager(userId,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
