package com.faas.core.api.framework.operation.details.client.hook;

import com.faas.core.api.model.ws.operation.details.client.hook.dto.ApiClientHookWSDTO;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ApiClientHookFramework {


    @Autowired
    AppUtils appUtils;


    public List<ApiClientHookWSDTO> apiGetClientHooksService(){

        List<ApiClientHookWSDTO> clientHookWSDTOS = new ArrayList<>();

        return clientHookWSDTOS;
    }



}
