package com.faas.core.base.framework.manager.operation.content;

import com.faas.core.base.model.ws.manager.operation.content.dto.OperationManagerWSDTO;
import com.faas.core.base.model.ws.operation.content.dto.OperationWSDTO;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.ManagerHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class OperationManagerFramework {

    @Autowired
    ManagerHelper managerHelper;

    @Autowired
    AppUtils appUtils;


    public OperationManagerWSDTO getOperationManagersService(long userId,int reqPage,int reqSize) {

        return null;
    }

    public OperationManagerWSDTO getOperationManagersByTypeService(long userId,String sessionType,int reqPage,int reqSize) {

        return null;
    }

    public OperationManagerWSDTO getOperationManagersByStateService(long userId,String operationState,int reqPage,int reqSize) {

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
