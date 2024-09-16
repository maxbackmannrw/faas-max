package com.faas.core.api.framework.agent.content;

import com.faas.core.data.ws.api.agent.content.dto.ApiAgentWSDTO;
import com.faas.core.data.db.user.content.UserDBModel;
import com.faas.core.data.db.user.details.UserDetailsDBModel;
import com.faas.core.data.repo.channel.account.SipAccountRepository;
import com.faas.core.data.repo.user.content.UserRepository;
import com.faas.core.data.repo.user.details.UserDetailsRepository;
import com.faas.core.data.repo.user.settings.UserRoleRepository;
import com.faas.core.misc.config.AppConstant;
import com.faas.core.misc.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ApiAgentFramework {


    @Autowired
    UserRepository userRepository;

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Autowired
    SipAccountRepository sipAccountRepository;

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


}
