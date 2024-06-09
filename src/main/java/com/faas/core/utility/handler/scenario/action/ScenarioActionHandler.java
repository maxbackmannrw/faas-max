package com.faas.core.utility.handler.scenario.action;

import com.faas.core.utility.config.AppUtils;
import com.faas.core.utility.rest.utility.CommonRestCall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class ScenarioActionHandler {

    @Autowired
    CommonRestCall commonRestCall;

    @Autowired
    AppUtils appUtils;


    public String urlShortenerService(String pwaLink) throws IOException {

        return null;
    }




}
