package com.faas.core.utility.rest.remote.android;

import com.faas.core.base.model.db.operation.details.channel.OperationSipCallDBModel;
import com.faas.core.utility.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class AndroidRemoteRestCall {


    @Autowired
    AppUtils appUtils;


    public void startSipCallIntegration(OperationSipCallDBModel operationSipCallDBModel) {


    }


}
