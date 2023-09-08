package com.faas.core.base.endpoint.controller.client.session.details;

import com.faas.core.base.middleware.client.session.details.ClientSessionDetailsMiddleware;
import com.faas.core.base.model.ws.client.session.details.SessionDetailsWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/client/session/details/")
public class ClientSessionDetailsController {


    @Autowired
    ClientSessionDetailsMiddleware clientSessionDetailsMiddleware;


    @RequestMapping(value = BaseRoute.GET_SESSION_DETAILS, method = RequestMethod.POST)
    public ResponseEntity<?> getSessionDetails(@RequestParam long userId,
                                               @RequestParam String sessionId) {

        SessionDetailsWSModel response = clientSessionDetailsMiddleware.getSessionDetails(userId,sessionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
