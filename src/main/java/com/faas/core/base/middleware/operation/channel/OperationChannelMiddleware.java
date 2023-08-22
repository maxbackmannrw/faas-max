package com.faas.core.base.middleware.operation.channel;

import com.faas.core.base.framework.operation.channel.OperationChannelFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.session.content.SessionWSModel;
import com.faas.core.base.model.ws.session.content.dto.SessionWSDTO;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OperationChannelMiddleware {


    @Autowired
    OperationChannelFramework operationChannelFramework;

    @Autowired
    AppUtils appUtils;


    public SessionWSModel getAllSessions(long userId, int reqPage, int reqSize) {

        SessionWSModel response = new SessionWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<SessionWSDTO> sessionWSDTOS = new ArrayList<>();


        response.setSessions(sessionWSDTOS);
        general.setOperation("getAllSessions");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
