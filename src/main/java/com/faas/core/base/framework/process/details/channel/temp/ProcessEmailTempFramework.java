package com.faas.core.base.framework.process.details.channel.temp;

import com.faas.core.base.model.db.channel.settings.EmailTypeDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.EmailTempDBModel;
import com.faas.core.base.model.ws.process.details.channel.temp.dto.ProcessEmailTempWSDTO;
import com.faas.core.base.repo.channel.settings.EmailTypeRepository;
import com.faas.core.base.repo.process.details.channel.temp.EmailTempRepository;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.process.ProcessHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ProcessEmailTempFramework {


    @Autowired
    ProcessHelper processHelper;

    @Autowired
    EmailTempRepository emailTempRepository;

    @Autowired
    EmailTypeRepository emailTypeRepository;

    @Autowired
    AppUtils appUtils;


    public List<ProcessEmailTempWSDTO> getProcessEmailTempsService(long userId, String processId) {

        List<ProcessEmailTempWSDTO> processEmailTempWSDTOS = new ArrayList<>();
        List<EmailTempDBModel> emailTempDBModels = emailTempRepository.findByProcessId(processId);
        for (EmailTempDBModel emailTempDBModel : emailTempDBModels) {
            processEmailTempWSDTOS.add(new ProcessEmailTempWSDTO(emailTempDBModel));
        }
        return processEmailTempWSDTOS;
    }

    public ProcessEmailTempWSDTO getProcessEmailTempService(long userId, String tempId) {

        Optional<EmailTempDBModel> processEmailTempDBModel = emailTempRepository.findById(tempId);
        if (processEmailTempDBModel.isPresent()) {
            return new ProcessEmailTempWSDTO(processEmailTempDBModel.get());
        }
        return null;
    }

    public ProcessEmailTempWSDTO createProcessEmailTempService(String processId, String emailSubject, String emailBody, String emailSender, long typeId) {

        Optional<EmailTypeDBModel> emailTypeDBModel = emailTypeRepository.findById(typeId);
        if (emailTypeDBModel.isPresent()){

            EmailTempDBModel emailTempDBModel = new EmailTempDBModel();
            emailTempDBModel.setProcessId(processId);
            emailTempDBModel.setEmailSubject(emailSubject);
            emailTempDBModel.setEmailBody(emailBody);
            emailTempDBModel.setEmailSender(emailSender);
            emailTempDBModel.setTypeId(typeId);
            emailTempDBModel.setEmailType(emailTypeDBModel.get().getEmailType());
            emailTempDBModel.setTempDatas(new ArrayList<>());
            emailTempDBModel.setTempAssets(new ArrayList<>());
            emailTempDBModel.setuDate(appUtils.getCurrentTimeStamp());
            emailTempDBModel.setcDate(appUtils.getCurrentTimeStamp());
            emailTempDBModel.setStatus(1);

            return new ProcessEmailTempWSDTO(emailTempRepository.save(emailTempDBModel));
        }
        return null;
    }


    public ProcessEmailTempWSDTO updateProcessEmailTempService(String tempId, String emailSubject, String emailBody, String emailSender, long typeId) {

        Optional<EmailTempDBModel> processEmailTempDBModel = emailTempRepository.findById(tempId);
        Optional<EmailTypeDBModel> emailTypeDBModel = emailTypeRepository.findById(typeId);
        if (processEmailTempDBModel.isPresent() && emailTypeDBModel.isPresent()){

            processEmailTempDBModel.get().setEmailSubject(emailSubject);
            processEmailTempDBModel.get().setEmailBody(emailBody);
            processEmailTempDBModel.get().setEmailSender(emailSender);
            processEmailTempDBModel.get().setTypeId(typeId);
            processEmailTempDBModel.get().setEmailType(emailTypeDBModel.get().getEmailType());
            processEmailTempDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            processEmailTempDBModel.get().setStatus(1);

            return new ProcessEmailTempWSDTO(emailTempRepository.save(processEmailTempDBModel.get()));
        }
        return null;
    }

    public ProcessEmailTempWSDTO removeProcessEmailTempService(String tempId) {

        Optional<EmailTempDBModel> processEmailTempDBModel = emailTempRepository.findById(tempId);
        if (processEmailTempDBModel.isPresent()){
            emailTempRepository.delete(processEmailTempDBModel.get());
            return new ProcessEmailTempWSDTO(processEmailTempDBModel.get());
        }
        return null;
    }


}
