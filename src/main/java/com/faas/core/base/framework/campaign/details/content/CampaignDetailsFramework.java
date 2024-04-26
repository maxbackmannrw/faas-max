package com.faas.core.base.framework.campaign.details.content;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.campaign.content.dao.CampaignDataDAO;
import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.db.utility.DataTypeDBModel;
import com.faas.core.base.model.ws.campaign.details.content.dto.CampaignDataWSDTO;
import com.faas.core.base.model.ws.campaign.details.content.dto.CampaignDetailsWSDTO;
import com.faas.core.base.model.ws.campaign.details.content.dto.CampaignProcessWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.campaign.details.CampaignAgentRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.base.repo.process.details.scenario.ProcessScenarioRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.base.repo.utility.DataTypeRepository;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.CampaignHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CampaignDetailsFramework {


    @Autowired
    CampaignHelper campaignHelper;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    ProcessScenarioRepository processScenarioRepository;

    @Autowired
    CampaignAgentRepository campaignAgentRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    DataTypeRepository dataTypeRepository;

    @Autowired
    AppUtils appUtils;


    public CampaignDetailsWSDTO getCampaignDetailsService(String campaignId) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignDBModel.isPresent()) {
            CampaignDetailsWSDTO campaignDetailsWSDTO = new CampaignDetailsWSDTO();
            campaignDetailsWSDTO.setCampaign(campaignDBModel.get());
            Optional<ProcessDBModel> processDBModel = processRepository.findById(campaignDBModel.get().getProcessId());
            if (processDBModel.isPresent()) {
                campaignDetailsWSDTO.setCampaignProcess(campaignHelper.mapCampaignProcessWSDTO(processDBModel.get()));
            }
            campaignDetailsWSDTO.setCampaignAgents(campaignHelper.mapCampaignAgentWSDTOS(campaignAgentRepository.findByCampaignId(campaignId)));
            return campaignDetailsWSDTO;
        }
        return null;
    }


    public CampaignProcessWSDTO getCampaignProcessService(String campaignId) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignDBModel.isPresent()) {
            Optional<ProcessDBModel> processDBModel = processRepository.findById(campaignDBModel.get().getProcessId());
            if (processDBModel.isPresent()) {
                return campaignHelper.mapCampaignProcessWSDTO(processDBModel.get());
            }
        }
        return null;
    }


    public CampaignDataWSDTO fillCampaignDataWSDTO(CampaignDataDAO campaignDataDAO) {

        CampaignDataWSDTO campaignDataWSDTO = new CampaignDataWSDTO();
        campaignDataWSDTO.setCampaignData(campaignDataDAO);
        return campaignDataWSDTO;
    }

    public CampaignDataDAO createCampaignDataService(String campaignId, long dataTypeId, String value) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        Optional<DataTypeDBModel> dataTypeDBModel = dataTypeRepository.findById(dataTypeId);
        if (campaignDBModel.isPresent() && dataTypeDBModel.isPresent()) {

            CampaignDataDAO campaignDataDAO = new CampaignDataDAO();
            campaignDataDAO.setDataId(appUtils.generateUUID());
            campaignDataDAO.setDataType(dataTypeDBModel.get().getDataType());
            campaignDataDAO.setValue(value);
            campaignDataDAO.setcDate(appUtils.getCurrentTimeStamp());
            campaignDataDAO.setStatus(1);

            if (campaignDBModel.get().getCampaignDatas() == null) {
                List<CampaignDataDAO> campaignDataDAOS = new ArrayList<>();
                campaignDataDAOS.add(campaignDataDAO);
                campaignDBModel.get().setCampaignDatas(campaignDataDAOS);
            } else {
                campaignDBModel.get().getCampaignDatas().add(campaignDataDAO);
            }
            campaignDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            campaignRepository.save(campaignDBModel.get());

            return campaignDataDAO;
        }
        return null;
    }


    public CampaignDataDAO updateCampaignDataService(String campaignId, String dataId, long dataTypeId, String value) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        Optional<DataTypeDBModel> dataTypeDBModel = dataTypeRepository.findById(dataTypeId);
        if (campaignDBModel.isPresent() && dataTypeDBModel.isPresent()) {
            for (int i = 0; i < campaignDBModel.get().getCampaignDatas().size(); i++) {
                if (campaignDBModel.get().getCampaignDatas().get(i).getDataId().equalsIgnoreCase(dataId)) {

                    campaignDBModel.get().getCampaignDatas().get(i).setDataType(dataTypeDBModel.get().getDataType());
                    campaignDBModel.get().getCampaignDatas().get(i).setValue(value);
                    campaignDBModel.get().getCampaignDatas().get(i).setcDate(appUtils.getCurrentTimeStamp());
                    campaignDBModel.get().getCampaignDatas().get(i).setStatus(1);
                    campaignDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                    campaignRepository.save(campaignDBModel.get());

                    return campaignDBModel.get().getCampaignDatas().get(i);
                }
            }
        }
        return null;
    }


    public CampaignDataDAO removeCampaignDataService(String campaignId, String dataId) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignDBModel.isPresent() && campaignDBModel.get().getCampaignDatas() != null) {
            for (int i = 0; i < campaignDBModel.get().getCampaignDatas().size(); i++) {
                if (campaignDBModel.get().getCampaignDatas().get(i).getDataId().equalsIgnoreCase(dataId)) {

                    CampaignDataDAO campaignDataDAO = campaignDBModel.get().getCampaignDatas().get(i);
                    campaignDBModel.get().getCampaignDatas().remove(campaignDataDAO);
                    campaignDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                    campaignRepository.save(campaignDBModel.get());

                    return campaignDataDAO;
                }
            }
        }
        return null;
    }


}
