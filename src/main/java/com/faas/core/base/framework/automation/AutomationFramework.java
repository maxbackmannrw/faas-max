package com.faas.core.base.framework.automation;

import com.faas.core.base.model.db.automation.AutomationDBModel;
import com.faas.core.base.model.db.scenario.settings.AutomationTypeDBModel;
import com.faas.core.base.model.ws.automation.dto.AutomationWSDTO;
import com.faas.core.base.repo.automation.AutomationRepository;
import com.faas.core.base.repo.scenario.settings.AutomationTypeRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class AutomationFramework {

    @Autowired
    AutomationRepository automationRepository;

    @Autowired
    AutomationTypeRepository automationTypeRepository;

    @Autowired
    AppUtils appUtils;


    public List<AutomationWSDTO> getAutomationsService(long userId) {

        List<AutomationWSDTO> automationWSDTOS = new ArrayList<>();
        List<AutomationDBModel> automationDBModels = automationRepository.findByStatus(1);
        for (AutomationDBModel automationDBModel : automationDBModels) {
            automationWSDTOS.add(new AutomationWSDTO(automationDBModel));
        }
        return automationWSDTOS;
    }

    public AutomationWSDTO getAutomationService(long automationId) {

        Optional<AutomationDBModel> automationDBModel = automationRepository.findById(automationId);
        if (automationDBModel.isPresent()) {
            AutomationWSDTO automationWSDTO = new AutomationWSDTO();
            automationWSDTO.setAutomation(automationDBModel.get());
            return automationWSDTO;
        }
        return null;
    }

    public AutomationWSDTO createAutomationService(long userId, String automation, long typeId) {

        Optional<AutomationTypeDBModel> automationTypeDBModel = automationTypeRepository.findById(typeId);
        if (automationTypeDBModel.isPresent()){

            AutomationDBModel automationDBModel = new AutomationDBModel();
            automationDBModel.setAutomation(automation);
            automationDBModel.setTypeId(typeId);
            automationDBModel.setAutomationType(automationTypeDBModel.get().getAutomationType());
            automationDBModel.setuDate(appUtils.getCurrentTimeStamp());
            automationDBModel.setcDate(appUtils.getCurrentTimeStamp());
            automationDBModel.setStatus(1);

            return new AutomationWSDTO(automationRepository.save(automationDBModel));
        }
        return null;
    }

    public AutomationWSDTO updateAutomationService(long userId,long automationId,String automation,long typeId) {

        Optional<AutomationDBModel> automationDBModel = automationRepository.findById(automationId);
        Optional<AutomationTypeDBModel> automationTypeDBModel = automationTypeRepository.findById(typeId);
        if (automationTypeDBModel.isPresent() && automationDBModel.isPresent()){

            automationDBModel.get().setAutomation(automation);
            automationDBModel.get().setTypeId(typeId);
            automationDBModel.get().setAutomationType(automationTypeDBModel.get().getAutomationType());
            automationDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            automationDBModel.get().setStatus(1);

            return new AutomationWSDTO(automationRepository.save(automationDBModel.get()));
        }
        return null;
    }

    public AutomationWSDTO removeAutomationService(long userId, long automationId) {

        Optional<AutomationDBModel> automationDBModel = automationRepository.findById(automationId);
        if (automationDBModel.isPresent()){
            automationRepository.delete(automationDBModel.get());
            return new AutomationWSDTO(automationDBModel.get());
        }
        return null;
    }

}
