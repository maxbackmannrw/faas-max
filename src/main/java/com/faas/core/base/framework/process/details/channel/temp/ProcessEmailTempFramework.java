package com.faas.core.base.framework.process.details.channel.temp;

import com.faas.core.base.model.db.channel.settings.EmailTypeDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessEmailTempDBModel;
import com.faas.core.base.model.ws.process.details.channel.temp.dto.ProcessEmailTempWSDTO;
import com.faas.core.base.repo.channel.settings.EmailTypeRepository;
import com.faas.core.base.repo.process.details.channel.temp.ProcessEmailTempRepository;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.ProcessHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ProcessEmailTempFramework {


    @Autowired
    ProcessHelper processHelper;

    @Autowired
    ProcessEmailTempRepository processEmailTempRepository;

    @Autowired
    EmailTypeRepository emailTypeRepository;

    @Autowired
    AppUtils appUtils;


    public List<ProcessEmailTempWSDTO> getProcessEmailTempsService(long userId, String processId) {

        List<ProcessEmailTempWSDTO> processEmailTempWSDTOS = new ArrayList<>();
        List<ProcessEmailTempDBModel> processEmailTempDBModels = processEmailTempRepository.findByProcessId(processId);
        for (ProcessEmailTempDBModel processEmailTempDBModel : processEmailTempDBModels) {
            processEmailTempWSDTOS.add(new ProcessEmailTempWSDTO(processEmailTempDBModel));
        }
        return processEmailTempWSDTOS;
    }

    public ProcessEmailTempWSDTO getProcessEmailTempService(long userId, String tempId) {

        Optional<ProcessEmailTempDBModel> processEmailTempDBModel = processEmailTempRepository.findById(tempId);
        if (processEmailTempDBModel.isPresent()) {
            return new ProcessEmailTempWSDTO(processEmailTempDBModel.get());
        }
        return null;
    }

    public ProcessEmailTempWSDTO createProcessEmailTempService(String processId, String emailSubject, String emailBody, String emailSender, long typeId) {

        Optional<EmailTypeDBModel> emailTypeDBModel = emailTypeRepository.findById(typeId);
        if (emailTypeDBModel.isPresent()){

            ProcessEmailTempDBModel processEmailTempDBModel = new ProcessEmailTempDBModel();
            processEmailTempDBModel.setProcessId(processId);
            processEmailTempDBModel.setEmailSubject(emailSubject);
            processEmailTempDBModel.setEmailBody(emailBody);
            processEmailTempDBModel.setEmailSender(emailSender);
            processEmailTempDBModel.setTypeId(typeId);
            processEmailTempDBModel.setEmailType(emailTypeDBModel.get().getEmailType());
            processEmailTempDBModel.setTempDatas(new ArrayList<>());
            processEmailTempDBModel.setTempAssets(new ArrayList<>());
            processEmailTempDBModel.setuDate(appUtils.getCurrentTimeStamp());
            processEmailTempDBModel.setcDate(appUtils.getCurrentTimeStamp());
            processEmailTempDBModel.setStatus(1);

            return new ProcessEmailTempWSDTO(processEmailTempRepository.save(processEmailTempDBModel));
        }
        return null;
    }


    public ProcessEmailTempWSDTO updateProcessEmailTempService(String tempId, String emailSubject, String emailBody, String emailSender, long typeId) {

        Optional<ProcessEmailTempDBModel> processEmailTempDBModel = processEmailTempRepository.findById(tempId);
        Optional<EmailTypeDBModel> emailTypeDBModel = emailTypeRepository.findById(typeId);
        if (processEmailTempDBModel.isPresent() && emailTypeDBModel.isPresent()){

            processEmailTempDBModel.get().setEmailSubject(emailSubject);
            processEmailTempDBModel.get().setEmailBody(emailBody);
            processEmailTempDBModel.get().setEmailSender(emailSender);
            processEmailTempDBModel.get().setTypeId(typeId);
            processEmailTempDBModel.get().setEmailType(emailTypeDBModel.get().getEmailType());
            processEmailTempDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            processEmailTempDBModel.get().setStatus(1);

            return new ProcessEmailTempWSDTO(processEmailTempRepository.save(processEmailTempDBModel.get()));
        }
        return null;
    }

    public ProcessEmailTempWSDTO removeProcessEmailTempService(String tempId) {

        Optional<ProcessEmailTempDBModel> processEmailTempDBModel = processEmailTempRepository.findById(tempId);
        if (processEmailTempDBModel.isPresent()){
            processEmailTempRepository.delete(processEmailTempDBModel.get());
            return new ProcessEmailTempWSDTO(processEmailTempDBModel.get());
        }
        return null;
    }


}
