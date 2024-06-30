package com.faas.core.api.framework.agent.details;

import com.faas.core.api.model.ws.agent.details.dto.ApiAgentDetailsWSDTO;
import com.faas.core.api.model.ws.agent.details.dto.ApiAgentInfoWSDTO;
import com.faas.core.api.model.ws.agent.details.dto.ApiAgentSipAccountWSDTO;
import com.faas.core.base.model.db.campaign.details.channel.content.dao.CampaignSipChannelDAO;
import com.faas.core.base.model.db.user.details.UserDetailsDBModel;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.user.content.UserRepository;
import com.faas.core.base.repo.user.details.UserDetailsRepository;
import com.faas.core.utility.config.AppConstant;
import com.faas.core.utility.config.AppUtils;
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
    OperationRepository operationRepository;

    @Autowired
    AppUtils appUtils;


    public ApiAgentDetailsWSDTO apiGetAgentDetailsService(long agentId) {

        return null;
    }

    public ApiAgentSipAccountWSDTO apiGetAgentSipAccountService(long agentId, String processId) {

        ApiAgentSipAccountWSDTO sipAccountWSDTO = new ApiAgentSipAccountWSDTO();

        List<UserDetailsDBModel> userDetails = userDetailsRepository.findByUserId(agentId);
        if (!userDetails.isEmpty() && userDetails.get(0).getSipChannel() != null){
            sipAccountWSDTO.setSipAccount(userDetails.get(0).getSipChannel());
        }
        return sipAccountWSDTO;
    }


    public ApiAgentInfoWSDTO apiGetAgentInfoService(long agentId) {

        ApiAgentInfoWSDTO agentInfoWSDTO = new ApiAgentInfoWSDTO();
        // agentInfoWSDTO.setReadyInquiry(inquiryRepository.countByAgentIdAndInquiryState(agentId, AppConstant.READY_INQUIRY));
        // agentInfoWSDTO.setActiveInquiry(inquiryRepository.countByAgentIdAndInquiryState(agentId, AppConstant.ACTIVE_INQUIRY));

        return agentInfoWSDTO;
    }


}
