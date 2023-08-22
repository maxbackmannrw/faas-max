package com.faas.core.utils.task.service;

import com.faas.core.base.model.db.channel.account.WappAccountDBModel;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.repo.channel.account.WappAccountRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.service.wapp.WappManagerRESTCall;
import com.faas.core.utils.task.model.ws.SystemStateWSModel;
import com.faas.core.utils.task.model.ws.dto.SystemStateWSDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class SystemTaskService {

    @Autowired
    WappAccountRepository wappAccountRepository;

    @Autowired
    WappManagerRESTCall wappManagerRESTCall;

    @Autowired
    AppUtils appUtils;


    public SystemStateWSModel getSystemState(String from) {

        SystemStateWSModel response = new SystemStateWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<SystemStateWSDTO>stateWSDTOS = new ArrayList<>();

        stateWSDTOS.add(setSystemStateWSDTO(from));

        response.setSystemStates(stateWSDTOS);
        general.setOperation("getSystemState");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public SystemStateWSDTO setSystemStateWSDTO(String from){

        SystemStateWSDTO systemStateWSDTO = new SystemStateWSDTO();
        systemStateWSDTO.setId(appUtils.generateUUID());
        systemStateWSDTO.setFrom(from);
        systemStateWSDTO.setcDate(appUtils.getCurrentTimeStamp());
        systemStateWSDTO.setStatus(1);

        return systemStateWSDTO;
    }


    public void refreshWappAccounts() {

        List<WappAccountDBModel> wappAccountDBModels = wappAccountRepository.findByStatus(1);
        for (WappAccountDBModel wappAccountDBModel : wappAccountDBModels) {
            try {
                wappManagerRESTCall.listAllWappInstances(wappAccountDBModel.getServerUrl());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
