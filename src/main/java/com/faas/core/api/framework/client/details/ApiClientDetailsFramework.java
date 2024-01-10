package com.faas.core.api.framework.client.details;

import com.faas.core.api.model.ws.client.details.dto.ApiClientDetailsWSDTO;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ApiClientDetailsFramework {

    @Autowired
    AppUtils appUtils;


    public ApiClientDetailsWSDTO apiGetClientDetailsService(long agentId, long clientId) {

        ApiClientDetailsWSDTO clientDetailsWSDTO = new ApiClientDetailsWSDTO();

        return clientDetailsWSDTO;
    }



    public ApiClientDetailsWSDTO apiGetClientNotesService(long agentId, long clientId) {

        ApiClientDetailsWSDTO clientDetailsWSDTO = new ApiClientDetailsWSDTO();

        return clientDetailsWSDTO;
    }

    public ApiClientDetailsWSDTO apiGetClientNoteService(long agentId, long clientId) {

        ApiClientDetailsWSDTO clientDetailsWSDTO = new ApiClientDetailsWSDTO();

        return clientDetailsWSDTO;
    }

    public ApiClientDetailsWSDTO apiCreateClientNoteService(long agentId, long clientId) {

        ApiClientDetailsWSDTO clientDetailsWSDTO = new ApiClientDetailsWSDTO();

        return clientDetailsWSDTO;
    }

    public ApiClientDetailsWSDTO apiUpdateClientNoteService(long agentId, long clientId) {

        ApiClientDetailsWSDTO clientDetailsWSDTO = new ApiClientDetailsWSDTO();

        return clientDetailsWSDTO;
    }

    public ApiClientDetailsWSDTO apiRemoveClientNoteService(long agentId, long clientId) {

        ApiClientDetailsWSDTO clientDetailsWSDTO = new ApiClientDetailsWSDTO();

        return clientDetailsWSDTO;
    }



    public ApiClientDetailsWSDTO apiGetClientRemoteAppsService(long agentId, long clientId) {

        ApiClientDetailsWSDTO clientDetailsWSDTO = new ApiClientDetailsWSDTO();

        return clientDetailsWSDTO;
    }

    public ApiClientDetailsWSDTO apiGetClientRemoteAppService(long agentId, long clientId) {

        ApiClientDetailsWSDTO clientDetailsWSDTO = new ApiClientDetailsWSDTO();

        return clientDetailsWSDTO;
    }



    public ApiClientDetailsWSDTO apiGetClientOSINTsService(long agentId, long clientId) {

        ApiClientDetailsWSDTO clientDetailsWSDTO = new ApiClientDetailsWSDTO();

        return clientDetailsWSDTO;
    }

    public ApiClientDetailsWSDTO apiGetClientOSINTService(long agentId, long clientId) {

        ApiClientDetailsWSDTO clientDetailsWSDTO = new ApiClientDetailsWSDTO();

        return clientDetailsWSDTO;
    }



}
