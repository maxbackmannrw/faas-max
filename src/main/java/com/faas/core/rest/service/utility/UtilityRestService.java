package com.faas.core.rest.service.utility;

import com.faas.core.rest.client.utility.UtilityRestClient;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;


@Component
public class UtilityRestService {

    @Autowired
    UtilityRestClient utilityRestClient;

    @Autowired
    AppUtils appUtils;


    public String urlShortenerService(String pwaLink) throws IOException {

        return null;
    }




}
