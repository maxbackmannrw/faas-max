package com.faas.core.api.service.channel.push;

import com.faas.core.base.model.db.operation.details.channel.OperationSmsMessageDBModel;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class PushMessageRestService {


    @Autowired
    AppUtils appUtils;


    public void sendSmsMessageService(OperationSmsMessageDBModel operationSmsMessageDBModel) throws IOException {

    }



}
