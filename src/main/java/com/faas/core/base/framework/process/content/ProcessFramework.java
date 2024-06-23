package com.faas.core.base.framework.process.content;

import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.db.process.settings.ProcessTypeDBModel;
import com.faas.core.base.model.ws.process.content.dto.ProcessWSDTO;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.base.repo.process.details.channel.content.*;
import com.faas.core.base.repo.process.details.channel.temp.EmailTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.SmsTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.PushTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.WappMessageTempRepository;
import com.faas.core.base.repo.process.details.scenario.ProcessScenarioRepository;
import com.faas.core.base.repo.process.details.trigger.*;
import com.faas.core.base.repo.process.settings.ProcessTypeRepository;
import com.faas.core.utility.config.AppConstant;
import com.faas.core.utility.config.AppUtils;
import com.faas.core.utility.helpers.process.ProcessHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProcessFramework {

    @Autowired
    ProcessHelpers processHelpers;

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    ProcessTypeRepository processTypeRepository;

    @Autowired
    ProcessEmailChannelRepository processEmailChannelRepository;

    @Autowired
    ProcessPushChannelRepository processPushChannelRepository;

    @Autowired
    ProcessSipChannelRepository processSipChannelRepository;

    @Autowired
    ProcessSmsChannelRepository processSmsChannelRepository;

    @Autowired
    ProcessWappChannelRepository processWappChannelRepository;

    @Autowired
    EmailTempRepository emailTempRepository;

    @Autowired
    PushTempRepository pushTempRepository;

    @Autowired
    SmsTempRepository smsTempRepository;

    @Autowired
    WappMessageTempRepository wappMessageTempRepository;

    @Autowired
    ProcessScenarioRepository processScenarioRepository;

    @Autowired
    AITriggerRepository AITriggerRepository;

    @Autowired
    EmailTriggerRepository emailTriggerRepository;

    @Autowired
    SipTriggerRepository sipTriggerRepository;

    @Autowired
    SmsTriggerRepository smsTriggerRepository;

    @Autowired
    WappCallTriggerRepository wappCallTriggerRepository;

    @Autowired
    WappMessageTriggerRepository wappMessageTriggerRepository;

    @Autowired
    AppUtils appUtils;


    public List<ProcessWSDTO> getAllProcessesService(long userId) {

        List<ProcessWSDTO>processWSDTOS = new ArrayList<>();
        List<ProcessDBModel> processDBModels = processRepository.findByStatus(1);
        for (ProcessDBModel processDBModel : processDBModels) {
            processWSDTOS.add(processHelpers.getProcessWSDTO(processDBModel));
        }
        return processWSDTOS;
    }


    public List<ProcessWSDTO> getProcessesByCategoryService(long userId,String processCategory) {

        List<ProcessWSDTO>processWSDTOS = new ArrayList<>();
        List<ProcessDBModel> processDBModels = processRepository.findByProcessCategory(processCategory);
        for (ProcessDBModel processDBModel : processDBModels) {
            processWSDTOS.add(processHelpers.getProcessWSDTO(processDBModel));
        }
        return processWSDTOS;
    }


    public ProcessWSDTO getProcessService(long userId,String processId) {

        Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);
        if (processDBModel.isPresent()){
            return processHelpers.getProcessWSDTO(processDBModel.get());
        }
        return null;
    }


    public ProcessWSDTO createProcessService(String process,String processDesc,long processTypeId,String processCategory,String processState) {

        Optional<ProcessTypeDBModel> processTypeDBModel = processTypeRepository.findById(processTypeId);
        if (processTypeDBModel.isPresent()){

            ProcessDBModel processDBModel = new ProcessDBModel();
            processDBModel.setProcess(process);
            processDBModel.setProcessDesc(processDesc);
            processDBModel.setProcessTypeId(processTypeId);
            processDBModel.setProcessType(processTypeDBModel.get().getProcessType());
            processDBModel.setProcessCategory(processCategory);
            if (processCategory.equalsIgnoreCase(AppConstant.INQUIRY_PROCESS)){
                processDBModel.setProcessInquiry(processHelpers.createProcessInquiryHelper(process));
            }
            if (processCategory.equalsIgnoreCase(AppConstant.AUTOMATIC_PROCESS)){
                processDBModel.setProcessFlow(processHelpers.createProcessFlowHelper(process));;
            }
            processDBModel.setProcessAssets(new ArrayList<>());
            processDBModel.setProcessScripts(new ArrayList<>());
            processDBModel.setProcessDatas(new ArrayList<>());
            processDBModel.setProcessState(processState);
            processDBModel.setuDate(appUtils.getCurrentTimeStamp());
            processDBModel.setcDate(appUtils.getCurrentTimeStamp());
            processDBModel.setStatus(1);

            return new ProcessWSDTO(processRepository.save(processDBModel));
        }
        return null;
    }


    public ProcessWSDTO updateProcessService(String processId,String process,String processDesc,String processState) {

        Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);
        if (processDBModel.isPresent()){

            processDBModel.get().setProcess(process);
            processDBModel.get().setProcessDesc(processDesc);
            processDBModel.get().setProcessState(processState);
            processDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            processDBModel.get().setStatus(1);

            return processHelpers.getProcessWSDTO(processRepository.save(processDBModel.get()));
        }
       return null;
    }


    public ProcessWSDTO removeProcessService(String processId) {

        Optional<ProcessDBModel> process = processRepository.findById(processId);
        if (process.isPresent()) {

            ProcessWSDTO processWSDTO = processHelpers.getProcessWSDTO(process.get());

            processRepository.delete(process.get());
            processScenarioRepository.deleteAll(processScenarioRepository.findByProcessId(processId));

            processEmailChannelRepository.deleteAll(processEmailChannelRepository.findByProcessId(processId));
            processPushChannelRepository.deleteAll(processPushChannelRepository.findByProcessId(processId));
            processSipChannelRepository.deleteAll(processSipChannelRepository.findByProcessId(processId));
            processSmsChannelRepository.deleteAll(processSmsChannelRepository.findByProcessId(processId));
            processWappChannelRepository.deleteAll(processWappChannelRepository.findByProcessId(processId));

            emailTempRepository.deleteAll(emailTempRepository.findByProcessId(processId));
            pushTempRepository.deleteAll(pushTempRepository.findByProcessId(processId));
            smsTempRepository.deleteAll(smsTempRepository.findByProcessId(processId));
            wappMessageTempRepository.deleteAll(wappMessageTempRepository.findByProcessId(processId));

            AITriggerRepository.deleteAll(AITriggerRepository.findByProcessId(processId));
            emailTriggerRepository.deleteAll(emailTriggerRepository.findByProcessId(processId));
            sipTriggerRepository.deleteAll(sipTriggerRepository.findByProcessId(processId));
            smsTriggerRepository.deleteAll(smsTriggerRepository.findByProcessId(processId));
            wappCallTriggerRepository.deleteAll(wappCallTriggerRepository.findByProcessId(processId));
            wappMessageTriggerRepository.deleteAll(wappMessageTriggerRepository.findByProcessId(processId));

            return processWSDTO;
        }
        return null;
    }


}
