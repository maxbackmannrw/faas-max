package com.faas.core.base.middleware.process.details.content;

import com.faas.core.base.framework.process.details.content.ProcessDetailsFramework;
import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.db.process.content.dao.ProcessDataDAO;
import com.faas.core.base.model.db.process.content.dao.ProcessUrlDAO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.content.ProcessDataWSModel;
import com.faas.core.base.model.ws.process.details.content.ProcessDetailsWSModel;
import com.faas.core.base.model.ws.process.details.content.ProcessUrlWSModel;
import com.faas.core.base.model.ws.process.details.content.dto.ProcessDataWSDTO;
import com.faas.core.base.model.ws.process.details.content.dto.ProcessDetailsWSDTO;
import com.faas.core.base.model.ws.process.details.content.dto.ProcessUrlWSDTO;
import com.faas.core.base.model.ws.process.details.content.ProcessScriptWSModel;
import com.faas.core.base.model.ws.process.details.content.dto.ProcessScriptWSDTO;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ProcessDetailsMiddleware {

    @Autowired
    ProcessDetailsFramework processDetailsFramework;

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    AppUtils appUtils;


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

        Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);


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

        Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);


        response.setProcessDatas(processDataWSDTOS);
        general.setOperation("getProcessData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessDataWSModel createProcessData(long userId,String processId,long dataTypeId,String value) {

        ProcessDataWSModel response = new ProcessDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessDataWSDTO> processDataWSDTOS = new ArrayList<>();

        ProcessDataDAO processDataDAO = processDetailsFramework.createProcessDataService(processId,dataTypeId,value);
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


    public ProcessDataWSModel updateProcessData(long userId,String processId,String dataId,long dataTypeId,String value) {

        ProcessDataWSModel response = new ProcessDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessDataWSDTO> processDataWSDTOS = new ArrayList<>();

        ProcessDataDAO processDataDAO = processDetailsFramework.updateProcessDataService(processId,dataId,dataTypeId,value);
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

        Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);

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

        Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);


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



    public ProcessScriptWSModel getProcessScripts(long userId, String processId) {

        ProcessScriptWSModel response = new ProcessScriptWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ProcessScriptWSDTO> processScriptWSDTOS = processDetailsFramework.getProcessScriptsService(processId);
        if (processScriptWSDTOS != null){
            response.setProcessScripts(processScriptWSDTOS);
        }

        general.setOperation("getProcessScripts");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessScriptWSModel getProcessScript(long userId, String processId, String scriptId) {

        ProcessScriptWSModel response = new ProcessScriptWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessScriptWSDTO> processScriptWSDTOS = new ArrayList<>();

        ProcessScriptWSDTO processScriptWSDTO = processDetailsFramework.getProcessScriptService(processId,scriptId);
        if (processScriptWSDTO != null){
            processScriptWSDTOS.add(processScriptWSDTO);
        }

        response.setProcessScripts(processScriptWSDTOS);
        general.setOperation("getProcessScript");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessScriptWSModel createProcessScript(long userId,String processId,String scriptTitle,String scriptBody,int order) {

        ProcessScriptWSModel response = new ProcessScriptWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessScriptWSDTO> processScriptWSDTOS = new ArrayList<>();

        ProcessScriptWSDTO processScriptWSDTO = processDetailsFramework.createProcessScriptService(processId,scriptTitle,scriptBody,order);
        if (processScriptWSDTO != null){
            processScriptWSDTOS.add(processScriptWSDTO);
        }

        response.setProcessScripts(processScriptWSDTOS);
        general.setOperation("createProcessScript");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ProcessScriptWSModel updateProcessScript(long userId,String processId, String scriptId, String scriptTitle, String scriptBody, int order) {

        ProcessScriptWSModel response = new ProcessScriptWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessScriptWSDTO> processScriptWSDTOS = new ArrayList<>();

        ProcessScriptWSDTO processScriptWSDTO = processDetailsFramework.updateProcessScriptService(processId,scriptId,scriptTitle,scriptBody,order);
        if (processScriptWSDTO != null){
            processScriptWSDTOS.add(processScriptWSDTO);
        }

        response.setProcessScripts(processScriptWSDTOS);
        general.setOperation("updateProcessScript");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessScriptWSModel removeProcessScript(long userId, String processId, String scriptId) {

        ProcessScriptWSModel response = new ProcessScriptWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessScriptWSDTO> processScriptWSDTOS = new ArrayList<>();

        ProcessScriptWSDTO processScriptWSDTO = processDetailsFramework.removeProcessScriptService(processId,scriptId);
        if (processScriptWSDTO != null){
            processScriptWSDTOS.add(processScriptWSDTO);
        }

        response.setProcessScripts(processScriptWSDTOS);
        general.setOperation("removeProcessScript");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

}
