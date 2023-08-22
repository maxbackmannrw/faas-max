package com.faas.core.base.framework.session.details;

import com.faas.core.base.model.ws.session.content.dto.SessionWSDTO;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class SessionDetailsFramework {


    @Autowired
    AppUtils appUtils;


    public SessionWSDTO fillClientSessionWSDTO() {
        return null;
    }


}
