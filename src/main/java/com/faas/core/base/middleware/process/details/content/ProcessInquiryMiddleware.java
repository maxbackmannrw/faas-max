package com.faas.core.base.middleware.process.details.content;

import com.faas.core.base.framework.process.details.content.ProcessInquiryFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.content.ProcessDataWSModel;
import com.faas.core.base.model.ws.process.details.content.dto.ProcessDataWSDTO;
import com.faas.core.base.model.ws.process.details.content.ProcessInquiryWSModel;
import com.faas.core.base.model.ws.process.details.content.dto.ProcessInquiryWSDTO;
import com.faas.core.utility.config.AppConstant;
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



}
