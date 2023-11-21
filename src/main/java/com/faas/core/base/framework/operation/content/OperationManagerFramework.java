package com.faas.core.base.framework.operation.content;

import com.faas.core.base.model.ws.operation.content.dto.OperationListWSDTO;
import com.faas.core.base.model.ws.operation.content.dto.OperationManagerWSDTO;
import com.faas.core.base.model.ws.operation.content.dto.OperationWSDTO;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.OperationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;


@Component
public class OperationManagerFramework {


    @Autowired
    OperationHelper operationHelper;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    AppUtils appUtils;



    public OperationListWSDTO getOperationsService(long userId, String sessionType,String sessionState,int reqPage,int reqSize) {

        return operationHelper.getOperationListWSDTO(sessionRepository.findAllBySessionTypeAndSessionState(sessionType,sessionState,PageRequest.of(reqPage,reqSize)));
    }


    public OperationWSDTO getOperationService(long userId, long sessionId) {

        return null;
    }


    public OperationWSDTO createOperationService(long userId) {

        return null;
    }


    public OperationWSDTO updateOperationService(long userId,long sessionId) {

        return null;
    }


    public OperationWSDTO removeOperationService(long userId, long sessionId) {

        return null;
    }

}
