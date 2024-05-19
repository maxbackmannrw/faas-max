package com.faas.core.api.framework.operation.details.note;

import com.faas.core.api.model.ws.operation.details.note.dto.ApiOperationNoteWSDTO;
import com.faas.core.base.model.db.client.details.ClientDetailsDBModel;
import com.faas.core.base.model.db.client.details.dao.ClientNoteDAO;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.client.details.ClientDetailsRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ApiOperationNoteFramework {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientDetailsRepository clientDetailsRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    AppUtils appUtils;


    public List<ApiOperationNoteWSDTO> apiGetOperationNotesService(long agentId,String operationId) {

        List<ApiOperationNoteWSDTO> operationNoteWSDTOS = new ArrayList<>();
        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId,agentId);
        if (!operationDBModels.isEmpty()){
            List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(operationDBModels.get(0).getClientId());
            if (!clientDetailsDBModels.isEmpty() && clientDetailsDBModels.get(0).getClientNotes() != null){
                for (int i=0;i<clientDetailsDBModels.get(0).getClientNotes().size();i++){
                    operationNoteWSDTOS.add(new ApiOperationNoteWSDTO(clientDetailsDBModels.get(0).getClientNotes().get(i)));
                }
            }
        }
        return operationNoteWSDTOS;
    }

    public ApiOperationNoteWSDTO apiGetOperationNoteService(long agentId,String operationId,String noteId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId,agentId);
        if (!operationDBModels.isEmpty()){
            List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(operationDBModels.get(0).getClientId());
            if (!clientDetailsDBModels.isEmpty() && clientDetailsDBModels.get(0).getClientNotes() != null){
                for (int i=0;i<clientDetailsDBModels.get(0).getClientNotes().size();i++){
                   if (clientDetailsDBModels.get(0).getClientNotes().get(i).getId().equalsIgnoreCase(noteId)){
                       return new ApiOperationNoteWSDTO(clientDetailsDBModels.get(0).getClientNotes().get(i));
                   }
                }
            }
        }
        return null;
    }

    public ApiOperationNoteWSDTO apiCreateOperationNoteService(long agentId,String operationId,String noteTitle,String noteText,String noteAsset) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId,agentId);
        if (!operationDBModels.isEmpty()){
            List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(operationDBModels.get(0).getClientId());
            if (!clientDetailsDBModels.isEmpty()){

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

    public ApiOperationNoteWSDTO apiUpdateOperationNoteService(long agentId,String operationId,String noteId,String noteTitle,String noteText, String noteAsset) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId,agentId);
        if (!operationDBModels.isEmpty()){
            List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(operationDBModels.get(0).getClientId());
            if (!clientDetailsDBModels.isEmpty() && clientDetailsDBModels.get(0).getClientNotes() != null){
                for (int i=0;i<clientDetailsDBModels.get(0).getClientNotes().size();i++){
                    if (clientDetailsDBModels.get(0).getClientNotes().get(i).getId().equalsIgnoreCase(noteId)){

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

    public ApiOperationNoteWSDTO apiRemoveOperationNoteService(long agentId,String operationId,String noteId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId,agentId);
        if (!operationDBModels.isEmpty()){
            List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(operationDBModels.get(0).getClientId());
            if (!clientDetailsDBModels.isEmpty() && clientDetailsDBModels.get(0).getClientNotes() != null){
                for (int i=0;i<clientDetailsDBModels.get(0).getClientNotes().size();i++){
                    if (clientDetailsDBModels.get(0).getClientNotes().get(i).getId().equalsIgnoreCase(noteId)){

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
