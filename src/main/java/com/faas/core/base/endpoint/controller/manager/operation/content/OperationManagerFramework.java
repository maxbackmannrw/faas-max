package com.faas.core.base.endpoint.controller.manager.operation.content;

import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.model.ws.manager.operation.content.dto.OperationManagerWSDTO;
import com.faas.core.base.model.ws.operation.content.dto.OperationWSDTO;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.operation.details.channel.*;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.ManagerHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class OperationManagerFramework {

    @Autowired
    ManagerHelper managerHelper;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    OperationSmsMessageRepository operationSmsMessageRepository;

    @Autowired
    OperationEmailMessageRepository operationEmailMessageRepository;

    @Autowired
    OperationSipCallRepository operationSipCallRepository;

    @Autowired
    OperationWappCallRepository operationWappCallRepository;

    @Autowired
    OperationWappMessageRepository operationWappMessageRepository;

    @Autowired
    OperationPushMessageRepository operationPushMessageRepository;

    @Autowired
    AppUtils appUtils;


    public OperationManagerWSDTO getOperationManagersService(long userId,int reqPage,int reqSize) {

        Page<OperationDBModel> operationModelPage = operationRepository.findAllByStatus(1, PageRequest.of(reqPage,reqSize));
        if (operationModelPage != null){
            return managerHelper.getOperationManagerWSDTOByOperationModel(operationModelPage);
        }
        return null;
    }


    public OperationManagerWSDTO getOperationManagersByTypeService(long userId,String sessionType,int reqPage,int reqSize) {

        Page<SessionDBModel> sessionModelPage = sessionRepository.findAllBySessionType(sessionType, PageRequest.of(reqPage,reqSize));
        if (sessionModelPage != null){
            return managerHelper.getOperationManagerWSDTOBySessionModel(sessionModelPage);
        }
        return null;
    }

    public OperationManagerWSDTO getOperationManagersByStateService(long userId,String operationState,int reqPage,int reqSize) {

        Page<OperationDBModel> operationModelPage = operationRepository.findAllByOperationState(operationState, PageRequest.of(reqPage,reqSize));
        if (operationModelPage != null){
            return managerHelper.getOperationManagerWSDTOByOperationModel(operationModelPage);
        }
        return null;
    }

    public OperationWSDTO getOperationManagerService(long userId,long sessionId) {

        List<OperationDBModel> operationDBModels = operationRepository.findBySessionId(sessionId);
        if (!operationDBModels.isEmpty()){
            return managerHelper.fillManagerOperationWSDTOByOperationModel(operationDBModels.get(0));
        }
        return null;
    }

    public OperationWSDTO updateOperationManagerService(long userId,long sessionId) {

        return null;
    }

    public OperationWSDTO removeOperationManagerService(long userId,long sessionId) {

        Optional<SessionDBModel> sessionDBModel = sessionRepository.findById(sessionId);
        if (sessionDBModel.isPresent()){

            OperationWSDTO operationWSDTO = managerHelper.fillManagerOperationWSDTOBySessionModel(sessionDBModel.get());
            sessionRepository.delete(sessionDBModel.get());
            operationRepository.deleteAll(operationRepository.findBySessionId(sessionId));
            operationEmailMessageRepository.deleteAll(operationEmailMessageRepository.findBySessionId(sessionId));
            operationPushMessageRepository.deleteAll(operationPushMessageRepository.findBySessionId(sessionId));
            operationSipCallRepository.deleteAll(operationSipCallRepository.findBySessionId(sessionId));
            operationSmsMessageRepository.deleteAll(operationSmsMessageRepository.findBySessionId(sessionId));
            operationWappCallRepository.deleteAll(operationWappCallRepository.findBySessionId(sessionId));
            operationWappMessageRepository.deleteAll(operationWappMessageRepository.findBySessionId(sessionId));

            return operationWSDTO;
        }
        return null;
    }


}
