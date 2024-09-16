package com.faas.core.base.framework.operation.manager.details;

import com.faas.core.data.ws.base.operation.manager.details.dto.OperationManagerDetailsWSDTO;
import com.faas.core.misc.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OperationManagerDetailsFramework {


    @Autowired
    AppUtils appUtils;


    public OperationManagerDetailsWSDTO getOperationManagerDetailsService(long userId, long sessionId) {

        return null;
    }


}
