package com.faas.core.base.framework.user.settings;

import com.faas.core.data.db.user.settings.UserRoleDBModel;
import com.faas.core.base.model.ws.user.settings.dto.UserRoleWSDTO;
import com.faas.core.data.repo.user.settings.UserRoleRepository;
import com.faas.core.misc.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserSettingsFramework {


    @Autowired
    UserRoleRepository userRoleRepository;

    @Autowired
    AppUtils appUtils;


    public UserRoleWSDTO fillUserRoleWSDTO(UserRoleDBModel userRoleDBModel) {

        UserRoleWSDTO userRoleWSDTO = new UserRoleWSDTO();
        userRoleWSDTO.setUserRole(userRoleDBModel);
        return userRoleWSDTO;
    }

    public UserRoleDBModel createUserRoleService(String userRole, String userType) {

        UserRoleDBModel userRoleDBModel = new UserRoleDBModel();
        userRoleDBModel.setUserRole(userRole);
        userRoleDBModel.setUserType(userType);
        userRoleDBModel.setuDate(appUtils.getCurrentTimeStamp());
        userRoleDBModel.setcDate(appUtils.getCurrentTimeStamp());
        userRoleDBModel.setStatus(1);

        return userRoleRepository.save(userRoleDBModel);
    }

    public UserRoleDBModel updateUserRoleService(long roleId, String userRole, String userType) {

        Optional<UserRoleDBModel> userRoleDBModel = userRoleRepository.findById(roleId);
        if (userRoleDBModel.isPresent()) {
            userRoleDBModel.get().setUserRole(userRole);
            userRoleDBModel.get().setUserType(userType);
            userRoleDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            userRoleDBModel.get().setStatus(1);

            return userRoleRepository.save(userRoleDBModel.get());
        }
        return null;
    }

    public UserRoleDBModel removeUserRoleService(long roleId) {

        Optional<UserRoleDBModel> userRoleDBModel = userRoleRepository.findById(roleId);
        if (userRoleDBModel.isPresent()) {
            userRoleRepository.delete(userRoleDBModel.get());
            return userRoleDBModel.get();
        }
        return null;
    }

}
