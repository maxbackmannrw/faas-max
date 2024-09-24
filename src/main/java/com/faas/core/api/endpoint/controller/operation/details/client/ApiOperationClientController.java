package com.faas.core.api.endpoint.controller.operation.details.client;

import com.faas.core.api.middleware.operation.details.client.ApiOperationClientMiddleware;
import com.faas.core.api.model.ws.operation.details.client.ApiOperationClientWSModel;
import com.faas.core.api.model.ws.operation.details.client.ApiOperationClientDetailsWSModel;
import com.faas.core.api.model.ws.operation.details.client.ApiOperationClientNoteWSModel;
import com.faas.core.api.model.ws.operation.details.client.ApiOperationClientOSINTWSModel;
import com.faas.core.api.model.ws.operation.details.client.ApiOperationClientRemoteWSModel;
import com.faas.core.misc.config.ApiRoute;
import com.faas.core.misc.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/api/operation/client/")
public class ApiOperationClientController {


    @Autowired
    ApiOperationClientMiddleware apiOperationClientMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_AGENT_CLIENTS, method = RequestMethod.POST)
    public ResponseEntity<?> apiAgentGetClients(@RequestParam long agentId,
                                                @RequestParam int reqPage,
                                                @RequestParam int reqSize) {

        ApiOperationClientWSModel response = apiOperationClientMiddleware.apiAgentGetClients(agentId, reqPage, reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_CLIENT, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetClient(@RequestParam long agentId,
                                          @RequestParam long clientId) {

        ApiOperationClientWSModel response = apiOperationClientMiddleware.apiGetClient(agentId, clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_CLIENT_DETAILS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetClientDetails(@RequestParam long agentId,
                                                 @RequestParam long clientId) {

        ApiOperationClientDetailsWSModel response = apiOperationClientMiddleware.apiGetClientDetails(agentId, clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_CLIENT_NOTES, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetClientNotes(@RequestParam long agentId,
                                               @RequestParam long clientId) {

        ApiOperationClientNoteWSModel response = apiOperationClientMiddleware.apiGetClientNotes(agentId, clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_CLIENT_NOTE, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetClientNote(@RequestParam long agentId,
                                              @RequestParam long clientId) {

        ApiOperationClientNoteWSModel response = apiOperationClientMiddleware.apiGetClientNote(agentId, clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_CREATE_CLIENT_NOTE, method = RequestMethod.POST)
    public ResponseEntity<?> apiCreateClientNote(@RequestParam long agentId,
                                                 @RequestParam long clientId) {

        ApiOperationClientNoteWSModel response = apiOperationClientMiddleware.apiCreateClientNote(agentId, clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_UPDATE_CLIENT_NOTE, method = RequestMethod.POST)
    public ResponseEntity<?> apiUpdateClientNote(@RequestParam long agentId,
                                                 @RequestParam long clientId) {

        ApiOperationClientNoteWSModel response = apiOperationClientMiddleware.apiUpdateClientNote(agentId, clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_REMOVE_CLIENT_NOTE, method = RequestMethod.POST)
    public ResponseEntity<?> apiRemoveClientNote(@RequestParam long agentId,
                                                 @RequestParam long clientId) {

        ApiOperationClientNoteWSModel response = apiOperationClientMiddleware.apiRemoveClientNote(agentId, clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_CLIENT_REMOTES, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetClientRemotes(@RequestParam long agentId,
                                                 @RequestParam long clientId) {

        ApiOperationClientRemoteWSModel response = apiOperationClientMiddleware.apiGetClientRemotes(agentId, clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_CLIENT_REMOTE, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetClientRemote(@RequestParam long agentId,
                                                @RequestParam long clientId,
                                                @RequestParam String clientRemoteId) {

        ApiOperationClientRemoteWSModel response = apiOperationClientMiddleware.apiGetClientRemote(agentId, clientId, clientRemoteId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_CLIENT_OS_INTS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetClientOSINTs(@RequestParam long agentId,
                                                @RequestParam long clientId) {

        ApiOperationClientOSINTWSModel response = apiOperationClientMiddleware.apiGetClientOSINTs(agentId, clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_CLIENT_OS_INT, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetClientOSINT(@RequestParam long agentId,
                                               @RequestParam long clientId) {

        ApiOperationClientOSINTWSModel response = apiOperationClientMiddleware.apiGetClientOSINT(agentId, clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

}