package com.faas.core.utils.endpoint.rest.remote.android;

import com.faas.core.base.model.db.operation.details.channel.OperationSipCallDBModel;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class AndroidClientRemoteRestCall {


    @Autowired
    AppUtils appUtils;


    public void startSipCallIntegration(OperationSipCallDBModel sipCallDBModel) {


    }


}
