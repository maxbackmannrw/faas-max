package com.faas.core.api.service.utils;

import com.faas.core.api.endpoint.restclient.utils.ApiUtilityRestClient;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class ApiUtilityService {

    @Autowired
    ApiUtilityRestClient apiUtilityRestClient;

    @Autowired
    AppUtils appUtils;


    public String urlShortenerService(String pwaLink) throws IOException {

        return null;
    }


}
