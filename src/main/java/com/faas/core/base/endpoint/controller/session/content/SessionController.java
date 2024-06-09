package com.faas.core.base.endpoint.controller.session.content;

import com.faas.core.base.middleware.session.content.SessionMiddleware;
import com.faas.core.base.model.ws.session.content.SessionWSModel;
import com.faas.core.base.model.ws.session.details.SessionRequest;
import com.faas.core.utility.config.AppConstant;
import com.faas.core.utility.config.BaseRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/base/session/")
public class SessionController {


    @Autowired
    SessionMiddleware sessionMiddleware;


    @RequestMapping(value = BaseRoute.GET_ALL_SESSIONS, method = RequestMethod.POST)
    public ResponseEntity<?> getAllSessions(@RequestParam long userId,
                                            @RequestParam int reqPage,
                                            @RequestParam int reqSize) {

        SessionWSModel response = sessionMiddleware.getAllSessions(userId,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_SESSIONS_BY_STATE, method = RequestMethod.POST)
    public ResponseEntity<?> getSessionsByState(@RequestParam long userId,
                                                @RequestParam String sessionState,
                                                @RequestParam int reqPage,
                                                @RequestParam int reqSize) {

        SessionWSModel response = sessionMiddleware.getSessionsByState(userId,sessionState,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_SESSION, method = RequestMethod.POST)
    public ResponseEntity<?> getSession(@RequestParam long userId,
                                        @RequestParam long sessionId,
                                        @RequestParam long clientId) {

        SessionWSModel response = sessionMiddleware.getSession(userId,sessionId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_SESSION, method = RequestMethod.POST)
    public ResponseEntity<?> createSession(@RequestParam long userId,
                                           @RequestParam long clientId,
                                           @RequestParam long agentId,
                                           @RequestParam String campaignId) {

        SessionWSModel response = sessionMiddleware.createSession(userId,clientId,agentId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_SESSIONS, method = RequestMethod.POST)
    public ResponseEntity<?> createSessions(@RequestBody SessionRequest sessionRequest) {

        SessionWSModel response = sessionMiddleware.createSessions(sessionRequest);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_SESSION, method = RequestMethod.POST)
    public ResponseEntity<?> updateSession(@RequestParam long userId,
                                           @RequestParam long sessionId,
                                           @RequestParam long clientId) {

        SessionWSModel response = sessionMiddleware.updateSession(userId,sessionId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_SESSION, method = RequestMethod.POST)
    public ResponseEntity<?> removeSession(@RequestParam long userId,
                                           @RequestParam long sessionId,
                                           @RequestParam long clientId) {

        SessionWSModel response = sessionMiddleware.removeSession(userId,sessionId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
