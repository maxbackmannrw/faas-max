package com.faas.core.base.middleware.process.details.inquiry;

import com.faas.core.base.framework.process.details.inquiry.ProcessInquiryFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.inquiry.ProcessInquiryDataWSModel;
import com.faas.core.base.model.ws.process.details.inquiry.ProcessInquiryWSModel;
import com.faas.core.base.model.ws.process.details.inquiry.dto.ProcessInquiryDataWSDTO;
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


    public ProcessInquiryWSModel updateProcessInquiry(long userId, String processId,String processInquiry,String inquiryDesc) {

        ProcessInquiryWSModel response = new ProcessInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ProcessInquiryWSDTO processInquiryWSDTO = processInquiryFramework.updateProcessInquiryService(userId,processId,processInquiry,inquiryDesc);
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


    public ProcessInquiryWSModel removeProcessInquiry(long userId, String processId) {

        ProcessInquiryWSModel response = new ProcessInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ProcessInquiryWSDTO processInquiryWSDTO = processInquiryFramework.removeProcessInquiryService(userId,processId);
        if (processInquiryWSDTO != null){
            response.setProcessInquiry(processInquiryWSDTO);
        }

        general.setOperation("removeProcessInquiry");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ProcessInquiryDataWSModel getProcessInquiryDatas(long userId, String processId) {

        ProcessInquiryDataWSModel response = new ProcessInquiryDataWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ProcessInquiryDataWSDTO> processInquiryDataWSDTOS = processInquiryFramework.getProcessInquiryDatasService(userId,processId);
        if (processInquiryDataWSDTOS != null){
            response.setInquiryDatas(processInquiryDataWSDTOS);
        }

        general.setOperation("getProcessInquiryDatas");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessInquiryDataWSModel getProcessInquiryData(long userId, String processId, String dataId) {

        ProcessInquiryDataWSModel response = new ProcessInquiryDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessInquiryDataWSDTO> processInquiryDataWSDTOS = new ArrayList<>();

        ProcessInquiryDataWSDTO processInquiryDataWSDTO = processInquiryFramework.getProcessInquiryDataService(userId,processId,dataId);
        if (processInquiryDataWSDTO != null){
            processInquiryDataWSDTOS.add(processInquiryDataWSDTO);
        }

        response.setInquiryDatas(processInquiryDataWSDTOS);
        general.setOperation("getProcessInquiryData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessInquiryDataWSModel createProcessInquiryData(long userId, String processId, long typeId, String value) {

        ProcessInquiryDataWSModel response = new ProcessInquiryDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessInquiryDataWSDTO> processInquiryDataWSDTOS = new ArrayList<>();

        ProcessInquiryDataWSDTO processInquiryDataWSDTO = processInquiryFramework.createProcessInquiryDataService(userId,processId,typeId,value);
        if (processInquiryDataWSDTO != null){
            processInquiryDataWSDTOS.add(processInquiryDataWSDTO);
        }

        response.setInquiryDatas(processInquiryDataWSDTOS);
        general.setOperation("createProcessInquiryData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessInquiryDataWSModel updateProcessInquiryData(long userId, String processId, String dataId, long typeId, String value) {

        ProcessInquiryDataWSModel response = new ProcessInquiryDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessInquiryDataWSDTO> processInquiryDataWSDTOS = new ArrayList<>();

        ProcessInquiryDataWSDTO ProcessInquiryDataWSDTO = processInquiryFramework.updateProcessInquiryDataService(userId,processId,dataId,typeId,value);
        if (ProcessInquiryDataWSDTO != null){
            processInquiryDataWSDTOS.add(ProcessInquiryDataWSDTO);
        }

        response.setInquiryDatas(processInquiryDataWSDTOS);
        general.setOperation("updateProcessInquiryData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessInquiryDataWSModel removeProcessInquiryData(long userId, String processId, String dataId) {

        ProcessInquiryDataWSModel response = new ProcessInquiryDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessInquiryDataWSDTO> processInquiryDataWSDTOS = new ArrayList<>();

        ProcessInquiryDataWSDTO ProcessInquiryDataWSDTO = processInquiryFramework.removeProcessInquiryDataService(userId,processId,dataId);
        if (ProcessInquiryDataWSDTO != null){
            processInquiryDataWSDTOS.add(ProcessInquiryDataWSDTO);
        }

        response.setInquiryDatas(processInquiryDataWSDTOS);
        general.setOperation("removeProcessInquiryData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }




}
