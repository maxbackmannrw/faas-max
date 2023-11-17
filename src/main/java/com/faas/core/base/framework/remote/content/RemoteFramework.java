package com.faas.core.base.framework.remote.content;

import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.remote.RemoteDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.model.ws.remote.content.dto.RemoteListWSDTO;
import com.faas.core.base.model.ws.remote.content.dto.RemoteWSDTO;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.client.details.*;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.operation.details.flow.OperationFlowRepository;
import com.faas.core.base.repo.operation.details.inquiry.OperationInquiryRepository;
import com.faas.core.base.repo.operation.details.scenario.OperationScenarioRepository;
import com.faas.core.base.repo.remote.RemoteRepository;
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
public class RemoteFramework {


    @Autowired
    RemoteHelper remoteHelper;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientAddressRepository clientAddressRepository;

    @Autowired
    ClientDataRepository clientDataRepository;

    @Autowired
    ClientEmailRepository clientEmailRepository;

    @Autowired
    ClientNoteRepository clientNoteRepository;

    @Autowired
    ClientPhoneRepository clientPhoneRepository;

    @Autowired
    RemoteRepository remoteRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    OperationInquiryRepository operationInquiryRepository;

    @Autowired
    OperationFlowRepository operationFlowRepository;

    @Autowired
    OperationScenarioRepository operationScenarioRepository;

    @Autowired
    AppUtils appUtils;


    public RemoteListWSDTO getAllRemotesService(long userId, String remoteType, String remoteState, int reqPage, int reqSize) {

        RemoteListWSDTO remoteListWSDTO = new RemoteListWSDTO();
        if (remoteType.equalsIgnoreCase(AppConstant.ALL_REMOTES) && remoteState.equalsIgnoreCase(AppConstant.ALL_REMOTES)){
            remoteListWSDTO = remoteHelper.getRemoteListWSDTO(remoteRepository.findAllByStatus(1, PageRequest.of(reqPage,reqSize)));
        }
        if (!remoteType.equalsIgnoreCase(AppConstant.ALL_REMOTES) && remoteState.equalsIgnoreCase(AppConstant.ALL_REMOTES)){
            remoteListWSDTO = remoteHelper.getRemoteListWSDTO(remoteRepository.findAllByRemoteTypeAndStatus(remoteType,1, PageRequest.of(reqPage,reqSize)));
        }
        if (remoteType.equalsIgnoreCase(AppConstant.ALL_REMOTES) && !remoteState.equalsIgnoreCase(AppConstant.ALL_REMOTES)){
            remoteListWSDTO = remoteHelper.getRemoteListWSDTO(remoteRepository.findAllByRemoteStateAndStatus(remoteState,1, PageRequest.of(reqPage,reqSize)));
        }
        if (!remoteType.equalsIgnoreCase(AppConstant.ALL_REMOTES) && !remoteState.equalsIgnoreCase(AppConstant.ALL_REMOTES)){
            remoteListWSDTO = remoteHelper.getRemoteListWSDTO(remoteRepository.findAllByRemoteTypeAndRemoteStateAndStatus(remoteType,remoteState,1, PageRequest.of(reqPage,reqSize)));
        }
        return remoteListWSDTO;
    }


    public List<RemoteWSDTO> getClientRemotesService(long userId, long clientId) {

        List<RemoteWSDTO> remoteWSDTOS = new ArrayList<>();
        List<RemoteDBModel> remoteDBModels = remoteRepository.findByClientId(clientId);
        for (RemoteDBModel remoteDBModel : remoteDBModels) {
            RemoteWSDTO remoteWSDTO = remoteHelper.getRemoteWSDTO(remoteDBModel);
            if (remoteWSDTO != null){
                remoteWSDTOS.add(remoteWSDTO);
            }
        }
        return remoteWSDTOS;
    }


    public RemoteWSDTO getRemoteService(long userId, String remoteId) {

        Optional<RemoteDBModel> remoteDBModel = remoteRepository.findById(remoteId);
        if ( remoteDBModel.isPresent()){
            return remoteHelper.getRemoteWSDTO(remoteDBModel.get());
        }
        return null;
    }


    public RemoteWSDTO createRemoteService(long userId, long sessionId, String deviceBrand, String deviceModel, String deviceOS, String deviceUrl, String remoteType, String remoteState) {

        List<OperationDBModel> operationDBModels = operationRepository.findBySessionId(sessionId);
        Optional<SessionDBModel> sessionDBModel = sessionRepository.findById(sessionId);
        if (sessionDBModel.isPresent() && !operationDBModels.isEmpty()){

            RemoteDBModel remoteDBModel = new RemoteDBModel();
            remoteDBModel.setClientId(sessionDBModel.get().getClientId());
            remoteDBModel.setSessionId(sessionId);
            remoteDBModel.setOperationId(operationDBModels.get(0).getId());
            remoteDBModel.setCampaignId(sessionDBModel.get().getCampaignId());
            remoteDBModel.setCampaign(sessionDBModel.get().getCampaign());
            remoteDBModel.setProcessId(sessionDBModel.get().getProcessId());
            remoteDBModel.setProcess(sessionDBModel.get().getProcess());
            remoteDBModel.setRemoteDevice(remoteHelper.createRemoteDeviceDAO(deviceBrand,deviceModel,deviceOS,deviceUrl));
            remoteDBModel.setRemoteType(remoteType);
            remoteDBModel.setRemoteState(remoteState);
            remoteDBModel.setuDate(appUtils.getCurrentTimeStamp());
            remoteDBModel.setcDate(appUtils.getCurrentTimeStamp());
            remoteDBModel.setStatus(1);

            return remoteHelper.getRemoteWSDTO(remoteRepository.save(remoteDBModel));
        }
        return null;
    }


    public RemoteWSDTO updateRemoteService(long userId, long sessionId, String remoteId, String deviceBrand, String deviceModel, String deviceOS, String deviceUrl, String remoteState) {


        return null;
    }


    public RemoteWSDTO removeRemoteService(long userId, String remoteId) {

        return null;
    }



}
