package com.faas.core.misc.handler.remote.pwa;

import com.faas.core.misc.config.AppUtils;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class PWARemoteHandler {

    private final OkHttpClient client = new OkHttpClient();

    @Autowired
    AppUtils appUtils;


    public void sendSmsMessageService() {


    }


}
