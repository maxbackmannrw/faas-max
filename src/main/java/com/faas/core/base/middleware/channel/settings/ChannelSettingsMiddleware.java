package com.faas.core.base.middleware.channel.settings;

import com.faas.core.base.framework.channel.settings.ChannelSettingsFramework;
import com.faas.core.base.model.db.channel.settings.EmailTypeDBModel;
import com.faas.core.base.model.db.channel.settings.MessageTypeDBModel;
import com.faas.core.base.model.db.channel.settings.PushTypeDBModel;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.channel.settings.EmailTypeWSModel;
import com.faas.core.base.model.ws.channel.settings.MessageTypeWSModel;
import com.faas.core.base.model.ws.channel.settings.PushTypeWSModel;
import com.faas.core.base.model.ws.channel.settings.dto.EmailTypeWSDTO;
import com.faas.core.base.model.ws.channel.settings.dto.MessageTypeWSDTO;
import com.faas.core.base.model.ws.channel.settings.dto.PushTypeWSDTO;
import com.faas.core.base.repo.channel.settings.EmailTypeRepository;
import com.faas.core.base.repo.channel.settings.MessageTypeRepository;
import com.faas.core.base.repo.channel.settings.PushTypeRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ChannelSettingsMiddleware {


    @Autowired
    ChannelSettingsFramework channelSettingsFramework;

    @Autowired
    EmailTypeRepository emailTypeRepository;

    @Autowired
    PushTypeRepository pushTypeRepository;

    @Autowired
    MessageTypeRepository messageTypeRepository;

    @Autowired
    AppUtils appUtils;


    public EmailTypeWSModel getAllEmailTypes(long userId) {

        EmailTypeWSModel response = new EmailTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<EmailTypeWSDTO> emailTypeWSDTOS = new ArrayList<>();

        List<EmailTypeDBModel> emailTypeDBModels = emailTypeRepository.findByStatus(1);
        for (EmailTypeDBModel emailTypeDBModel : emailTypeDBModels) {
            emailTypeWSDTOS.add(channelSettingsFramework.fillEmailTypeWSDTO(emailTypeDBModel));
        }

        response.setEmailTypes(emailTypeWSDTOS);
        general.setOperation("getAllEmailTypes");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public EmailTypeWSModel getEmailType(long userId,long typeId) {

        EmailTypeWSModel response = new EmailTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<EmailTypeWSDTO> emailTypeWSDTOS = new ArrayList<>();

        Optional<EmailTypeDBModel> emailTypeDBModel = emailTypeRepository.findById(typeId);
        if (emailTypeDBModel.isPresent()){
            emailTypeWSDTOS.add(channelSettingsFramework.fillEmailTypeWSDTO(emailTypeDBModel.get()));
        }

        response.setEmailTypes(emailTypeWSDTOS);
        general.setOperation("getEmailType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public EmailTypeWSModel createEmailType(long userId,String emailType) {

        EmailTypeWSModel response = new EmailTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<EmailTypeWSDTO> emailTypeWSDTOS = new ArrayList<>();

        EmailTypeDBModel emailTypeDBModel = channelSettingsFramework.createEmailTypeService(emailType);
        if (emailTypeDBModel != null){
            emailTypeWSDTOS.add(channelSettingsFramework.fillEmailTypeWSDTO(emailTypeDBModel));
        }

        response.setEmailTypes(emailTypeWSDTOS);
        general.setOperation("createEmailType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public EmailTypeWSModel updateEmailType(long userId,long typeId,String emailType) {

        EmailTypeWSModel response = new EmailTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<EmailTypeWSDTO> emailTypeWSDTOS = new ArrayList<>();

        EmailTypeDBModel emailTypeDBModel = channelSettingsFramework.updateEmailTypeService(typeId,emailType);
        if (emailTypeDBModel != null){
            emailTypeWSDTOS.add(channelSettingsFramework.fillEmailTypeWSDTO(emailTypeDBModel));
        }

        response.setEmailTypes(emailTypeWSDTOS);
        general.setOperation("updateEmailType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public EmailTypeWSModel removeEmailType(long userId, long typeId) {

        EmailTypeWSModel response = new EmailTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<EmailTypeWSDTO> emailTypeWSDTOS = new ArrayList<>();

        EmailTypeDBModel emailTypeDBModel = channelSettingsFramework.removeEmailTypeService(typeId);
        if (emailTypeDBModel != null){
            emailTypeWSDTOS.add(channelSettingsFramework.fillEmailTypeWSDTO(emailTypeDBModel));
        }

        response.setEmailTypes(emailTypeWSDTOS);
        general.setOperation("removeEmailType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }




    public PushTypeWSModel getPushTypes(long userId) {

        PushTypeWSModel response = new PushTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<PushTypeWSDTO> pushTypeWSDTOS = new ArrayList<>();

        List<PushTypeDBModel> pushTypeDBModels = pushTypeRepository.findByStatus(1);
        if (pushTypeDBModels != null){
            for (PushTypeDBModel pushTypeDBModel : pushTypeDBModels) {
                pushTypeWSDTOS.add(channelSettingsFramework.fillPushTypeWSDTO(pushTypeDBModel));
            }
        }

        response.setPushTypes(pushTypeWSDTOS);
        general.setOperation("getPushTypes");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public PushTypeWSModel getPushTypesByMain(long userId, String mainType) {

        PushTypeWSModel response = new PushTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<PushTypeWSDTO> pushTypeWSDTOS = new ArrayList<>();

        List<PushTypeDBModel> pushTypeDBModels = pushTypeRepository.findByMainType(mainType);
        if (pushTypeDBModels != null){
            for (PushTypeDBModel pushTypeDBModel : pushTypeDBModels) {
                pushTypeWSDTOS.add(channelSettingsFramework.fillPushTypeWSDTO(pushTypeDBModel));
            }
        }

        response.setPushTypes(pushTypeWSDTOS);
        general.setOperation("getPushTypesByMain");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public PushTypeWSModel getPushType(long userId, long typeId) {

        PushTypeWSModel response = new PushTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<PushTypeWSDTO> pushTypeWSDTOS = new ArrayList<>();

        Optional<PushTypeDBModel> pushTypeDBModel = pushTypeRepository.findById(typeId);
        if (pushTypeDBModel.isPresent()){
            pushTypeWSDTOS.add(channelSettingsFramework.fillPushTypeWSDTO(pushTypeDBModel.get()));
        }

        response.setPushTypes(pushTypeWSDTOS);
        general.setOperation("getPushType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public PushTypeWSModel createPushType(long userId, String pushType, String mainType) {

        PushTypeWSModel response = new PushTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<PushTypeWSDTO> pushTypeWSDTOS = new ArrayList<>();

        PushTypeDBModel pushTypeDBModel = channelSettingsFramework.createPushTypeService(pushType,mainType);
        if (pushTypeDBModel != null){
            pushTypeWSDTOS.add(channelSettingsFramework.fillPushTypeWSDTO(pushTypeDBModel));
        }

        response.setPushTypes(pushTypeWSDTOS);
        general.setOperation("createPushType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public PushTypeWSModel updatePushType(long userId,long typeId, String pushType, String mainType) {

        PushTypeWSModel response = new PushTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<PushTypeWSDTO> pushTypeWSDTOS = new ArrayList<>();

        PushTypeDBModel pushTypeDBModel = channelSettingsFramework.updatePushTypeService(typeId,pushType,mainType);
        if (pushTypeDBModel != null){
            pushTypeWSDTOS.add(channelSettingsFramework.fillPushTypeWSDTO(pushTypeDBModel));
        }

        response.setPushTypes(pushTypeWSDTOS);
        general.setOperation("updatePushType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public PushTypeWSModel removePushType(long userId, long typeId) {

        PushTypeWSModel response = new PushTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<PushTypeWSDTO> pushTypeWSDTOS = new ArrayList<>();

        PushTypeDBModel pushTypeDBModel = channelSettingsFramework.removePushTypeService(typeId);
        if (pushTypeDBModel != null){
            pushTypeWSDTOS.add(channelSettingsFramework.fillPushTypeWSDTO(pushTypeDBModel));
        }

        response.setPushTypes(pushTypeWSDTOS);
        general.setOperation("removePushType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public MessageTypeWSModel getAllMessageTypes(long userId) {

        MessageTypeWSModel response = new MessageTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<MessageTypeWSDTO> messageTypeWSDTOS = new ArrayList<>();

        List<MessageTypeDBModel> messageTypeDBModels = messageTypeRepository.findByStatus(1);
        for (MessageTypeDBModel messageTypeDBModel : messageTypeDBModels) {
            messageTypeWSDTOS.add(channelSettingsFramework.fillMessageTypeWSDTO(messageTypeDBModel));
        }

        response.setMessageTypes(messageTypeWSDTOS);
        general.setOperation("getAllMessageTypes");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public MessageTypeWSModel getMessageTypesByMain(long userId, String mainType) {

        MessageTypeWSModel response = new MessageTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<MessageTypeWSDTO> messageTypeWSDTOS = new ArrayList<>();

        List<MessageTypeDBModel> messageTypeDBModels = messageTypeRepository.findByMainType(mainType);
        for (MessageTypeDBModel messageTypeDBModel : messageTypeDBModels) {
            messageTypeWSDTOS.add(channelSettingsFramework.fillMessageTypeWSDTO(messageTypeDBModel));
        }

        response.setMessageTypes(messageTypeWSDTOS);
        general.setOperation("getMessageTypesByMain");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public MessageTypeWSModel getMessageType(long userId, long typeId) {

        MessageTypeWSModel response = new MessageTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<MessageTypeWSDTO> messageTypeWSDTOS = new ArrayList<>();

        Optional<MessageTypeDBModel> messageTypeDBModel = messageTypeRepository.findById(typeId);
        if (messageTypeDBModel.isPresent()){
            messageTypeWSDTOS.add(channelSettingsFramework.fillMessageTypeWSDTO(messageTypeDBModel.get()));
        }

        response.setMessageTypes(messageTypeWSDTOS);
        general.setOperation("getMessageType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public MessageTypeWSModel createMessageType(long userId,String messageType,String mainType) {

        MessageTypeWSModel response = new MessageTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<MessageTypeWSDTO> messageTypeWSDTOS = new ArrayList<>();

        MessageTypeDBModel messageTypeDBModel = channelSettingsFramework.createMessageTypeService(messageType,mainType);
        if (messageTypeDBModel != null){
            messageTypeWSDTOS.add(channelSettingsFramework.fillMessageTypeWSDTO(messageTypeDBModel));
        }

        response.setMessageTypes(messageTypeWSDTOS);
        general.setOperation("createMessageType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public MessageTypeWSModel updateMessageType(long userId,long typeId, String messageType, String mainType) {

        MessageTypeWSModel response = new MessageTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<MessageTypeWSDTO> messageTypeWSDTOS = new ArrayList<>();

        MessageTypeDBModel messageTypeDBModel = channelSettingsFramework.updateMessageTypeService(typeId,messageType,mainType);
        if (messageTypeDBModel != null){
            messageTypeWSDTOS.add(channelSettingsFramework.fillMessageTypeWSDTO(messageTypeDBModel));
        }

        response.setMessageTypes(messageTypeWSDTOS);
        general.setOperation("updateMessageType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public MessageTypeWSModel removeMessageType(long userId, long typeId) {

        MessageTypeWSModel response = new MessageTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<MessageTypeWSDTO> messageTypeWSDTOS = new ArrayList<>();

        MessageTypeDBModel messageTypeDBModel = channelSettingsFramework.removeMessageTypeService(typeId);
        if (messageTypeDBModel != null){
            messageTypeWSDTOS.add(channelSettingsFramework.fillMessageTypeWSDTO(messageTypeDBModel));
        }

        response.setMessageTypes(messageTypeWSDTOS);
        general.setOperation("removeMessageType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
