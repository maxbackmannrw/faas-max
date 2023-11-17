package com.faas.core.utils.helpers;

import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.remote.RemoteDBModel;
import com.faas.core.base.model.db.remote.dao.RemoteDeviceDAO;
import com.faas.core.base.model.ws.general.PaginationWSDTO;
import com.faas.core.base.model.ws.remote.content.dto.RemoteListWSDTO;
import com.faas.core.base.model.ws.remote.content.dto.RemoteWSDTO;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.remote.RemoteRepository;
import com.faas.core.base.repo.session.SessionRepository;
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
    RemoteRepository remoteRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    AppUtils appUtils;


    public RemoteListWSDTO getRemoteListWSDTO(Page<RemoteDBModel> remoteModelPage){

        RemoteListWSDTO remoteListWSDTO = new RemoteListWSDTO();
        remoteListWSDTO.setRemotes(getRemoteWSDTOS(remoteModelPage.getContent()));
        remoteListWSDTO.setPagination(createRemotePagination(remoteModelPage));

        return remoteListWSDTO;
    }


    public List<RemoteWSDTO> getRemoteWSDTOS(List<RemoteDBModel> remoteDBModels){

        List<RemoteWSDTO> remoteWSDTOS = new ArrayList<>();
        for (RemoteDBModel remoteDBModel : remoteDBModels) {
            RemoteWSDTO remoteWSDTO = getRemoteWSDTO(remoteDBModel);
            if (remoteWSDTO != null) {
                remoteWSDTOS.add(remoteWSDTO);
            }
        }
        return remoteWSDTOS;
    }


    public RemoteWSDTO getRemoteWSDTO(RemoteDBModel remoteDBModel){

        Optional<ClientDBModel> clientDBModel = clientRepository.findById(remoteDBModel.getClientId());
        if (clientDBModel.isPresent()) {

            RemoteWSDTO remoteWSDTO = new RemoteWSDTO();
            remoteWSDTO.setClient(clientDBModel.get());
            remoteWSDTO.setClientRemote(remoteDBModel);

            return remoteWSDTO;
        }
        return null;
    }


    public PaginationWSDTO createRemotePagination(Page<RemoteDBModel> remoteModelPage){

        PaginationWSDTO remotePagination = new PaginationWSDTO();
        remotePagination.setPageSize(remoteModelPage.getPageable().getPageSize());
        remotePagination.setPageNumber(remoteModelPage.getPageable().getPageNumber());
        remotePagination.setTotalPage(remoteModelPage.getTotalPages());
        remotePagination.setTotalElements(remoteModelPage.getTotalElements());

        return remotePagination;
    }


    public RemoteDeviceDAO createRemoteDeviceDAO(String deviceBrand,String deviceModel,String deviceOS,String deviceUrl){

        RemoteDeviceDAO remoteDeviceDAO = new RemoteDeviceDAO();
        remoteDeviceDAO.setDeviceId(appUtils.generateUUID());
        remoteDeviceDAO.setDeviceBrand(deviceBrand);
        remoteDeviceDAO.setDeviceModel(deviceModel);
        remoteDeviceDAO.setDeviceOS(deviceOS);
        remoteDeviceDAO.setDeviceUrl(deviceUrl);
        remoteDeviceDAO.setuDate(appUtils.getCurrentTimeStamp());
        remoteDeviceDAO.setcDate(appUtils.getCurrentTimeStamp());
        remoteDeviceDAO.setStatus(1);

        return remoteDeviceDAO;
    }

}
