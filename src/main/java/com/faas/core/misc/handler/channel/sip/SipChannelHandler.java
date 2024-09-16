package com.faas.core.misc.handler.channel.sip;

import com.faas.core.data.db.operation.details.channel.OperationSipCallDBModel;
import com.faas.core.misc.config.AppUtils;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SipChannelHandler {

    private final OkHttpClient client = new OkHttpClient();

    @Autowired
    AppUtils appUtils;


    public void startSipCallIntegration(OperationSipCallDBModel operationSipCallDBModel) {


    }


}
