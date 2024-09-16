package com.faas.core.misc.handler.utility;

import com.faas.core.misc.config.AppUtils;
import com.faas.core.misc.rest.utility.CommonRestCall;
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
