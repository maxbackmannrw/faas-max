package com.faas.core.utils.service.channel.message.email;

import com.faas.core.base.model.db.operation.details.channel.OperationSmsMessageDBModel;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
public class EmailMessageService {

    @Autowired
    AppUtils appUtils;


    public void sendSmsMessageService(OperationSmsMessageDBModel operationSmsMessageDBModel) throws IOException {
        return;
    }




}
