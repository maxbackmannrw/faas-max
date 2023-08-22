package com.faas.core.base.middleware.user.details;

import com.faas.core.base.framework.user.details.UserDetailsFramework;
import com.faas.core.base.model.db.user.details.UserDetailsDBModel;
import com.faas.core.base.model.db.user.details.dao.UserDataDAO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.user.details.UserDataWSModel;
import com.faas.core.base.model.ws.user.details.UserDetailsWSModel;
import com.faas.core.base.model.ws.user.details.UserSipChannelWSModel;
import com.faas.core.base.model.ws.user.details.UserWappChannelWSModel;
import com.faas.core.base.model.ws.user.details.dto.UserDataWSDTO;
import com.faas.core.base.model.ws.user.details.dto.UserDetailsWSDTO;
import com.faas.core.base.model.ws.user.details.dto.UserSipChannelWSDTO;
import com.faas.core.base.model.ws.user.details.dto.UserWappChannelWSDTO;
import com.faas.core.base.repo.user.details.UserDetailsRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDetailsMiddleware {


    @Autowired
    UserDetailsFramework userDetailsFramework;

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Autowired
    AppUtils appUtils;


    public UserDetailsWSModel getUserDetails(long userId,long selectedId) {

        UserDetailsWSModel response = new UserDetailsWSModel();
        GeneralWSModel general = new GeneralWSModel();

        UserDetailsWSDTO userDetailsWSDTO = userDetailsFramework.getUserDetailsService(selectedId);
        if (userDetailsWSDTO != null){
            response.setUserDetails(userDetailsWSDTO);
        }

        general.setOperation("getUserDetails");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public UserDataWSModel getUserDatas(long userId,long selectedId) {

        UserDataWSModel response = new UserDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<UserDataWSDTO>userDataWSDTOS = new ArrayList<>();

        List<UserDetailsDBModel> userDetailsDBModels = userDetailsRepository.findByUserId(selectedId);
        if (userDetailsDBModels.size()>0 && userDetailsDBModels.get(0).getUserDatas() != null){
            for (int i=0;i<userDetailsDBModels.get(0).getUserDatas().size();i++){
                userDataWSDTOS.add(userDetailsFramework.fillUserDataWSDTO(userDetailsDBModels.get(0).getUserDatas().get(i)));
            }
        }

        response.setUserDatas(userDataWSDTOS);
        general.setOperation("getUserDatas");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public UserDataWSModel getUserData(long userId,long selectedId,String dataId) {

        UserDataWSModel response = new UserDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<UserDataWSDTO>userDataWSDTOS = new ArrayList<>();

        List<UserDetailsDBModel> userDetailsDBModels = userDetailsRepository.findByUserId(selectedId);
        if (userDetailsDBModels.size()>0 && userDetailsDBModels.get(0).getUserDatas() != null){
            for (int i=0;i<userDetailsDBModels.get(0).getUserDatas().size();i++){
                if (userDetailsDBModels.get(i).getUserDatas().get(i).getDataId().equalsIgnoreCase(dataId)){
                    userDataWSDTOS.add(userDetailsFramework.fillUserDataWSDTO(userDetailsDBModels.get(0).getUserDatas().get(i)));
                }
            }
        }

        response.setUserDatas(userDataWSDTOS);
        general.setOperation("getUserData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public UserDataWSModel createUserData(long userId,long selectedId,long dataTypeId,String value) {

        UserDataWSModel response = new UserDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<UserDataWSDTO>userDataWSDTOS = new ArrayList<>();

        UserDataDAO userDataDAO = userDetailsFramework.createUserDataService(selectedId,dataTypeId,value);
        if (userDataDAO != null){
            userDataWSDTOS.add(userDetailsFramework.fillUserDataWSDTO(userDataDAO));
        }

        response.setUserDatas(userDataWSDTOS);
        general.setOperation("createUserData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public UserDataWSModel updateUserData(long userId,long selectedId,String dataId,long dataTypeId,String value) {

        UserDataWSModel response = new UserDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<UserDataWSDTO>userDataWSDTOS = new ArrayList<>();

        UserDataDAO userDataDAO = userDetailsFramework.updateUserDataService(selectedId,dataId,dataTypeId,value);
        if (userDataDAO != null){
            userDataWSDTOS.add(userDetailsFramework.fillUserDataWSDTO(userDataDAO));
        }

        response.setUserDatas(userDataWSDTOS);
        general.setOperation("updateUserData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public UserDataWSModel removeUserData(long userId,long selectedId,String dataId) {

        UserDataWSModel response = new UserDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<UserDataWSDTO>userDataWSDTOS = new ArrayList<>();

        UserDataDAO userDataDAO = userDetailsFramework.removeUserDataService(selectedId,dataId);
        if (userDataDAO != null){
            userDataWSDTOS.add(userDetailsFramework.fillUserDataWSDTO(userDataDAO));
        }

        response.setUserDatas(userDataWSDTOS);
        general.setOperation("removeUserData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }





    public UserSipChannelWSModel getUserSipChannel(long userId, long selectedId) {

        UserSipChannelWSModel response = new UserSipChannelWSModel();
        GeneralWSModel general = new GeneralWSModel();

        UserSipChannelWSDTO sipChannelWSDTO = userDetailsFramework.getUserSipChannelService(selectedId);
        if (sipChannelWSDTO != null){
            response.setUserSipChannel(sipChannelWSDTO);
        }

        general.setOperation("getUserSipChannel");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public UserSipChannelWSModel createUserSipChannel(long userId, long selectedId, String accountId) {

        UserSipChannelWSModel response = new UserSipChannelWSModel();
        GeneralWSModel general = new GeneralWSModel();

        UserSipChannelWSDTO sipChannelWSDTO = userDetailsFramework.createUserSipChannelService(selectedId,accountId);
        if (sipChannelWSDTO != null){
            response.setUserSipChannel(sipChannelWSDTO);
        }

        general.setOperation("createUserSipChannel");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public UserSipChannelWSModel removeUserSipChannel(long userId, long selectedId) {

        UserSipChannelWSModel response = new UserSipChannelWSModel();
        GeneralWSModel general = new GeneralWSModel();

        UserSipChannelWSDTO sipChannelWSDTO = userDetailsFramework.removeUserSipChannelService(selectedId);
        if (sipChannelWSDTO != null){
            response.setUserSipChannel(sipChannelWSDTO);
        }

        general.setOperation("removeUserSipChannel");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }




    public UserWappChannelWSModel getUserWappChannel(long userId, long selectedId) {

        UserWappChannelWSModel response = new UserWappChannelWSModel();
        GeneralWSModel general = new GeneralWSModel();

        UserWappChannelWSDTO wappChannelWSDTO = userDetailsFramework.getUserWappChannelService(selectedId);
        if (wappChannelWSDTO != null){
            response.setUserWappChannel(wappChannelWSDTO);
        }

        general.setOperation("getUserWappChannel");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public UserWappChannelWSModel createUserWappChannel(long userId, long selectedId, String accountId) {

        UserWappChannelWSModel response = new UserWappChannelWSModel();
        GeneralWSModel general = new GeneralWSModel();

        UserWappChannelWSDTO wappChannelWSDTO = userDetailsFramework.createUserWappChannelService(selectedId,accountId);
        if (wappChannelWSDTO != null){
            response.setUserWappChannel(wappChannelWSDTO);
        }

        general.setOperation("createUserWappChannel");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public UserWappChannelWSModel removeUserWappChannel(long userId, long selectedId) {

        UserWappChannelWSModel response = new UserWappChannelWSModel();
        GeneralWSModel general = new GeneralWSModel();

        UserWappChannelWSDTO wappChannelWSDTO = userDetailsFramework.removeUserWappChannelService(selectedId);
        if (wappChannelWSDTO != null){
            response.setUserWappChannel(wappChannelWSDTO);
        }

        general.setOperation("removeUserWappChannel");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }




}
