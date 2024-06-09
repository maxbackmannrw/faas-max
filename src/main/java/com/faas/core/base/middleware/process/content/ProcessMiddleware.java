package com.faas.core.base.middleware.process.content;

import com.faas.core.base.framework.process.content.ProcessFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.content.ProcessWSModel;
import com.faas.core.base.model.ws.process.content.dto.ProcessWSDTO;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.utility.config.AppConstant;
import com.faas.core.utility.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ProcessMiddleware {

    @Autowired
    ProcessFramework processFramework;

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    AppUtils appUtils;


    public ProcessWSModel getAllProcesses(long userId) {

        ProcessWSModel response = new ProcessWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ProcessWSDTO> processWSDTOS =processFramework.getAllProcessesService(userId);
        if (processWSDTOS != null){
            response.setProcesses(processWSDTOS);
        }

        general.setOperation("getAllProcesses");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessWSModel getProcessesByCategory(long userId,String processCategory) {

        ProcessWSModel response = new ProcessWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ProcessWSDTO> processWSDTOS =processFramework.getProcessesByCategoryService(userId,processCategory);
        if (processWSDTOS != null){
            response.setProcesses(processWSDTOS);
        }

        general.setOperation("getProcessesByCategory");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessWSModel getProcess(long userId,String processId) {

        ProcessWSModel response = new ProcessWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessWSDTO> processWSDTOS = new ArrayList<>();

        ProcessWSDTO processWSDTO =processFramework.getProcessService(userId,processId);
        if (processWSDTO != null){
            processWSDTOS.add(processWSDTO);
        }

        response.setProcesses(processWSDTOS);
        general.setOperation("getProcess");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessWSModel createProcess(long userId,String process,String processDesc,long processTypeId,String processCategory,String processState) {

        ProcessWSModel response = new ProcessWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessWSDTO> processWSDTOS = new ArrayList<>();

        ProcessWSDTO processWSDTO = processFramework.createProcessService(process,processDesc,processTypeId,processCategory,processState);
        if (processWSDTO != null) {
            processWSDTOS.add(processWSDTO);
        }

        response.setProcesses(processWSDTOS);
        general.setOperation("createProcess");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessWSModel updateProcess(long userId,String processId,String process,String processDesc,String processState) {

        ProcessWSModel response = new ProcessWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessWSDTO> processWSDTOS = new ArrayList<>();

        ProcessWSDTO processWSDTO = processFramework.updateProcessService(processId,process,processDesc,processState);
        if (processWSDTO != null) {
            processWSDTOS.add(processWSDTO);
        }

        response.setProcesses(processWSDTOS);
        general.setOperation("updateProcess");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessWSModel removeProcess(long userId, String processId) {

        ProcessWSModel response = new ProcessWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessWSDTO> processWSDTOS = new ArrayList<>();

        ProcessWSDTO processWSDTO = processFramework.removeProcessService(processId);
        if (processWSDTO != null) {
            processWSDTOS.add(processWSDTO);
        }

        response.setProcesses(processWSDTOS);
        general.setOperation("removeProcess");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
