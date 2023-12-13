package com.faas.core.utils.helpers;

import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.db.process.details.channel.content.*;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessEmailTempDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessPushTempDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessSmsMessageTempDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessWappMessageTempDBModel;
import com.faas.core.base.model.db.process.details.flow.ProcessFlowDBModel;
import com.faas.core.base.model.db.process.details.inquiry.ProcessInquiryDBModel;
import com.faas.core.base.model.db.process.details.scenario.ProcessScenarioDBModel;
import com.faas.core.base.model.db.process.details.trigger.*;
import com.faas.core.base.model.db.scenario.content.ScenarioDBModel;
import com.faas.core.base.model.ws.process.details.channel.content.dto.*;
import com.faas.core.base.model.ws.process.details.channel.temp.dto.*;
import com.faas.core.base.model.ws.process.details.content.dto.ProcessDetailsWSDTO;
import com.faas.core.base.model.ws.process.details.flow.dto.ProcessFlowWSDTO;
import com.faas.core.base.model.ws.process.details.inquiry.dto.ProcessInquiryWSDTO;
import com.faas.core.base.model.ws.process.details.scenario.dto.ProcessScenarioWSDTO;
import com.faas.core.base.model.ws.process.details.trigger.dto.*;
import com.faas.core.base.repo.process.details.channel.content.*;
import com.faas.core.base.repo.process.details.channel.temp.EmailTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.PushTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.SmsMessageTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.WappMessageTempRepository;
import com.faas.core.base.repo.process.details.flow.ProcessFlowRepository;
import com.faas.core.base.repo.process.details.inquiry.ProcessInquiryRepository;
import com.faas.core.base.repo.process.details.scenario.ProcessScenarioRepository;
import com.faas.core.base.repo.process.details.trigger.*;
import com.faas.core.base.repo.scenario.content.ScenarioRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ProcessHelper {


    @Autowired
    ScenarioRepository scenarioRepository;

    @Autowired
    EmailTempRepository emailTempRepository;

    @Autowired
    PushTempRepository pushTempRepository;

    @Autowired
    SmsMessageTempRepository smsMessageTempRepository;

    @Autowired
    WappMessageTempRepository wappMessageTempRepository;

    @Autowired
    ProcessWappChannelRepository processWappChannelRepository;

    @Autowired
    ProcessSipChannelRepository processSipChannelRepository;

    @Autowired
    ProcessSmsChannelRepository processSmsChannelRepository;

    @Autowired
    ProcessEmailChannelRepository processEmailChannelRepository;

    @Autowired
    ProcessPushChannelRepository processPushChannelRepository;

    @Autowired
    ProcessScenarioRepository processScenarioRepository;

    @Autowired
    ProcessInquiryRepository processInquiryRepository;

    @Autowired
    ProcessFlowRepository processFlowRepository;

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


    public ProcessDetailsWSDTO createProcessDetailsWSDTO(ProcessDBModel processDBModel) {

        ProcessDetailsWSDTO processDetailsWSDTO = new ProcessDetailsWSDTO();
        processDetailsWSDTO.setProcess(processDBModel);
        if (processDBModel.getProcessCategory().equalsIgnoreCase(AppConstant.INQUIRY_PROCESS)){
            processDetailsWSDTO.setProcessInquiry(createProcessInquiryWSDTO(processDBModel));
        }
        if (processDBModel.getProcessCategory().equalsIgnoreCase(AppConstant.AUTOMATIC_PROCESS)){
            processDetailsWSDTO.setProcessFlow(createProcessFlowWSDTO(processDBModel));
        }
        processDetailsWSDTO.setProcessTemps(createProcessTempWSDTO(processDBModel.getId()));
        processDetailsWSDTO.setProcessChannels(createProcessChannelWSDTO(processDBModel.getId()));
        processDetailsWSDTO.setProcessTrigger(createProcessTriggersWSDTO(processDBModel.getId()));
        processDetailsWSDTO.setProcessScenarios(createProcessScenarioWSDTOS(processDBModel));
        processDetailsWSDTO.setProcessAssets(new ArrayList<>());

        return processDetailsWSDTO;
    }


    public ProcessInquiryWSDTO createProcessInquiryWSDTO(ProcessDBModel processDBModel){

        List<ProcessInquiryDBModel> processInquiryDBModels = processInquiryRepository.findByProcessId(processDBModel.getId());
        if (!processInquiryDBModels.isEmpty()){
            return new ProcessInquiryWSDTO(processInquiryDBModels.get(0));
        }
        return null;
    }

    public ProcessInquiryDBModel createProcessInquiryHelper(ProcessDBModel processDBModel){

        List<ProcessInquiryDBModel> processInquiryDBModels = processInquiryRepository.findByProcessId(processDBModel.getId());
        if (processInquiryDBModels.isEmpty()){

            ProcessInquiryDBModel processInquiryDBModel = new ProcessInquiryDBModel();
            processInquiryDBModel.setProcessId(processDBModel.getId());
            processInquiryDBModel.setProcessInquiry("");
            processInquiryDBModel.setInquiryDesc("");
            processInquiryDBModel.setInquiryDatas(new ArrayList<>());
            processInquiryDBModel.setInquiryUrls(new ArrayList<>());
            processInquiryDBModel.setuDate(appUtils.getCurrentTimeStamp());
            processInquiryDBModel.setcDate(appUtils.getCurrentTimeStamp());
            processInquiryDBModel.setStatus(1);

            return processInquiryRepository.save(processInquiryDBModel);
        }
        return processInquiryDBModels.get(0);
    }


    public ProcessFlowWSDTO createProcessFlowWSDTO(ProcessDBModel processDBModel){

        List<ProcessFlowDBModel> processFlowDBModels = processFlowRepository.findByProcessId(processDBModel.getId());
        if (!processFlowDBModels.isEmpty()){
            return new ProcessFlowWSDTO(processFlowDBModels.get(0));
        }
        return null;
    }

    public ProcessFlowDBModel createProcessFlowHelper(ProcessDBModel processDBModel){

        List<ProcessFlowDBModel> processFlowDBModels = processFlowRepository.findByProcessId(processDBModel.getId());
        if (processFlowDBModels.isEmpty()){

            ProcessFlowDBModel processFlowDBModel = new ProcessFlowDBModel();
            processFlowDBModel.setProcessId(processDBModel.getId());
            processFlowDBModel.setProcessFlow("");
            processFlowDBModel.setFlowDesc("");
            processFlowDBModel.setFlowUrls(new ArrayList<>());
            processFlowDBModel.setFlowDatas(new ArrayList<>());
            processFlowDBModel.setuDate(appUtils.getCurrentTimeStamp());
            processFlowDBModel.setcDate(appUtils.getCurrentTimeStamp());
            processFlowDBModel.setStatus(1);

            return processFlowRepository.save(processFlowDBModel);
        }
        return null;
    }


    public ProcessTriggerWSDTO createProcessTriggersWSDTO(String processId){

        ProcessTriggerWSDTO processTriggerWSDTO = new ProcessTriggerWSDTO();
        processTriggerWSDTO.setAiTriggers(createAiTriggerWSDTOS(processId));
        processTriggerWSDTO.setEmailTriggers(createEmailTriggerWSDTOS(processId));
        processTriggerWSDTO.setSipCallTriggers(createSipCallTriggerWSDTOS(processId));
        processTriggerWSDTO.setSmsMessageTriggers(createSmsMessageTriggerWSDTOS(processId));
        processTriggerWSDTO.setWappCallTriggers(createWappCallTriggerWSDTOS(processId));
        processTriggerWSDTO.setWappMessageTriggers(createWappMessageTriggerWSDTOS(processId));

        return processTriggerWSDTO;
    }

    public List<AiTriggerWSDTO> createAiTriggerWSDTOS(String processId) {

        List<AiTriggerWSDTO> aiTriggerWSDTOS = new ArrayList<>();
        List<ProcessAiTriggerDBModel> processAiTriggerDBModels = aiTriggerRepository.findByProcessId(processId);
        for (ProcessAiTriggerDBModel processAiTriggerDBModel : processAiTriggerDBModels) {
            aiTriggerWSDTOS.add(new AiTriggerWSDTO(processAiTriggerDBModel));
        }
        return aiTriggerWSDTOS;
    }

    public List<EmailTriggerWSDTO> createEmailTriggerWSDTOS(String processId) {

        List<EmailTriggerWSDTO> emailTriggerWSDTOS = new ArrayList<>();
        List<ProcessEmailTriggerDBModel> processEmailTriggerDBModels = emailTriggerRepository.findByProcessId(processId);
        for (ProcessEmailTriggerDBModel processEmailTriggerDBModel : processEmailTriggerDBModels) {
            emailTriggerWSDTOS.add(new EmailTriggerWSDTO(processEmailTriggerDBModel));
        }
        return emailTriggerWSDTOS;
    }

    public List<SipCallTriggerWSDTO> createSipCallTriggerWSDTOS(String processId) {

        List<SipCallTriggerWSDTO> sipCallTriggerWSDTOS = new ArrayList<>();
        List<ProcessSipCallTriggerDBModel> processSipCallTriggerDBModels = sipCallTriggerRepository.findByProcessId(processId);
        for (ProcessSipCallTriggerDBModel processSipCallTriggerDBModel : processSipCallTriggerDBModels) {
            sipCallTriggerWSDTOS.add(new SipCallTriggerWSDTO(processSipCallTriggerDBModel));
        }
        return sipCallTriggerWSDTOS;
    }

    public List<SmsMessageTriggerWSDTO> createSmsMessageTriggerWSDTOS(String processId) {

        List<SmsMessageTriggerWSDTO>smsMessageTriggerWSDTOS = new ArrayList<>();
        List<ProcessSmsMessageTriggerDBModel> processSmsMessageTriggerDBModels = smsMessageTriggerRepository.findByProcessId(processId);
        for (ProcessSmsMessageTriggerDBModel processSmsMessageTriggerDBModel : processSmsMessageTriggerDBModels) {
            smsMessageTriggerWSDTOS.add(new SmsMessageTriggerWSDTO(processSmsMessageTriggerDBModel));
        }
        return smsMessageTriggerWSDTOS;
    }

    public List<WappCallTriggerWSDTO> createWappCallTriggerWSDTOS(String processId) {

        List<WappCallTriggerWSDTO>wappCallTriggerWSDTOS = new ArrayList<>();
        List<ProcessWappCallTriggerDBModel> processWappCallTriggerDBModels = wappCallTriggerRepository.findByProcessId(processId);
        for (ProcessWappCallTriggerDBModel processWappCallTriggerDBModel : processWappCallTriggerDBModels) {
            wappCallTriggerWSDTOS.add(new WappCallTriggerWSDTO(processWappCallTriggerDBModel));
        }
        return wappCallTriggerWSDTOS;
    }

    public List<WappMessageTriggerWSDTO> createWappMessageTriggerWSDTOS(String processId) {

        List<WappMessageTriggerWSDTO>wappMessageTriggerWSDTOS = new ArrayList<>();
        List<ProcessWappMessageTriggerDBModel> processWappMessageTriggerDBModels = wappMessageTriggerRepository.findByProcessId(processId);
        for (ProcessWappMessageTriggerDBModel processWappMessageTriggerDBModel : processWappMessageTriggerDBModels) {
            wappMessageTriggerWSDTOS.add(new WappMessageTriggerWSDTO(processWappMessageTriggerDBModel));
        }
        return wappMessageTriggerWSDTOS;
    }



    public List<ProcessScenarioWSDTO> createProcessScenarioWSDTOS(ProcessDBModel processDBModel){

        List<ProcessScenarioWSDTO> processScenarioWSDTOS = new ArrayList<>();
        List<ProcessScenarioDBModel> processScenarioDBModels = processScenarioRepository.findByProcessId(processDBModel.getId());
        for (ProcessScenarioDBModel processScenarioDBModel : processScenarioDBModels) {
            ProcessScenarioWSDTO processScenarioWSDTO = mapProcessScenarioWSDTO(processScenarioDBModel);
            if (processScenarioWSDTO != null){
                processScenarioWSDTOS.add(processScenarioWSDTO);
            }
        }
        return processScenarioWSDTOS;
    }


    public ProcessScenarioWSDTO mapProcessScenarioWSDTO(ProcessScenarioDBModel processScenarioDBModel){

        ProcessScenarioWSDTO processScenarioWSDTO = new ProcessScenarioWSDTO();
        processScenarioWSDTO.setProcessScenario(processScenarioDBModel);
        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(processScenarioDBModel.getScenarioId());
        scenarioDBModel.ifPresent(processScenarioWSDTO::setProcessScenarioDetails);

        return processScenarioWSDTO;
    }


    public ProcessTempWSDTO createProcessTempWSDTO(String processId){

        ProcessTempWSDTO processTempWSDTO = new ProcessTempWSDTO();

        List<ProcessEmailTempDBModel> emailTemps = emailTempRepository.findByProcessId(processId);
        List<EmailTempWSDTO>emailTempWSDTOS = new ArrayList<>();
        for (ProcessEmailTempDBModel emailTemp : emailTemps) {
            emailTempWSDTOS.add(new EmailTempWSDTO(emailTemp));
        }
        processTempWSDTO.setEmailTemps(emailTempWSDTOS);

        List<ProcessPushTempDBModel> pushTemps = pushTempRepository.findByProcessId(processId);
        List<PushTempWSDTO>pushTempWSDTOS = new ArrayList<>();
        for (ProcessPushTempDBModel pushTemp : pushTemps) {
            pushTempWSDTOS.add(new PushTempWSDTO(pushTemp));
        }
        processTempWSDTO.setPushTemps(pushTempWSDTOS);

        List<ProcessSmsMessageTempDBModel>smsMessageTemps = smsMessageTempRepository.findByProcessId(processId);
        List<SmsMessageTempWSDTO>smsMessageTempWSDTOS = new ArrayList<>();
        for (ProcessSmsMessageTempDBModel smsMessageTemp : smsMessageTemps) {
            smsMessageTempWSDTOS.add(new SmsMessageTempWSDTO(smsMessageTemp));
        }
        processTempWSDTO.setSmsMessageTemps(smsMessageTempWSDTOS);

        List<ProcessWappMessageTempDBModel>wappMessageTemps = wappMessageTempRepository.findByProcessId(processId);
        List<WappMessageTempWSDTO>wappMessageTempWSDTOS = new ArrayList<>();
        for (ProcessWappMessageTempDBModel wappMessageTemp : wappMessageTemps) {
            wappMessageTempWSDTOS.add(new WappMessageTempWSDTO(wappMessageTemp));
        }
        processTempWSDTO.setWappMessageTemps(wappMessageTempWSDTOS);

        return processTempWSDTO;
    }


    public ProcessChannelWSDTO createProcessChannelWSDTO(String processId){

        ProcessChannelWSDTO processChannelWSDTO = new ProcessChannelWSDTO();
        List<ProcessSipChannelDBModel> sipChannelDBModels =  processSipChannelRepository.findByProcessId(processId);
        if (!sipChannelDBModels.isEmpty()){
            processChannelWSDTO.setSipChannel(new ProcessSipChannelWSDTO(sipChannelDBModels.get(0)));
        }
        List<ProcessSmsChannelDBModel> smsChannelDBModels = processSmsChannelRepository.findByProcessId(processId);
        if (!smsChannelDBModels.isEmpty()){
            processChannelWSDTO.setSmsChannel(new ProcessSmsChannelWSDTO(smsChannelDBModels.get(0)));
        }
        List<ProcessWappChannelDBModel> wappChannelDBModels = processWappChannelRepository.findByProcessId(processId);
        if (!wappChannelDBModels.isEmpty()){
            processChannelWSDTO.setWappChannel(new ProcessWappChannelWSDTO(wappChannelDBModels.get(0)));
        }
        List<ProcessEmailChannelDBModel> emailChannelDBModels = processEmailChannelRepository.findByProcessId(processId);
        if (!emailChannelDBModels.isEmpty()){
            processChannelWSDTO.setEmailChannel(new ProcessEmailChannelWSDTO(emailChannelDBModels.get(0)));
        }
        List<ProcessPushChannelDBModel> pushChannelDBModels = processPushChannelRepository.findByProcessId(processId);
        if (!pushChannelDBModels.isEmpty()){
            processChannelWSDTO.setPushChannel(new ProcessPushChannelWSDTO(pushChannelDBModels.get(0)));
        }
        return processChannelWSDTO;
    }



}
