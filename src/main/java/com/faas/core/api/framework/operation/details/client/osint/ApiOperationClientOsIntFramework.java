package com.faas.core.api.framework.operation.details.client.osint;

import com.faas.core.api.model.ws.client.details.dto.ApiClientOsIntWSDTO;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ApiOperationClientOsIntFramework {

    @Autowired
    AppUtils appUtils;


    public List<ApiClientOsIntWSDTO> apiGetClientOsIntsService(){

        List<ApiClientOsIntWSDTO> clientOsIntWSDTOS = new ArrayList<>();
        return clientOsIntWSDTOS;
    }


}
