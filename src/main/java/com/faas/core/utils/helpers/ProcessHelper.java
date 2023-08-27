package com.faas.core.utils.helpers;

import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.db.process.details.channel.content.*;
import com.faas.core.base.model.db.process.details.channel.temp.EmailTempDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.PushTempDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.SmsMessageTempDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.WappMessageTempDBModel;
import com.faas.core.base.model.db.process.details.scenario.ProcessScenarioDBModel;
import com.faas.core.base.model.db.process.details.trigger.TriggerDBModel;
import com.faas.core.base.model.db.scenario.content.ScenarioDBModel;
import com.faas.core.base.model.ws.process.details.channel.content.dto.*;
import com.faas.core.base.model.ws.process.details.channel.temp.dto.*;
import com.faas.core.base.model.ws.process.details.content.dto.ProcessDetailsWSDTO;
import com.faas.core.base.model.ws.process.details.scenario.dto.ProcessScenarioWSDTO;
import com.faas.core.base.model.ws.process.details.trigger.dto.TriggerWSDTO;
import com.faas.core.base.repo.process.details.channel.content.*;
import com.faas.core.base.repo.process.details.channel.temp.EmailTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.PushTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.SmsMessageTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.WappMessageTempRepository;
import com.faas.core.base.repo.process.details.scenario.ProcessScenarioRepository;
import com.faas.core.base.repo.process.details.trigger.TriggerRepository;
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
    TriggerRepository triggerRepository;

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
    AppUtils appUtils;


    public ProcessDetailsWSDTO createProcessDetailsWSDTO(ProcessDBModel processDBModel) {

        ProcessDetailsWSDTO processDetailsWSDTO = new ProcessDetailsWSDTO();

        processDetailsWSDTO.setProcess(processDBModel);
        processDetailsWSDTO.setProcessTriggers(createProcessTriggersWSDTOS(processDBModel));
        processDetailsWSDTO.setProcessScenarios(createProcessScenarioWSDTOS(processDBModel));
        processDetailsWSDTO.setProcessTemps(createProcessTempWSDTO(processDBModel.getId()));
        processDetailsWSDTO.setProcessChannels(createProcessChannelWSDTO(processDBModel.getId()));
        processDetailsWSDTO.setProcessAssets(new ArrayList<>());

        return processDetailsWSDTO;
    }


    public List<TriggerWSDTO> createProcessTriggersWSDTOS(ProcessDBModel processDBModel){

        List<TriggerWSDTO> triggerWSDTOS = new ArrayList<>();

        List<TriggerDBModel> triggerDBModels = triggerRepository.findByProcessId(processDBModel.getId());
        for (TriggerDBModel triggerDBModel : triggerDBModels) {
            triggerWSDTOS.add(new TriggerWSDTO(triggerDBModel));
        }
        return triggerWSDTOS;
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

        List<EmailTempDBModel> emailTemps = emailTempRepository.findByProcessId(processId);
        List<EmailTempWSDTO>emailTempWSDTOS = new ArrayList<>();
        for (EmailTempDBModel emailTemp : emailTemps) {
            emailTempWSDTOS.add(new EmailTempWSDTO(emailTemp));
        }
        processTempWSDTO.setEmailTemps(emailTempWSDTOS);

        List<PushTempDBModel> pushTemps = pushTempRepository.findByProcessId(processId);
        List<PushTempWSDTO>pushTempWSDTOS = new ArrayList<>();
        for (PushTempDBModel pushTemp : pushTemps) {
            pushTempWSDTOS.add(new PushTempWSDTO(pushTemp));
        }
        processTempWSDTO.setPushTemps(pushTempWSDTOS);

        List<SmsMessageTempDBModel>smsMessageTemps = smsMessageTempRepository.findByProcessId(processId);
        List<SmsMessageTempWSDTO>smsMessageTempWSDTOS = new ArrayList<>();
        for (SmsMessageTempDBModel smsMessageTemp : smsMessageTemps) {
            smsMessageTempWSDTOS.add(new SmsMessageTempWSDTO(smsMessageTemp));
        }
        processTempWSDTO.setSmsMessageTemps(smsMessageTempWSDTOS);

        List<WappMessageTempDBModel>wappMessageTemps = wappMessageTempRepository.findByProcessId(processId);
        List<WappMessageTempWSDTO>wappMessageTempWSDTOS = new ArrayList<>();
        for (WappMessageTempDBModel wappMessageTemp : wappMessageTemps) {
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
