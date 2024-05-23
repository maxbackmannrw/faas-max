package com.faas.core.utils.helpers.process;

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
import com.faas.core.base.model.ws.process.details.trigger.temp.ai.dto.AITriggerTempWSDTO;
import com.faas.core.base.model.ws.process.details.trigger.content.dto.*;
import com.faas.core.base.model.ws.process.details.trigger.temp.email.dto.EmailTriggerTempWSDTO;
import com.faas.core.base.model.ws.process.details.trigger.temp.sip.dto.SipTriggerTempWSDTO;
import com.faas.core.base.model.ws.process.details.trigger.temp.sms.dto.SmsTriggerTempWSDTO;
import com.faas.core.base.model.ws.process.details.trigger.temp.wapp.call.dto.WappCallTriggerTempWSDTO;
import com.faas.core.base.model.ws.process.details.trigger.temp.wapp.message.dto.WappMessageTriggerTempWSDTO;
import com.faas.core.base.repo.process.details.channel.content.*;
import com.faas.core.base.repo.process.details.channel.temp.EmailTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.PushTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.SmsTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.WappMessageTempRepository;
import com.faas.core.base.repo.process.details.remote.ProcessRemoteRepository;
import com.faas.core.base.repo.process.details.scenario.ProcessScenarioRepository;
import com.faas.core.base.repo.process.details.trigger.*;
import com.faas.core.base.repo.scenario.content.ScenarioRepository;
import com.faas.core.base.repo.utility.UrlRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ProcessHelper {

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
    AITriggerTempRepository AITriggerTempRepository;

    @Autowired
    EmailTriggerTempRepository emailTriggerTempRepository;

    @Autowired
    SipTriggerTempRepository sipTriggerTempRepository;

    @Autowired
    SmsTriggerTempRepository smsTriggerTempRepository;

    @Autowired
    WappCallTriggerTempRepository wappCallTriggerTempRepository;

    @Autowired
    WappMessageTriggerTempRepository wappMessageTriggerTempRepository;

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
        processDetailsWSDTO.setProcessTriggerTemp(createProcessTriggerTempWSDTO(processDBModel.getId()));
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


    public ProcessTriggerTempWSDTO createProcessTriggerTempWSDTO(String processId){

        ProcessTriggerTempWSDTO processTriggerTempWSDTO = new ProcessTriggerTempWSDTO();
        processTriggerTempWSDTO.setAiTriggerTemps(createAITriggerTempWSDTOS(processId));
        processTriggerTempWSDTO.setEmailTriggerTemps(createEmailTriggerTempWSDTOS(processId));
        processTriggerTempWSDTO.setSipTriggerTemps(createSipTriggerTempWSDTOS(processId));
        processTriggerTempWSDTO.setSmsTriggerTemps(createSmsTriggerTempWSDTOS(processId));
        processTriggerTempWSDTO.setWappCallTriggerTemps(createWappCallTriggerTempWSDTOS(processId));
        processTriggerTempWSDTO.setWappMessageTriggerTemps(createWappMessageTriggerTempWSDTOS(processId));

        return processTriggerTempWSDTO;
    }

    public List<AITriggerTempWSDTO> createAITriggerTempWSDTOS(String processId) {

        List<AITriggerTempWSDTO> AITriggerTempWSDTOS = new ArrayList<>();
        List<AITriggerTempDBModel> AITriggerTempDBModels = AITriggerTempRepository.findByProcessId(processId);
        for (AITriggerTempDBModel aiTriggerTempDBModel : AITriggerTempDBModels) {
            AITriggerTempWSDTOS.add(new AITriggerTempWSDTO(aiTriggerTempDBModel));
        }
        return AITriggerTempWSDTOS;
    }

    public List<EmailTriggerTempWSDTO> createEmailTriggerTempWSDTOS(String processId) {

        List<EmailTriggerTempWSDTO> emailTriggerTempWSDTOS = new ArrayList<>();
        List<EmailTriggerTempDBModel> emailTriggerTempDBModels = emailTriggerTempRepository.findByProcessId(processId);
        for (EmailTriggerTempDBModel emailTriggerTempDBModel : emailTriggerTempDBModels) {
            emailTriggerTempWSDTOS.add(new EmailTriggerTempWSDTO(emailTriggerTempDBModel));
        }
        return emailTriggerTempWSDTOS;
    }

    public List<SipTriggerTempWSDTO> createSipTriggerTempWSDTOS(String processId) {

        List<SipTriggerTempWSDTO> sipTriggerTempWSDTOS = new ArrayList<>();
        List<SipTriggerTempDBModel> sipTriggerTempDBModels = sipTriggerTempRepository.findByProcessId(processId);
        for (SipTriggerTempDBModel sipTriggerTempDBModel : sipTriggerTempDBModels) {
            sipTriggerTempWSDTOS.add(new SipTriggerTempWSDTO(sipTriggerTempDBModel));
        }
        return sipTriggerTempWSDTOS;
    }

    public List<SmsTriggerTempWSDTO> createSmsTriggerTempWSDTOS(String processId) {

        List<SmsTriggerTempWSDTO> smsTriggerTempWSDTOS = new ArrayList<>();
        List<SmsTriggerTempDBModel> smsTriggerTempDBModels = smsTriggerTempRepository.findByProcessId(processId);
        for (SmsTriggerTempDBModel smsTriggerTempDBModel : smsTriggerTempDBModels) {
            smsTriggerTempWSDTOS.add(new SmsTriggerTempWSDTO(smsTriggerTempDBModel));
        }
        return smsTriggerTempWSDTOS;
    }

    public List<WappCallTriggerTempWSDTO> createWappCallTriggerTempWSDTOS(String processId) {

        List<WappCallTriggerTempWSDTO> wappCallTriggerTempWSDTOS = new ArrayList<>();
        List<WappCallTriggerTempDBModel> wappCallTriggerTempDBModels = wappCallTriggerTempRepository.findByProcessId(processId);
        for (WappCallTriggerTempDBModel wappCallTriggerTempDBModel : wappCallTriggerTempDBModels) {
            wappCallTriggerTempWSDTOS.add(new WappCallTriggerTempWSDTO(wappCallTriggerTempDBModel));
        }
        return wappCallTriggerTempWSDTOS;
    }

    public List<WappMessageTriggerTempWSDTO> createWappMessageTriggerTempWSDTOS(String processId) {

        List<WappMessageTriggerTempWSDTO> wappMessageTriggerTempWSDTOS = new ArrayList<>();
        List<WappMessageTriggerTempDBModel> wappMessageTriggerTempDBModels = wappMessageTriggerTempRepository.findByProcessId(processId);
        for (WappMessageTriggerTempDBModel wappMessageTriggerTempDBModel : wappMessageTriggerTempDBModels) {
            wappMessageTriggerTempWSDTOS.add(new WappMessageTriggerTempWSDTO(wappMessageTriggerTempDBModel));
        }
        return wappMessageTriggerTempWSDTOS;
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
