package com.faas.core.utility.helpers.user;

import com.faas.core.base.model.db.user.details.dao.UserDataDAO;
import com.faas.core.base.model.db.utilz.DataTypeDBModel;
import com.faas.core.base.repo.channel.account.SipAccountRepository;
import com.faas.core.base.repo.channel.account.WappAccountRepository;
import com.faas.core.base.repo.user.details.UserDetailsRepository;
import com.faas.core.base.repo.utilz.DataTypeRepository;
import com.faas.core.utility.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserHelpers {

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Autowired
    DataTypeRepository dataTypeRepository;

    @Autowired
    SipAccountRepository sipAccountRepository;

    @Autowired
    WappAccountRepository wappAccountRepository;

    @Autowired
    AppUtils appUtils;


    public UserDataDAO mapUserDataDAO(String dataId,long dataTypeId,String value){

        Optional<DataTypeDBModel> dataTypeDBModel = dataTypeRepository.findById(dataTypeId);
        if (dataTypeDBModel.isPresent()){

            UserDataDAO userDataDAO = new UserDataDAO();
            userDataDAO.setDataId(dataId);
            userDataDAO.setDataType(dataTypeDBModel.get().getDataType());
            userDataDAO.setValue(value);
            userDataDAO.setcDate(appUtils.getCurrentTimeStamp());
            userDataDAO.setStatus(1);

            return userDataDAO;
        }
        return null;
    }






}
