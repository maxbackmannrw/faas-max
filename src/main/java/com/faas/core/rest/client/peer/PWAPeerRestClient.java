package com.faas.core.rest.client.peer;

import com.faas.core.base.model.db.operation.channel.SipCallDBModel;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class PWAPeerRestClient {

    @Autowired
    AppUtils appUtils;


    public void startSipCallIntegration(SipCallDBModel sipCallDBModel) {

    }


}