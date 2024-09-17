package com.faas.core.base.framework.remoteapp.content;

import com.faas.core.data.db.operation.content.OperationDBModel;
import com.faas.core.data.db.remote.content.RemoteDBModel;
import com.faas.core.data.db.remoteapp.RemoteAppDBModel;
import com.faas.core.base.model.ws.remoteapp.content.dto.RemoteAppListWSDTO;
import com.faas.core.base.model.ws.remoteapp.content.dto.RemoteAppSummaryWSDTO;
import com.faas.core.base.model.ws.remoteapp.content.dto.RemoteAppWSDTO;
import com.faas.core.base.model.ws.remoteapp.details.dto.RemoteAppDetailsWSDTO;
import com.faas.core.data.repo.campaign.content.CampaignRepository;
import com.faas.core.data.repo.client.content.ClientRepository;
import com.faas.core.data.repo.operation.content.OperationRepository;
import com.faas.core.data.repo.remote.content.RemoteRepository;
import com.faas.core.data.repo.remoteapp.RemoteAppRepository;
import com.faas.core.misc.config.AppConstant;
import com.faas.core.misc.config.AppUtils;
import com.faas.core.misc.helpers.remoteapp.RemoteAppHelper;
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
    RemoteAppHelper remoteAppHelper;

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


    public RemoteAppListWSDTO getRemoteAppsService(long userId, String connState, int reqPage, int reqSize) {

        Page<RemoteAppDBModel> remoteAppModelPage = remoteAppRepository.findAllByConnState(connState, PageRequest.of(reqPage, reqSize));
        RemoteAppListWSDTO remoteAppListWSDTO = new RemoteAppListWSDTO();
        List<RemoteAppWSDTO> remoteAppWSDTOS = new ArrayList<>();
        return null;
    }

    public RemoteAppListWSDTO getRemoteAppsByBaseTypeService(long userId, String connState, String baseType, int reqPage, int reqSize) {

        Page<RemoteAppDBModel> remoteAppDBModelPage = remoteAppRepository.findAllByConnStateAndBaseType(connState, baseType, PageRequest.of(reqPage, reqSize));

        RemoteAppListWSDTO remoteAppListWSDTO = new RemoteAppListWSDTO();
        List<RemoteAppWSDTO> remoteAppWSDTOS = new ArrayList<>();
        return null;
    }

    public RemoteAppListWSDTO getClientRemoteAppsService(long userId, long clientId) {

        List<RemoteAppDBModel> clientRemoteModelPage = remoteAppRepository.findByClientId(clientId);

        return null;
    }

    public RemoteAppWSDTO getRemoteAppService(long userId, String remoteAppId) {

        Optional<RemoteAppDBModel> remoteAppDBModel = remoteAppRepository.findById(remoteAppId);
        if (remoteAppDBModel.isPresent()) {
            return null;
        }
        return null;
    }

    public RemoteAppWSDTO createRemoteAppService(long userId, String operationId, String remoteId) {

        Optional<OperationDBModel> operationDBModel = operationRepository.findById(operationId);
        Optional<RemoteDBModel> remoteDBModel = remoteRepository.findById(remoteId);

        return null;
    }

    public RemoteAppWSDTO updateRemoteAppService(long userId, String remoteAppId, String remoteState) {

        Optional<RemoteAppDBModel> remoteAppDBModel = remoteAppRepository.findById(remoteAppId);
        if (remoteAppDBModel.isPresent()) {
            remoteAppDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            return null;
        }
        return null;
    }

    public RemoteAppWSDTO removeRemoteAppService(long userId, String remoteAppId) {

        Optional<RemoteAppDBModel> remoteAppDBModel = remoteAppRepository.findById(remoteAppId);
        if (remoteAppDBModel.isPresent()) {
            remoteAppRepository.delete(remoteAppDBModel.get());
            return null;
        }
        return null;
    }


    public RemoteAppDetailsWSDTO getRemoteAppDetailsService(long userId, String remoteAppId) {

        return null;
    }

    public RemoteAppSummaryWSDTO getRemoteAppsSummaryService(long userId) {

        RemoteAppSummaryWSDTO remoteAppSummaryWSDTO = new RemoteAppSummaryWSDTO();
        remoteAppSummaryWSDTO.setTotalConnCount(remoteAppRepository.count());
        remoteAppSummaryWSDTO.setWaitingConnCount(remoteAppRepository.countByConnState(AppConstant.CONN_WAITING));
        remoteAppSummaryWSDTO.setActiveConnCount(remoteAppRepository.countByConnState(AppConstant.CONN_ACTIVE));
        remoteAppSummaryWSDTO.setFailedConnCount(remoteAppRepository.countByConnState(AppConstant.CONN_FAILED));

        return remoteAppSummaryWSDTO;
    }

}
