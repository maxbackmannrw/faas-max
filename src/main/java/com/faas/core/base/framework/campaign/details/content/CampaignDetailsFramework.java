package com.faas.core.base.framework.campaign.details.content;

import com.faas.core.data.db.campaign.content.CampaignDBModel;
import com.faas.core.data.db.campaign.content.dao.CampaignDataDAO;
import com.faas.core.data.db.campaign.content.dao.CampaignScriptDAO;
import com.faas.core.data.db.utils.DataTypeDBModel;
import com.faas.core.base.model.ws.campaign.details.content.dto.CampaignDataWSDTO;
import com.faas.core.base.model.ws.campaign.details.content.dto.CampaignDetailsWSDTO;
import com.faas.core.base.model.ws.campaign.details.content.dto.CampaignScriptWSDTO;
import com.faas.core.data.repo.campaign.content.CampaignRepository;
import com.faas.core.data.repo.remote.content.RemoteRepository;
import com.faas.core.data.repo.utils.DataTypeRepository;
import com.faas.core.misc.config.AppUtils;
import com.faas.core.misc.helpers.campaign.CampaignHelper;
import com.faas.core.misc.helpers.remote.RemoteHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CampaignDetailsFramework {

    @Autowired
    CampaignHelper campaignHelper;

    @Autowired
    RemoteHelper remoteHelper;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    DataTypeRepository dataTypeRepository;

    @Autowired
    RemoteRepository remoteRepository;

    @Autowired
    AppUtils appUtils;


    public CampaignDetailsWSDTO getCampaignDetailsService(long userId, String campaignId) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignDBModel.isPresent()) {
            return campaignHelper.getCampaignDetailsWSDTO(campaignDBModel.get());
        }
        return null;
    }


    public List<CampaignDataWSDTO> getCampaignDatasService(long userId, String campaignId) {

        List<CampaignDataWSDTO> campaignDataWSDTOS = new ArrayList<>();
        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignDBModel.isPresent() && campaignDBModel.get().getCampaignDatas() != null) {
            for (int i = 0; i < campaignDBModel.get().getCampaignDatas().size(); i++) {
                campaignDataWSDTOS.add(new CampaignDataWSDTO(campaignDBModel.get().getCampaignDatas().get(i)));
            }
        }
        return campaignDataWSDTOS;
    }

    public CampaignDataWSDTO getCampaignDataService(long userId, String campaignId, String dataId) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignDBModel.isPresent() && campaignDBModel.get().getCampaignDatas() != null) {
            for (int i = 0; i < campaignDBModel.get().getCampaignDatas().size(); i++) {
                if (campaignDBModel.get().getCampaignDatas().get(i).getDataId().equalsIgnoreCase(dataId)) {
                    return new CampaignDataWSDTO(campaignDBModel.get().getCampaignDatas().get(i));
                }
            }
        }
        return null;
    }

    public CampaignDataWSDTO createCampaignDataService(long userId, String campaignId, long typeId, String value) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        Optional<DataTypeDBModel> dataTypeDBModel = dataTypeRepository.findById(typeId);
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

            return new CampaignDataWSDTO(campaignDataDAO);
        }
        return null;
    }

    public CampaignDataWSDTO updateCampaignDataService(long userId, String campaignId, String dataId, long typeId, String value) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        Optional<DataTypeDBModel> dataTypeDBModel = dataTypeRepository.findById(typeId);
        if (campaignDBModel.isPresent() && campaignDBModel.get().getCampaignDatas() != null && dataTypeDBModel.isPresent()) {
            for (int i = 0; i < campaignDBModel.get().getCampaignDatas().size(); i++) {
                if (campaignDBModel.get().getCampaignDatas().get(i).getDataId().equalsIgnoreCase(dataId)) {

                    campaignDBModel.get().getCampaignDatas().get(i).setDataType(dataTypeDBModel.get().getDataType());
                    campaignDBModel.get().getCampaignDatas().get(i).setValue(value);
                    campaignDBModel.get().getCampaignDatas().get(i).setcDate(appUtils.getCurrentTimeStamp());
                    campaignDBModel.get().getCampaignDatas().get(i).setStatus(1);
                    campaignDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                    campaignRepository.save(campaignDBModel.get());

                    return new CampaignDataWSDTO(campaignDBModel.get().getCampaignDatas().get(i));
                }
            }
        }
        return null;
    }

    public CampaignDataWSDTO removeCampaignDataService(long userId, String campaignId, String dataId) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignDBModel.isPresent() && campaignDBModel.get().getCampaignDatas() != null) {
            for (int i = 0; i < campaignDBModel.get().getCampaignDatas().size(); i++) {
                if (campaignDBModel.get().getCampaignDatas().get(i).getDataId().equalsIgnoreCase(dataId)) {

                    CampaignDataDAO campaignDataDAO = campaignDBModel.get().getCampaignDatas().get(i);
                    campaignDBModel.get().getCampaignDatas().remove(campaignDBModel.get().getCampaignDatas().get(i));
                    campaignDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                    campaignRepository.save(campaignDBModel.get());

                    return new CampaignDataWSDTO(campaignDataDAO);
                }
            }
        }
        return null;
    }


    public List<CampaignScriptWSDTO> getCampaignScriptsService(long userId, String campaignId) {

        List<CampaignScriptWSDTO> campaignScriptWSDTOS = new ArrayList<>();
        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignDBModel.isPresent() && campaignDBModel.get().getCampaignScripts() != null) {
            for (int i = 0; i < campaignDBModel.get().getCampaignScripts().size(); i++) {
                campaignScriptWSDTOS.add(new CampaignScriptWSDTO(campaignDBModel.get().getCampaignScripts().get(i)));
            }
        }
        return campaignScriptWSDTOS;
    }

    public CampaignScriptWSDTO getCampaignScriptService(long userId, String campaignId, String scriptId) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignDBModel.isPresent() && campaignDBModel.get().getCampaignScripts() != null) {
            for (int i = 0; i < campaignDBModel.get().getCampaignScripts().size(); i++) {
                if (campaignDBModel.get().getCampaignScripts().get(i).getScriptId().equalsIgnoreCase(scriptId)) {
                    return new CampaignScriptWSDTO(campaignDBModel.get().getCampaignScripts().get(i));
                }
            }
        }
        return null;
    }

    public CampaignScriptWSDTO createCampaignScriptService(long userId, String campaignId, String scriptTitle, String scriptBody, int scriptOrder) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignDBModel.isPresent()) {

            CampaignScriptDAO campaignScriptDAO = new CampaignScriptDAO();
            campaignScriptDAO.setScriptId(appUtils.generateUUID());
            campaignScriptDAO.setScriptTitle(scriptTitle);
            campaignScriptDAO.setScriptBody(scriptBody);
            campaignScriptDAO.setScriptOrder(scriptOrder);
            campaignScriptDAO.setcDate(appUtils.getCurrentTimeStamp());
            campaignScriptDAO.setStatus(1);

            if (campaignDBModel.get().getCampaignScripts() != null) {
                campaignDBModel.get().getCampaignScripts().add(campaignScriptDAO);
            } else {
                List<CampaignScriptDAO> campaignScriptDAOS = new ArrayList<>();
                campaignScriptDAOS.add(campaignScriptDAO);
                campaignDBModel.get().setCampaignScripts(campaignScriptDAOS);
            }
            campaignDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            campaignRepository.save(campaignDBModel.get());

            return new CampaignScriptWSDTO(campaignScriptDAO);
        }
        return null;
    }

    public CampaignScriptWSDTO updateCampaignScriptService(long userId, String campaignId, String scriptId, String scriptTitle, String scriptBody, int scriptOrder) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignDBModel.isPresent() && campaignDBModel.get().getCampaignScripts() != null) {
            for (int i = 0; i < campaignDBModel.get().getCampaignScripts().size(); i++) {
                if (campaignDBModel.get().getCampaignScripts().get(i).getScriptId().equalsIgnoreCase(scriptId)) {

                    campaignDBModel.get().getCampaignScripts().get(i).setScriptTitle(scriptTitle);
                    campaignDBModel.get().getCampaignScripts().get(i).setScriptBody(scriptBody);
                    campaignDBModel.get().getCampaignScripts().get(i).setScriptOrder(scriptOrder);
                    campaignDBModel.get().getCampaignScripts().get(i).setcDate(appUtils.getCurrentTimeStamp());
                    campaignDBModel.get().getCampaignScripts().get(i).setStatus(1);
                    campaignDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                    campaignRepository.save(campaignDBModel.get());

                    return new CampaignScriptWSDTO(campaignDBModel.get().getCampaignScripts().get(i));
                }
            }
        }
        return null;
    }

    public CampaignScriptWSDTO removeCampaignScriptService(long userId, String campaignId, String scriptId) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignDBModel.isPresent() && campaignDBModel.get().getCampaignScripts() != null) {
            for (int i = 0; i < campaignDBModel.get().getCampaignScripts().size(); i++) {
                if (campaignDBModel.get().getCampaignScripts().get(i).getScriptId().equalsIgnoreCase(scriptId)) {

                    CampaignScriptDAO campaignScriptDAO = campaignDBModel.get().getCampaignScripts().get(i);
                    campaignDBModel.get().getCampaignScripts().remove(campaignDBModel.get().getCampaignScripts().get(i));
                    campaignDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                    campaignRepository.save(campaignDBModel.get());

                    return new CampaignScriptWSDTO(campaignScriptDAO);
                }
            }
        }
        return null;
    }


}
