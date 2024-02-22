package com.faas.core.base.framework.remote.app;

import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.remote.app.RemoteAppDBModel;
import com.faas.core.base.model.db.remote.content.RemoteDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.model.ws.remote.app.content.dto.RemoteAppListWSDTO;
import com.faas.core.base.model.ws.remote.app.content.dto.RemoteAppWSDTO;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.base.repo.remote.app.RemoteAppRepository;
import com.faas.core.base.repo.remote.content.RemoteRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.RemoteAppHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class RemoteAppFramework {

    @Autowired
    RemoteAppHelper remoteAppHelper;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    RemoteAppRepository remoteAppRepository;

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    RemoteRepository remoteRepository;

    @Autowired
    AppUtils appUtils;


    public RemoteAppListWSDTO getRemoteAppsService(long userId,String connState,int reqPage,int reqSize) {

        Page<RemoteAppDBModel> remoteAppModelPage = remoteAppRepository.findAllByConnState(connState,PageRequest.of(reqPage,reqSize));
        if (remoteAppModelPage != null){
            RemoteAppListWSDTO remoteAppListWSDTO = new RemoteAppListWSDTO();
            List<RemoteAppWSDTO> remoteAppWSDTOS = new ArrayList<>();
            for (int i=0;i<remoteAppModelPage.getContent().size();i++){
                remoteAppWSDTOS.add(remoteAppHelper.createRemoteAppWSDTO(remoteAppModelPage.getContent().get(i)));
            }
            remoteAppListWSDTO.setRemoteApps(remoteAppWSDTOS);
            remoteAppListWSDTO.setPagination(remoteAppHelper.createRemoteAppPagination(remoteAppModelPage));

            return remoteAppListWSDTO;
        }
        return null;
    }


    public RemoteAppListWSDTO getRemoteAppsByBaseTypeService(long userId,String connState,String baseType,int reqPage,int reqSize) {

        Page<RemoteAppDBModel> remoteAppModelPage = remoteAppRepository.findAllByConnStateAndBaseType(connState,baseType,PageRequest.of(reqPage,reqSize));
        if (remoteAppModelPage != null){
            RemoteAppListWSDTO remoteAppListWSDTO = new RemoteAppListWSDTO();
            List<RemoteAppWSDTO> remoteAppWSDTOS = new ArrayList<>();
            for (int i=0;i<remoteAppModelPage.getContent().size();i++){
                remoteAppWSDTOS.add(remoteAppHelper.createRemoteAppWSDTO(remoteAppModelPage.getContent().get(i)));
            }
            remoteAppListWSDTO.setRemoteApps(remoteAppWSDTOS);
            remoteAppListWSDTO.setPagination(remoteAppHelper.createRemoteAppPagination(remoteAppModelPage));

            return remoteAppListWSDTO;
        }
        return null;
    }


    public List<RemoteAppWSDTO> getClientRemoteAppsService(long userId,long clientId) {

        List<RemoteAppWSDTO> remoteAppWSDTOS = new ArrayList<>();
        List<RemoteAppDBModel> remoteAppDBModels = remoteAppRepository.findByClientId(clientId);
        for (RemoteAppDBModel remoteAppDBModel : remoteAppDBModels) {
            remoteAppWSDTOS.add(remoteAppHelper.createRemoteAppWSDTO(remoteAppDBModel));
        }
        return remoteAppWSDTOS;
    }


    public RemoteAppWSDTO getRemoteAppService(long userId, String appId) {

        Optional<RemoteAppDBModel> remoteAppDBModel = remoteAppRepository.findById(appId);
        if (remoteAppDBModel.isPresent()){
            return remoteAppHelper.createRemoteAppWSDTO(remoteAppDBModel.get());
        }
        return null;
    }


    public RemoteAppWSDTO createRemoteAppService(long userId,long sessionId,String remoteId) {

        Optional<SessionDBModel> sessionDBModel = sessionRepository.findById(sessionId);
        List<OperationDBModel> operationDBModels = operationRepository.findBySessionId(sessionId);
        Optional<RemoteDBModel> remoteDBModel = remoteRepository.findById(remoteId);
        if (sessionDBModel.isPresent() && !operationDBModels.isEmpty() && remoteDBModel.isPresent()){
            RemoteAppDBModel remoteAppDBModel = remoteAppRepository.save(remoteAppHelper.createRemoteAppDBModel(sessionDBModel.get(),operationDBModels.get(0),remoteDBModel.get()));
            return remoteAppHelper.createRemoteAppWSDTO(remoteAppDBModel);
        }
        return null;
    }


    public RemoteAppWSDTO updateRemoteAppService(long userId,String appId,String connState) {

        Optional<RemoteAppDBModel>remoteAppDBModel = remoteAppRepository.findById(appId);
        if (remoteAppDBModel.isPresent()){
            remoteAppDBModel.get().setConnState(connState);
            remoteAppDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            return remoteAppHelper.createRemoteAppWSDTO(remoteAppRepository.save(remoteAppDBModel.get()));
        }
        return null;
    }


    public RemoteAppWSDTO removeRemoteAppService(long userId,String appId) {

        Optional<RemoteAppDBModel> remoteAppDBModel = remoteAppRepository.findById(appId);
        if (remoteAppDBModel.isPresent()){
            remoteAppRepository.delete(remoteAppDBModel.get());
            return remoteAppHelper.createRemoteAppWSDTO(remoteAppDBModel.get());
        }
        return null;
    }


}
