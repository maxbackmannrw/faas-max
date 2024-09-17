package com.faas.core.base.framework.campaign.details.scenario;

import com.faas.core.data.db.campaign.content.CampaignDBModel;
import com.faas.core.data.db.campaign.details.scenario.CampaignScenarioDBModel;
import com.faas.core.data.db.scenario.content.ScenarioDBModel;
import com.faas.core.data.db.scenario.content.dao.ScenarioDataDAO;
import com.faas.core.data.db.utilz.DataTypeDBModel;
import com.faas.core.base.model.ws.campaign.details.scenario.dto.CampaignScenarioWSDTO;
import com.faas.core.base.model.ws.campaign.details.scenario.dto.ProcessScenarioDataWSDTO;
import com.faas.core.data.repo.campaign.content.CampaignRepository;
import com.faas.core.data.repo.campaign.details.scenario.CampaignScenarioRepository;
import com.faas.core.data.repo.scenario.content.ScenarioRepository;
import com.faas.core.data.repo.utilz.DataTypeRepository;
import com.faas.core.misc.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CampaignScenarioFramework {


    @Autowired
    ScenarioRepository scenarioRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    CampaignScenarioRepository campaignScenarioRepository;

    @Autowired
    DataTypeRepository dataTypeRepository;

    @Autowired
    AppUtils appUtils;


    public List<CampaignScenarioWSDTO> getCampaignScenariosService(long userId, String campaignId) {

        List<CampaignScenarioWSDTO> campaignScenarioWSDTOS = new ArrayList<>();
        List<CampaignScenarioDBModel> campaignScenarioDBModels = campaignScenarioRepository.findByCampaignId(campaignId);
        for (CampaignScenarioDBModel campaignScenarioDBModel : campaignScenarioDBModels) {
            campaignScenarioWSDTOS.add(new CampaignScenarioWSDTO(campaignScenarioDBModel));
        }
        return campaignScenarioWSDTOS;
    }

    public CampaignScenarioWSDTO getCampaignScenarioService(long userId, String campaignId, String scenarioId) {

        List<CampaignScenarioDBModel> campaignScenarioDBModels = campaignScenarioRepository.findByCampaignIdAndScenarioId(campaignId, scenarioId);
        if (!campaignScenarioDBModels.isEmpty()) {
            return new CampaignScenarioWSDTO(campaignScenarioDBModels.get(0));
        }
        return null;
    }

    public CampaignScenarioWSDTO createCampaignScenarioService(long userId, String campaignId, String scenarioId) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(scenarioId);
        if (!campaignScenarioRepository.existsByCampaignIdAndScenarioId(campaignId, scenarioId) && campaignDBModel.isPresent() && scenarioDBModel.isPresent()) {

            CampaignScenarioDBModel campaignScenarioDBModel = new CampaignScenarioDBModel();
            campaignScenarioDBModel.setCampaignId(campaignId);
            campaignScenarioDBModel.setScenarioId(scenarioId);
            campaignScenarioDBModel.setScenario(scenarioDBModel.get().getScenario());
            campaignScenarioDBModel.setScenarioDesc(scenarioDBModel.get().getScenarioDesc());
            campaignScenarioDBModel.setTypeId(scenarioDBModel.get().getTypeId());
            campaignScenarioDBModel.setScenarioType(scenarioDBModel.get().getScenarioType());
            campaignScenarioDBModel.setBaseType(scenarioDBModel.get().getBaseType());
            if (scenarioDBModel.get().getScenarioDatas() != null) {
                campaignScenarioDBModel.setScenarioDatas(scenarioDBModel.get().getScenarioDatas());
            } else {
                campaignScenarioDBModel.setScenarioDatas(new ArrayList<>());
            }
            campaignScenarioDBModel.setuDate(appUtils.getCurrentTimeStamp());
            campaignScenarioDBModel.setcDate(appUtils.getCurrentTimeStamp());
            campaignScenarioDBModel.setStatus(1);

            return new CampaignScenarioWSDTO(campaignScenarioRepository.save(campaignScenarioDBModel));
        }
        return null;
    }

    public CampaignScenarioWSDTO removeCampaignScenarioService(long userId, String campaignId, String scenarioId) {

        List<CampaignScenarioDBModel> campaignScenarioDBModels = campaignScenarioRepository.findByCampaignIdAndScenarioId(campaignId, scenarioId);
        if (!campaignScenarioDBModels.isEmpty()) {
            campaignScenarioRepository.deleteAll(campaignScenarioDBModels);
            return new CampaignScenarioWSDTO(campaignScenarioDBModels.get(0));
        }
        return null;
    }


    public List<ProcessScenarioDataWSDTO> getCampaignScenarioDatasService(long userId, String campaignId, String scenarioId) {

        List<ProcessScenarioDataWSDTO> scenarioDataWSDTOS = new ArrayList<>();
        List<CampaignScenarioDBModel> campaignScenarioDBModels = campaignScenarioRepository.findByCampaignIdAndScenarioId(campaignId, scenarioId);
        if (!campaignScenarioDBModels.isEmpty() && campaignScenarioDBModels.get(0).getScenarioDatas() != null) {
            for (int i = 0; i < campaignScenarioDBModels.get(0).getScenarioDatas().size(); i++) {
                scenarioDataWSDTOS.add(new ProcessScenarioDataWSDTO(campaignScenarioDBModels.get(0).getScenarioDatas().get(i)));
            }
        }
        return scenarioDataWSDTOS;
    }

    public ProcessScenarioDataWSDTO getCampaignScenarioDataService(long userId, String campaignId, String scenarioId, String dataId) {

        List<CampaignScenarioDBModel> campaignScenarioDBModels = campaignScenarioRepository.findByCampaignIdAndScenarioId(campaignId, scenarioId);
        if (!campaignScenarioDBModels.isEmpty() && campaignScenarioDBModels.get(0).getScenarioDatas() != null) {
            for (int i = 0; i < campaignScenarioDBModels.get(0).getScenarioDatas().size(); i++) {
                if (campaignScenarioDBModels.get(0).getScenarioDatas().get(i).getDataId().equalsIgnoreCase(dataId)) {
                    return new ProcessScenarioDataWSDTO(campaignScenarioDBModels.get(0).getScenarioDatas().get(i));
                }
            }
        }
        return null;
    }

    public ProcessScenarioDataWSDTO createCampaignScenarioDataService(long userId, String campaignId, String scenarioId, long typeId, String value) {

        List<CampaignScenarioDBModel> campaignScenarioDBModels = campaignScenarioRepository.findByCampaignIdAndScenarioId(campaignId, scenarioId);
        Optional<DataTypeDBModel> dataTypeDBModel = dataTypeRepository.findById(typeId);
        if (!campaignScenarioDBModels.isEmpty() && dataTypeDBModel.isPresent()) {

            ScenarioDataDAO scenarioDataDAO = new ScenarioDataDAO();
            scenarioDataDAO.setDataId(appUtils.generateUUID());
            scenarioDataDAO.setDataType(dataTypeDBModel.get().getDataType());
            scenarioDataDAO.setValue(value);
            scenarioDataDAO.setcDate(appUtils.getCurrentTimeStamp());
            scenarioDataDAO.setStatus(1);

            if (campaignScenarioDBModels.get(0).getScenarioDatas() != null) {
                campaignScenarioDBModels.get(0).getScenarioDatas().add(scenarioDataDAO);
            } else {
                List<ScenarioDataDAO> scenarioDataDAOS = new ArrayList<>();
                scenarioDataDAOS.add(scenarioDataDAO);
                campaignScenarioDBModels.get(0).setScenarioDatas(scenarioDataDAOS);
            }
            campaignScenarioDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
            campaignScenarioRepository.save(campaignScenarioDBModels.get(0));

            return new ProcessScenarioDataWSDTO(scenarioDataDAO);
        }
        return null;
    }

    public ProcessScenarioDataWSDTO updateCampaignScenarioDataService(long userId, String campaignId, String scenarioId, String dataId, long typeId, String value) {

        List<CampaignScenarioDBModel> campaignScenarioDBModels = campaignScenarioRepository.findByCampaignIdAndScenarioId(campaignId, scenarioId);
        Optional<DataTypeDBModel> dataTypeDBModel = dataTypeRepository.findById(typeId);
        if (!campaignScenarioDBModels.isEmpty() && campaignScenarioDBModels.get(0).getScenarioDatas() != null && dataTypeDBModel.isPresent()) {
            for (int i = 0; i < campaignScenarioDBModels.get(0).getScenarioDatas().size(); i++) {
                if (campaignScenarioDBModels.get(0).getScenarioDatas().get(i).getDataId().equalsIgnoreCase(dataId)) {

                    campaignScenarioDBModels.get(0).getScenarioDatas().get(i).setDataType(dataTypeDBModel.get().getDataType());
                    campaignScenarioDBModels.get(0).getScenarioDatas().get(i).setValue(value);
                    campaignScenarioDBModels.get(0).getScenarioDatas().get(i).setcDate(appUtils.getCurrentTimeStamp());
                    campaignScenarioDBModels.get(0).getScenarioDatas().get(i).setStatus(1);
                    campaignScenarioDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
                    campaignScenarioRepository.save(campaignScenarioDBModels.get(0));

                    return new ProcessScenarioDataWSDTO(campaignScenarioDBModels.get(0).getScenarioDatas().get(i));
                }
            }
        }
        return null;
    }

    public ProcessScenarioDataWSDTO removeCampaignScenarioDataService(long userId, String campaignId, String scenarioId, String dataId) {

        List<CampaignScenarioDBModel> campaignScenarioDBModels = campaignScenarioRepository.findByCampaignIdAndScenarioId(campaignId, scenarioId);
        if (!campaignScenarioDBModels.isEmpty() && campaignScenarioDBModels.get(0).getScenarioDatas() != null) {
            for (int i = 0; i < campaignScenarioDBModels.get(0).getScenarioDatas().size(); i++) {
                if (campaignScenarioDBModels.get(0).getScenarioDatas().get(i).getDataId().equalsIgnoreCase(dataId)) {

                    ScenarioDataDAO scenarioDataDAO = campaignScenarioDBModels.get(0).getScenarioDatas().get(i);
                    campaignScenarioDBModels.get(0).getScenarioDatas().remove(scenarioDataDAO);
                    campaignScenarioDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
                    campaignScenarioRepository.save(campaignScenarioDBModels.get(0));

                    return new ProcessScenarioDataWSDTO(scenarioDataDAO);
                }
            }
        }
        return null;
    }


}
