package com.faas.core.base.framework.operation.channel;

import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.model.ws.session.content.dto.SessionWSDTO;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class OperationChannelFramework {


    @Autowired
    AppUtils appUtils;


    public SessionWSDTO filSessionWSDTO(SessionDBModel sessionDBModel) {

        SessionWSDTO sessionWSDTO =  new SessionWSDTO();
        sessionWSDTO.setSession(sessionDBModel);
        return sessionWSDTO;
    }




}
