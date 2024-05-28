package com.faas.core.base.endpoint.controller.session.details;

import com.faas.core.base.middleware.session.details.SessionDetailsMiddleware;
import com.faas.core.base.model.ws.session.details.SessionDetailsWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/session/details/")
public class SessionDetailsController {


    @Autowired
    SessionDetailsMiddleware sessionDetailsMiddleware;


    @RequestMapping(value = BaseRoute.GET_SESSION_DETAILS, method = RequestMethod.POST)
    public ResponseEntity<?> getSessionDetails(@RequestParam long userId,
                                               @RequestParam String sessionId) {

        SessionDetailsWSModel response = sessionDetailsMiddleware.getSessionDetails(userId,sessionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
