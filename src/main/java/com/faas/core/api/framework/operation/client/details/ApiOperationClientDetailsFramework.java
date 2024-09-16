package com.faas.core.api.framework.operation.client.details;

import com.faas.core.data.ws.api.operation.client.details.dto.ApiOperationClientDetailsWSDTO;
import com.faas.core.misc.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ApiOperationClientDetailsFramework {

    @Autowired
    AppUtils appUtils;


    public ApiOperationClientDetailsWSDTO apiGetClientDetailsService(long agentId, long clientId) {

        ApiOperationClientDetailsWSDTO clientDetailsWSDTO = new ApiOperationClientDetailsWSDTO();

        return clientDetailsWSDTO;
    }


    public ApiOperationClientDetailsWSDTO apiGetClientNotesService(long agentId, long clientId) {

        ApiOperationClientDetailsWSDTO clientDetailsWSDTO = new ApiOperationClientDetailsWSDTO();

        return clientDetailsWSDTO;
    }

    public ApiOperationClientDetailsWSDTO apiGetClientNoteService(long agentId, long clientId) {

        ApiOperationClientDetailsWSDTO clientDetailsWSDTO = new ApiOperationClientDetailsWSDTO();

        return clientDetailsWSDTO;
    }

    public ApiOperationClientDetailsWSDTO apiCreateClientNoteService(long agentId, long clientId) {

        ApiOperationClientDetailsWSDTO clientDetailsWSDTO = new ApiOperationClientDetailsWSDTO();

        return clientDetailsWSDTO;
    }

    public ApiOperationClientDetailsWSDTO apiUpdateClientNoteService(long agentId, long clientId) {

        ApiOperationClientDetailsWSDTO clientDetailsWSDTO = new ApiOperationClientDetailsWSDTO();

        return clientDetailsWSDTO;
    }

    public ApiOperationClientDetailsWSDTO apiRemoveClientNoteService(long agentId, long clientId) {

        ApiOperationClientDetailsWSDTO clientDetailsWSDTO = new ApiOperationClientDetailsWSDTO();

        return clientDetailsWSDTO;
    }


    public ApiOperationClientDetailsWSDTO apiGetClientRemoteAppsService(long agentId, long clientId) {

        ApiOperationClientDetailsWSDTO clientDetailsWSDTO = new ApiOperationClientDetailsWSDTO();

        return clientDetailsWSDTO;
    }

    public ApiOperationClientDetailsWSDTO apiGetClientRemoteAppService(long agentId, long clientId) {

        ApiOperationClientDetailsWSDTO clientDetailsWSDTO = new ApiOperationClientDetailsWSDTO();

        return clientDetailsWSDTO;
    }


    public ApiOperationClientDetailsWSDTO apiGetClientOSINTsService(long agentId, long clientId) {

        ApiOperationClientDetailsWSDTO clientDetailsWSDTO = new ApiOperationClientDetailsWSDTO();

        return clientDetailsWSDTO;
    }

    public ApiOperationClientDetailsWSDTO apiGetClientOSINTService(long agentId, long clientId) {

        ApiOperationClientDetailsWSDTO clientDetailsWSDTO = new ApiOperationClientDetailsWSDTO();

        return clientDetailsWSDTO;
    }


}
