package com.faas.core.base.framework.remote.content;

import com.faas.core.base.model.ws.remote.client.dto.ClientRemoteListWSDTO;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.RemoteHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class RemoteDetailsFramework {

    @Autowired
    RemoteHelper remoteHelper;

    @Autowired
    AppUtils appUtils;

    public ClientRemoteListWSDTO getRemoteDetailsService(long userId, String remoteType, String remoteState, int reqPage, int reqSize) {

        return null;
    }


    public ClientRemoteListWSDTO getRemoteSummaryService(long userId, String remoteType, String remoteState, int reqPage, int reqSize) {

        return null;
    }


}
