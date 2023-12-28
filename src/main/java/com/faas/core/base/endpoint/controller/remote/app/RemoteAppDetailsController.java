package com.faas.core.base.endpoint.controller.remote.app;

import com.faas.core.base.middleware.remote.app.RemoteAppDetailsMiddleware;
import com.faas.core.base.model.ws.remote.app.RemoteAppSummaryWSModel;
import com.faas.core.base.model.ws.remote.app.RemoteAppWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/remote/app/details/")
public class RemoteAppDetailsController {

    @Autowired
    RemoteAppDetailsMiddleware remoteAppDetailsMiddleware;

    @RequestMapping(value = BaseRoute.GET_REMOTE_APP_DETAILS, method = RequestMethod.POST)
    public ResponseEntity<?> getRemoteAppDetails(@RequestParam long userId) {

        RemoteAppWSModel response = remoteAppDetailsMiddleware.getRemoteAppDetails(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_REMOTE_APP_SUMMARY, method = RequestMethod.POST)
    public ResponseEntity<?> getRemoteAppSummary(@RequestParam long userId) {

        RemoteAppSummaryWSModel response = remoteAppDetailsMiddleware.getRemoteAppSummary(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
