package com.faas.core.base.endpoint.controller.client.session.content;

import com.faas.core.base.middleware.client.session.content.ClientSessionMiddleware;
import com.faas.core.base.model.ws.campaign.details.client.manual.ManualClientRequest;
import com.faas.core.base.model.ws.client.session.content.SessionWSModel;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.BaseRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/base/client/session/")
public class ClientSessionController {


    @Autowired
    ClientSessionMiddleware clientSessionMiddleware;


    @RequestMapping(value = BaseRoute.GET_ALL_SESSIONS, method = RequestMethod.POST)
    public ResponseEntity<?> getAllSessions(@RequestParam long userId,
                                            @RequestParam int reqPage,
                                            @RequestParam int reqSize) {

        SessionWSModel response = clientSessionMiddleware.getAllSessions(userId,reqPage,reqSize);

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

        SessionWSModel response = clientSessionMiddleware.getSessionsByState(userId,sessionState,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_SESSION, method = RequestMethod.POST)
    public ResponseEntity<?> getSession(@RequestParam long userId,
                                        @RequestParam long sessionId,
                                        @RequestParam long clientId) {

        SessionWSModel response = clientSessionMiddleware.getSession(userId,sessionId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_SESSION, method = RequestMethod.POST)
    public ResponseEntity<?> createSession(@RequestParam long userId,
                                           @RequestParam long clientId,
                                           @RequestParam String campaign) {

        SessionWSModel response = clientSessionMiddleware.createSession(userId,clientId,campaign);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_SESSIONS, method = RequestMethod.POST)
    public ResponseEntity<?> createSessions(@RequestBody ManualClientRequest manualClientRequest) {

        SessionWSModel response = clientSessionMiddleware.createSessions(manualClientRequest);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_SESSION, method = RequestMethod.POST)
    public ResponseEntity<?> updateSession(@RequestParam long userId,
                                           @RequestParam long sessionId,
                                           @RequestParam long clientId) {

        SessionWSModel response = clientSessionMiddleware.updateSession(userId,sessionId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_SESSION, method = RequestMethod.POST)
    public ResponseEntity<?> removeSession(@RequestParam long userId,
                                           @RequestParam long sessionId,
                                           @RequestParam long clientId) {

        SessionWSModel response = clientSessionMiddleware.removeSession(userId,sessionId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
