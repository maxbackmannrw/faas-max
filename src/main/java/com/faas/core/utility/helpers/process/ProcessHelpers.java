package com.faas.core.utility.helpers.process;

import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.db.process.content.dao.ProcessFlowDAO;
import com.faas.core.base.model.db.process.content.dao.ProcessInquiryDAO;
import com.faas.core.base.model.db.process.details.channel.content.*;
import com.faas.core.base.model.db.process.details.channel.temp.EmailTempDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.PushTempDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.SmsTempDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.WappMessageTempDBModel;
import com.faas.core.base.model.db.process.details.remote.ProcessRemoteDBModel;
import com.faas.core.base.model.db.process.details.scenario.ProcessScenarioDBModel;
import com.faas.core.base.model.db.process.details.trigger.*;
import com.faas.core.base.model.ws.process.content.dto.ProcessWSDTO;
import com.faas.core.base.model.ws.process.details.channel.content.dto.*;
import com.faas.core.base.model.ws.process.details.channel.temp.dto.ProcessTempWSDTO;
import com.faas.core.base.model.ws.process.details.channel.temp.dto.ProcessEmailTempWSDTO;
import com.faas.core.base.model.ws.process.details.channel.temp.dto.ProcessPushTempWSDTO;
import com.faas.core.base.model.ws.process.details.channel.temp.dto.ProcessSmsTempWSDTO;
import com.faas.core.base.model.ws.process.details.channel.temp.dto.ProcessWappMessageTempWSDTO;
import com.faas.core.base.model.ws.process.details.content.dto.ProcessDetailsWSDTO;
import com.faas.core.base.model.ws.process.details.remote.dto.ProcessRemoteWSDTO;
import com.faas.core.base.model.ws.process.details.scenario.dto.ProcessScenarioWSDTO;
import com.faas.core.base.model.ws.process.details.trigger.dto.ProcessAITriggerWSDTO;
import com.faas.core.base.model.ws.process.details.trigger.dto.*;
import com.faas.core.base.model.ws.process.details.trigger.dto.ProcessEmailTriggerWSDTO;
import com.faas.core.base.model.ws.process.details.trigger.dto.ProcessSipTriggerWSDTO;
import com.faas.core.base.model.ws.process.details.trigger.dto.ProcessSmsTriggerWSDTO;
import com.faas.core.base.model.ws.process.details.trigger.dto.ProcessWappCallTriggerWSDTO;
import com.faas.core.base.model.ws.process.details.trigger.dto.ProcessWappMessageTriggerWSDTO;
import com.faas.core.base.repo.process.details.channel.content.*;
import com.faas.core.base.repo.process.details.channel.temp.EmailTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.PushTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.SmsTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.WappMessageTempRepository;
import com.faas.core.base.repo.process.details.remote.ProcessRemoteRepository;
import com.faas.core.base.repo.process.details.scenario.ProcessScenarioRepository;
import com.faas.core.base.repo.process.details.trigger.*;
import com.faas.core.base.repo.scenario.content.ScenarioRepository;
import com.faas.core.base.repo.utils.UrlRepository;
import com.faas.core.utility.config.AppConstant;
import com.faas.core.utility.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ProcessHelpers {

    @Autowired
    ScenarioRepository scenarioRepository;

    @Autowired
    ProcessRemoteRepository processRemoteRepository;

    @Autowired
    UrlRepository urlRepository;

    @Autowired
    EmailTempRepository emailTempRepository;

    @Autowired
    PushTempRepository pushTempRepository;

    @Autowired
    SmsTempRepository smsTempRepository;

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


    public ProcessWSDTO getProcessWSDTO(ProcessDBModel processDBModel) {

        ProcessWSDTO processWSDTO = new ProcessWSDTO();
        processWSDTO.setProcess(processDBModel);
        return processWSDTO;
    }


    public ProcessDetailsWSDTO createProcessDetailsWSDTO(ProcessDBModel processDBModel) {

        ProcessDetailsWSDTO processDetailsWSDTO = new ProcessDetailsWSDTO();
        processDetailsWSDTO.setProcess(processDBModel);
        processDetailsWSDTO.setProcessTemp(createProcessTempWSDTO(processDBModel.getId()));
        processDetailsWSDTO.setProcessChannels(createProcessChannelWSDTO(processDBModel.getId()));
        processDetailsWSDTO.setProcessTrigger(createProcessTriggerWSDTO(processDBModel.getId()));
        processDetailsWSDTO.setProcessScenarios(createProcessScenarioWSDTOS(processDBModel));
        processDetailsWSDTO.setProcessRemotes(createProcessRemoteWSDTOS(processDBModel));

        return processDetailsWSDTO;
    }


    public ProcessInquiryDAO createProcessInquiryHelper(String processInquiry){

        ProcessInquiryDAO processInquiryDAO = new ProcessInquiryDAO();
        processInquiryDAO.setInquiryId(appUtils.generateUUID());
        processInquiryDAO.setProcessInquiry(processInquiry);
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
        processFlowDAO.setFlowDatas(new ArrayList<>());
        processFlowDAO.setuDate(appUtils.getCurrentTimeStamp());
        processFlowDAO.setcDate(appUtils.getCurrentTimeStamp());
        processFlowDAO.setStatus(1);

        return processFlowDAO;
    }


    public ProcessTriggerWSDTO createProcessTriggerWSDTO(String processId){

        ProcessTriggerWSDTO processTriggerWSDTO = new ProcessTriggerWSDTO();
        processTriggerWSDTO.setProcessAITriggers(createProcessAITriggerWSDTOS(processId));
        processTriggerWSDTO.setProcessEmailTriggers(createProcessEmailTriggerWSDTOS(processId));
        processTriggerWSDTO.setProcessSipTriggers(createProcessSipTriggerWSDTOS(processId));
        processTriggerWSDTO.setProcessSmsTriggers(createProcessSmsTriggerWSDTOS(processId));
        processTriggerWSDTO.setProcessWappCallTriggers(createProcessWappCallTriggerWSDTOS(processId));
        processTriggerWSDTO.setProcessWappMessageTriggers(createProcessWappMessageTriggerWSDTOS(processId));

        return processTriggerWSDTO;
    }

    public List<ProcessAITriggerWSDTO> createProcessAITriggerWSDTOS(String processId) {

        List<ProcessAITriggerWSDTO> ProcessAITriggerWSDTOS = new ArrayList<>();
        List<AITriggerDBModel> AITriggerDBModels = AITriggerRepository.findByProcessId(processId);
        for (AITriggerDBModel aiTriggerDBModel : AITriggerDBModels) {
            ProcessAITriggerWSDTOS.add(new ProcessAITriggerWSDTO(aiTriggerDBModel));
        }
        return ProcessAITriggerWSDTOS;
    }

    public List<ProcessEmailTriggerWSDTO> createProcessEmailTriggerWSDTOS(String processId) {

        List<ProcessEmailTriggerWSDTO> processEmailTriggerWSDTOS = new ArrayList<>();
        List<EmailTriggerDBModel> emailTriggerDBModels = emailTriggerRepository.findByProcessId(processId);
        for (EmailTriggerDBModel emailTriggerDBModel : emailTriggerDBModels) {
            processEmailTriggerWSDTOS.add(new ProcessEmailTriggerWSDTO(emailTriggerDBModel));
        }
        return processEmailTriggerWSDTOS;
    }

    public List<ProcessSipTriggerWSDTO> createProcessSipTriggerWSDTOS(String processId) {

        List<ProcessSipTriggerWSDTO> processSipTriggerWSDTOS = new ArrayList<>();
        List<SipTriggerDBModel> sipTriggerDBModels = sipTriggerRepository.findByProcessId(processId);
        for (SipTriggerDBModel sipTriggerDBModel : sipTriggerDBModels) {
            processSipTriggerWSDTOS.add(new ProcessSipTriggerWSDTO(sipTriggerDBModel));
        }
        return processSipTriggerWSDTOS;
    }

    public List<ProcessSmsTriggerWSDTO> createProcessSmsTriggerWSDTOS(String processId) {

        List<ProcessSmsTriggerWSDTO> processSmsTriggerWSDTOS = new ArrayList<>();
        List<SmsTriggerDBModel> smsTriggerDBModels = smsTriggerRepository.findByProcessId(processId);
        for (SmsTriggerDBModel smsTriggerDBModel : smsTriggerDBModels) {
            processSmsTriggerWSDTOS.add(new ProcessSmsTriggerWSDTO(smsTriggerDBModel));
        }
        return processSmsTriggerWSDTOS;
    }

    public List<ProcessWappCallTriggerWSDTO> createProcessWappCallTriggerWSDTOS(String processId) {

        List<ProcessWappCallTriggerWSDTO> processWappCallTriggerWSDTOS = new ArrayList<>();
        List<WappCallTriggerDBModel> wappCallTriggerDBModels = wappCallTriggerRepository.findByProcessId(processId);
        for (WappCallTriggerDBModel wappCallTriggerDBModel : wappCallTriggerDBModels) {
            processWappCallTriggerWSDTOS.add(new ProcessWappCallTriggerWSDTO(wappCallTriggerDBModel));
        }
        return processWappCallTriggerWSDTOS;
    }

    public List<ProcessWappMessageTriggerWSDTO> createProcessWappMessageTriggerWSDTOS(String processId) {

        List<ProcessWappMessageTriggerWSDTO> processWappMessageTriggerWSDTOS = new ArrayList<>();
        List<WappMessageTriggerDBModel> wappMessageTriggerDBModels = wappMessageTriggerRepository.findByProcessId(processId);
        for (WappMessageTriggerDBModel wappMessageTriggerDBModel : wappMessageTriggerDBModels) {
            processWappMessageTriggerWSDTOS.add(new ProcessWappMessageTriggerWSDTO(wappMessageTriggerDBModel));
        }
        return processWappMessageTriggerWSDTOS;
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

    public List<ProcessRemoteWSDTO> createProcessRemoteWSDTOS(ProcessDBModel processDBModel){

        List<ProcessRemoteWSDTO> processRemoteWSDTOS = new ArrayList<>();
        List<ProcessRemoteDBModel> processRemoteDBModels = processRemoteRepository.findByProcessId(processDBModel.getId());
        for (ProcessRemoteDBModel processRemoteDBModel : processRemoteDBModels) {
            processRemoteWSDTOS.add(mapProcessRemoteWSDTO(processRemoteDBModel));
        }
        return processRemoteWSDTOS;
    }

    public ProcessRemoteWSDTO mapProcessRemoteWSDTO(ProcessRemoteDBModel processRemoteDBModel){

        ProcessRemoteWSDTO processRemoteWSDTO = new ProcessRemoteWSDTO();
        processRemoteWSDTO.setProcessRemote(processRemoteDBModel);
        processRemoteWSDTO.setProcessRemoteUrls(urlRepository.findByBaseTypeAndOwnerId(AppConstant.REMOTE_URL,processRemoteDBModel.getRemoteId()));

        return processRemoteWSDTO;
    }


    public ProcessTempWSDTO createProcessTempWSDTO(String processId){

        ProcessTempWSDTO processTempWSDTO = new ProcessTempWSDTO();

        List<EmailTempDBModel> processEmailTemps = emailTempRepository.findByProcessId(processId);
        List<ProcessEmailTempWSDTO> processEmailTempWSDTOS = new ArrayList<>();
        for (EmailTempDBModel processEmailTemp : processEmailTemps) {
            processEmailTempWSDTOS.add(new ProcessEmailTempWSDTO(processEmailTemp));
        }
        processTempWSDTO.setProcessEmailTemps(processEmailTempWSDTOS);

        List<PushTempDBModel> processPushTemps = pushTempRepository.findByProcessId(processId);
        List<ProcessPushTempWSDTO> processPushTempWSDTOS = new ArrayList<>();
        for (PushTempDBModel processPushTemp : processPushTemps) {
            processPushTempWSDTOS.add(new ProcessPushTempWSDTO(processPushTemp));
        }
        processTempWSDTO.setProcessPushTemps(processPushTempWSDTOS);

        List<SmsTempDBModel>processSmsTemps = smsTempRepository.findByProcessId(processId);
        List<ProcessSmsTempWSDTO> processSmsTempWSDTOS = new ArrayList<>();
        for (SmsTempDBModel processSmsTemp : processSmsTemps) {
            processSmsTempWSDTOS.add(new ProcessSmsTempWSDTO(processSmsTemp));
        }
        processTempWSDTO.setProcessSmsTemps(processSmsTempWSDTOS);

        List<WappMessageTempDBModel>processWappMessageTemps = wappMessageTempRepository.findByProcessId(processId);
        List<ProcessWappMessageTempWSDTO> processWappMessageTempWSDTOS = new ArrayList<>();
        for (WappMessageTempDBModel processWappMessageTemp : processWappMessageTemps) {
            processWappMessageTempWSDTOS.add(new ProcessWappMessageTempWSDTO(processWappMessageTemp));
        }
        processTempWSDTO.setProcessWappMessageTemps(processWappMessageTempWSDTOS);

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
