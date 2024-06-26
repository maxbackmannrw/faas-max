package com.faas.core.base.framework.operation.content;

import com.faas.core.base.model.ws.operation.content.dto.OperationListWSDTO;
import com.faas.core.base.model.ws.operation.content.dto.OperationWSDTO;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.utility.config.AppUtils;
import com.faas.core.utility.helpers.operation.OperationHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
public class OperationFramework {


    @Autowired
    OperationHelpers operationHelpers;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    AppUtils appUtils;



    public OperationListWSDTO getOperationsService(long userId, String sessionType,String sessionState,int reqPage,int reqSize) {

        return null;
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
