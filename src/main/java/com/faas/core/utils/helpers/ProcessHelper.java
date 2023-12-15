package com.faas.core.utils.helpers;

import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.db.process.content.dao.ProcessFlowDAO;
import com.faas.core.base.model.db.process.content.dao.ProcessInquiryDAO;
import com.faas.core.base.model.db.process.details.channel.content.*;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessEmailTempDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessPushTempDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessSmsMessageTempDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessWappMessageTempDBModel;
import com.faas.core.base.model.db.process.details.scenario.ProcessScenarioDBModel;
import com.faas.core.base.model.db.process.details.trigger.*;
import com.faas.core.base.model.db.scenario.content.ScenarioDBModel;
import com.faas.core.base.model.ws.process.content.dto.ProcessWSDTO;
import com.faas.core.base.model.ws.process.details.channel.content.dto.*;
import com.faas.core.base.model.ws.process.details.channel.temp.dto.*;
import com.faas.core.base.model.ws.process.details.content.dto.ProcessDetailsWSDTO;
import com.faas.core.base.model.ws.process.details.flow.dto.ProcessFlowWSDTO;
import com.faas.core.base.model.ws.process.details.scenario.dto.ProcessScenarioWSDTO;
import com.faas.core.base.model.ws.process.details.trigger.dto.*;
import com.faas.core.base.repo.process.details.channel.content.*;
import com.faas.core.base.repo.process.details.channel.temp.ProcessEmailTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.ProcessPushTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.ProcessSmsMessageTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.ProcessWappMessageTempRepository;
import com.faas.core.base.repo.process.details.scenario.ProcessScenarioRepository;
import com.faas.core.base.repo.process.details.trigger.*;
import com.faas.core.base.repo.scenario.content.ScenarioRepository;
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
    ProcessEmailTempRepository processEmailTempRepository;

    @Autowired
    ProcessPushTempRepository processPushTempRepository;

    @Autowired
    ProcessSmsMessageTempRepository processSmsMessageTempRepository;

    @Autowired
    ProcessWappMessageTempRepository processWappMessageTempRepository;

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


    public ProcessWSDTO getProcessWSDTO(ProcessDBModel processDBModel) {

        ProcessWSDTO processWSDTO = new ProcessWSDTO();
        processWSDTO.setProcess(processDBModel);
        return processWSDTO;
    }


    public ProcessDetailsWSDTO createProcessDetailsWSDTO(ProcessDBModel processDBModel) {

        ProcessDetailsWSDTO processDetailsWSDTO = new ProcessDetailsWSDTO();
        processDetailsWSDTO.setProcess(processDBModel);
        processDetailsWSDTO.setProcessTemps(createProcessTempWSDTO(processDBModel.getId()));
        processDetailsWSDTO.setProcessChannels(createProcessChannelWSDTO(processDBModel.getId()));
        processDetailsWSDTO.setProcessTrigger(createProcessTriggersWSDTO(processDBModel.getId()));
        processDetailsWSDTO.setProcessScenarios(createProcessScenarioWSDTOS(processDBModel));

        return processDetailsWSDTO;
    }


    public ProcessInquiryDAO createProcessInquiryHelper(String processInquiry){

        ProcessInquiryDAO processInquiryDAO = new ProcessInquiryDAO();
        processInquiryDAO.setInquiryId(appUtils.generateUUID());
        processInquiryDAO.setProcessInquiry(processInquiry);
        processInquiryDAO.setInquiryRemotes(new ArrayList<>());
        processInquiryDAO.setInquiryDatas(new ArrayList<>());
        processInquiryDAO.setuDate(appUtils.getCurrentTimeStamp());
        processInquiryDAO.setcDate(appUtils.getCurrentTimeStamp());
        processInquiryDAO.setStatus(1);

        return processInquiryDAO;
    }


    public ProcessFlowDAO createProcessFlowHelper(String processFlow){

        ProcessFlowDAO processFlowDAO = new ProcessFlowDAO();
        processFlowDAO.setFlowId(appUtils.generateUUID());
        processFlowDAO.setProcessFlow(processFlow);
        processFlowDAO.setFlowRemotes(new ArrayList<>());
        processFlowDAO.setFlowDatas(new ArrayList<>());
        processFlowDAO.setuDate(appUtils.getCurrentTimeStamp());
        processFlowDAO.setcDate(appUtils.getCurrentTimeStamp());
        processFlowDAO.setStatus(1);

        return processFlowDAO;
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
        return processScenarioWSDTO;
    }


    public ProcessTempWSDTO createProcessTempWSDTO(String processId){

        ProcessTempWSDTO processTempWSDTO = new ProcessTempWSDTO();

        List<ProcessEmailTempDBModel> emailTemps = processEmailTempRepository.findByProcessId(processId);
        List<ProcessEmailTempWSDTO> processEmailTempWSDTOS = new ArrayList<>();
        for (ProcessEmailTempDBModel emailTemp : emailTemps) {
            processEmailTempWSDTOS.add(new ProcessEmailTempWSDTO(emailTemp));
        }
        processTempWSDTO.setEmailTemps(processEmailTempWSDTOS);

        List<ProcessPushTempDBModel> pushTemps = processPushTempRepository.findByProcessId(processId);
        List<ProcessPushTempWSDTO> processPushTempWSDTOS = new ArrayList<>();
        for (ProcessPushTempDBModel pushTemp : pushTemps) {
            processPushTempWSDTOS.add(new ProcessPushTempWSDTO(pushTemp));
        }
        processTempWSDTO.setPushTemps(processPushTempWSDTOS);

        List<ProcessSmsMessageTempDBModel>smsMessageTemps = processSmsMessageTempRepository.findByProcessId(processId);
        List<ProcessSmsMessageTempWSDTO> processSmsMessageTempWSDTOS = new ArrayList<>();
        for (ProcessSmsMessageTempDBModel smsMessageTemp : smsMessageTemps) {
            processSmsMessageTempWSDTOS.add(new ProcessSmsMessageTempWSDTO(smsMessageTemp));
        }
        processTempWSDTO.setSmsMessageTemps(processSmsMessageTempWSDTOS);

        List<ProcessWappMessageTempDBModel>wappMessageTemps = processWappMessageTempRepository.findByProcessId(processId);
        List<ProcessWappMessageTempWSDTO> processWappMessageTempWSDTOS = new ArrayList<>();
        for (ProcessWappMessageTempDBModel wappMessageTemp : wappMessageTemps) {
            processWappMessageTempWSDTOS.add(new ProcessWappMessageTempWSDTO(wappMessageTemp));
        }
        processTempWSDTO.setWappMessageTemps(processWappMessageTempWSDTOS);

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
