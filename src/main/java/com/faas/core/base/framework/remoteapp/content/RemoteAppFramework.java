package com.faas.core.base.framework.remoteapp.content;

import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.remoteapp.RemoteAppDBModel;
import com.faas.core.base.model.db.remote.content.RemoteDBModel;
import com.faas.core.base.model.ws.remoteapp.content.dto.RemoteAppListWSDTO;
import com.faas.core.base.model.ws.remoteapp.content.dto.RemoteAppWSDTO;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.remoteapp.RemoteAppRepository;
import com.faas.core.base.repo.remote.content.RemoteRepository;
import com.faas.core.utility.config.AppUtils;
import com.faas.core.utility.helpers.remote.RemoteAppHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RemoteAppFramework {


    @Autowired
    RemoteAppHelpers remoteAppHelpers;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    RemoteAppRepository remoteAppRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    RemoteRepository remoteRepository;

    @Autowired
    AppUtils appUtils;


    public RemoteAppListWSDTO getRemoteAppsService(long userId, String appState, String baseType, int reqPage, int reqSize) {

        Page<RemoteAppDBModel> remoteAppDBModelPage = remoteAppRepository.findAllByAppStateAndBaseType(appState,baseType,PageRequest.of(reqPage,reqSize));
        if (remoteAppDBModelPage != null){
            RemoteAppListWSDTO remoteAppListWSDTO = new RemoteAppListWSDTO();
            List<RemoteAppWSDTO> remoteAppWSDTOS = new ArrayList<>();


        }
        return null;
    }

    public RemoteAppListWSDTO getClientRemoteAppsService(long userId, long clientId) {

        List<RemoteAppDBModel> clientRemoteModelPage = remoteAppRepository.findByClientId(clientId);

        return null;
    }

    public RemoteAppWSDTO getRemoteAppService(long userId, String clientRemoteId) {

        Optional<RemoteAppDBModel> clientRemoteDBModel = remoteAppRepository.findById(clientRemoteId);
        if (clientRemoteDBModel.isPresent()){
            return null;
        }
        return null;
    }

    public RemoteAppWSDTO createRemoteAppService(long userId, String operationId, String remoteId) {

        Optional<OperationDBModel> operationDBModel = operationRepository.findById(operationId);
        Optional<RemoteDBModel> remoteDBModel = remoteRepository.findById(remoteId);

        return null;
    }

    public RemoteAppWSDTO updateRemoteAppService(long userId, String clientRemoteId, String remoteState) {

        Optional<RemoteAppDBModel>clientRemoteDBModel = remoteAppRepository.findById(clientRemoteId);
        if (clientRemoteDBModel.isPresent()){
            clientRemoteDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            return null;
        }
        return null;
    }

    public RemoteAppWSDTO removeRemoteAppService(long userId, String clientRemoteId) {

        Optional<RemoteAppDBModel> clientRemoteDBModel = remoteAppRepository.findById(clientRemoteId);
        if (clientRemoteDBModel.isPresent()){
            remoteAppRepository.delete(clientRemoteDBModel.get());
            return null;
        }
        return null;
    }


}
