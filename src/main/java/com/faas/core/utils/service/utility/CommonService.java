package com.faas.core.utils.service.utility;

import com.faas.core.utils.endpoint.request.utility.CommonRequest;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class CommonService {

    @Autowired
    CommonRequest commonRequest;

    @Autowired
    AppUtils appUtils;


    public String urlShortenerService(String pwaLink) throws IOException {

        return null;
    }




}
