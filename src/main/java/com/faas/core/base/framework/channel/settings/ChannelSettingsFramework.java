package com.faas.core.base.framework.channel.settings;

import com.faas.core.base.model.db.channel.settings.EmailTypeDBModel;
import com.faas.core.base.model.db.channel.settings.MessageTypeDBModel;
import com.faas.core.base.model.db.channel.settings.PushTypeDBModel;
import com.faas.core.base.model.ws.channel.settings.dto.EmailTypeWSDTO;
import com.faas.core.base.model.ws.channel.settings.dto.MessageTypeWSDTO;
import com.faas.core.base.model.ws.channel.settings.dto.PushTypeWSDTO;
import com.faas.core.base.repo.channel.settings.EmailTypeRepository;
import com.faas.core.base.repo.channel.settings.MessageTypeRepository;
import com.faas.core.base.repo.channel.settings.PushTypeRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class ChannelSettingsFramework {


    @Autowired
    EmailTypeRepository emailTypeRepository;

    @Autowired
    PushTypeRepository pushTypeRepository;

    @Autowired
    MessageTypeRepository messageTypeRepository;

    @Autowired
    AppUtils appUtils;


    public EmailTypeWSDTO fillEmailTypeWSDTO(EmailTypeDBModel emailTypeDBModel) {

        EmailTypeWSDTO emailTypeWSDTO = new EmailTypeWSDTO();
        emailTypeWSDTO.setEmailType(emailTypeDBModel);
        return emailTypeWSDTO;
    }


    public EmailTypeDBModel createEmailTypeService(String emailType) {

        EmailTypeDBModel emailTypeDBModel = new EmailTypeDBModel();
        emailTypeDBModel.setEmailType(emailType);
        emailTypeDBModel.setuDate(appUtils.getCurrentTimeStamp());
        emailTypeDBModel.setcDate(appUtils.getCurrentTimeStamp());
        emailTypeDBModel.setStatus(1);

        return emailTypeRepository.save(emailTypeDBModel);
    }

    public EmailTypeDBModel updateEmailTypeService(long typeId,String emailType) {

        Optional<EmailTypeDBModel> emailTypeDBModel = emailTypeRepository.findById(typeId);
        if (emailTypeDBModel.isPresent()){

            emailTypeDBModel.get().setEmailType(emailType);
            emailTypeDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            emailTypeDBModel.get().setStatus(1);

            return emailTypeRepository.save(emailTypeDBModel.get());
        }
        return null;
    }

    public EmailTypeDBModel removeEmailTypeService(long typeId) {

        Optional<EmailTypeDBModel> emailTypeDBModel = emailTypeRepository.findById(typeId);
        if (emailTypeDBModel.isPresent()){
            emailTypeRepository.delete(emailTypeDBModel.get());
            return emailTypeDBModel.get();
        }
        return null;
    }



    public PushTypeWSDTO fillPushTypeWSDTO(PushTypeDBModel pushTypeDBModel) {

        PushTypeWSDTO pushTypeWSDTO = new PushTypeWSDTO();
        pushTypeWSDTO.setPushType(pushTypeDBModel);
        return pushTypeWSDTO;
    }



    public PushTypeDBModel createPushTypeService(String pushType, String mainType) {

        PushTypeDBModel pushTypeDBModel = new PushTypeDBModel();
        pushTypeDBModel.setPushType(pushType);
        pushTypeDBModel.setMainType(mainType);
        pushTypeDBModel.setuDate(appUtils.getCurrentTimeStamp());
        pushTypeDBModel.setcDate(appUtils.getCurrentTimeStamp());
        pushTypeDBModel.setStatus(1);

        return pushTypeRepository.save(pushTypeDBModel);
    }


    public PushTypeDBModel updatePushTypeService(long typeId, String pushType, String mainType) {

        Optional<PushTypeDBModel> pushTypeDBModel = pushTypeRepository.findById(typeId);
        if (pushTypeDBModel.isPresent()){
            pushTypeDBModel.get().setPushType(pushType);
            pushTypeDBModel.get().setMainType(mainType);
            pushTypeDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            pushTypeDBModel.get().setStatus(1);

            return pushTypeRepository.save(pushTypeDBModel.get());
        }
        return null;
    }


    public PushTypeDBModel removePushTypeService(long typeId) {

        Optional<PushTypeDBModel> pushTypeDBModel = pushTypeRepository.findById(typeId);
        if (pushTypeDBModel.isPresent()){
            pushTypeRepository.delete(pushTypeDBModel.get());
            return pushTypeDBModel.get();
        }
        return null;
    }



    public MessageTypeWSDTO fillMessageTypeWSDTO(MessageTypeDBModel messageTypeDBModel) {

        MessageTypeWSDTO messageTypeWSDTO = new MessageTypeWSDTO();
        messageTypeWSDTO.setMessageType(messageTypeDBModel);
        return messageTypeWSDTO;
    }


    public MessageTypeDBModel createMessageTypeService(String messageType,String mainType) {

        MessageTypeDBModel messageTypeDBModel = new MessageTypeDBModel();

        messageTypeDBModel.setMessageType(messageType);
        messageTypeDBModel.setMainType(mainType);
        messageTypeDBModel.setuDate(appUtils.getCurrentTimeStamp());
        messageTypeDBModel.setcDate(appUtils.getCurrentTimeStamp());
        messageTypeDBModel.setStatus(1);

        return messageTypeRepository.save(messageTypeDBModel);
    }

    public MessageTypeDBModel updateMessageTypeService(long typeId,String messageType,String mainType) {

        Optional<MessageTypeDBModel> connectionTypeDBModel = messageTypeRepository.findById(typeId);
        if (connectionTypeDBModel.isPresent()) {
            connectionTypeDBModel.get().setMessageType(messageType);
            connectionTypeDBModel.get().setMainType(mainType);
            connectionTypeDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            connectionTypeDBModel.get().setStatus(1);

            return messageTypeRepository.save(connectionTypeDBModel.get());
        }
        return null;
    }

    public MessageTypeDBModel removeMessageTypeService(long typeId) {

        Optional<MessageTypeDBModel> messageTypeDBModel = messageTypeRepository.findById(typeId);
        if (messageTypeDBModel.isPresent()) {
            messageTypeRepository.delete(messageTypeDBModel.get());
            return messageTypeDBModel.get();
        }
        return null;
    }


}
