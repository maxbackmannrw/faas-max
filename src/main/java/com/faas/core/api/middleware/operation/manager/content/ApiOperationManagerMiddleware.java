package com.faas.core.api.middleware.operation.manager.content;

import com.faas.core.api.framework.operation.manager.content.ApiOperationManagerFramework;
import com.faas.core.api.model.ws.operation.content.ApiOperationWSModel;
import com.faas.core.api.model.ws.operation.content.dto.ApiOperationWSDTO;
import com.faas.core.api.model.ws.operation.manager.content.ApiOperationManagerWSModel;
import com.faas.core.api.model.ws.operation.manager.content.dto.ApiOperationManagerWSDTO;
import com.faas.core.api.model.ws.operation.manager.content.ApiOperationCampaignWSModel;
import com.faas.core.api.model.ws.operation.manager.content.ApiOperationClientWSModel;
import com.faas.core.api.model.ws.operation.manager.content.ApiOperationNoteWSModel;
import com.faas.core.api.model.ws.operation.manager.content.ApiOperationScriptWSModel;
import com.faas.core.api.model.ws.operation.manager.content.dto.ApiOperationCampaignWSDTO;
import com.faas.core.api.model.ws.operation.manager.content.dto.ApiOperationClientWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.data.db.campaign.content.dao.CampaignScriptDAO;
import com.faas.core.data.db.client.details.dao.ClientNoteDAO;
import com.faas.core.misc.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ApiOperationManagerMiddleware {


    @Autowired
    ApiOperationManagerFramework apiOperationManagerFramework;


    public ApiOperationManagerWSModel apiGetOperationManager(long agentId, String operationId) {

        ApiOperationManagerWSModel response = new ApiOperationManagerWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationManagerWSDTO operationManagerWSDTO = apiOperationManagerFramework.apiGetOperationManagerService(agentId, operationId);
        if (operationManagerWSDTO != null) {
            response.setOperationManager(operationManagerWSDTO);
        }

        general.setOperation("apiGetOperationManager");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationWSModel apiStartOperation(long agentId, String operationId) {

        ApiOperationWSModel response = new ApiOperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationWSDTO> operationWSDTOS = new ArrayList<>();

        ApiOperationWSDTO operationWSDTO = apiOperationManagerFramework.apiStartOperationService(agentId, operationId);
        if (operationWSDTO != null) {
            operationWSDTOS.add(operationWSDTO);
        }

        response.setOperations(operationWSDTOS);
        general.setOperation("apiStartOperation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationWSModel apiCompleteOperation(long agentId, String operationId, String operationResult) {

        ApiOperationWSModel response = new ApiOperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationWSDTO> operationWSDTOS = new ArrayList<>();

        ApiOperationWSDTO operationWSDTO = apiOperationManagerFramework.apiCompleteOperationService(agentId, operationId, operationResult);
        if (operationWSDTO != null) {
            operationWSDTOS.add(operationWSDTO);
        }

        response.setOperations(operationWSDTOS);
        general.setOperation("apiCompleteOperation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationWSModel apiGetSwitchOperations(long agentId, String operationId) {

        ApiOperationWSModel response = new ApiOperationWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiOperationWSDTO> operationWSDTOS = apiOperationManagerFramework.apiGetSwitchOperationsService(agentId, operationId);
        if (operationWSDTOS != null) {
            response.setOperations(operationWSDTOS);
        }

        general.setOperation("apiGetSwitchOperations");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationWSModel apiSwitchOperation(long agentId, String operationId, String selectedId) {

        ApiOperationWSModel response = new ApiOperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationWSDTO> operationWSDTOS = new ArrayList<>();

        ApiOperationWSDTO operationWSDTO = apiOperationManagerFramework.apiSwitchOperationService(agentId, operationId, selectedId);
        if (operationWSDTO != null) {
            operationWSDTOS.add(operationWSDTO);
        }

        response.setOperations(operationWSDTOS);
        general.setOperation("apiSwitchOperation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationCampaignWSModel apiGetOperationCampaign(long agentId, String campaignId) {

        ApiOperationCampaignWSModel response = new ApiOperationCampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationCampaignWSDTO operationCampaign = apiOperationManagerFramework.apiGetOperationCampaignService(agentId,campaignId);
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

    public ApiOperationScriptWSModel apiGetOperationScripts(long agentId, String campaignId) {

        ApiOperationScriptWSModel response = new ApiOperationScriptWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<CampaignScriptDAO> operationScripts = apiOperationManagerFramework.apiGetOperationScriptsService(agentId, campaignId);
        if (operationScripts != null) {
            response.setOperationScripts(operationScripts);
        }

        general.setOperation("apiGetOperationScripts");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationClientWSModel apiGetOperationClient(long agentId, long clientId) {

        ApiOperationClientWSModel response = new ApiOperationClientWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationClientWSDTO operationClientWSDTO = apiOperationManagerFramework.apiGetOperationClientService(agentId, clientId);
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

        List<ClientNoteDAO> operationNotes = apiOperationManagerFramework.apiGetOperationNotesService(agentId, operationId);
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

        ClientNoteDAO operationNote = apiOperationManagerFramework.apiGetOperationNoteService(agentId, operationId, noteId);
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

        ClientNoteDAO operationNote = apiOperationManagerFramework.apiCreateOperationNoteService(agentId, operationId, noteTitle, noteBody);
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

        ClientNoteDAO operationNote = apiOperationManagerFramework.apiUpdateOperationNoteService(agentId, operationId, noteId, noteTitle, noteBody);
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

        ClientNoteDAO operationNote = apiOperationManagerFramework.apiRemoveOperationNoteService(agentId, operationId, noteId);
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