package com.faas.core.api.endpoint.controller.operation.client.details;

import com.faas.core.api.middleware.operation.client.details.ApiOperationClientDetailsMiddleware;
import com.faas.core.api.model.ws.operation.client.details.ApiOperationClientDetailsWSModel;
import com.faas.core.api.model.ws.operation.client.details.ApiOperationClientNoteWSModel;
import com.faas.core.api.model.ws.operation.client.details.ApiOperationClientOSINTWSModel;
import com.faas.core.api.model.ws.operation.client.details.ApiOperationClientRemoteWSModel;
import com.faas.core.utility.config.ApiRoute;
import com.faas.core.utility.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/api/operation/client/details/")
public class ApiOperationClientDetailsController {


    @Autowired
    ApiOperationClientDetailsMiddleware apiOperationClientDetailsMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_CLIENT_DETAILS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetClientDetails(@RequestParam long agentId,
                                                 @RequestParam long clientId) {

        ApiOperationClientDetailsWSModel response = apiOperationClientDetailsMiddleware.apiGetClientDetails(agentId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_CLIENT_NOTES, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetClientNotes(@RequestParam long agentId,
                                               @RequestParam long clientId) {

        ApiOperationClientNoteWSModel response = apiOperationClientDetailsMiddleware.apiGetClientNotes(agentId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_CLIENT_NOTE, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetClientNote(@RequestParam long agentId,
                                              @RequestParam long clientId) {

        ApiOperationClientNoteWSModel response = apiOperationClientDetailsMiddleware.apiGetClientNote(agentId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_CREATE_CLIENT_NOTE, method = RequestMethod.POST)
    public ResponseEntity<?> apiCreateClientNote(@RequestParam long agentId,
                                                 @RequestParam long clientId) {

        ApiOperationClientNoteWSModel response = apiOperationClientDetailsMiddleware.apiCreateClientNote(agentId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_UPDATE_CLIENT_NOTE, method = RequestMethod.POST)
    public ResponseEntity<?> apiUpdateClientNote(@RequestParam long agentId,
                                                 @RequestParam long clientId) {

        ApiOperationClientNoteWSModel response = apiOperationClientDetailsMiddleware.apiUpdateClientNote(agentId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_REMOVE_CLIENT_NOTE, method = RequestMethod.POST)
    public ResponseEntity<?> apiRemoveClientNote(@RequestParam long agentId,
                                                 @RequestParam long clientId) {

        ApiOperationClientNoteWSModel response = apiOperationClientDetailsMiddleware.apiRemoveClientNote(agentId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = ApiRoute.API_GET_CLIENT_REMOTES, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetClientRemotes(@RequestParam long agentId,
                                                 @RequestParam long clientId) {

        ApiOperationClientRemoteWSModel response = apiOperationClientDetailsMiddleware.apiGetClientRemotes(agentId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_CLIENT_REMOTE, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetClientRemote(@RequestParam long agentId,
                                                @RequestParam long clientId,
                                                @RequestParam String clientRemoteId) {

        ApiOperationClientRemoteWSModel response = apiOperationClientDetailsMiddleware.apiGetClientRemote(agentId,clientId,clientRemoteId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_CLIENT_OS_INTS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetClientOSINTs(@RequestParam long agentId,
                                                @RequestParam long clientId) {

        ApiOperationClientOSINTWSModel response = apiOperationClientDetailsMiddleware.apiGetClientOSINTs(agentId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_CLIENT_OS_INT, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetClientOSINT(@RequestParam long agentId,
                                               @RequestParam long clientId) {

        ApiOperationClientOSINTWSModel response = apiOperationClientDetailsMiddleware.apiGetClientOSINT(agentId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}