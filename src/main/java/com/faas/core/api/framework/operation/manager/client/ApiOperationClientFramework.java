package com.faas.core.api.framework.operation.manager.client;

import com.faas.core.api.model.ws.operation.manager.client.dto.ApiOperationClientWSDTO;
import com.faas.core.api.model.ws.operation.manager.client.dto.ApiOperationNoteWSDTO;
import com.faas.core.data.db.client.content.ClientDBModel;
import com.faas.core.data.db.client.details.ClientDetailsDBModel;
import com.faas.core.data.db.client.details.dao.ClientNoteDAO;
import com.faas.core.data.db.operation.content.OperationDBModel;
import com.faas.core.data.repo.client.content.ClientRepository;
import com.faas.core.data.repo.client.details.ClientDetailsRepository;
import com.faas.core.data.repo.operation.content.OperationRepository;
import com.faas.core.misc.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ApiOperationClientFramework {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientDetailsRepository clientDetailsRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    AppUtils appUtils;


    public ApiOperationClientWSDTO apiGetClientService(long agentId, long clientId) {

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

    public List<ApiOperationNoteWSDTO> apiGetOperationNotesService(long agentId, String operationId) {

        List<ApiOperationNoteWSDTO> operationNoteWSDTOS = new ArrayList<>();
        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId, agentId);
        if (!operationDBModels.isEmpty()) {
            List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(operationDBModels.get(0).getClientId());
            if (!clientDetailsDBModels.isEmpty() && clientDetailsDBModels.get(0).getClientNotes() != null) {
                for (int i = 0; i < clientDetailsDBModels.get(0).getClientNotes().size(); i++) {
                    operationNoteWSDTOS.add(new ApiOperationNoteWSDTO(clientDetailsDBModels.get(0).getClientNotes().get(i)));
                }
            }
        }
        return operationNoteWSDTOS;
    }

    public ApiOperationNoteWSDTO apiGetOperationNoteService(long agentId, String operationId, String noteId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId, agentId);
        if (!operationDBModels.isEmpty()) {
            List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(operationDBModels.get(0).getClientId());
            if (!clientDetailsDBModels.isEmpty() && clientDetailsDBModels.get(0).getClientNotes() != null) {
                for (int i = 0; i < clientDetailsDBModels.get(0).getClientNotes().size(); i++) {
                    if (clientDetailsDBModels.get(0).getClientNotes().get(i).getId().equalsIgnoreCase(noteId)) {
                        return new ApiOperationNoteWSDTO(clientDetailsDBModels.get(0).getClientNotes().get(i));
                    }
                }
            }
        }
        return null;
    }

    public ApiOperationNoteWSDTO apiCreateOperationNoteService(long agentId, String operationId, String noteTitle, String noteText, String noteAsset) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId, agentId);
        if (!operationDBModels.isEmpty()) {
            List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(operationDBModels.get(0).getClientId());
            if (!clientDetailsDBModels.isEmpty()) {

                ClientNoteDAO operationNote = new ClientNoteDAO();
                operationNote.setId(appUtils.generateUUID());
                operationNote.setCreatorId(agentId);
                operationNote.setNoteTitle(noteTitle);
                operationNote.setNoteText(noteText);
                operationNote.setNoteAsset(noteAsset);
                operationNote.setuDate(appUtils.getCurrentTimeStamp());
                operationNote.setcDate(appUtils.getCurrentTimeStamp());
                operationNote.setStatus(1);

                clientDetailsDBModels.get(0).getClientNotes().add(operationNote);
                clientDetailsDBModels.get(0).setClientNotes(clientDetailsDBModels.get(0).getClientNotes());
                clientDetailsRepository.save(clientDetailsDBModels.get(0));

                return new ApiOperationNoteWSDTO(operationNote);
            }
        }
        return null;
    }

    public ApiOperationNoteWSDTO apiUpdateOperationNoteService(long agentId, String operationId, String noteId, String noteTitle, String noteText, String noteAsset) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId, agentId);
        if (!operationDBModels.isEmpty()) {
            List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(operationDBModels.get(0).getClientId());
            if (!clientDetailsDBModels.isEmpty() && clientDetailsDBModels.get(0).getClientNotes() != null) {
                for (int i = 0; i < clientDetailsDBModels.get(0).getClientNotes().size(); i++) {
                    if (clientDetailsDBModels.get(0).getClientNotes().get(i).getId().equalsIgnoreCase(noteId)) {

                        clientDetailsDBModels.get(0).getClientNotes().get(i).setNoteTitle(noteTitle);
                        clientDetailsDBModels.get(0).getClientNotes().get(i).setNoteText(noteText);
                        clientDetailsDBModels.get(0).getClientNotes().get(i).setNoteAsset(noteAsset);

                        clientDetailsDBModels.get(0).getClientNotes().get(i).setuDate(appUtils.getCurrentTimeStamp());
                        clientDetailsDBModels.get(0).setClientNotes(clientDetailsDBModels.get(0).getClientNotes());
                        clientDetailsRepository.save(clientDetailsDBModels.get(0));

                        return new ApiOperationNoteWSDTO(clientDetailsDBModels.get(0).getClientNotes().get(i));
                    }
                }
            }
        }
        return null;
    }

    public ApiOperationNoteWSDTO apiRemoveOperationNoteService(long agentId, String operationId, String noteId) {

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

                        return new ApiOperationNoteWSDTO(operationNote);
                    }
                }
            }
        }
        return null;
    }


}
