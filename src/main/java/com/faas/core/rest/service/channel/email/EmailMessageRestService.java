package com.faas.core.rest.service.channel.email;

import com.faas.core.base.model.db.operation.details.channel.OperationSmsMessageDBModel;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class EmailMessageRestService {

    @Autowired
    AppUtils appUtils;


    public void sendSmsMessageService(OperationSmsMessageDBModel operationSmsMessageDBModel) throws IOException {
        return;
    }




}
