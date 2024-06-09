package com.faas.core.utility.handler.utility;

import com.faas.core.utility.rest.utility.CommonRestCall;
import com.faas.core.utility.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class CommonHandler {

    @Autowired
    CommonRestCall commonRestCall;

    @Autowired
    AppUtils appUtils;


    public String urlShortenerService(String pwaLink) throws IOException {

        return null;
    }




}
