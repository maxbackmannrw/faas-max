package com.faas.core.api.framework.operation.manager.client;

import com.faas.core.api.model.ws.operation.manager.client.dto.ApiOperationClientWSDTO;
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

    public List<ClientNoteDAO> apiGetOperationClientNotesService(long agentId, String operationId) {

        List<ClientNoteDAO> operationNotes = new ArrayList<>();
        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId, agentId);
        if (!operationDBModels.isEmpty()) {
            List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(operationDBModels.get(0).getClientId());
            if (!clientDetailsDBModels.isEmpty() && clientDetailsDBModels.get(0).getClientNotes() != null) {
                for (int i = 0; i < clientDetailsDBModels.get(0).getClientNotes().size(); i++) {
                    operationNotes.add(clientDetailsDBModels.get(0).getClientNotes().get(i));
                }
            }
        }
        return operationNotes;
    }

    public ClientNoteDAO apiGetOperationClientNoteService(long agentId, String operationId, String noteId) {

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

    public ClientNoteDAO apiCreateOperationClientNoteService(long agentId, String operationId, String noteTitle, String noteBody) {

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

    public ClientNoteDAO apiUpdateOperationClientNoteService(long agentId, String operationId, String noteId, String noteTitle, String noteBody) {

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

    public ClientNoteDAO apiRemoveOperationClientNoteService(long agentId, String operationId, String noteId) {

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
