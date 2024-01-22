package com.faas.core.api.endpoint.controller.operation.details.client;

import com.faas.core.api.middleware.operation.details.client.ApiOperationClientMiddleware;
import com.faas.core.api.model.ws.operation.details.client.ApiOperationClientWSModel;
import com.faas.core.api.model.ws.operation.details.client.ApiOperationNoteWSModel;
import com.faas.core.api.model.ws.operation.details.client.ApiOperationOSINTWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/api/operation/details/client/")
public class ApiOperationClientController {


    @Autowired
    ApiOperationClientMiddleware apiOperationClientMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_CLIENT, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationClient(@RequestParam long agentId,
                                                   @RequestParam long sessionId,
                                                   @RequestParam long clientId) {

        ApiOperationClientWSModel response = apiOperationClientMiddleware.apiGetOperationClient(agentId,sessionId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_NOTES, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationNotes(@RequestParam long agentId,
                                                  @RequestParam long clientId) {

        ApiOperationNoteWSModel response = apiOperationClientMiddleware.apiGetOperationNotes(agentId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_OPERATION_NOTE, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationNote(@RequestParam long agentId,
                                                 @RequestParam long sessionId,
                                                 @RequestParam long clientId,
                                                 @RequestParam long noteId) {

        ApiOperationNoteWSModel response = apiOperationClientMiddleware.apiGetOperationNote(agentId,sessionId,clientId,noteId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_CREATE_OPERATION_NOTE, method = RequestMethod.POST)
    public ResponseEntity<?> apiCreateOperationNote(@RequestParam long agentId,
                                                    @RequestParam long sessionId,
                                                    @RequestParam long clientId,
                                                    @RequestParam String noteTitle,
                                                    @RequestParam String noteText,
                                                    @RequestParam String noteAsset) {

        ApiOperationNoteWSModel response = apiOperationClientMiddleware.apiCreateOperationNote(agentId,sessionId,clientId,noteTitle,noteText,noteAsset);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_UPDATE_OPERATION_NOTE, method = RequestMethod.POST)
    public ResponseEntity<?> apiUpdateOperationNote(@RequestParam long agentId,
                                                    @RequestParam long sessionId,
                                                    @RequestParam long clientId,
                                                    @RequestParam long noteId,
                                                    @RequestParam String noteTitle,
                                                    @RequestParam String noteText,
                                                    @RequestParam String noteAsset) {

        ApiOperationNoteWSModel response = apiOperationClientMiddleware.apiUpdateOperationNote(agentId,sessionId,clientId,noteId,noteTitle,noteText,noteAsset);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_REMOVE_OPERATION_NOTE, method = RequestMethod.POST)
    public ResponseEntity<?> apiRemoveOperationNote(@RequestParam long agentId,
                                                    @RequestParam long sessionId,
                                                    @RequestParam long clientId,
                                                    @RequestParam long noteId) {

        ApiOperationNoteWSModel response = apiOperationClientMiddleware.apiRemoveOperationNote(agentId,sessionId,clientId,noteId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_OS_INTS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationOSINTs(@RequestParam long agentId,
                                                   @RequestParam long clientId) {

        ApiOperationOSINTWSModel response = apiOperationClientMiddleware.apiGetOperationOSINTs(agentId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_OPERATION_OS_INT, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationOSINT(@RequestParam long agentId,
                                                  @RequestParam long clientId) {

        ApiOperationOSINTWSModel response = apiOperationClientMiddleware.apiGetOperationOSINT(agentId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
