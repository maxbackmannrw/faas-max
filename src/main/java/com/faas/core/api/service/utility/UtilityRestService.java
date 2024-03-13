package com.faas.core.api.service.utility;

import com.faas.core.api.endpoint.request.utility.ApiUtilityRequest;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class UtilityRestService {

    @Autowired
    ApiUtilityRequest apiUtilityRequest;

    @Autowired
    AppUtils appUtils;


    public String urlShortenerService(String pwaLink) throws IOException {

        return null;
    }




}
