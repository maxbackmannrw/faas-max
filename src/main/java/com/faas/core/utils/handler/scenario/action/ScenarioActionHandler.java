package com.faas.core.utils.handler.scenario.action;

import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.endpoint.request.utility.CommonRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class ScenarioActionHandler {

    @Autowired
    CommonRequest commonRequest;

    @Autowired
    AppUtils appUtils;


    public String urlShortenerService(String pwaLink) throws IOException {

        return null;
    }




}
