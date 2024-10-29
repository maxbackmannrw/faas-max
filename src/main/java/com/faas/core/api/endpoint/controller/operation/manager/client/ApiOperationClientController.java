package com.faas.core.api.endpoint.controller.operation.manager.client;

import com.faas.core.api.middleware.operation.manager.client.ApiOperationClientMiddleware;
import com.faas.core.api.model.ws.operation.manager.client.ApiOperationClientWSModel;
import com.faas.core.api.model.ws.operation.manager.client.ApiOperationClientIntelWSModel;
import com.faas.core.api.model.ws.operation.manager.client.ApiOperationClientNoteWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/api/operation/manager/client/")
public class ApiOperationClientController {


    @Autowired
    ApiOperationClientMiddleware apiOperationClientMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_CLIENT, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationClient(@RequestParam long agentId,
                                                   @RequestParam long clientId) {

        ApiOperationClientWSModel response = apiOperationClientMiddleware.apiGetOperationClient(agentId, clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_OPERATION_CLIENT_NOTES, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationClientNotes(@RequestParam long agentId,
                                                        @RequestParam String operationId) {

        ApiOperationClientNoteWSModel response = apiOperationClientMiddleware.apiGetOperationClientNotes(agentId, operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_OPERATION_CLIENT_NOTE, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationClientNote(@RequestParam long agentId,
                                                       @RequestParam String operationId,
                                                       @RequestParam String noteId) {

        ApiOperationClientNoteWSModel response = apiOperationClientMiddleware.apiGetOperationClientNote(agentId, operationId, noteId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_CREATE_OPERATION_CLIENT_NOTE, method = RequestMethod.POST)
    public ResponseEntity<?> apiCreateOperationClientNote(@RequestParam long agentId,
                                                          @RequestParam String operationId,
                                                          @RequestParam String noteTitle,
                                                          @RequestParam String noteBody) {

        ApiOperationClientNoteWSModel response = apiOperationClientMiddleware.apiCreateOperationClientNote(agentId, operationId, noteTitle, noteBody);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_UPDATE_OPERATION_CLIENT_NOTE, method = RequestMethod.POST)
    public ResponseEntity<?> apiUpdateOperationClientNote(@RequestParam long agentId,
                                                          @RequestParam String operationId,
                                                          @RequestParam String noteId,
                                                          @RequestParam String noteTitle,
                                                          @RequestParam String noteBody) {

        ApiOperationClientNoteWSModel response = apiOperationClientMiddleware.apiUpdateOperationClientNote(agentId, operationId, noteId, noteTitle, noteBody);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_REMOVE_OPERATION_CLIENT_NOTE, method = RequestMethod.POST)
    public ResponseEntity<?> apiRemoveOperationClientNote(@RequestParam long agentId,
                                                          @RequestParam String operationId,
                                                          @RequestParam String noteId) {

        ApiOperationClientNoteWSModel response = apiOperationClientMiddleware.apiRemoveOperationClientNote(agentId, operationId, noteId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_CLIENT_INTELS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationClientIntels(@RequestParam long agentId,
                                                         @RequestParam long clientId) {

        ApiOperationClientIntelWSModel response = apiOperationClientMiddleware.apiGetOperationClientIntels(agentId, clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_OPERATION_CLIENT_INTEL, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationClientIntel(@RequestParam long agentId,
                                                        @RequestParam long clientId) {

        ApiOperationClientIntelWSModel response = apiOperationClientMiddleware.apiGetOperationClientIntel(agentId, clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

}