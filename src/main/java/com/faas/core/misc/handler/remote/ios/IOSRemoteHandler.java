package com.faas.core.misc.handler.remote.ios;

import com.faas.core.misc.config.AppUtils;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class IOSRemoteHandler {

    private final OkHttpClient client = new OkHttpClient();

    @Autowired
    AppUtils appUtils;


    public void sendSmsMessageService() {


    }


}
