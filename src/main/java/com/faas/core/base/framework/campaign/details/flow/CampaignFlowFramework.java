package com.faas.core.base.framework.campaign.details.flow;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.campaign.content.dao.CampaignDataDAO;
import com.faas.core.base.model.db.utilz.DataTypeDBModel;
import com.faas.core.base.model.ws.campaign.details.content.dto.CampaignDataWSDTO;
import com.faas.core.base.model.ws.campaign.details.flow.dto.CampaignFlowWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.remote.content.RemoteRepository;
import com.faas.core.base.repo.utilz.DataTypeRepository;
import com.faas.core.utility.config.AppUtils;
import com.faas.core.utility.helpers.remote.RemoteHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CampaignFlowFramework {

    @Autowired
    RemoteHelpers remoteHelpers;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    RemoteRepository remoteRepository;

    @Autowired
    DataTypeRepository dataTypeRepository;

    @Autowired
    AppUtils appUtils;


    public CampaignFlowWSDTO getCampaignFlowService(long userId, String campaignId) {

        Optional<CampaignDBModel>campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignDBModel.isPresent() && campaignDBModel.get().getCampaignFlow() != null){
            return new CampaignFlowWSDTO(campaignDBModel.get().getCampaignFlow());
        }
        return null;
    }

    public CampaignFlowWSDTO updateCampaignFlowService(long userId, String campaignId, String campaignFlow) {

        Optional<CampaignDBModel>campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignDBModel.isPresent() && campaignDBModel.get().getCampaignFlow() != null){

            campaignDBModel.get().getCampaignFlow().setCampaignFlow(campaignFlow);
            campaignDBModel.get().getCampaignFlow().setuDate(appUtils.getCurrentTimeStamp());
            campaignDBModel.get().getCampaignFlow().setStatus(1);
            campaignDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            campaignRepository.save(campaignDBModel.get());

            return new CampaignFlowWSDTO(campaignDBModel.get().getCampaignFlow());
        }
        return null;
    }


    public List<CampaignDataWSDTO> getCampaignFlowDatasService(long userId, String campaignId) {

        List<CampaignDataWSDTO> campaignDataWSDTOS = new ArrayList<>();
        Optional<CampaignDBModel>campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignDBModel.isPresent() && campaignDBModel.get().getCampaignFlow() != null && campaignDBModel.get().getCampaignFlow().getFlowDatas() != null){
            for (int i=0;i<campaignDBModel.get().getCampaignFlow().getFlowDatas().size();i++){
                campaignDataWSDTOS.add(new CampaignDataWSDTO(campaignDBModel.get().getCampaignFlow().getFlowDatas().get(i)));
            }
        }
        return campaignDataWSDTOS;
    }

    public CampaignDataWSDTO getCampaignFlowDataService(long userId, String campaignId, String dataId) {

        Optional<CampaignDBModel>campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignDBModel.isPresent() && campaignDBModel.get().getCampaignFlow() != null && campaignDBModel.get().getCampaignFlow().getFlowDatas() != null){
            for (int i=0;i<campaignDBModel.get().getCampaignFlow().getFlowDatas().size();i++){
                if (campaignDBModel.get().getCampaignFlow().getFlowDatas().get(i).getDataId().equals(dataId)){
                    return new CampaignDataWSDTO(campaignDBModel.get().getCampaignFlow().getFlowDatas().get(i));
                }
            }
        }
        return null;
    }

    public CampaignDataWSDTO createCampaignFlowDataService(long userId, String campaignId, long typeId, String value) {

        Optional<CampaignDBModel>campaignDBModel = campaignRepository.findById(campaignId);
        Optional<DataTypeDBModel> dataTypeDBModel = dataTypeRepository.findById(typeId);
        if (campaignDBModel.isPresent() && campaignDBModel.get().getCampaignFlow() != null && dataTypeDBModel.isPresent()) {

            CampaignDataDAO campaignDataDAO = new CampaignDataDAO();
            campaignDataDAO.setDataId(appUtils.generateUUID());
            campaignDataDAO.setDataType(dataTypeDBModel.get().getDataType());
            campaignDataDAO.setValue(value);
            campaignDataDAO.setcDate(appUtils.getCurrentTimeStamp());
            campaignDataDAO.setStatus(1);

            if (campaignDBModel.get().getCampaignFlow().getFlowDatas() == null){
                List<CampaignDataDAO> campaignDataDAOS = new ArrayList<>();
                campaignDataDAOS.add(campaignDataDAO);
                campaignDBModel.get().getCampaignFlow().setFlowDatas(campaignDataDAOS);
            }else {
                campaignDBModel.get().getCampaignFlow().getFlowDatas().add(campaignDataDAO);
            }

            campaignDBModel.get().getCampaignFlow().setuDate(appUtils.getCurrentTimeStamp());
            campaignDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            campaignRepository.save(campaignDBModel.get());

            return  new CampaignDataWSDTO(campaignDataDAO);
        }
        return null;
    }

    public CampaignDataWSDTO updateCampaignFlowDataService(long userId, String campaignId, String dataId, long typeId, String value) {

        Optional<CampaignDBModel>campaignDBModel = campaignRepository.findById(campaignId);
        Optional<DataTypeDBModel> dataTypeDBModel = dataTypeRepository.findById(typeId);
        if (campaignDBModel.isPresent() && campaignDBModel.get().getCampaignFlow() != null && campaignDBModel.get().getCampaignFlow().getFlowDatas() != null && dataTypeDBModel.isPresent()){
            for (int i=0;i<campaignDBModel.get().getCampaignFlow().getFlowDatas().size();i++){
                if (campaignDBModel.get().getCampaignFlow().getFlowDatas().get(i).getDataId().equals(dataId)){

                    campaignDBModel.get().getCampaignFlow().getFlowDatas().get(i).setDataType(dataTypeDBModel.get().getDataType());
                    campaignDBModel.get().getCampaignFlow().getFlowDatas().get(i).setValue(value);
                    campaignDBModel.get().getCampaignFlow().getFlowDatas().get(i).setcDate(appUtils.getCurrentTimeStamp());
                    campaignDBModel.get().getCampaignFlow().getFlowDatas().get(i).setStatus(1);
                    campaignDBModel.get().getCampaignFlow().setuDate(appUtils.getCurrentTimeStamp());
                    campaignDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                    campaignRepository.save(campaignDBModel.get());

                    return new CampaignDataWSDTO(campaignDBModel.get().getCampaignFlow().getFlowDatas().get(i));
                }
            }
        }
        return null;
    }

    public CampaignDataWSDTO removeCampaignFlowDataService(long userId, String campaignId, String dataId) {

        Optional<CampaignDBModel>campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignDBModel.isPresent() && campaignDBModel.get().getCampaignFlow() != null && campaignDBModel.get().getCampaignFlow().getFlowDatas() != null){
            for (int i=0;i<campaignDBModel.get().getCampaignFlow().getFlowDatas().size();i++){
                if (campaignDBModel.get().getCampaignFlow().getFlowDatas().get(i).getDataId().equals(dataId)){

                    CampaignDataDAO campaignDataDAO = campaignDBModel.get().getCampaignFlow().getFlowDatas().get(i);
                    campaignDBModel.get().getCampaignFlow().getFlowDatas().remove(i);
                    campaignDBModel.get().getCampaignFlow().setuDate(appUtils.getCurrentTimeStamp());
                    campaignDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                    campaignRepository.save(campaignDBModel.get());

                    return new CampaignDataWSDTO(campaignDataDAO);
                }
            }
        }
        return null;
    }



}
