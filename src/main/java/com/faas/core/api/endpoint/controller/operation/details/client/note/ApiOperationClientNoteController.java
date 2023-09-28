package com.faas.core.api.endpoint.controller.operation.details.client.note;

import com.faas.core.api.middleware.operation.details.client.note.ApiOperationClientNoteMiddleware;
import com.faas.core.api.model.ws.client.details.ApiClientNoteWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/api/operation/details/client/note/")
public class ApiOperationClientNoteController {


    @Autowired
    ApiOperationClientNoteMiddleware apiOperationClientNoteMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_CLIENT_NOTES, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetClientNotes(@RequestParam long agentId,
                                               @RequestParam long clientId) {

        ApiClientNoteWSModel response = apiOperationClientNoteMiddleware.apiGetClientNotes(agentId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_CLIENT_NOTE, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetClientNote(@RequestParam long agentId,
                                              @RequestParam long sessionId,
                                              @RequestParam long clientId,
                                              @RequestParam long noteId) {

        ApiClientNoteWSModel response = apiOperationClientNoteMiddleware.apiGetClientNote(agentId,sessionId,clientId,noteId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_CREATE_CLIENT_NOTE, method = RequestMethod.POST)
    public ResponseEntity<?> apiCreateClientNote(@RequestParam long agentId,
                                                 @RequestParam long sessionId,
                                                 @RequestParam long clientId,
                                                 @RequestParam String noteTitle,
                                                 @RequestParam String noteText,
                                                 @RequestParam String noteAsset) {

        ApiClientNoteWSModel response = apiOperationClientNoteMiddleware.apiCreateClientNote(agentId,sessionId,clientId,noteTitle,noteText,noteAsset);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_UPDATE_CLIENT_NOTE, method = RequestMethod.POST)
    public ResponseEntity<?> apiUpdateClientNote(@RequestParam long agentId,
                                                 @RequestParam long sessionId,
                                                 @RequestParam long clientId,
                                                 @RequestParam long noteId,
                                                 @RequestParam String noteTitle,
                                                 @RequestParam String noteText,
                                                 @RequestParam String noteAsset) {

        ApiClientNoteWSModel response = apiOperationClientNoteMiddleware.apiUpdateClientNote(agentId,sessionId,clientId,noteId,noteTitle,noteText,noteAsset);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_REMOVE_CLIENT_NOTE, method = RequestMethod.POST)
    public ResponseEntity<?> apiRemoveClientNote(@RequestParam long agentId,
                                                 @RequestParam long sessionId,
                                                 @RequestParam long clientId,
                                                 @RequestParam long noteId) {

        ApiClientNoteWSModel response = apiOperationClientNoteMiddleware.apiRemoveClientNote(agentId,sessionId,clientId,noteId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
