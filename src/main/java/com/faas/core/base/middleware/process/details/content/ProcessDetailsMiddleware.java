package com.faas.core.base.middleware.process.details.content;

import com.faas.core.base.framework.process.details.content.ProcessDetailsFramework;
import com.faas.core.base.model.db.process.content.dao.ProcessDataDAO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.content.ProcessDataWSModel;
import com.faas.core.base.model.ws.process.details.content.ProcessDetailsWSModel;
import com.faas.core.base.model.ws.process.details.content.ProcessRemoteWSModel;
import com.faas.core.base.model.ws.process.details.content.dto.ProcessDataWSDTO;
import com.faas.core.base.model.ws.process.details.content.dto.ProcessDetailsWSDTO;
import com.faas.core.base.model.ws.process.details.content.dto.ProcessRemoteWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ProcessDetailsMiddleware {


    @Autowired
    ProcessDetailsFramework processDetailsFramework;


    public ProcessDetailsWSModel getProcessDetails(long userId, String processId) {

        ProcessDetailsWSModel response = new ProcessDetailsWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ProcessDetailsWSDTO processDetailsWSDTO = processDetailsFramework.getProcessDetailsService(processId);
        if (processDetailsWSDTO != null){
            response.setProcessDetails(processDetailsWSDTO);
        }

        general.setOperation("getProcessDetails");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessDataWSModel getProcessDatas(long userId, String processId) {

        ProcessDataWSModel response = new ProcessDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessDataWSDTO> processDataWSDTOS = new ArrayList<>();


        response.setProcessDatas(processDataWSDTOS);
        general.setOperation("getProcessDatas");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessDataWSModel getProcessData(long userId, String processId, String dataId) {

        ProcessDataWSModel response = new ProcessDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessDataWSDTO> processDataWSDTOS = new ArrayList<>();



        response.setProcessDatas(processDataWSDTOS);
        general.setOperation("getProcessData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessDataWSModel createProcessData(long userId,String processId,long typeId,String value) {

        ProcessDataWSModel response = new ProcessDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessDataWSDTO> processDataWSDTOS = new ArrayList<>();

        ProcessDataDAO processDataDAO = processDetailsFramework.createProcessDataService(processId,typeId,value);
        if (processDataDAO != null) {
            processDataWSDTOS.add(processDetailsFramework.fillProcessDataWSDTO(processDataDAO));
        }

        response.setProcessDatas(processDataWSDTOS);
        general.setOperation("createProcessData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessDataWSModel updateProcessData(long userId,String processId,String dataId,long typeId,String value) {

        ProcessDataWSModel response = new ProcessDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessDataWSDTO> processDataWSDTOS = new ArrayList<>();

        ProcessDataDAO processDataDAO = processDetailsFramework.updateProcessDataService(processId,dataId,typeId,value);
        if (processDataDAO != null) {
            processDataWSDTOS.add(processDetailsFramework.fillProcessDataWSDTO(processDataDAO));
        }

        response.setProcessDatas(processDataWSDTOS);
        general.setOperation("updateProcessData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessDataWSModel removeProcessData(long userId,String processId,String dataId) {

        ProcessDataWSModel response = new ProcessDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessDataWSDTO> processDataWSDTOS = new ArrayList<>();

        ProcessDataDAO processDataDAO = processDetailsFramework.removeProcessDataService(processId,dataId);
        if (processDataDAO != null) {
            processDataWSDTOS.add(processDetailsFramework.fillProcessDataWSDTO(processDataDAO));
        }

        response.setProcessDatas(processDataWSDTOS);
        general.setOperation("removeProcessData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ProcessRemoteWSModel getProcessRemotes(long userId,String processId) {

        ProcessRemoteWSModel response = new ProcessRemoteWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ProcessRemoteWSDTO> processRemoteWSDTOS = processDetailsFramework.getProcessRemotesService(userId,processId);
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

    public ProcessRemoteWSModel getProcessRemote(long userId,String processId,String processRemoteId) {

        ProcessRemoteWSModel response = new ProcessRemoteWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessRemoteWSDTO> processRemoteWSDTOS = new ArrayList<>();

        ProcessRemoteWSDTO processRemoteWSDTO = processDetailsFramework.getProcessRemoteService(userId,processId,processRemoteId);
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

    public ProcessRemoteWSModel createProcessRemote(long userId,String processId,String remoteId) {

        ProcessRemoteWSModel response = new ProcessRemoteWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessRemoteWSDTO> processRemoteWSDTOS = new ArrayList<>();

        ProcessRemoteWSDTO processRemoteWSDTO = processDetailsFramework.createProcessRemoteService(userId,processId,remoteId);
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

    public ProcessRemoteWSModel updateProcessRemote(long userId,String processId,String processRemoteId,String remoteState) {

        ProcessRemoteWSModel response = new ProcessRemoteWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessRemoteWSDTO> processRemoteWSDTOS = new ArrayList<>();

        ProcessRemoteWSDTO processRemoteWSDTO = processDetailsFramework.updateProcessRemoteService(userId,processId,processRemoteId,remoteState);
        if (processRemoteWSDTO != null){
            processRemoteWSDTOS.add(processRemoteWSDTO);
        }

        response.setProcessRemotes(processRemoteWSDTOS);
        general.setOperation("updateProcessRemote");
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

        ProcessRemoteWSDTO processRemoteWSDTO = processDetailsFramework.removeProcessRemoteService(userId,processId,processRemoteId);
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


}
