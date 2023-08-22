package com.faas.core.api.endpoint.controller.operation.details.client.note;

import com.faas.core.api.middleware.operation.details.client.note.ApiClientNoteMiddleware;
import com.faas.core.api.model.ws.operation.details.client.note.ApiClientNoteWSModel;
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
public class ApiClientNoteController {


    @Autowired
    ApiClientNoteMiddleware apiClientNoteMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_CLIENT_NOTES, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetClientNotes(@RequestParam long agentId,
                                               @RequestParam long clientId) {

        ApiClientNoteWSModel response = apiClientNoteMiddleware.apiGetClientNotes(agentId,clientId);

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

        ApiClientNoteWSModel response = apiClientNoteMiddleware.apiGetClientNote(agentId,sessionId,clientId,noteId);

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

        ApiClientNoteWSModel response = apiClientNoteMiddleware.apiCreateClientNote(agentId,sessionId,clientId,noteTitle,noteText,noteAsset);

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

        ApiClientNoteWSModel response = apiClientNoteMiddleware.apiUpdateClientNote(agentId,sessionId,clientId,noteId,noteTitle,noteText,noteAsset);

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

        ApiClientNoteWSModel response = apiClientNoteMiddleware.apiRemoveClientNote(agentId,sessionId,clientId,noteId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
