package com.faas.core.api.framework.operation.manager.content;

import com.faas.core.api.model.ws.operation.content.dto.ApiOperationWSDTO;
import com.faas.core.api.model.ws.operation.manager.content.dto.ApiOperationManagerWSDTO;
import com.faas.core.api.model.ws.operation.manager.content.dto.ApiOperationCampaignWSDTO;
import com.faas.core.api.model.ws.operation.manager.content.dto.ApiOperationClientWSDTO;
import com.faas.core.data.db.campaign.content.CampaignDBModel;
import com.faas.core.data.db.campaign.content.dao.CampaignScriptDAO;
import com.faas.core.data.db.client.content.ClientDBModel;
import com.faas.core.data.db.client.details.ClientDetailsDBModel;
import com.faas.core.data.db.client.details.dao.ClientNoteDAO;
import com.faas.core.data.db.operation.content.OperationDBModel;
import com.faas.core.data.db.user.content.UserDBModel;
import com.faas.core.data.repo.campaign.content.CampaignRepository;
import com.faas.core.data.repo.client.content.ClientRepository;
import com.faas.core.data.repo.client.details.ClientDetailsRepository;
import com.faas.core.data.repo.operation.content.OperationRepository;
import com.faas.core.data.repo.user.content.UserRepository;
import com.faas.core.misc.config.AppConstant;
import com.faas.core.misc.config.AppUtils;
import com.faas.core.misc.helpers.operation.content.OperationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ApiOperationManagerFramework {


    @Autowired
    OperationHelper operationHelper;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientDetailsRepository clientDetailsRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AppUtils appUtils;


    public ApiOperationManagerWSDTO apiGetOperationManagerService(long agentId, String operationId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId, agentId);
        if (!operationDBModels.isEmpty()) {
            return operationHelper.getApiOperationManagerWSDTO(operationDBModels.get(0));
        }
        return null;
    }

    public ApiOperationWSDTO apiStartOperationService(long agentId, String operationId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId, agentId);
        Optional<UserDBModel> agentModel = userRepository.findById(agentId);
        if (!operationDBModels.isEmpty() && agentModel.isPresent()){
            operationDBModels.get(0).setOperationState(AppConstant.ACTIVE_STATE);
            operationDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());

            return new ApiOperationWSDTO(operationRepository.save(operationDBModels.get(0)));
        }
        return null;
    }

    public ApiOperationWSDTO apiCompleteOperationService(long agentId, String operationId, String operationResult) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentIdAndOperationState(operationId, agentId, AppConstant.ACTIVE_STATE);
        return null;
    }

    public List<ApiOperationWSDTO> apiGetSwitchOperationsService(long agentId, String operationId) {

        List<ApiOperationWSDTO> operationWSDTOS = new ArrayList<>();
        List<OperationDBModel> operationDBModels = operationRepository.findByAgentIdAndOperationState(agentId, AppConstant.ACTIVE_STATE);
        for (OperationDBModel operationDBModel : operationDBModels) {
            if (!operationDBModel.getId().equalsIgnoreCase(operationId)) {
                operationWSDTOS.add(operationHelper.getApiOperationWSDTO(operationDBModel));
            }
        }
        return operationWSDTOS;
    }

    public ApiOperationWSDTO apiSwitchOperationService(long agentId, String operationId, String selectedId) {

        List<OperationDBModel> currentOperations = operationRepository.findByIdAndAgentId(operationId, agentId);
        List<OperationDBModel> selectedOperations = operationRepository.findByIdAndAgentId(selectedId, agentId);
        if (!currentOperations.isEmpty() && !selectedOperations.isEmpty() && selectedOperations.get(0).getOperationState().equalsIgnoreCase(AppConstant.ACTIVE_STATE)) {
            return operationHelper.getApiOperationWSDTO(selectedOperations.get(0));
        }
        return null;
    }


    public ApiOperationCampaignWSDTO apiGetOperationCampaignService(long agentId, String campaignId) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignDBModel.isPresent()) {
            return operationHelper.getApiOperationCampaignWSDTO(campaignDBModel.get());
        }
        return null;
    }

    public List<CampaignScriptDAO> apiGetOperationScriptsService(long agentId, String campaignId) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignDBModel.isPresent() && campaignDBModel.get().getCampaignScripts() != null) {
            return campaignDBModel.get().getCampaignScripts();
        }
        return null;
    }


    public ApiOperationClientWSDTO apiGetOperationClientService(long agentId, long clientId) {

        if (operationRepository.existsByClientIdAndAgentId(clientId, agentId)) {
            Optional<ClientDBModel> clientDBModel = clientRepository.findById(clientId);
            List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(clientId);
            if (clientDBModel.isPresent() && !clientDetailsDBModels.isEmpty()) {
                ApiOperationClientWSDTO clientWSDTO = new ApiOperationClientWSDTO();
                clientWSDTO.setClient(clientDBModel.get());
                clientWSDTO.setClientDetails(clientDetailsDBModels.get(0));

                return clientWSDTO;
            }
        }
        return null;
    }

    public List<ClientNoteDAO> apiGetOperationNotesService(long agentId, String operationId) {

        List<ClientNoteDAO> operationNotes = new ArrayList<>();
        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId, agentId);
        if (!operationDBModels.isEmpty()) {
            List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(operationDBModels.get(0).getClientId());
            if (!clientDetailsDBModels.isEmpty() && clientDetailsDBModels.get(0).getClientNotes() != null) {
                operationNotes.addAll(clientDetailsDBModels.get(0).getClientNotes());
            }
        }
        return operationNotes;
    }

    public ClientNoteDAO apiGetOperationNoteService(long agentId, String operationId, String noteId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId, agentId);
        if (!operationDBModels.isEmpty()) {
            List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(operationDBModels.get(0).getClientId());
            if (!clientDetailsDBModels.isEmpty() && clientDetailsDBModels.get(0).getClientNotes() != null) {
                for (int i = 0; i < clientDetailsDBModels.get(0).getClientNotes().size(); i++) {
                    if (clientDetailsDBModels.get(0).getClientNotes().get(i).getId().equalsIgnoreCase(noteId)) {
                        return clientDetailsDBModels.get(0).getClientNotes().get(i);
                    }
                }
            }
        }
        return null;
    }

    public ClientNoteDAO apiCreateOperationNoteService(long agentId, String operationId, String noteTitle, String noteBody) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId, agentId);
        if (!operationDBModels.isEmpty()) {
            List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(operationDBModels.get(0).getClientId());
            if (!clientDetailsDBModels.isEmpty()) {

                ClientNoteDAO operationNote = new ClientNoteDAO();
                operationNote.setId(appUtils.generateUUID());
                operationNote.setCreatorId(agentId);
                operationNote.setNoteTitle(noteTitle);
                operationNote.setNoteBody(noteBody);
                operationNote.setuDate(appUtils.getCurrentTimeStamp());
                operationNote.setcDate(appUtils.getCurrentTimeStamp());
                operationNote.setStatus(1);

                clientDetailsDBModels.get(0).getClientNotes().add(operationNote);
                clientDetailsDBModels.get(0).setClientNotes(clientDetailsDBModels.get(0).getClientNotes());
                clientDetailsRepository.save(clientDetailsDBModels.get(0));

                return operationNote;
            }
        }
        return null;
    }

    public ClientNoteDAO apiUpdateOperationNoteService(long agentId, String operationId, String noteId, String noteTitle, String noteBody) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId, agentId);
        if (!operationDBModels.isEmpty()) {
            List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(operationDBModels.get(0).getClientId());
            if (!clientDetailsDBModels.isEmpty() && clientDetailsDBModels.get(0).getClientNotes() != null) {
                for (int i = 0; i < clientDetailsDBModels.get(0).getClientNotes().size(); i++) {
                    if (clientDetailsDBModels.get(0).getClientNotes().get(i).getId().equalsIgnoreCase(noteId)) {

                        clientDetailsDBModels.get(0).getClientNotes().get(i).setNoteTitle(noteTitle);
                        clientDetailsDBModels.get(0).getClientNotes().get(i).setNoteBody(noteBody);
                        clientDetailsDBModels.get(0).getClientNotes().get(i).setuDate(appUtils.getCurrentTimeStamp());

                        clientDetailsDBModels.get(0).getClientNotes().get(i).setuDate(appUtils.getCurrentTimeStamp());
                        clientDetailsDBModels.get(0).setClientNotes(clientDetailsDBModels.get(0).getClientNotes());
                        clientDetailsRepository.save(clientDetailsDBModels.get(0));

                        return clientDetailsDBModels.get(0).getClientNotes().get(i);
                    }
                }
            }
        }
        return null;
    }

    public ClientNoteDAO apiRemoveOperationNoteService(long agentId, String operationId, String noteId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId, agentId);
        if (!operationDBModels.isEmpty()) {
            List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(operationDBModels.get(0).getClientId());
            if (!clientDetailsDBModels.isEmpty() && clientDetailsDBModels.get(0).getClientNotes() != null) {
                for (int i = 0; i < clientDetailsDBModels.get(0).getClientNotes().size(); i++) {
                    if (clientDetailsDBModels.get(0).getClientNotes().get(i).getId().equalsIgnoreCase(noteId)) {

                        ClientNoteDAO operationNote = clientDetailsDBModels.get(0).getClientNotes().get(i);
                        clientDetailsDBModels.get(0).getClientNotes().remove(operationNote);
                        clientDetailsDBModels.get(0).setClientNotes(clientDetailsDBModels.get(0).getClientNotes());
                        clientDetailsDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
                        clientDetailsRepository.save(clientDetailsDBModels.get(0));

                        return operationNote;
                    }
                }
            }
        }
        return null;
    }

}
