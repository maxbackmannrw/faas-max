package com.faas.core.base.middleware.remote.settings;

import com.faas.core.base.framework.remote.settings.RemoteSettingsFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.remote.content.RemoteListWSModel;
import com.faas.core.base.model.ws.remote.content.dto.RemoteListWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class RemoteSettingsMiddleware {


    @Autowired
    RemoteSettingsFramework remoteSettingsFramework;


    public RemoteListWSModel getAllRemotes(long userId, String remoteType, String remoteState, int reqPage, int reqSize) {

        RemoteListWSModel response = new RemoteListWSModel();
        GeneralWSModel general = new GeneralWSModel();

        RemoteListWSDTO remoteListWSDTO = remoteSettingsFramework.getAllRemotesService(userId,remoteType,remoteState,reqPage,reqSize);
        if (remoteListWSDTO != null){
            response.setRemoteList(remoteListWSDTO);
        }

        general.setOperation("getAllRemotes");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
