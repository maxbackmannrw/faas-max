package com.faas.core.api.framework.operation.details.channel.content;

import com.faas.core.api.model.ws.operation.details.channel.call.sip.dto.ApiOperationSipCallWSDTO;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.repo.operation.details.channel.OperationSipCallRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.ChannelHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


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


    public ApiOperationSipCallWSDTO apiGetOperationChannelService(long agentId,long sessionId,long clientId) {

        List<SessionDBModel> sessionDBModels = sessionRepository.findByIdAndClientIdAndAgentId(sessionId,clientId,agentId);
        if (!sessionDBModels.isEmpty()){
            return channelHelper.getApiOperationSipCallWSDTO(agentId,sessionId,clientId,sessionDBModels.get(0).getProcessId());
        }
        return null;
    }


}
