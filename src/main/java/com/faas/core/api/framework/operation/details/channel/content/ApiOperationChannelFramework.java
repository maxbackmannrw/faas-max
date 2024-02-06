package com.faas.core.api.framework.operation.details.channel.content;

import com.faas.core.api.model.ws.operation.details.channel.content.dto.ApiOperationCallChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.content.dto.ApiOperationMessageChannelWSDTO;
import com.faas.core.base.repo.operation.details.channel.OperationSipCallRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.ChannelHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ApiOperationChannelFramework {

    @Autowired
    ChannelHelper channelHelper;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    OperationSipCallRepository operationSipCallRepository;

    @Autowired
    AppUtils appUtils;


    public ApiOperationCallChannelWSDTO apiGetOperationCallChannelService(long agentId, String operationId) {


        return null;
    }


    public ApiOperationMessageChannelWSDTO apiGetOperationMessageChannelService(long agentId, String operationId) {


        return null;
    }


}