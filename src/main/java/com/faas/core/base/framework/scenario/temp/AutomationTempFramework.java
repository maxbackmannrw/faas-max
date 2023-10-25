package com.faas.core.base.framework.scenario.temp;

import com.faas.core.base.model.db.scenario.temp.AutomationTempDBModel;
import com.faas.core.base.model.db.scenario.settings.AutomationTypeDBModel;
import com.faas.core.base.model.ws.scenario.temp.automation.dto.AutomationTempWSDTO;
import com.faas.core.base.repo.scenario.temp.AutomationTempRepository;
import com.faas.core.base.repo.scenario.settings.AutomationTypeRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class AutomationTempFramework {

    @Autowired
    AutomationTempRepository automationTempRepository;

    @Autowired
    AutomationTypeRepository automationTypeRepository;

    @Autowired
    AppUtils appUtils;


    public List<AutomationTempWSDTO> getAutomationTempsService(long userId) {

        List<AutomationTempWSDTO> automationTempWSDTOS = new ArrayList<>();
        List<AutomationTempDBModel> automationTempDBModels = automationTempRepository.findByStatus(1);
        for (AutomationTempDBModel automationTempDBModel : automationTempDBModels) {
            automationTempWSDTOS.add(new AutomationTempWSDTO(automationTempDBModel));
        }
        return automationTempWSDTOS;
    }


    public AutomationTempWSDTO getAutomationTempService(long tempId) {

        Optional<AutomationTempDBModel> automationTempDBModel = automationTempRepository.findById(tempId);
        if (automationTempDBModel.isEmpty()) {
            return null;
        }
        return new AutomationTempWSDTO(automationTempDBModel.get());
    }

    public AutomationTempWSDTO createAutomationTempService(long userId,String automationTemp,long typeId) {

        Optional<AutomationTypeDBModel> automationTypeDBModel = automationTypeRepository.findById(typeId);
        if (automationTypeDBModel.isPresent()){

            AutomationTempDBModel automationTempDBModel = new AutomationTempDBModel();
            automationTempDBModel.setAutomationTemp(automationTemp);
            automationTempDBModel.setTypeId(typeId);
            automationTempDBModel.setAutomationType(automationTypeDBModel.get().getAutomationType());
            automationTempDBModel.setuDate(appUtils.getCurrentTimeStamp());
            automationTempDBModel.setcDate(appUtils.getCurrentTimeStamp());
            automationTempDBModel.setStatus(1);

            return new AutomationTempWSDTO(automationTempRepository.save(automationTempDBModel));
        }
        return null;
    }


    public AutomationTempWSDTO updateAutomationTempService(long userId,long tempId,String automationTemp,long typeId) {

        Optional<AutomationTempDBModel> automationTempDBModel = automationTempRepository.findById(tempId);
        Optional<AutomationTypeDBModel> automationTypeDBModel = automationTypeRepository.findById(typeId);
        if (automationTypeDBModel.isPresent() && automationTempDBModel.isPresent()){

            automationTempDBModel.get().setAutomationTemp(automationTemp);
            automationTempDBModel.get().setTypeId(typeId);
            automationTempDBModel.get().setAutomationType(automationTypeDBModel.get().getAutomationType());
            automationTempDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            automationTempDBModel.get().setStatus(1);

            return new AutomationTempWSDTO(automationTempRepository.save(automationTempDBModel.get()));
        }
        return null;
    }


    public AutomationTempWSDTO removeAutomationTempService(long userId, long tempId) {

        Optional<AutomationTempDBModel> automationTempDBModel = automationTempRepository.findById(tempId);
        if (automationTempDBModel.isPresent()){
            automationTempRepository.delete(automationTempDBModel.get());
            return new AutomationTempWSDTO(automationTempDBModel.get());
        }
        return null;
    }


}
