package com.faas.core.base.framework.remote.settings;

import com.faas.core.base.model.ws.remote.content.dto.RemoteListWSDTO;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.RemoteHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class RemoteSettingsFramework {


    @Autowired
    RemoteHelper remoteHelper;

    @Autowired
    AppUtils appUtils;


    public RemoteListWSDTO getAllRemotesService(long userId, String remoteType, String remoteState, int reqPage, int reqSize) {

        RemoteListWSDTO remoteListWSDTO = new RemoteListWSDTO();

        return remoteListWSDTO;
    }



}
