package com.faas.core.base.framework.process.details.channel.content;

import com.faas.core.base.model.db.channel.account.EmailAccountDBModel;
import com.faas.core.base.model.db.channel.account.PushAccountDBModel;
import com.faas.core.base.model.db.channel.account.SmsAccountDBModel;
import com.faas.core.base.model.db.process.details.channel.content.*;
import com.faas.core.base.model.db.process.details.channel.content.dao.ProcessSmsAccountDAO;
import com.faas.core.base.model.ws.process.details.channel.content.dto.*;
import com.faas.core.base.repo.channel.account.EmailAccountRepository;
import com.faas.core.base.repo.channel.account.PushAccountRepository;
import com.faas.core.base.repo.channel.account.SmsAccountRepository;
import com.faas.core.base.repo.process.details.channel.content.*;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.ChannelHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class ProcessChannelFramework {


    @Autowired
    ChannelHelper channelHelper;

    @Autowired
    ProcessSipChannelRepository processSipChannelRepository;

    @Autowired
    ProcessWappChannelRepository processWappChannelRepository;

    @Autowired
    ProcessSmsChannelRepository processSmsChannelRepository;

    @Autowired
    ProcessEmailChannelRepository processEmailChannelRepository;

    @Autowired
    ProcessPushChannelRepository processPushChannelRepository;

    @Autowired
    SmsAccountRepository smsAccountRepository;

    @Autowired
    EmailAccountRepository emailAccountRepository;

    @Autowired
    PushAccountRepository pushAccountRepository;

    @Autowired
    AppUtils appUtils;


    public ProcessChannelWSDTO getProcessChannelsService(String processId) {

        ProcessChannelWSDTO processChannelWSDTO = new ProcessChannelWSDTO();
        List<ProcessWappChannelDBModel> processWappChannelDBModels = processWappChannelRepository.findByProcessId(processId);
        if (!processWappChannelDBModels.isEmpty()) {
            processChannelWSDTO.setWappChannel(new ProcessWappChannelWSDTO(processWappChannelDBModels.get(0)));
        }
        List<ProcessSipChannelDBModel> processSipChannelDBModels = processSipChannelRepository.findByProcessId(processId);
        if (!processSipChannelDBModels.isEmpty()) {
            processChannelWSDTO.setSipChannel(new ProcessSipChannelWSDTO(processSipChannelDBModels.get(0)));
        }
        List<ProcessSmsChannelDBModel> processSmsChannelDBModels = processSmsChannelRepository.findByProcessId(processId);
        if (!processSmsChannelDBModels.isEmpty()) {
            processChannelWSDTO.setSmsChannel(new ProcessSmsChannelWSDTO(processSmsChannelDBModels.get(0)));
        }
        List<ProcessEmailChannelDBModel> processEmailChannelDBModels = processEmailChannelRepository.findByProcessId(processId);
        if (!processEmailChannelDBModels.isEmpty()) {
            processChannelWSDTO.setEmailChannel(new ProcessEmailChannelWSDTO(processEmailChannelDBModels.get(0)));
        }
        List<ProcessPushChannelDBModel> processPushChannelDBModels = processPushChannelRepository.findByProcessId(processId);
        if (!processPushChannelDBModels.isEmpty()) {
            processChannelWSDTO.setPushChannel(new ProcessPushChannelWSDTO(processPushChannelDBModels.get(0)));
        }
        return processChannelWSDTO;
    }


    public ProcessSipChannelWSDTO getProcessSipChannelService(String processId) {

        List<ProcessSipChannelDBModel> processSipChannelDBModels = processSipChannelRepository.findByProcessId(processId);
        if (!processSipChannelDBModels.isEmpty()) {
            return new ProcessSipChannelWSDTO(processSipChannelDBModels.get(0));
        }
        return null;
    }


    public ProcessSipChannelWSDTO createProcessSipChannelService(String processId, String callerId, String channelState) {

        List<ProcessSipChannelDBModel> existedSipChannel = processSipChannelRepository.findByProcessId(processId);
        if (!existedSipChannel.isEmpty()) {

            existedSipChannel.get(0).setCallerId(callerId);
            existedSipChannel.get(0).setChannelState(channelState);
            existedSipChannel.get(0).setuDate(appUtils.getCurrentTimeStamp());

            return new ProcessSipChannelWSDTO(processSipChannelRepository.save(existedSipChannel.get(0)));
        }else {

            ProcessSipChannelDBModel processSipChannelDBModel = new ProcessSipChannelDBModel();
            processSipChannelDBModel.setProcessId(processId);
            processSipChannelDBModel.setCallerId(callerId);
            processSipChannelDBModel.setChannelState(channelState);
            processSipChannelDBModel.setuDate(appUtils.getCurrentTimeStamp());
            processSipChannelDBModel.setcDate(appUtils.getCurrentTimeStamp());
            processSipChannelDBModel.setStatus(1);

            return new ProcessSipChannelWSDTO(processSipChannelRepository.save(processSipChannelDBModel));
        }
    }


    public ProcessSipChannelWSDTO removeProcessSipChannelService(String processId) {

        List<ProcessSipChannelDBModel> processSipChannelDBModels = processSipChannelRepository.findByProcessId(processId);
        if (!processSipChannelDBModels.isEmpty()) {
            processSipChannelRepository.deleteAll(processSipChannelDBModels);
            return new ProcessSipChannelWSDTO(processSipChannelDBModels.get(0));
        }
        return null;
    }


    public ProcessSmsChannelWSDTO getProcessSmsChannelService(String processId) {

        List<ProcessSmsChannelDBModel> processSmsChannelDBModels = processSmsChannelRepository.findByProcessId(processId);
        if (!processSmsChannelDBModels.isEmpty()) {
            return new ProcessSmsChannelWSDTO(processSmsChannelDBModels.get(0));
        }
        return null;
    }


    public ProcessSmsChannelWSDTO createProcessSmsChannelService(String processId, String accountId, String channelState) {

        Optional<SmsAccountDBModel> smsAccountDBModel = smsAccountRepository.findById(accountId);
        if (smsAccountDBModel.isEmpty()) {
            return null;
        }
        ProcessSmsAccountDAO processSmsAccountDAO = channelHelper.mapProcessSmsAccountDAO(smsAccountDBModel.get());
        if (processSmsAccountDAO != null) {
            List<ProcessSmsChannelDBModel> existedSmsChannel = processSmsChannelRepository.findByProcessId(processId);
            if (!existedSmsChannel.isEmpty()) {

                existedSmsChannel.get(0).setSmsAccount(processSmsAccountDAO);
                existedSmsChannel.get(0).setChannelState(channelState);
                existedSmsChannel.get(0).setuDate(appUtils.getCurrentTimeStamp());
                processSmsChannelRepository.save(existedSmsChannel.get(0));

                return new ProcessSmsChannelWSDTO(existedSmsChannel.get(0));
            }else {

                ProcessSmsChannelDBModel processSmsChannelDBModel = new ProcessSmsChannelDBModel();
                processSmsChannelDBModel.setProcessId(processId);
                processSmsChannelDBModel.setSmsAccount(processSmsAccountDAO);
                processSmsChannelDBModel.setChannelState(channelState);
                processSmsChannelDBModel.setuDate(appUtils.getCurrentTimeStamp());
                processSmsChannelDBModel.setcDate(appUtils.getCurrentTimeStamp());
                processSmsChannelDBModel.setStatus(1);

                return new ProcessSmsChannelWSDTO(processSmsChannelRepository.save(processSmsChannelDBModel));
            }
        }
        return null;
    }


    public ProcessSmsChannelWSDTO removeProcessSmsChannelService(String processId) {

        List<ProcessSmsChannelDBModel> processSmsChannelDBModels = processSmsChannelRepository.findByProcessId(processId);
        if (!processSmsChannelDBModels.isEmpty()) {
            processSmsChannelRepository.deleteAll(processSmsChannelDBModels);
            return new ProcessSmsChannelWSDTO(processSmsChannelDBModels.get(0));
        }
        return null;
    }


    public ProcessWappChannelWSDTO getProcessWappChannelService(String processId) {

        List<ProcessWappChannelDBModel> processWappChannelDBModels = processWappChannelRepository.findByProcessId(processId);
        if (!processWappChannelDBModels.isEmpty()) {
            return new ProcessWappChannelWSDTO(processWappChannelDBModels.get(0));
        }
        return null;
    }


    public ProcessWappChannelWSDTO createProcessWappChannelService(long userId,String processId, String callState, String messageState) {

        List<ProcessWappChannelDBModel> existedWappChannel = processWappChannelRepository.findByProcessId(processId);
        if (!existedWappChannel.isEmpty()) {
            existedWappChannel.get(0).setCallState(callState);
            existedWappChannel.get(0).setMessageState(messageState);
            existedWappChannel.get(0).setuDate(appUtils.getCurrentTimeStamp());

            return new ProcessWappChannelWSDTO(processWappChannelRepository.save(existedWappChannel.get(0)));
        }else {

            ProcessWappChannelDBModel processWappChannelDBModel = new ProcessWappChannelDBModel();
            processWappChannelDBModel.setProcessId(processId);
            processWappChannelDBModel.setCallState(callState);
            processWappChannelDBModel.setMessageState(messageState);
            processWappChannelDBModel.setuDate(appUtils.getCurrentTimeStamp());
            processWappChannelDBModel.setcDate(appUtils.getCurrentTimeStamp());
            processWappChannelDBModel.setStatus(1);

            return new ProcessWappChannelWSDTO(processWappChannelRepository.save(processWappChannelDBModel));
        }
    }


    public ProcessWappChannelWSDTO removeProcessWappChannelService(String processId) {

        List<ProcessWappChannelDBModel> processWappChannelDBModels = processWappChannelRepository.findByProcessId(processId);
        if (!processWappChannelDBModels.isEmpty()) {
            processWappChannelRepository.deleteAll(processWappChannelDBModels);
            return new ProcessWappChannelWSDTO(processWappChannelDBModels.get(0));
        }
        return null;
    }


    public ProcessEmailChannelWSDTO getProcessEmailChannelService(String processId) {

        List<ProcessEmailChannelDBModel> processEmailChannelDBModels = processEmailChannelRepository.findByProcessId(processId);
        if (!processEmailChannelDBModels.isEmpty()) {
            return new ProcessEmailChannelWSDTO(processEmailChannelDBModels.get(0));
        }
        return null;
    }

    public ProcessEmailChannelWSDTO createProcessEmailChannelService(String processId, String accountId,String channelState) {

        Optional<EmailAccountDBModel> emailAccountDBModel = emailAccountRepository.findById(accountId);
        if (emailAccountDBModel.isPresent()) {
            List<ProcessEmailChannelDBModel> existedEmailChannel = processEmailChannelRepository.findByProcessId(processId);
            if (!existedEmailChannel.isEmpty()) {

                existedEmailChannel.get(0).setEmailAccount(channelHelper.mapProcessEmailAccountDAO(emailAccountDBModel.get()));
                existedEmailChannel.get(0).setChannelState(channelState);
                existedEmailChannel.get(0).setuDate(appUtils.getCurrentTimeStamp());

                return new ProcessEmailChannelWSDTO(processEmailChannelRepository.save(existedEmailChannel.get(0)));
            }else {

                ProcessEmailChannelDBModel processEmailChannelDBModel = new ProcessEmailChannelDBModel();
                processEmailChannelDBModel.setProcessId(processId);
                processEmailChannelDBModel.setEmailAccount(channelHelper.mapProcessEmailAccountDAO(emailAccountDBModel.get()));
                processEmailChannelDBModel.setChannelState(channelState);
                processEmailChannelDBModel.setuDate(appUtils.getCurrentTimeStamp());
                processEmailChannelDBModel.setcDate(appUtils.getCurrentTimeStamp());
                processEmailChannelDBModel.setStatus(1);

                return new ProcessEmailChannelWSDTO(processEmailChannelRepository.save(processEmailChannelDBModel));
            }
        }
        return null;
    }

    public ProcessEmailChannelWSDTO removeProcessEmailChannelService(String processId) {

        List<ProcessEmailChannelDBModel> processEmailChannelDBModels = processEmailChannelRepository.findByProcessId(processId);
        if (!processEmailChannelDBModels.isEmpty()) {
            processEmailChannelRepository.deleteAll(processEmailChannelDBModels);
            return new ProcessEmailChannelWSDTO(processEmailChannelDBModels.get(0));
        }
        return null;
    }



    public ProcessPushChannelWSDTO getProcessPushChannelService(String processId) {

        List<ProcessPushChannelDBModel>processPushChannelDBModels = processPushChannelRepository.findByProcessId(processId);
        if (!processPushChannelDBModels.isEmpty()) {
            return new ProcessPushChannelWSDTO(processPushChannelDBModels.get(0));
        }
        return null;
    }


    public ProcessPushChannelWSDTO createProcessPushChannelService(String processId, String accountId,String channelState) {

        Optional<PushAccountDBModel> pushAccountDBModel = pushAccountRepository.findById(accountId);
        if (pushAccountDBModel.isPresent()) {
            List<ProcessPushChannelDBModel> existedPushChannel = processPushChannelRepository.findByProcessId(processId);
            if (!existedPushChannel.isEmpty()) {

                existedPushChannel.get(0).setPushAccount(channelHelper.mapProcessPushAccountDAO(pushAccountDBModel.get()));
                existedPushChannel.get(0).setChannelState(channelState);
                existedPushChannel.get(0).setuDate(appUtils.getCurrentTimeStamp());

                return new ProcessPushChannelWSDTO(processPushChannelRepository.save(existedPushChannel.get(0)));
            }else {

                ProcessPushChannelDBModel processPushChannelDBModel = new ProcessPushChannelDBModel();
                processPushChannelDBModel.setProcessId(processId);
                processPushChannelDBModel.setPushAccount(channelHelper.mapProcessPushAccountDAO(pushAccountDBModel.get()));
                processPushChannelDBModel.setChannelState(channelState);
                processPushChannelDBModel.setuDate(appUtils.getCurrentTimeStamp());
                processPushChannelDBModel.setcDate(appUtils.getCurrentTimeStamp());
                processPushChannelDBModel.setStatus(1);

                return new ProcessPushChannelWSDTO(processPushChannelRepository.save(processPushChannelDBModel));
            }
        }
        return null;
    }

    public ProcessPushChannelWSDTO removeProcessPushChannelService(String processId) {

        List<ProcessPushChannelDBModel> processPushChannelDBModels = processPushChannelRepository.findByProcessId(processId);
        if (!processPushChannelDBModels.isEmpty()) {
            processPushChannelRepository.deleteAll(processPushChannelDBModels);
            return new ProcessPushChannelWSDTO(processPushChannelDBModels.get(0));
        }
        return null;
    }



}
