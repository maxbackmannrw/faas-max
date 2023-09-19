package com.faas.core.base.middleware.process.details.content;

import com.faas.core.base.framework.process.details.content.ProcessDetailsFramework;
import com.faas.core.base.model.db.process.content.dao.ProcessDataDAO;
import com.faas.core.base.model.db.process.content.dao.ProcessUrlDAO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.content.ProcessDataWSModel;
import com.faas.core.base.model.ws.process.details.content.ProcessDetailsWSModel;
import com.faas.core.base.model.ws.process.details.content.ProcessUrlWSModel;
import com.faas.core.base.model.ws.process.details.content.dto.ProcessDataWSDTO;
import com.faas.core.base.model.ws.process.details.content.dto.ProcessDetailsWSDTO;
import com.faas.core.base.model.ws.process.details.content.dto.ProcessUrlWSDTO;
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



    public ProcessUrlWSModel getProcessUrls(long userId,String processId) {

        ProcessUrlWSModel response = new ProcessUrlWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessUrlWSDTO>processUrlWSDTOS = new ArrayList<>();


        response.setProcessUrls(processUrlWSDTOS);
        general.setOperation("getProcessUrls");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessUrlWSModel getProcessUrl(long userId,String processId,String urlId) {

        ProcessUrlWSModel response = new ProcessUrlWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessUrlWSDTO>processUrlWSDTOS = new ArrayList<>();



        response.setProcessUrls(processUrlWSDTOS);
        general.setOperation("getProcessUrl");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessUrlWSModel createProcessUrl(long userId,String processId,String urlType,String url) {

        ProcessUrlWSModel response = new ProcessUrlWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessUrlWSDTO>processUrlWSDTOS = new ArrayList<>();

        ProcessUrlDAO processUrlDAO = processDetailsFramework.createProcessUrlService(processId,urlType,url);
        if (processUrlDAO != null){
            processUrlWSDTOS.add(processDetailsFramework.fillProcessUrlWSDTO(processUrlDAO));
        }

        response.setProcessUrls(processUrlWSDTOS);
        general.setOperation("createProcessUrl");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessUrlWSModel updateProcessUrl(long userId,String processId,String urlId,String urlType,String url) {

        ProcessUrlWSModel response = new ProcessUrlWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessUrlWSDTO>processUrlWSDTOS = new ArrayList<>();

        ProcessUrlDAO processUrlDAO = processDetailsFramework.updateProcessUrlService(processId,urlId,urlType,url);
        if (processUrlDAO != null){
            processUrlWSDTOS.add(processDetailsFramework.fillProcessUrlWSDTO(processUrlDAO));
        }

        response.setProcessUrls(processUrlWSDTOS);
        general.setOperation("updateProcessUrl");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessUrlWSModel removeProcessUrl(long userId,String processId, String urlId) {

        ProcessUrlWSModel response = new ProcessUrlWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessUrlWSDTO>processUrlWSDTOS = new ArrayList<>();

        ProcessUrlDAO processUrlDAO = processDetailsFramework.removeProcessUrlService(processId,urlId);
        if (processUrlDAO != null){
            processUrlWSDTOS.add(processDetailsFramework.fillProcessUrlWSDTO(processUrlDAO));
        }

        response.setProcessUrls(processUrlWSDTOS);
        general.setOperation("removeProcessUrl");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
