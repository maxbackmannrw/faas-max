package com.faas.core.base.middleware.process.details.inquiry;

import com.faas.core.base.framework.process.details.inquiry.ProcessInquiryFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.content.ProcessDataWSModel;
import com.faas.core.base.model.ws.process.details.remote.ProcessRemoteWSModel;
import com.faas.core.base.model.ws.process.details.content.dto.ProcessDataWSDTO;
import com.faas.core.base.model.ws.process.details.remote.dto.ProcessRemoteWSDTO;
import com.faas.core.base.model.ws.process.details.inquiry.ProcessInquiryWSModel;
import com.faas.core.base.model.ws.process.details.inquiry.dto.ProcessInquiryWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ProcessInquiryMiddleware {


    @Autowired
    ProcessInquiryFramework processInquiryFramework;


    public ProcessInquiryWSModel getProcessInquiry(long userId, String processId) {

        ProcessInquiryWSModel response = new ProcessInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ProcessInquiryWSDTO processInquiryWSDTO = processInquiryFramework.getProcessInquiryService(userId,processId);
        if (processInquiryWSDTO != null){
            response.setProcessInquiry(processInquiryWSDTO);
        }

        general.setOperation("getProcessInquiry");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessInquiryWSModel updateProcessInquiry(long userId,String processId,String processInquiry) {

        ProcessInquiryWSModel response = new ProcessInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ProcessInquiryWSDTO processInquiryWSDTO = processInquiryFramework.updateProcessInquiryService(userId,processId,processInquiry);
        if (processInquiryWSDTO != null){
            response.setProcessInquiry(processInquiryWSDTO);
        }

        general.setOperation("updateProcessInquiry");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessDataWSModel getProcessInquiryDatas(long userId, String processId) {

        ProcessDataWSModel response = new ProcessDataWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ProcessDataWSDTO> processDataWSDTOS = processInquiryFramework.getProcessInquiryDatasService(userId,processId);
        if (processDataWSDTOS != null){
            response.setProcessDatas(processDataWSDTOS);
        }

        general.setOperation("getProcessInquiryDatas");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessDataWSModel getProcessInquiryData(long userId, String processId, String dataId) {

        ProcessDataWSModel response = new ProcessDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessDataWSDTO> processDataWSDTOS = new ArrayList<>();

        ProcessDataWSDTO processDataWSDTO = processInquiryFramework.getProcessInquiryDataService(userId,processId,dataId);
        if (processDataWSDTO != null){
            processDataWSDTOS.add(processDataWSDTO);
        }

        response.setProcessDatas(processDataWSDTOS);
        general.setOperation("getProcessInquiryData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessDataWSModel createProcessInquiryData(long userId, String processId, long typeId, String value) {

        ProcessDataWSModel response = new ProcessDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessDataWSDTO> processDataWSDTOS = new ArrayList<>();

        ProcessDataWSDTO processDataWSDTO = processInquiryFramework.createProcessInquiryDataService(userId,processId,typeId,value);
        if (processDataWSDTO != null){
            processDataWSDTOS.add(processDataWSDTO);
        }

        response.setProcessDatas(processDataWSDTOS);
        general.setOperation("createProcessInquiryData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessDataWSModel updateProcessInquiryData(long userId, String processId, String dataId,long typeId, String value) {

        ProcessDataWSModel response = new ProcessDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessDataWSDTO> processDataWSDTOS = new ArrayList<>();

        ProcessDataWSDTO processDataWSDTO = processInquiryFramework.updateProcessInquiryDataService(userId,processId,dataId,typeId,value);
        if (processDataWSDTO != null){
            processDataWSDTOS.add(processDataWSDTO);
        }

        response.setProcessDatas(processDataWSDTOS);
        general.setOperation("updateProcessInquiryData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessDataWSModel removeProcessInquiryData(long userId, String processId, String dataId) {

        ProcessDataWSModel response = new ProcessDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessDataWSDTO> processDataWSDTOS = new ArrayList<>();

        ProcessDataWSDTO processDataWSDTO = processInquiryFramework.removeProcessInquiryDataService(userId,processId,dataId);
        if (processDataWSDTO != null){
            processDataWSDTOS.add(processDataWSDTO);
        }

        response.setProcessDatas(processDataWSDTOS);
        general.setOperation("removeProcessInquiryData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ProcessRemoteWSModel getProcessInquiryRemotes(long userId, String processId) {

        ProcessRemoteWSModel response = new ProcessRemoteWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ProcessRemoteWSDTO> processRemoteWSDTOS = processInquiryFramework.getProcessInquiryRemotesService(userId,processId);
        if (processRemoteWSDTOS != null){
            response.setProcessRemotes(processRemoteWSDTOS);
        }

        general.setOperation("getProcessInquiryRemotes");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessRemoteWSModel getProcessInquiryRemote(long userId, String processId, String remoteId) {

        ProcessRemoteWSModel response = new ProcessRemoteWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessRemoteWSDTO> processRemoteWSDTOS = new ArrayList<>();

        ProcessRemoteWSDTO processRemoteWSDTO = processInquiryFramework.getProcessInquiryRemoteService(userId,processId,remoteId);
        if (processRemoteWSDTO != null){
            processRemoteWSDTOS.add(processRemoteWSDTO);
        }

        response.setProcessRemotes(processRemoteWSDTOS);
        general.setOperation("getProcessInquiryRemote");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessRemoteWSModel createProcessInquiryRemote(long userId,String processId,String remoteId) {

        ProcessRemoteWSModel response = new ProcessRemoteWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessRemoteWSDTO> processRemoteWSDTOS = new ArrayList<>();

        ProcessRemoteWSDTO processRemoteWSDTO = processInquiryFramework.createProcessInquiryRemoteService(userId,processId,remoteId);
        if (processRemoteWSDTO != null){
            processRemoteWSDTOS.add(processRemoteWSDTO);
        }

        response.setProcessRemotes(processRemoteWSDTOS);
        general.setOperation("createProcessInquiryRemote");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessRemoteWSModel removeProcessInquiryRemote(long userId, String processId, String remoteId) {

        ProcessRemoteWSModel response = new ProcessRemoteWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessRemoteWSDTO> processRemoteWSDTOS = new ArrayList<>();

        ProcessRemoteWSDTO processRemoteWSDTO = processInquiryFramework.removeProcessInquiryRemoteService(userId,processId,remoteId);
        if (processRemoteWSDTO != null){
            processRemoteWSDTOS.add(processRemoteWSDTO);
        }

        response.setProcessRemotes(processRemoteWSDTOS);
        general.setOperation("removeProcessInquiryRemote");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
