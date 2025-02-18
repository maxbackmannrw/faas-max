package com.faas.core.api.endpoint.controller.operation.manager.content;

import com.faas.core.api.middleware.operation.manager.content.ApiOperationManagerMiddleware;
import com.faas.core.api.model.ws.operation.content.ApiOperationWSModel;
import com.faas.core.api.model.ws.operation.manager.content.ApiOperationManagerWSModel;
import com.faas.core.api.model.ws.operation.manager.content.ApiOperationCampaignWSModel;
import com.faas.core.api.model.ws.operation.manager.content.ApiOperationClientWSModel;
import com.faas.core.api.model.ws.operation.manager.content.ApiOperationNoteWSModel;
import com.faas.core.api.model.ws.operation.manager.content.ApiOperationScriptWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/api/operation/manager/")
public class ApiOperationManagerController {


    @Autowired
    ApiOperationManagerMiddleware operationManagerMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_MANAGER, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationManager(@RequestParam long agentId,
                                                    @RequestParam String operationId) {

        ApiOperationManagerWSModel response = operationManagerMiddleware.apiGetOperationManager(agentId, operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_START_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> apiStartOperation(@RequestParam long agentId,
                                               @RequestParam String operationId) {

        ApiOperationWSModel response = operationManagerMiddleware.apiStartOperation(agentId, operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_COMPLETE_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> apiCompleteOperation(@RequestParam long agentId,
                                                  @RequestParam String operationId,
                                                  @RequestParam String operationResult) {

        ApiOperationWSModel response = operationManagerMiddleware.apiCompleteOperation(agentId, operationId, operationResult);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_SWITCH_OPERATIONS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetSwitchOperations(@RequestParam long agentId,
                                                    @RequestParam String operationId) {

        ApiOperationWSModel response = operationManagerMiddleware.apiGetSwitchOperations(agentId, operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_SWITCH_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> apiSwitchOperation(@RequestParam long agentId,
                                                @RequestParam String operationId,
                                                @RequestParam String selectedId) {

        ApiOperationWSModel response = operationManagerMiddleware.apiSwitchOperation(agentId, operationId, selectedId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_OPERATION_CAMPAIGN, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationCampaign(@RequestParam long agentId,
                                                     @RequestParam String campaignId) {

        ApiOperationCampaignWSModel response = operationManagerMiddleware.apiGetOperationCampaign(agentId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_OPERATION_SCRIPTS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationScripts(@RequestParam long agentId,
                                                    @RequestParam String campaignId) {

        ApiOperationScriptWSModel response = operationManagerMiddleware.apiGetOperationScripts(agentId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_OPERATION_CLIENT, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationClient(@RequestParam long agentId,
                                                   @RequestParam long clientId) {

        ApiOperationClientWSModel response = operationManagerMiddleware.apiGetOperationClient(agentId, clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_OPERATION_NOTES, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationNotes(@RequestParam long agentId,
                                                  @RequestParam String operationId) {

        ApiOperationNoteWSModel response = operationManagerMiddleware.apiGetOperationNotes(agentId, operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_OPERATION_NOTE, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationNote(@RequestParam long agentId,
                                                 @RequestParam String operationId,
                                                 @RequestParam String noteId) {

        ApiOperationNoteWSModel response = operationManagerMiddleware.apiGetOperationNote(agentId, operationId, noteId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_CREATE_OPERATION_NOTE, method = RequestMethod.POST)
    public ResponseEntity<?> apiCreateOperationNote(@RequestParam long agentId,
                                                    @RequestParam String operationId,
                                                    @RequestParam String noteTitle,
                                                    @RequestParam String noteBody) {

        ApiOperationNoteWSModel response = operationManagerMiddleware.apiCreateOperationNote(agentId, operationId, noteTitle, noteBody);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_UPDATE_OPERATION_NOTE, method = RequestMethod.POST)
    public ResponseEntity<?> apiUpdateOperationNote(@RequestParam long agentId,
                                                    @RequestParam String operationId,
                                                    @RequestParam String noteId,
                                                    @RequestParam String noteTitle,
                                                    @RequestParam String noteBody) {

        ApiOperationNoteWSModel response = operationManagerMiddleware.apiUpdateOperationNote(agentId, operationId, noteId, noteTitle, noteBody);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_REMOVE_OPERATION_NOTE, method = RequestMethod.POST)
    public ResponseEntity<?> apiRemoveOperationNote(@RequestParam long agentId,
                                                    @RequestParam String operationId,
                                                    @RequestParam String noteId) {

        ApiOperationNoteWSModel response = operationManagerMiddleware.apiRemoveOperationNote(agentId, operationId, noteId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
