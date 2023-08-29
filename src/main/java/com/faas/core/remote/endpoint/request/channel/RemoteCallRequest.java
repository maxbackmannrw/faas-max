package com.faas.core.remote.endpoint.request.channel;

import com.faas.core.base.model.db.operation.channel.SipCallDBModel;
import com.faas.core.utils.config.AppUtils;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class RemoteCallRequest {

    private final OkHttpClient client = new OkHttpClient();

    @Autowired
    AppUtils appUtils;


    public void startSipCallIntegration(SipCallDBModel sipCallDBModel) {


    }


}
