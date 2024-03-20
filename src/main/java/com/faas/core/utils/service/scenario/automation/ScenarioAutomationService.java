package com.faas.core.utils.service.scenario.automation;

import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.endpoint.request.utility.CommonRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class ScenarioAutomationService {

    @Autowired
    CommonRequest commonRequest;

    @Autowired
    AppUtils appUtils;


    public String urlShortenerService(String pwaLink) throws IOException {

        return null;
    }




}
