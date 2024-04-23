package com.faas.core.base.middleware.process.details.remote;

import com.faas.core.base.framework.process.details.remote.ProcessRemoteFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.remote.ProcessRemoteWSModel;
import com.faas.core.base.model.ws.process.details.remote.dto.ProcessRemoteWSDTO;
import com.faas.core.base.model.ws.remote.content.RemoteUrlWSModel;
import com.faas.core.base.model.ws.remote.content.dto.RemoteUrlWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ProcessRemoteMiddleware {


    @Autowired
    ProcessRemoteFramework processRemoteFramework;


    public ProcessRemoteWSModel getProcessRemotes(long userId,String processId) {

        ProcessRemoteWSModel response = new ProcessRemoteWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ProcessRemoteWSDTO> processRemoteWSDTOS = processRemoteFramework.getProcessRemotesService(userId,processId);
        if (processRemoteWSDTOS != null){
            response.setProcessRemotes(processRemoteWSDTOS);
        }

        general.setOperation("getProcessRemotes");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessRemoteWSModel getProcessRemotesByCategory(long userId,String processId,String remoteCategory) {

        ProcessRemoteWSModel response = new ProcessRemoteWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ProcessRemoteWSDTO> processRemoteWSDTOS = processRemoteFramework.getProcessRemotesByCategoryService(userId,processId,remoteCategory);
        if (processRemoteWSDTOS != null){
            response.setProcessRemotes(processRemoteWSDTOS);
        }

        general.setOperation("getProcessRemotesByCategory");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessRemoteWSModel getProcessRemote(long userId,String processId,String processRemoteId) {

        ProcessRemoteWSModel response = new ProcessRemoteWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessRemoteWSDTO> processRemoteWSDTOS = new ArrayList<>();

        ProcessRemoteWSDTO processRemoteWSDTO = processRemoteFramework.getProcessRemoteService(userId,processId,processRemoteId);
        if (processRemoteWSDTO != null){
            processRemoteWSDTOS.add(processRemoteWSDTO);
        }

        response.setProcessRemotes(processRemoteWSDTOS);
        general.setOperation("getProcessRemote");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessRemoteWSModel createProcessRemote(long userId,String processId,String remoteId,String remoteCategory) {

        ProcessRemoteWSModel response = new ProcessRemoteWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessRemoteWSDTO> processRemoteWSDTOS = new ArrayList<>();

        ProcessRemoteWSDTO processRemoteWSDTO = processRemoteFramework.createProcessRemoteService(userId,processId,remoteId,remoteCategory);
        if (processRemoteWSDTO != null){
            processRemoteWSDTOS.add(processRemoteWSDTO);
        }

        response.setProcessRemotes(processRemoteWSDTOS);
        general.setOperation("createProcessRemote");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessRemoteWSModel removeProcessRemote(long userId,String processId,String processRemoteId) {

        ProcessRemoteWSModel response = new ProcessRemoteWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessRemoteWSDTO> processRemoteWSDTOS = new ArrayList<>();

        ProcessRemoteWSDTO processRemoteWSDTO = processRemoteFramework.removeProcessRemoteService(userId,processId,processRemoteId);
        if (processRemoteWSDTO != null){
            processRemoteWSDTOS.add(processRemoteWSDTO);
        }

        response.setProcessRemotes(processRemoteWSDTOS);
        general.setOperation("removeProcessRemote");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public RemoteUrlWSModel getProcessRemoteUrls(long userId, String processId) {

        RemoteUrlWSModel response = new RemoteUrlWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<RemoteUrlWSDTO> remoteUrlWSDTOS = processRemoteFramework.getProcessRemoteUrlsService(userId,processId);
        if (remoteUrlWSDTOS != null){
            response.setRemoteUrls(remoteUrlWSDTOS);
        }

        general.setOperation("getProcessRemoteUrls");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
