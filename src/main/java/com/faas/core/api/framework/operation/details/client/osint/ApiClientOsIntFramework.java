package com.faas.core.api.framework.operation.details.client.osint;

import com.faas.core.api.model.ws.operation.details.client.osint.dto.ApiClientOsIntWSDTO;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ApiClientOsIntFramework {

    @Autowired
    AppUtils appUtils;


    public List<ApiClientOsIntWSDTO> apiGetClientOsIntsService(){

        List<ApiClientOsIntWSDTO> clientOsIntWSDTOS = new ArrayList<>();
        return clientOsIntWSDTOS;
    }


}
