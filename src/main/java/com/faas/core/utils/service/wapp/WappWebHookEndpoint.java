package com.faas.core.utils.service.wapp;

import com.faas.core.utils.config.AppUtils;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class WappWebHookEndpoint {

    private final OkHttpClient client = new OkHttpClient();

    @Autowired
    AppUtils appUtils;


    public String initWappInstance() throws IOException {

        return null;
    }



}
