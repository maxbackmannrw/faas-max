package com.faas.core.api.middleware.operation.manager.details;

import com.faas.core.api.framework.operation.manager.details.ApiOperationManagerDetailsFramework;
import com.faas.core.api.model.ws.operation.manager.details.*;
import com.faas.core.api.model.ws.operation.manager.details.dto.ApiOperationClientWSDTO;
import com.faas.core.api.model.ws.operation.manager.details.dto.ApiOperationCampaignWSDTO;
import com.faas.core.api.model.ws.operation.manager.details.dto.ApiOperationDetailsWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.data.db.campaign.content.dao.CampaignScriptDAO;
import com.faas.core.data.db.client.details.dao.ClientNoteDAO;
import com.faas.core.misc.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApiOperationManagerDetailsMiddleware {


    @Autowired
    ApiOperationManagerDetailsFramework apiOperationManagerDetailsFramework;


    public ApiOperationDetailsWSModel apiGetOperationDetails(long agentId, String operationId) {

        ApiOperationDetailsWSModel response = new ApiOperationDetailsWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationDetailsWSDTO operationDetailsWSDTO = apiOperationManagerDetailsFramework.apiGetOperationDetailsService(agentId,operationId);
        if (operationDetailsWSDTO != null) {
            response.setOperationDetails(operationDetailsWSDTO);
        }

        general.setOperation("apiGetOperationDetails");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationCampaignWSModel apiGetOperationCampaign(long agentId, String campaignId) {

        ApiOperationCampaignWSModel response = new ApiOperationCampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationCampaignWSDTO operationCampaign = apiOperationManagerDetailsFramework.apiGetOperationCampaignService(agentId,campaignId);
        if (operationCampaign != null) {
            response.setCampaign(operationCampaign);
        }

        general.setOperation("apiGetOperationCampaign");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationScriptWSModel apiGetOperationCampaignScripts(long agentId, String campaignId) {

        ApiOperationScriptWSModel response = new ApiOperationScriptWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<CampaignScriptDAO> operationScripts = apiOperationManagerDetailsFramework.apiGetOperationCampaignScriptsService(agentId, campaignId);
        if (operationScripts != null) {
            response.setOperationScripts(operationScripts);
        }

        general.setOperation("apiGetOperationCampaignScripts");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationClientWSModel apiGetOperationClient(long agentId, long clientId) {

        ApiOperationClientWSModel response = new ApiOperationClientWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationClientWSDTO operationClientWSDTO = apiOperationManagerDetailsFramework.apiGetOperationClientService(agentId, clientId);
        if (operationClientWSDTO != null) {
            response.setOperationClient(operationClientWSDTO);
        }

        general.setOperation("apiGetOperationClient");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationNoteWSModel apiGetOperationNotes(long agentId, String operationId) {

        ApiOperationNoteWSModel response = new ApiOperationNoteWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ClientNoteDAO> operationNotes = apiOperationManagerDetailsFramework.apiGetOperationNotesService(agentId, operationId);
        if (operationNotes != null) {
            response.setOperationNotes(operationNotes);
        }

        general.setOperation("apiGetOperationNotes");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationNoteWSModel apiGetOperationNote(long agentId, String operationId, String noteId) {

        ApiOperationNoteWSModel response = new ApiOperationNoteWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientNoteDAO> operationNotes = new ArrayList<>();

        ClientNoteDAO operationNote = apiOperationManagerDetailsFramework.apiGetOperationNoteService(agentId, operationId, noteId);
        if (operationNote != null) {
            operationNotes.add(operationNote);
        }

        response.setOperationNotes(operationNotes);
        general.setOperation("apiGetOperationNote");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationNoteWSModel apiCreateOperationNote(long agentId, String operationId, String noteTitle, String noteBody) {

        ApiOperationNoteWSModel response = new ApiOperationNoteWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientNoteDAO> operationNotes = new ArrayList<>();

        ClientNoteDAO operationNote = apiOperationManagerDetailsFramework.apiCreateOperationNoteService(agentId, operationId, noteTitle, noteBody);
        if (operationNote != null) {
            operationNotes.add(operationNote);
        }

        response.setOperationNotes(operationNotes);
        general.setOperation("apiCreateOperationNote");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationNoteWSModel apiUpdateOperationNote(long agentId, String operationId, String noteId, String noteTitle, String noteBody) {

        ApiOperationNoteWSModel response = new ApiOperationNoteWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientNoteDAO> operationNotes = new ArrayList<>();

        ClientNoteDAO operationNote = apiOperationManagerDetailsFramework.apiUpdateOperationNoteService(agentId, operationId, noteId, noteTitle, noteBody);
        if (operationNote != null) {
            operationNotes.add(operationNote);
        }

        response.setOperationNotes(operationNotes);
        general.setOperation("apiUpdateOperationNote");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationNoteWSModel apiRemoveOperationNote(long agentId, String operationId, String noteId) {

        ApiOperationNoteWSModel response = new ApiOperationNoteWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientNoteDAO> operationNotes = new ArrayList<>();

        ClientNoteDAO operationNote = apiOperationManagerDetailsFramework.apiRemoveOperationNoteService(agentId, operationId, noteId);
        if (operationNote != null) {
            operationNotes.add(operationNote);
        }

        response.setOperationNotes(operationNotes);
        general.setOperation("apiRemoveOperationNote");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }





}