package com.faas.core.utils.helpers;

import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.process.content.dao.ProcessRemoteDAO;
import com.faas.core.base.model.db.remote.app.RemoteAppDBModel;
import com.faas.core.base.model.db.remote.content.RemoteDBModel;
import com.faas.core.base.model.db.remote.content.dao.RemoteDataDAO;
import com.faas.core.base.model.ws.general.PaginationWSDTO;
import com.faas.core.base.model.ws.remote.app.dto.RemoteAppListWSDTO;
import com.faas.core.base.model.ws.remote.app.dto.RemoteAppWSDTO;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.remote.app.RemoteAppRepository;
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
    RemoteAppRepository remoteAppRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    AppUtils appUtils;


    public ProcessRemoteDAO createProcessRemoteDAO(RemoteDBModel remoteDBModel){

        ProcessRemoteDAO processRemoteDAO = new ProcessRemoteDAO();
        processRemoteDAO.setId(appUtils.generateUUID());
        processRemoteDAO.setRemote(remoteDBModel.getRemote());
        processRemoteDAO.setRemoteDesc(remoteDBModel.getRemoteDesc());
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
        processRemoteDAO.setuDate(appUtils.getCurrentTimeStamp());
        processRemoteDAO.setcDate(appUtils.getCurrentTimeStamp());
        processRemoteDAO.setStatus(1);

        return processRemoteDAO;
    }

    public RemoteAppListWSDTO getRemoteListWSDTO(Page<RemoteAppDBModel> remoteModelPage){

        RemoteAppListWSDTO remoteAppListWSDTO = new RemoteAppListWSDTO();
        remoteAppListWSDTO.setRemoteApps(getRemoteWSDTOS(remoteModelPage.getContent()));
        remoteAppListWSDTO.setPagination(createRemotePagination(remoteModelPage));

        return remoteAppListWSDTO;
    }


    public List<RemoteAppWSDTO> getRemoteWSDTOS(List<RemoteAppDBModel> remoteAppDBModels){

        List<RemoteAppWSDTO> remoteAppWSDTOS = new ArrayList<>();
        for (RemoteAppDBModel remoteAppDBModel : remoteAppDBModels) {
            RemoteAppWSDTO remoteAppWSDTO = getRemoteWSDTO(remoteAppDBModel);
            if (remoteAppWSDTO != null) {
                remoteAppWSDTOS.add(remoteAppWSDTO);
            }
        }
        return remoteAppWSDTOS;
    }


    public RemoteAppWSDTO getRemoteWSDTO(RemoteAppDBModel remoteAppDBModel){

        Optional<ClientDBModel> clientDBModel = clientRepository.findById(remoteAppDBModel.getClientId());
        if (clientDBModel.isPresent()) {

            RemoteAppWSDTO remoteAppWSDTO = new RemoteAppWSDTO();
            remoteAppWSDTO.setClient(clientDBModel.get());
            remoteAppWSDTO.setClientRemote(remoteAppDBModel);

            return remoteAppWSDTO;
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


    public PaginationWSDTO createRemotePagination(Page<RemoteAppDBModel> remoteModelPage){

        PaginationWSDTO remotePagination = new PaginationWSDTO();
        remotePagination.setPageSize(remoteModelPage.getPageable().getPageSize());
        remotePagination.setPageNumber(remoteModelPage.getPageable().getPageNumber());
        remotePagination.setTotalPage(remoteModelPage.getTotalPages());
        remotePagination.setTotalElements(remoteModelPage.getTotalElements());

        return remotePagination;
    }


}
