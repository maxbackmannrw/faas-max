package com.faas.core.base.endpoint.controller.manager.remoteapp.content;

import com.faas.core.base.middleware.manager.remoteapp.content.RemoteAppManagerMiddleware;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/manager/remote/app/")
public class RemoteAppManagerController {


    @Autowired
    RemoteAppManagerMiddleware remoteAppManagerMiddleware;


    @RequestMapping(value = BaseRoute.GET_PROCESS_INQUIRY_REMOTE, method = RequestMethod.POST)
    public ResponseEntity<?> getAppManager(@RequestParam long userId,
                                           @RequestParam int reqPage,
                                           @RequestParam int reqSize) {

        AppManagerOperationWSModel response = remoteAppManagerMiddleware.getAppManager(userId,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
