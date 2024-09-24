package com.faas.core.api.framework.user;

import com.faas.core.api.model.ws.user.content.dto.ApiAgentWSDTO;
import com.faas.core.api.model.ws.user.details.dto.ApiAgentDetailsWSDTO;
import com.faas.core.api.model.ws.user.details.dto.ApiAgentInfoWSDTO;
import com.faas.core.api.model.ws.user.details.dto.ApiAgentSipAccountWSDTO;
import com.faas.core.data.db.user.content.UserDBModel;
import com.faas.core.data.db.user.details.UserDetailsDBModel;
import com.faas.core.data.repo.user.content.UserRepository;
import com.faas.core.data.repo.user.details.UserDetailsRepository;
import com.faas.core.misc.config.AppConstant;
import com.faas.core.misc.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ApiUserFramework {


    @Autowired
    UserRepository userRepository;

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Autowired
    AppUtils appUtils;


    public ApiAgentWSDTO fillAgentApiAgentWSDTO(UserDBModel userDBModel) {

        ApiAgentWSDTO apiAgentWSDTO = new ApiAgentWSDTO();
        userDBModel.setPassword("");
        apiAgentWSDTO.setAgent(userDBModel);
        List<UserDetailsDBModel> agentDetails = userDetailsRepository.findByUserId(userDBModel.getId());
        if (!agentDetails.isEmpty()) {
            apiAgentWSDTO.setAgentDetails(agentDetails.get(0));
        }

        return apiAgentWSDTO;
    }

    public ApiAgentWSDTO apiAgentLoginService(String userEmail, String password) {

        List<UserDBModel> userDBModels = userRepository.findByUserEmailAndPasswordAndUserTypeAndValidUser(userEmail.toLowerCase(), appUtils.base64Encoder(password), AppConstant.AGENT_USER, true);
        if (!userDBModels.isEmpty()) {
            return fillAgentApiAgentWSDTO(userDBModels.get(0));
        }
        return null;
    }

    public ApiAgentDetailsWSDTO apiGetAgentDetailsService(long agentId) {

        return null;
    }

    public ApiAgentSipAccountWSDTO apiGetAgentSipAccountService(long agentId, String processId) {

        ApiAgentSipAccountWSDTO sipAccountWSDTO = new ApiAgentSipAccountWSDTO();

        List<UserDetailsDBModel> userDetails = userDetailsRepository.findByUserId(agentId);
        if (!userDetails.isEmpty() && userDetails.get(0).getSipChannel() != null) {
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
