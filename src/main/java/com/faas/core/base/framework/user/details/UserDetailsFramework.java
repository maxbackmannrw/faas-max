package com.faas.core.base.framework.user.details;

import com.faas.core.base.model.db.user.content.UserDBModel;
import com.faas.core.base.model.db.user.details.UserDetailsDBModel;
import com.faas.core.base.model.db.user.details.dao.UserSipChannelDAO;
import com.faas.core.base.model.db.user.details.dao.UserWappChannelDAO;
import com.faas.core.base.model.db.user.details.dao.UserDataDAO;
import com.faas.core.base.model.db.channel.account.SipAccountDBModel;
import com.faas.core.base.model.db.channel.account.WappAccountDBModel;
import com.faas.core.base.model.ws.user.details.dto.UserDataWSDTO;
import com.faas.core.base.model.ws.user.details.dto.UserDetailsWSDTO;
import com.faas.core.base.model.ws.user.details.dto.UserSipChannelWSDTO;
import com.faas.core.base.model.ws.user.details.dto.UserWappChannelWSDTO;
import com.faas.core.base.repo.user.content.UserRepository;
import com.faas.core.base.repo.user.details.UserDetailsRepository;
import com.faas.core.base.repo.channel.account.SipAccountRepository;
import com.faas.core.base.repo.channel.account.WappAccountRepository;
import com.faas.core.base.repo.utilz.DataTypeRepository;
import com.faas.core.utility.config.AppUtils;
import com.faas.core.utility.helpers.user.UserHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UserDetailsFramework {


    @Autowired
    UserHelpers userHelpers;

    @Autowired
    UserRepository userRepository;

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


    public UserDetailsWSDTO getUserDetailsService(long selectedId) {

        Optional<UserDBModel> userDBModel = userRepository.findById(selectedId);
        if (userDBModel.isPresent()){

            UserDetailsWSDTO userDetailsWSDTO = new UserDetailsWSDTO();
            userDetailsWSDTO.setUser(userDBModel.get());
            List<UserDetailsDBModel> userDetailsDBModels = userDetailsRepository.findByUserId(selectedId);

            if (!userDetailsDBModels.isEmpty()){
                userDetailsWSDTO.setUserDetails(userDetailsDBModels.get(0));
            }
            return userDetailsWSDTO;
        }
        return null;
    }


    public UserDataWSDTO fillUserDataWSDTO(UserDataDAO userDataDAO){

        UserDataWSDTO userDataWSDTO = new UserDataWSDTO();
        userDataWSDTO.setUserData(userDataDAO);

        return userDataWSDTO;
    }

    public UserDataDAO createUserDataService(long selectedId,long dataTypeId,String value){

        List<UserDetailsDBModel> userDetailsDBModels = userDetailsRepository.findByUserId(selectedId);
        if (!userDetailsDBModels.isEmpty()){

            UserDataDAO userDataDAO = userHelpers.mapUserDataDAO(appUtils.generateUUID(),dataTypeId,value);
            if (userDataDAO != null){

                userDetailsDBModels.get(0).getUserDatas().add(userDataDAO);
                userDetailsDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
                userDetailsRepository.save(userDetailsDBModels.get(0));

                return userDataDAO;
            }
        }
        return null;
    }

    public UserDataDAO updateUserDataService(long selectedId,String dataId,long dataTypeId,String value){

        List<UserDetailsDBModel> userDetailsDBModels = userDetailsRepository.findByUserId(selectedId);
        if (!userDetailsDBModels.isEmpty() && userDetailsDBModels.get(0).getUserDatas() != null){
            for (int i=0;i<userDetailsDBModels.get(0).getUserDatas().size();i++){
                if (userDetailsDBModels.get(0).getUserDatas().get(i).getDataId().equalsIgnoreCase(dataId)){

                    UserDataDAO userDataDAO = userHelpers.mapUserDataDAO(dataId,dataTypeId,value);
                    userDetailsDBModels.get(0).getUserDatas().set(i,userDataDAO);
                    userDetailsDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
                    userDetailsRepository.save(userDetailsDBModels.get(0));

                    return userDataDAO;
                }
            }
        }
        return null;
    }

    public UserDataDAO removeUserDataService(long selectedId,String dataId){

        List<UserDetailsDBModel> userDetailsDBModels = userDetailsRepository.findByUserId(selectedId);
        if (!userDetailsDBModels.isEmpty() && userDetailsDBModels.get(0).getUserDatas() != null){
            for (int i=0;i<userDetailsDBModels.get(0).getUserDatas().size();i++){
                if (userDetailsDBModels.get(0).getUserDatas().get(i).getDataId().equalsIgnoreCase(dataId)){

                    UserDataDAO userDataDAO = userDetailsDBModels.get(0).getUserDatas().get(i);
                    userDetailsDBModels.get(0).getUserDatas().remove(userDataDAO);
                    userDetailsDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
                    userDetailsRepository.save(userDetailsDBModels.get(0));

                    return userDataDAO;
                }
            }
        }
        return null;
    }



    public UserSipChannelWSDTO getUserSipChannelService(long selectedId){

        List<UserDetailsDBModel> userDetailsDBModels = userDetailsRepository.findByUserId(selectedId);
        if (!userDetailsDBModels.isEmpty() && userDetailsDBModels.get(0).getSipChannel() != null){
            return new UserSipChannelWSDTO(userDetailsDBModels.get(0).getSipChannel());
        }
        return null;
    }

    public UserSipChannelWSDTO createUserSipChannelService(long selectedId, String accountId){

        List<UserDetailsDBModel> userDetailsDBModels = userDetailsRepository.findByUserId(selectedId);
        Optional<SipAccountDBModel> sipAccountDBModel = sipAccountRepository.findById(accountId);
        if (!userDetailsDBModels.isEmpty() && sipAccountDBModel.isPresent()){

            UserSipChannelDAO userSipChannelDAO = new UserSipChannelDAO();
            userSipChannelDAO.setAccountId(sipAccountDBModel.get().getId());
            userSipChannelDAO.setAccount(sipAccountDBModel.get().getAccount());
            userSipChannelDAO.setUserName(sipAccountDBModel.get().getUserName());
            userSipChannelDAO.setAuthUser(sipAccountDBModel.get().getAuthUser());
            userSipChannelDAO.setPassword(sipAccountDBModel.get().getPassword());
            userSipChannelDAO.setSipUrl(sipAccountDBModel.get().getSipUrl());
            if (sipAccountDBModel.get().getAccountDatas() != null){
                userSipChannelDAO.setAccountDatas(sipAccountDBModel.get().getAccountDatas());
            }else {
                userSipChannelDAO.setAccountDatas(new ArrayList<>());
            }
            userSipChannelDAO.setProvider(sipAccountDBModel.get().getProvider());
            userSipChannelDAO.setcDate(appUtils.getCurrentTimeStamp());
            userSipChannelDAO.setStatus(1);

            userDetailsDBModels.get(0).setSipChannel(userSipChannelDAO);
            userDetailsDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
            userDetailsRepository.save(userDetailsDBModels.get(0));

            return new UserSipChannelWSDTO(userSipChannelDAO);
        }
        return null;
    }

    public UserSipChannelWSDTO removeUserSipChannelService(long selectedId){

        List<UserDetailsDBModel> userDetailsDBModels = userDetailsRepository.findByUserId(selectedId);
        if (!userDetailsDBModels.isEmpty() && userDetailsDBModels.get(0).getSipChannel() != null){

            UserSipChannelDAO userSipChannelDAO = userDetailsDBModels.get(0).getSipChannel();
            userDetailsDBModels.get(0).setSipChannel(null);
            userDetailsDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
            userDetailsRepository.save(userDetailsDBModels.get(0));

            return new UserSipChannelWSDTO(userSipChannelDAO);
        }
        return null;
    }



    public UserWappChannelWSDTO getUserWappChannelService(long selectedId){

        List<UserDetailsDBModel> userDetailsDBModels = userDetailsRepository.findByUserId(selectedId);
        if (!userDetailsDBModels.isEmpty() && userDetailsDBModels.get(0).getWappChannel() != null){
            return new UserWappChannelWSDTO(userDetailsDBModels.get(0).getWappChannel());
        }
        return null;
    }

    public UserWappChannelWSDTO createUserWappChannelService(long selectedId, String accountId){

        List<UserDetailsDBModel> userDetailsDBModels = userDetailsRepository.findByUserId(selectedId);
        Optional<WappAccountDBModel> wappAccountDBModel = wappAccountRepository.findById(accountId);
        if (!userDetailsDBModels.isEmpty() && wappAccountDBModel.isPresent()){

            UserWappChannelDAO userWappChannelDAO = new UserWappChannelDAO();
            userWappChannelDAO.setAccountId(accountId);
            userWappChannelDAO.setAccount(wappAccountDBModel.get().getAccount());
            userWappChannelDAO.setInstanceKey(wappAccountDBModel.get().getInstanceKey());
            userWappChannelDAO.setPhoneNumber(wappAccountDBModel.get().getPhoneNumber());
            userWappChannelDAO.setServerUrl(wappAccountDBModel.get().getServerUrl());
            if (wappAccountDBModel.get().getAccountDatas() !=null){
                userWappChannelDAO.setAccountDatas(wappAccountDBModel.get().getAccountDatas());
            }else {
                userWappChannelDAO.setAccountDatas(new ArrayList<>());
            }
            userWappChannelDAO.setcDate(appUtils.getCurrentTimeStamp());
            userWappChannelDAO.setStatus(1);

            userDetailsDBModels.get(0).setWappChannel(userWappChannelDAO);
            userDetailsDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
            userDetailsRepository.save(userDetailsDBModels.get(0));

            return new UserWappChannelWSDTO(userWappChannelDAO);
        }
        return null;
    }

    public UserWappChannelWSDTO removeUserWappChannelService(long selectedId){

        List<UserDetailsDBModel> userDetailsDBModels = userDetailsRepository.findByUserId(selectedId);
        if (!userDetailsDBModels.isEmpty() && userDetailsDBModels.get(0).getWappChannel() != null){

            UserWappChannelDAO userWappChannelDAO = userDetailsDBModels.get(0).getWappChannel();
            userDetailsDBModels.get(0).setWappChannel(null);
            userDetailsDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
            userDetailsRepository.save(userDetailsDBModels.get(0));

            return new UserWappChannelWSDTO(userWappChannelDAO);
        }
        return null;
    }



}
