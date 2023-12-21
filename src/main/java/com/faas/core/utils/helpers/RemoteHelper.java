package com.faas.core.utils.helpers;

import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.db.process.content.dao.ProcessRemoteDAO;
import com.faas.core.base.model.db.remote.client.ClientRemoteDBModel;
import com.faas.core.base.model.db.remote.client.dao.ClientRemoteDAO;
import com.faas.core.base.model.db.remote.content.RemoteDBModel;
import com.faas.core.base.model.db.remote.content.dao.RemoteDataDAO;
import com.faas.core.base.model.ws.general.PaginationWSDTO;
import com.faas.core.base.model.ws.remote.client.dto.ClientRemoteListWSDTO;
import com.faas.core.base.model.ws.remote.client.dto.ClientRemoteWSDTO;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.remote.client.ClientRemoteRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class RemoteHelper {


    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientRemoteRepository clientRemoteRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    AppUtils appUtils;


    public ProcessRemoteDAO createProcessRemoteDAO(RemoteDBModel remoteDBModel){

        ProcessRemoteDAO processRemoteDAO = new ProcessRemoteDAO();
        processRemoteDAO.setId(appUtils.generateUUID());
        processRemoteDAO.setRemote(remoteDBModel.getRemote());
        processRemoteDAO.setRemoteDesc(remoteDBModel.getRemoteDesc());
        processRemoteDAO.setRemoteModel(remoteDBModel.getRemoteModel());
        processRemoteDAO.setRemoteVersion(remoteDBModel.getRemoteVersion());
        if (remoteDBModel.getRemoteDatas() != null) {
            processRemoteDAO.setRemoteDatas(remoteDBModel.getRemoteDatas());
        }else {
            processRemoteDAO.setRemoteDatas(new ArrayList<>());
        }
        if (remoteDBModel.getRemoteUrls() != null) {
            processRemoteDAO.setRemoteUrls(remoteDBModel.getRemoteUrls());
        }else {
            processRemoteDAO.setRemoteUrls(new ArrayList<>());
        }
        processRemoteDAO.setTypeId(remoteDBModel.getTypeId());
        processRemoteDAO.setRemoteType(remoteDBModel.getRemoteType());
        processRemoteDAO.setBaseType(remoteDBModel.getBaseType());
        processRemoteDAO.setRemoteState(AppConstant.ACTIVE_STATE);
        processRemoteDAO.setuDate(appUtils.getCurrentTimeStamp());
        processRemoteDAO.setcDate(appUtils.getCurrentTimeStamp());
        processRemoteDAO.setStatus(1);

        return processRemoteDAO;
    }

    public ProcessRemoteDAO createFlowProcessRemoteDAO(RemoteDBModel remoteDBModel){

        ProcessRemoteDAO processRemoteDAO = new ProcessRemoteDAO();
        processRemoteDAO.setId(appUtils.generateUUID());
        processRemoteDAO.setRemote(remoteDBModel.getRemote());
        processRemoteDAO.setRemoteDesc(remoteDBModel.getRemoteDesc());
        processRemoteDAO.setRemoteModel(remoteDBModel.getRemoteModel());
        processRemoteDAO.setRemoteVersion(remoteDBModel.getRemoteVersion());
        if (remoteDBModel.getRemoteDatas() != null) {
            processRemoteDAO.setRemoteDatas(remoteDBModel.getRemoteDatas());
        }else {
            processRemoteDAO.setRemoteDatas(new ArrayList<>());
        }
        if (remoteDBModel.getRemoteUrls() != null) {
            processRemoteDAO.setRemoteUrls(remoteDBModel.getRemoteUrls());
        }else {
            processRemoteDAO.setRemoteUrls(new ArrayList<>());
        }
        processRemoteDAO.setTypeId(remoteDBModel.getTypeId());
        processRemoteDAO.setRemoteType(remoteDBModel.getRemoteType());
        processRemoteDAO.setBaseType(remoteDBModel.getBaseType());
        processRemoteDAO.setRemoteState(AppConstant.ACTIVE_STATE);
        processRemoteDAO.setuDate(appUtils.getCurrentTimeStamp());
        processRemoteDAO.setcDate(appUtils.getCurrentTimeStamp());
        processRemoteDAO.setStatus(1);

        return processRemoteDAO;
    }

    public ProcessRemoteDAO createInquiryProcessRemoteDAO(RemoteDBModel remoteDBModel){

        ProcessRemoteDAO processRemoteDAO = new ProcessRemoteDAO();
        processRemoteDAO.setId(appUtils.generateUUID());
        processRemoteDAO.setRemote(remoteDBModel.getRemote());
        processRemoteDAO.setRemoteDesc(remoteDBModel.getRemoteDesc());
        processRemoteDAO.setRemoteModel(remoteDBModel.getRemoteModel());
        processRemoteDAO.setRemoteVersion(remoteDBModel.getRemoteVersion());

        if (remoteDBModel.getRemoteDatas() != null) {
            processRemoteDAO.setRemoteDatas(remoteDBModel.getRemoteDatas());
        }else {
            processRemoteDAO.setRemoteDatas(new ArrayList<>());
        }

        if (remoteDBModel.getRemoteUrls() != null) {
            processRemoteDAO.setRemoteUrls(remoteDBModel.getRemoteUrls());
        }else {
            processRemoteDAO.setRemoteUrls(new ArrayList<>());
        }

        processRemoteDAO.setTypeId(remoteDBModel.getTypeId());
        processRemoteDAO.setRemoteType(remoteDBModel.getRemoteType());
        processRemoteDAO.setBaseType(remoteDBModel.getBaseType());
        processRemoteDAO.setRemoteState(AppConstant.ACTIVE_STATE);
        processRemoteDAO.setuDate(appUtils.getCurrentTimeStamp());
        processRemoteDAO.setcDate(appUtils.getCurrentTimeStamp());
        processRemoteDAO.setStatus(1);

        return processRemoteDAO;
    }

    public ClientRemoteListWSDTO getRemoteListWSDTO(Page<ClientRemoteDBModel> remoteModelPage){

        ClientRemoteListWSDTO clientRemoteListWSDTO = new ClientRemoteListWSDTO();
        clientRemoteListWSDTO.setRemotes(getRemoteWSDTOS(remoteModelPage.getContent()));
        clientRemoteListWSDTO.setPagination(createRemotePagination(remoteModelPage));

        return clientRemoteListWSDTO;
    }


    public List<ClientRemoteWSDTO> getRemoteWSDTOS(List<ClientRemoteDBModel> clientRemoteDBModels){

        List<ClientRemoteWSDTO> clientRemoteWSDTOS = new ArrayList<>();
        for (ClientRemoteDBModel clientRemoteDBModel : clientRemoteDBModels) {
            ClientRemoteWSDTO clientRemoteWSDTO = getRemoteWSDTO(clientRemoteDBModel);
            if (clientRemoteWSDTO != null) {
                clientRemoteWSDTOS.add(clientRemoteWSDTO);
            }
        }
        return clientRemoteWSDTOS;
    }


    public ClientRemoteWSDTO getRemoteWSDTO(ClientRemoteDBModel clientRemoteDBModel){

        Optional<ClientDBModel> clientDBModel = clientRepository.findById(clientRemoteDBModel.getClientId());
        if (clientDBModel.isPresent()) {

            ClientRemoteWSDTO clientRemoteWSDTO = new ClientRemoteWSDTO();
            clientRemoteWSDTO.setClient(clientDBModel.get());
            clientRemoteWSDTO.setClientRemote(clientRemoteDBModel);

            return clientRemoteWSDTO;
        }
        return null;
    }


    public RemoteDataDAO createRemoteDataDAO(String dataId, String dataType, String value){

        RemoteDataDAO remoteDataDAO = new RemoteDataDAO();
        remoteDataDAO.setDataId(dataId);
        remoteDataDAO.setDataType(dataType);
        remoteDataDAO.setValue(value);
        remoteDataDAO.setcDate(appUtils.getCurrentTimeStamp());
        remoteDataDAO.setStatus(1);

        return remoteDataDAO;
    }


    public PaginationWSDTO createRemotePagination(Page<ClientRemoteDBModel> remoteModelPage){

        PaginationWSDTO remotePagination = new PaginationWSDTO();
        remotePagination.setPageSize(remoteModelPage.getPageable().getPageSize());
        remotePagination.setPageNumber(remoteModelPage.getPageable().getPageNumber());
        remotePagination.setTotalPage(remoteModelPage.getTotalPages());
        remotePagination.setTotalElements(remoteModelPage.getTotalElements());

        return remotePagination;
    }


}
