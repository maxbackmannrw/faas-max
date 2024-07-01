package com.faas.core.base.framework.operation.manager.content;

import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.ws.operation.manager.content.dto.OperationManagerWSDTO;
import com.faas.core.base.model.ws.operation.content.dto.OperationWSDTO;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.operation.details.channel.*;
import com.faas.core.utility.config.AppUtils;
import com.faas.core.utility.helpers.manager.ManagerHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
public class OperationManagerFramework {

    @Autowired
    ManagerHelpers managerHelpers;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    OperationSmsRepository OperationSmsRepository;

    @Autowired
    OperationEmailRepository operationEmailRepository;

    @Autowired
    OperationSipCallRepository operationSipCallRepository;

    @Autowired
    OperationWappCallRepository operationWappCallRepository;

    @Autowired
    OperationWappMessageRepository operationWappMessageRepository;

    @Autowired
    OperationPushRepository operationPushRepository;

    @Autowired
    AppUtils appUtils;


    public OperationManagerWSDTO getOperationManagersService(long userId,int reqPage,int reqSize) {

        Page<OperationDBModel> operationModelPage = operationRepository.findAllByStatus(1, PageRequest.of(reqPage,reqSize));
        if (operationModelPage != null){
            return managerHelpers.getOperationManagerWSDTOByOperationModel(operationModelPage);
        }
        return null;
    }


    public OperationManagerWSDTO getOperationManagersByTypeService(long userId,String sessionType,int reqPage,int reqSize) {


        return null;
    }

    public OperationManagerWSDTO getOperationManagersByStateService(long userId,String operationState,int reqPage,int reqSize) {

        Page<OperationDBModel> operationModelPage = operationRepository.findAllByOperationState(operationState, PageRequest.of(reqPage,reqSize));
        if (operationModelPage != null){
            return managerHelpers.getOperationManagerWSDTOByOperationModel(operationModelPage);
        }
        return null;
    }

    public OperationWSDTO getOperationManagerService(long userId,long sessionId) {


        return null;
    }

    public OperationWSDTO updateOperationManagerService(long userId,long sessionId) {

        return null;
    }

    public OperationWSDTO removeOperationManagerService(long userId,long sessionId) {


        return null;
    }


}
