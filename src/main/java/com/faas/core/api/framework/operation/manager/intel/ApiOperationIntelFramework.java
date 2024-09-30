package com.faas.core.api.framework.operation.manager.intel;

import com.faas.core.api.model.ws.operation.manager.intel.dto.ApiOperationOSINTWSDTO;
import com.faas.core.misc.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApiOperationIntelFramework {


    @Autowired
    AppUtils appUtils;


    public List<ApiOperationOSINTWSDTO> apiGetOperationClientOSINTsService(long agentId, long clientId) {

        return null;
    }

    public ApiOperationOSINTWSDTO apiGetOperationClientOSINTService(long agentId, long clientId) {

        return null;
    }


}
