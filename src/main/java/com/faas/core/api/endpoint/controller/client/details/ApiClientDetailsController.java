package com.faas.core.api.endpoint.controller.client.details;

import com.faas.core.api.middleware.client.details.ApiClientDetailsMiddleware;
import com.faas.core.api.model.ws.client.details.ApiClientDetailsWSModel;
import com.faas.core.api.model.ws.client.details.ApiClientNoteWSModel;
import com.faas.core.api.model.ws.client.details.ApiClientOSINTWSModel;
import com.faas.core.api.model.ws.client.details.ApiClientRemoteWSModel;
import com.faas.core.utils.config.ApiRoute;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/api/client/details/")
public class ApiClientDetailsController {


    @Autowired
    ApiClientDetailsMiddleware apiClientDetailsMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_CLIENT_DETAILS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetClientDetails(@RequestParam long agentId,
                                                 @RequestParam long clientId) {

        ApiClientDetailsWSModel response = apiClientDetailsMiddleware.apiGetClientDetails(agentId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_CLIENT_NOTES, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetClientNotes(@RequestParam long agentId,
                                               @RequestParam long clientId) {

        ApiClientNoteWSModel response = apiClientDetailsMiddleware.apiGetClientNotes(agentId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_CLIENT_NOTE, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetClientNote(@RequestParam long agentId,
                                              @RequestParam long clientId) {

        ApiClientNoteWSModel response = apiClientDetailsMiddleware.apiGetClientNote(agentId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_CREATE_CLIENT_NOTE, method = RequestMethod.POST)
    public ResponseEntity<?> apiCreateClientNote(@RequestParam long agentId,
                                                 @RequestParam long clientId) {

        ApiClientNoteWSModel response = apiClientDetailsMiddleware.apiCreateClientNote(agentId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_UPDATE_CLIENT_NOTE, method = RequestMethod.POST)
    public ResponseEntity<?> apiUpdateClientNote(@RequestParam long agentId,
                                                 @RequestParam long clientId) {

        ApiClientNoteWSModel response = apiClientDetailsMiddleware.apiUpdateClientNote(agentId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_REMOVE_CLIENT_NOTE, method = RequestMethod.POST)
    public ResponseEntity<?> apiRemoveClientNote(@RequestParam long agentId,
                                                 @RequestParam long clientId) {

        ApiClientNoteWSModel response = apiClientDetailsMiddleware.apiRemoveClientNote(agentId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = ApiRoute.API_GET_CLIENT_REMOTES, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetClientRemotes(@RequestParam long agentId,
                                                 @RequestParam long clientId) {

        ApiClientRemoteWSModel response = apiClientDetailsMiddleware.apiGetClientRemotes(agentId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_CLIENT_REMOTE, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetClientRemote(@RequestParam long agentId,
                                                @RequestParam long clientId,
                                                @RequestParam String clientRemoteId) {

        ApiClientRemoteWSModel response = apiClientDetailsMiddleware.apiGetClientRemote(agentId,clientId,clientRemoteId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_CLIENT_OS_INTS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetClientOSINTs(@RequestParam long agentId,
                                                @RequestParam long clientId) {

        ApiClientOSINTWSModel response = apiClientDetailsMiddleware.apiGetClientOSINTs(agentId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_CLIENT_OS_INT, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetClientOSINT(@RequestParam long agentId,
                                               @RequestParam long clientId) {

        ApiClientOSINTWSModel response = apiClientDetailsMiddleware.apiGetClientOSINT(agentId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}