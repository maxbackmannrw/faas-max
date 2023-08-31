package com.faas.core.external.service.utils;

import com.faas.core.external.endpoint.restcall.utils.ExtUtilityRestCall;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class ExtUtilityService {

    @Autowired
    ExtUtilityRestCall extUtilityRestCall;

    @Autowired
    AppUtils appUtils;


    public String urlShortenerService(String pwaLink) throws IOException {

        return null;
    }


}
