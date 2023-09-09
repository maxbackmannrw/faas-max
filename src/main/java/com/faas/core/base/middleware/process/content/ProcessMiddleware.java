package com.faas.core.base.middleware.process.content;

import com.faas.core.base.framework.process.content.ProcessFramework;
import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.content.ProcessWSModel;
import com.faas.core.base.model.ws.process.content.dto.ProcessWSDTO;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ProcessMiddleware {

    @Autowired
    ProcessFramework processFramework;

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    AppUtils appUtils;


    public ProcessWSModel getAllProcess(long userId) {

        ProcessWSModel response = new ProcessWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessWSDTO> processWSDTOS = new ArrayList<>();

        List<ProcessDBModel> processDBModels = processRepository.findByStatus(1);
        for (ProcessDBModel processDBModel : processDBModels) {
            processWSDTOS.add(processFramework.fillProcessWSDTO(processDBModel));
        }

        response.setProcesses(processWSDTOS);
        general.setOperation("getAllProcess");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessWSModel getProcessesByCategory(long userId, String processCategory) {

        ProcessWSModel response = new ProcessWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessWSDTO> processWSDTOS = new ArrayList<>();

        List<ProcessDBModel> processDBModels = processRepository.findByProcessCategory(processCategory);
        for (ProcessDBModel processDBModel : processDBModels) {
            processWSDTOS.add(processFramework.fillProcessWSDTO(processDBModel));
        }

        response.setProcesses(processWSDTOS);
        general.setOperation("getProcessesByCategory");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ProcessWSModel getProcess(long userId, String processId) {

        ProcessWSModel response = new ProcessWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessWSDTO> processWSDTOS = new ArrayList<>();

        Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);
        if (processDBModel.isPresent()) {
            processWSDTOS.add(processFramework.fillProcessWSDTO(processDBModel.get()));
        }

        response.setProcesses(processWSDTOS);
        general.setOperation("getProcess");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessWSModel createProcess(long userId,String process,String processDesc,String pwaUrl,long processTypeId,String category,String processState) {

        ProcessWSModel response = new ProcessWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessWSDTO> processWSDTOS = new ArrayList<>();

        ProcessDBModel processDBModel = processFramework.createProcessService(process,processDesc,pwaUrl,processTypeId,category,processState);
        if (processDBModel != null) {
            processWSDTOS.add(processFramework.fillProcessWSDTO(processDBModel));
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

        ProcessDBModel processDBModel = processFramework.updateProcessService(processId,process,processDesc,processState);
        if (processDBModel != null) {
            processWSDTOS.add(processFramework.fillProcessWSDTO(processDBModel));
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

        ProcessDBModel processDBModel = processFramework.removeProcessService(processId);
        if (processDBModel != null) {
            processWSDTOS.add(processFramework.fillProcessWSDTO(processDBModel));
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
