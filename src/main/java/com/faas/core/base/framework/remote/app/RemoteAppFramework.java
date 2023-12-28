package com.faas.core.base.framework.remote.app;

import com.faas.core.base.model.db.remote.app.RemoteAppDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.model.ws.remote.app.dto.RemoteAppListWSDTO;
import com.faas.core.base.model.ws.remote.app.dto.RemoteAppWSDTO;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.remote.app.RemoteAppRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.RemoteHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class RemoteAppFramework {


    @Autowired
    RemoteHelper remoteHelper;

    @Autowired
    ClientRepository clientRepository;


    @Autowired
    RemoteAppRepository remoteAppRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    AppUtils appUtils;


    public RemoteAppListWSDTO getAllClientRemotesService(long userId, String remoteType, String remoteState, int reqPage, int reqSize) {

        RemoteAppListWSDTO remoteAppListWSDTO = new RemoteAppListWSDTO();
        if (remoteType.equalsIgnoreCase(AppConstant.ALL_REMOTES) && remoteState.equalsIgnoreCase(AppConstant.ALL_REMOTES)){
            remoteAppListWSDTO = remoteHelper.getRemoteListWSDTO(remoteAppRepository.findAllByStatus(1, PageRequest.of(reqPage,reqSize)));
        }
        if (!remoteType.equalsIgnoreCase(AppConstant.ALL_REMOTES) && remoteState.equalsIgnoreCase(AppConstant.ALL_REMOTES)){
            remoteAppListWSDTO = remoteHelper.getRemoteListWSDTO(remoteAppRepository.findAllByRemoteTypeAndStatus(remoteType,1, PageRequest.of(reqPage,reqSize)));
        }
        if (remoteType.equalsIgnoreCase(AppConstant.ALL_REMOTES) && !remoteState.equalsIgnoreCase(AppConstant.ALL_REMOTES)){
            remoteAppListWSDTO = remoteHelper.getRemoteListWSDTO(remoteAppRepository.findAllByRemoteStateAndStatus(remoteState,1, PageRequest.of(reqPage,reqSize)));
        }
        if (!remoteType.equalsIgnoreCase(AppConstant.ALL_REMOTES) && !remoteState.equalsIgnoreCase(AppConstant.ALL_REMOTES)){
            remoteAppListWSDTO = remoteHelper.getRemoteListWSDTO(remoteAppRepository.findAllByRemoteTypeAndRemoteStateAndStatus(remoteType,remoteState,1, PageRequest.of(reqPage,reqSize)));
        }
        return remoteAppListWSDTO;
    }

    public List<RemoteAppWSDTO> getClientRemotesService(long userId, long clientId) {

        List<RemoteAppWSDTO> remoteAppWSDTOS = new ArrayList<>();
        List<RemoteAppDBModel> remoteAppDBModels = remoteAppRepository.findByClientId(clientId);
        for (RemoteAppDBModel remoteAppDBModel : remoteAppDBModels) {
            RemoteAppWSDTO remoteAppWSDTO = remoteHelper.getRemoteWSDTO(remoteAppDBModel);
            if (remoteAppWSDTO != null){
                remoteAppWSDTOS.add(remoteAppWSDTO);
            }
        }
        return remoteAppWSDTOS;
    }

    public RemoteAppWSDTO getClientRemoteService(long userId, String remoteId) {

        Optional<RemoteAppDBModel> remoteDBModel = remoteAppRepository.findById(remoteId);
        if ( remoteDBModel.isPresent()){
            return remoteHelper.getRemoteWSDTO(remoteDBModel.get());
        }
        return null;
    }

    public RemoteAppWSDTO createClientRemoteService(long userId, long sessionId, String deviceBrand, String deviceModel, String deviceOS, String deviceUrl, String remoteType, String remoteState) {

        Optional<SessionDBModel> sessionDBModel = sessionRepository.findById(sessionId);
        List<OperationDBModel> operationDBModels = operationRepository.findBySessionId(sessionId);
        if (sessionDBModel.isPresent() && !operationDBModels.isEmpty()){
            if (clientRepository.existsById(sessionDBModel.get().getClientId())){

                RemoteAppDBModel remoteAppDBModel = new RemoteAppDBModel();
                remoteAppDBModel.setClientId(sessionDBModel.get().getClientId());
                remoteAppDBModel.setSessionId(sessionId);
                remoteAppDBModel.setOperationId(operationDBModels.get(0).getId());
                remoteAppDBModel.setCampaignId(sessionDBModel.get().getCampaignId());
                remoteAppDBModel.setCampaign(sessionDBModel.get().getCampaign());
                remoteAppDBModel.setProcessId(sessionDBModel.get().getProcessId());
                remoteAppDBModel.setProcess(sessionDBModel.get().getProcess());
                remoteAppDBModel.setRemoteType(remoteType);
                remoteAppDBModel.setRemoteState(remoteState);
                remoteAppDBModel.setuDate(appUtils.getCurrentTimeStamp());
                remoteAppDBModel.setcDate(appUtils.getCurrentTimeStamp());
                remoteAppDBModel.setStatus(1);

                return remoteHelper.getRemoteWSDTO(remoteAppRepository.save(remoteAppDBModel));
            }
        }
        return null;
    }

    public RemoteAppWSDTO updateClientRemoteService(long userId, String remoteId, String deviceBrand, String deviceModel, String deviceOS, String deviceUrl, String remoteState) {

        Optional<RemoteAppDBModel> remoteDBModel = remoteAppRepository.findById(remoteId);

        return null;
    }

    public RemoteAppWSDTO removeClientRemoteService(long userId, String remoteId) {

        Optional<RemoteAppDBModel> remoteDBModel = remoteAppRepository.findById(remoteId);
        if (remoteDBModel.isPresent()){
            remoteAppRepository.delete(remoteDBModel.get());
            return remoteHelper.getRemoteWSDTO(remoteDBModel.get());
        }
        return null;
    }








}
