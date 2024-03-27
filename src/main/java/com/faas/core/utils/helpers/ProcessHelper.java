package com.faas.core.utils.helpers;

import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.db.process.content.dao.ProcessFlowDAO;
import com.faas.core.base.model.db.process.content.dao.ProcessInquiryDAO;
import com.faas.core.base.model.db.process.details.channel.content.*;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessEmailTempDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessPushTempDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessSmsTempDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessWappMessageTempDBModel;
import com.faas.core.base.model.db.process.details.scenario.ProcessScenarioDBModel;
import com.faas.core.base.model.db.process.details.channel.trigger.*;
import com.faas.core.base.model.ws.process.content.dto.ProcessWSDTO;
import com.faas.core.base.model.ws.process.details.channel.content.dto.*;
import com.faas.core.base.model.ws.process.details.channel.temp.dto.*;
import com.faas.core.base.model.ws.process.details.content.dto.ProcessDetailsWSDTO;
import com.faas.core.base.model.ws.process.details.scenario.dto.ProcessScenarioWSDTO;
import com.faas.core.base.model.ws.process.details.channel.trigger.dto.*;
import com.faas.core.base.repo.process.details.channel.content.*;
import com.faas.core.base.repo.process.details.channel.temp.ProcessEmailTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.ProcessPushTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.ProcessSmsTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.ProcessWappMessageTempRepository;
import com.faas.core.base.repo.process.details.scenario.ProcessScenarioRepository;
import com.faas.core.base.repo.process.details.trigger.*;
import com.faas.core.base.repo.scenario.content.ScenarioRepository;
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
    ProcessEmailTempRepository processEmailTempRepository;

    @Autowired
    ProcessPushTempRepository processPushTempRepository;

    @Autowired
    ProcessSmsTempRepository processSmsTempRepository;

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
    ProcessAITriggerRepository processAITriggerRepository;

    @Autowired
    ProcessEmailTriggerRepository processEmailTriggerRepository;

    @Autowired
    ProcessSipTriggerRepository processSipTriggerRepository;

    @Autowired
    ProcessSmsTriggerRepository processSmsTriggerRepository;

    @Autowired
    ProcessWappCallTriggerRepository processWappCallTriggerRepository;

    @Autowired
    ProcessWappMessageTriggerRepository processWappMessageTriggerRepository;

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

        List<ProcessAITriggerWSDTO> processAITriggerWSDTOS = new ArrayList<>();
        List<ProcessAITriggerDBModel> processAITriggerDBModels = processAITriggerRepository.findByProcessId(processId);
        for (ProcessAITriggerDBModel processAiTriggerDBModel : processAITriggerDBModels) {
            processAITriggerWSDTOS.add(new ProcessAITriggerWSDTO(processAiTriggerDBModel));
        }
        return processAITriggerWSDTOS;
    }

    public List<ProcessEmailTriggerWSDTO> createProcessEmailTriggerWSDTOS(String processId) {

        List<ProcessEmailTriggerWSDTO> processEmailTriggerWSDTOS = new ArrayList<>();
        List<ProcessEmailTriggerDBModel> processEmailTriggerDBModels = processEmailTriggerRepository.findByProcessId(processId);
        for (ProcessEmailTriggerDBModel processEmailTriggerDBModel : processEmailTriggerDBModels) {
            processEmailTriggerWSDTOS.add(new ProcessEmailTriggerWSDTO(processEmailTriggerDBModel));
        }
        return processEmailTriggerWSDTOS;
    }

    public List<ProcessSipTriggerWSDTO> createProcessSipTriggerWSDTOS(String processId) {

        List<ProcessSipTriggerWSDTO> processSipTriggerWSDTOS = new ArrayList<>();
        List<ProcessSipTriggerDBModel> processSipTriggerDBModels = processSipTriggerRepository.findByProcessId(processId);
        for (ProcessSipTriggerDBModel processSipTriggerDBModel : processSipTriggerDBModels) {
            processSipTriggerWSDTOS.add(new ProcessSipTriggerWSDTO(processSipTriggerDBModel));
        }
        return processSipTriggerWSDTOS;
    }

    public List<ProcessSmsTriggerWSDTO> createProcessSmsTriggerWSDTOS(String processId) {

        List<ProcessSmsTriggerWSDTO> processSmsTriggerWSDTOS = new ArrayList<>();
        List<ProcessSmsTriggerDBModel> processSmsTriggerDBModels = processSmsTriggerRepository.findByProcessId(processId);
        for (ProcessSmsTriggerDBModel processSmsTriggerDBModel : processSmsTriggerDBModels) {
            processSmsTriggerWSDTOS.add(new ProcessSmsTriggerWSDTO(processSmsTriggerDBModel));
        }
        return processSmsTriggerWSDTOS;
    }

    public List<ProcessWappCallTriggerWSDTO> createProcessWappCallTriggerWSDTOS(String processId) {

        List<ProcessWappCallTriggerWSDTO> processWappCallTriggerWSDTOS = new ArrayList<>();
        List<ProcessWappCallTriggerDBModel> processWappCallTriggerDBModels = processWappCallTriggerRepository.findByProcessId(processId);
        for (ProcessWappCallTriggerDBModel processWappCallTriggerDBModel : processWappCallTriggerDBModels) {
            processWappCallTriggerWSDTOS.add(new ProcessWappCallTriggerWSDTO(processWappCallTriggerDBModel));
        }
        return processWappCallTriggerWSDTOS;
    }

    public List<ProcessWappMessageTriggerWSDTO> createProcessWappMessageTriggerWSDTOS(String processId) {

        List<ProcessWappMessageTriggerWSDTO> processWappMessageTriggerWSDTOS = new ArrayList<>();
        List<ProcessWappMessageTriggerDBModel> processWappMessageTriggerDBModels = processWappMessageTriggerRepository.findByProcessId(processId);
        for (ProcessWappMessageTriggerDBModel processWappMessageTriggerDBModel : processWappMessageTriggerDBModels) {
            processWappMessageTriggerWSDTOS.add(new ProcessWappMessageTriggerWSDTO(processWappMessageTriggerDBModel));
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


    public ProcessTempWSDTO createProcessTempWSDTO(String processId){

        ProcessTempWSDTO processTempWSDTO = new ProcessTempWSDTO();

        List<ProcessEmailTempDBModel> processEmailTemps = processEmailTempRepository.findByProcessId(processId);
        List<ProcessEmailTempWSDTO> processEmailTempWSDTOS = new ArrayList<>();
        for (ProcessEmailTempDBModel processEmailTemp : processEmailTemps) {
            processEmailTempWSDTOS.add(new ProcessEmailTempWSDTO(processEmailTemp));
        }
        processTempWSDTO.setProcessEmailTemps(processEmailTempWSDTOS);

        List<ProcessPushTempDBModel> processPushTemps = processPushTempRepository.findByProcessId(processId);
        List<ProcessPushTempWSDTO> processPushTempWSDTOS = new ArrayList<>();
        for (ProcessPushTempDBModel processPushTemp : processPushTemps) {
            processPushTempWSDTOS.add(new ProcessPushTempWSDTO(processPushTemp));
        }
        processTempWSDTO.setProcessPushTemps(processPushTempWSDTOS);

        List<ProcessSmsTempDBModel>processSmsTemps = processSmsTempRepository.findByProcessId(processId);
        List<ProcessSmsTempWSDTO> processSmsTempWSDTOS = new ArrayList<>();
        for (ProcessSmsTempDBModel processSmsTemp : processSmsTemps) {
            processSmsTempWSDTOS.add(new ProcessSmsTempWSDTO(processSmsTemp));
        }
        processTempWSDTO.setProcessSmsTemps(processSmsTempWSDTOS);

        List<ProcessWappMessageTempDBModel>processWappMessageTemps = processWappMessageTempRepository.findByProcessId(processId);
        List<ProcessWappMessageTempWSDTO> processWappMessageTempWSDTOS = new ArrayList<>();
        for (ProcessWappMessageTempDBModel processWappMessageTemp : processWappMessageTemps) {
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
