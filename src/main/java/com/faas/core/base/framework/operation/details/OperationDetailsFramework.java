package com.faas.core.base.framework.operation.details;

import com.faas.core.base.model.ws.operation.content.dto.OperationListWSDTO;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.utility.config.AppUtils;
import com.faas.core.utility.helpers.operation.OperationHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OperationDetailsFramework {


    @Autowired
    OperationHelpers operationHelpers;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    AppUtils appUtils;


    public OperationListWSDTO getOperationDetailsService(long userId, String sessionType,String sessionState,int reqPage,int reqSize) {

        return null;
    }


}
