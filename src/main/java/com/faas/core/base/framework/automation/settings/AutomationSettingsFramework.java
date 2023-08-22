package com.faas.core.base.framework.automation.settings;

import com.faas.core.base.model.db.automation.settings.AutomationTypeDBModel;
import com.faas.core.base.model.ws.automation.settings.dto.AutomationTypeWSDTO;
import com.faas.core.base.repo.automation.settings.AutomationTypeRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class AutomationSettingsFramework {

    @Autowired
    AutomationTypeRepository automationTypeRepository;

    @Autowired
    AppUtils appUtils;


    public List<AutomationTypeWSDTO> getAutomationTypesService(long userId) {

        List<AutomationTypeWSDTO>automationTypeWSDTOS = new ArrayList<>();
        List<AutomationTypeDBModel> automationTypeDBModels = automationTypeRepository.findByStatus(1);
        for (AutomationTypeDBModel automationTypeDBModel : automationTypeDBModels) {
            automationTypeWSDTOS.add(new AutomationTypeWSDTO(automationTypeDBModel));
        }
        return automationTypeWSDTOS;
    }


    public AutomationTypeWSDTO getAutomationTypeService(long userId,long typeId) {

        Optional<AutomationTypeDBModel> automationTypeDBModel = automationTypeRepository.findById(typeId);
        if (automationTypeDBModel.isPresent()){
            return new AutomationTypeWSDTO(automationTypeDBModel.get());
        }
        return null;
    }


    public AutomationTypeWSDTO createAutomationTypeService(long userId,String automationType,String baseType) {

        AutomationTypeDBModel automationTypeDBModel = new AutomationTypeDBModel();

        automationTypeDBModel.setAutomationType(automationType);
        automationTypeDBModel.setBaseType(baseType);
        automationTypeDBModel.setuDate(appUtils.getCurrentTimeStamp());
        automationTypeDBModel.setcDate(appUtils.getCurrentTimeStamp());
        automationTypeDBModel.setStatus(1);

        return new AutomationTypeWSDTO(automationTypeRepository.save(automationTypeDBModel));
    }


    public AutomationTypeWSDTO updateAutomationTypeService(long userId,long typeId,String automationType,String baseType) {

        Optional<AutomationTypeDBModel> automationTypeDBModel = automationTypeRepository.findById(typeId);
        if (automationTypeDBModel.isPresent()){

            automationTypeDBModel.get().setAutomationType(automationType);
            automationTypeDBModel.get().setBaseType(baseType);
            automationTypeDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            automationTypeDBModel.get().setStatus(1);

            return new AutomationTypeWSDTO(automationTypeRepository.save(automationTypeDBModel.get()));
        }
        return null;
    }


    public AutomationTypeWSDTO removeAutomationTypeService(long userId,long typeId) {

        Optional<AutomationTypeDBModel> automationTypeDBModel = automationTypeRepository.findById(typeId);
        if (automationTypeDBModel.isPresent()){
            automationTypeRepository.delete(automationTypeDBModel.get());
            return new AutomationTypeWSDTO(automationTypeDBModel.get());
        }
        return null;
    }



}
