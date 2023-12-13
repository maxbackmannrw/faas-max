package com.faas.core.base.framework.process.content;

import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.db.process.settings.ProcessTypeDBModel;
import com.faas.core.base.model.ws.process.content.dto.ProcessWSDTO;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.base.repo.process.details.channel.content.*;
import com.faas.core.base.repo.process.details.channel.temp.ProcessEmailTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.ProcessSmsMessageTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.ProcessPushTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.ProcessWappMessageTempRepository;
import com.faas.core.base.repo.process.details.flow.ProcessFlowRepository;
import com.faas.core.base.repo.process.details.inquiry.ProcessInquiryRepository;
import com.faas.core.base.repo.process.details.scenario.ProcessScenarioRepository;
import com.faas.core.base.repo.process.details.trigger.*;
import com.faas.core.base.repo.process.settings.ProcessTypeRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.ProcessHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProcessFramework {

    @Autowired
    ProcessHelper processHelper;

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    ProcessInquiryRepository processInquiryRepository;

    @Autowired
    ProcessFlowRepository processFlowRepository;

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
    ProcessEmailTempRepository processEmailTempRepository;

    @Autowired
    ProcessPushTempRepository processPushTempRepository;

    @Autowired
    ProcessSmsMessageTempRepository processSmsMessageTempRepository;

    @Autowired
    ProcessWappMessageTempRepository processWappMessageTempRepository;

    @Autowired
    ProcessScenarioRepository processScenarioRepository;

    @Autowired
    AiTriggerRepository aiTriggerRepository;

    @Autowired
    EmailTriggerRepository emailTriggerRepository;

    @Autowired
    SipCallTriggerRepository sipCallTriggerRepository;

    @Autowired
    SmsMessageTriggerRepository smsMessageTriggerRepository;

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
            processWSDTOS.add(processHelper.getProcessWSDTO(processDBModel));
        }
        return processWSDTOS;
    }


    public List<ProcessWSDTO> getProcessesByCategoryService(long userId,String processCategory) {

        List<ProcessWSDTO>processWSDTOS = new ArrayList<>();
        List<ProcessDBModel> processDBModels = processRepository.findByProcessCategory(processCategory);
        for (ProcessDBModel processDBModel : processDBModels) {
            processWSDTOS.add(processHelper.getProcessWSDTO(processDBModel));
        }
        return processWSDTOS;
    }


    public ProcessWSDTO getProcessService(long userId,String processId) {

        Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);
        if (processDBModel.isPresent()){
            return processHelper.getProcessWSDTO(processDBModel.get());
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
            processDBModel.setProcessRemotes(new ArrayList<>());
            processDBModel.setProcessAssets(new ArrayList<>());
            processDBModel.setProcessScripts(new ArrayList<>());
            processDBModel.setProcessDatas(new ArrayList<>());
            processDBModel.setProcessState(processState);
            processDBModel.setuDate(appUtils.getCurrentTimeStamp());
            processDBModel.setcDate(appUtils.getCurrentTimeStamp());
            processDBModel.setStatus(1);

            processDBModel =processRepository.save(processDBModel);

            if (processDBModel.getProcessCategory().equalsIgnoreCase(AppConstant.INQUIRY_PROCESS)){
                processHelper.createProcessInquiryHelper(processDBModel);
                return processHelper.getProcessWSDTO(processDBModel);
            }
            if (processDBModel.getProcessCategory().equalsIgnoreCase(AppConstant.AUTOMATIC_PROCESS)){
                processHelper.createProcessFlowHelper(processDBModel);
                return processHelper.getProcessWSDTO(processDBModel);
            }
            return processHelper.getProcessWSDTO(processDBModel);
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

            return processHelper.getProcessWSDTO(processRepository.save(processDBModel.get()));
        }
       return null;
    }


    public ProcessWSDTO removeProcessService(String processId) {

        Optional<ProcessDBModel> process = processRepository.findById(processId);
        if (process.isPresent()) {

            ProcessWSDTO processWSDTO = processHelper.getProcessWSDTO(process.get());

            processRepository.delete(process.get());
            processEmailChannelRepository.deleteAll(processEmailChannelRepository.findByProcessId(processId));
            processPushChannelRepository.deleteAll(processPushChannelRepository.findByProcessId(processId));
            processSipChannelRepository.deleteAll(processSipChannelRepository.findByProcessId(processId));
            processSmsChannelRepository.deleteAll(processSmsChannelRepository.findByProcessId(processId));
            processWappChannelRepository.deleteAll(processWappChannelRepository.findByProcessId(processId));

            processEmailTempRepository.deleteAll(processEmailTempRepository.findByProcessId(processId));
            processPushTempRepository.deleteAll(processPushTempRepository.findByProcessId(processId));
            processSmsMessageTempRepository.deleteAll(processSmsMessageTempRepository.findByProcessId(processId));
            processWappMessageTempRepository.deleteAll(processWappMessageTempRepository.findByProcessId(processId));

            processScenarioRepository.deleteAll(processScenarioRepository.findByProcessId(processId));
            processInquiryRepository.deleteAll(processInquiryRepository.findByProcessId(processId));
            processFlowRepository.deleteAll(processFlowRepository.findByProcessId(processId));

            aiTriggerRepository.deleteAll(aiTriggerRepository.findByProcessId(processId));
            emailTriggerRepository.deleteAll(emailTriggerRepository.findByProcessId(processId));
            sipCallTriggerRepository.deleteAll(sipCallTriggerRepository.findByProcessId(processId));
            smsMessageTriggerRepository.deleteAll(smsMessageTriggerRepository.findByProcessId(processId));
            wappCallTriggerRepository.deleteAll(wappCallTriggerRepository.findByProcessId(processId));
            wappMessageTriggerRepository.deleteAll(wappMessageTriggerRepository.findByProcessId(processId));

            return processWSDTO;
        }
        return null;
    }


}
