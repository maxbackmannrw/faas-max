package com.faas.core.api.framework.agent.details;

import com.faas.core.api.model.ws.agent.details.dto.ApiAgentDetailsWSDTO;
import com.faas.core.api.model.ws.agent.details.dto.ApiAgentInfoWSDTO;
import com.faas.core.api.model.ws.agent.details.dto.ApiAgentSipAccountWSDTO;
import com.faas.core.base.model.db.process.details.channel.content.ProcessSipChannelDBModel;
import com.faas.core.base.model.db.user.details.UserDetailsDBModel;
import com.faas.core.base.repo.inquiry.InquiryRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.process.details.channel.content.ProcessSipChannelRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.base.repo.user.content.UserRepository;
import com.faas.core.base.repo.user.details.UserDetailsRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ApiAgentDetailsFramework {


    @Autowired
    UserRepository userRepository;

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Autowired
    ProcessSipChannelRepository processSipChannelRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    InquiryRepository inquiryRepository;

    @Autowired
    AppUtils appUtils;


    public ApiAgentDetailsWSDTO apiGetAgentDetailsService(long agentId) {

        return null;
    }


    public ApiAgentInfoWSDTO apiGetAgentInfosService(long agentId) {

        ApiAgentInfoWSDTO agentInfoWSDTO = new ApiAgentInfoWSDTO();
        agentInfoWSDTO.setReadySession(sessionRepository.countByAgentIdAndSessionState(agentId, AppConstant.READY_SESSION));
        agentInfoWSDTO.setActiveSession(sessionRepository.countByAgentIdAndSessionState(agentId, AppConstant.ACTIVE_SESSION));
        agentInfoWSDTO.setReadyInquiry(inquiryRepository.countByAgentIdAndInquiryState(agentId, AppConstant.READY_INQUIRY));
        agentInfoWSDTO.setActiveInquiry(inquiryRepository.countByAgentIdAndInquiryState(agentId, AppConstant.ACTIVE_INQUIRY));

        return agentInfoWSDTO;
    }


    public ApiAgentSipAccountWSDTO apiGetAgentSipAccountService(long agentId, String processId) {

        ApiAgentSipAccountWSDTO sipAccountWSDTO = new ApiAgentSipAccountWSDTO();
        List<ProcessSipChannelDBModel> sipChannels = processSipChannelRepository.findByProcessId(processId);
        if (!sipChannels.isEmpty()){
            sipAccountWSDTO.setSipChannel(sipChannels.get(0));
        }
        List<UserDetailsDBModel> userDetails = userDetailsRepository.findByUserId(agentId);
        if (!userDetails.isEmpty() && userDetails.get(0).getSipChannel() != null){
            sipAccountWSDTO.setSipAccount(userDetails.get(0).getSipChannel());
        }
        return sipAccountWSDTO;
    }

}
