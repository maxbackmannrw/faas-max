package com.faas.core.base.framework.manager.operation.details;

import com.faas.core.base.model.ws.manager.operation.details.dto.OperationManagerDetailsWSDTO;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.ManagerHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OperationManagerDetailsFramework {


    @Autowired
    ManagerHelper managerHelper;

    @Autowired
    AppUtils appUtils;


    public OperationManagerDetailsWSDTO getOperationManagerDetailsService(long userId, long sessionId) {

        return null;
    }



}
