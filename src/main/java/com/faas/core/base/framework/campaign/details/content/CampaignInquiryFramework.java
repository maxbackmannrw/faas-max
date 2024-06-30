package com.faas.core.base.framework.campaign.details.content;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.campaign.content.dao.CampaignDataDAO;
import com.faas.core.base.model.db.utils.DataTypeDBModel;
import com.faas.core.base.model.ws.campaign.details.content.dto.CampaignDataWSDTO;
import com.faas.core.base.model.ws.campaign.details.content.dto.CampaignInquiryWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.remote.content.RemoteRepository;
import com.faas.core.base.repo.utils.DataTypeRepository;
import com.faas.core.utility.config.AppUtils;
import com.faas.core.utility.helpers.remote.RemoteHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CampaignInquiryFramework {

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


    public CampaignInquiryWSDTO getCampaignInquiryService(long userId, String campaignId) {

        Optional<CampaignDBModel>campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignDBModel.isPresent() &&  campaignDBModel.get().getCampaignInquiry() != null){
            return new CampaignInquiryWSDTO(campaignDBModel.get().getCampaignInquiry());
        }
        return null;
    }

    public CampaignInquiryWSDTO updateCampaignInquiryService(long userId, String campaignId, String campaignInquiry) {

        Optional<CampaignDBModel>campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignDBModel.isPresent() &&  campaignDBModel.get().getCampaignInquiry() != null){

            campaignDBModel.get().getCampaignInquiry().setCampaignInquiry(campaignInquiry);
            campaignDBModel.get().getCampaignInquiry().setuDate(appUtils.getCurrentTimeStamp());
            campaignDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            campaignRepository.save(campaignDBModel.get());

            return new CampaignInquiryWSDTO(campaignDBModel.get().getCampaignInquiry());
        }
        return null;
    }


    public List<CampaignDataWSDTO> getCampaignInquiryDatasService(long userId, String campaignId) {

        List<CampaignDataWSDTO> campaignDataWSDTOS = new ArrayList<>();
        Optional<CampaignDBModel>campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignDBModel.isPresent() &&  campaignDBModel.get().getCampaignInquiry() != null && campaignDBModel.get().getCampaignInquiry().getInquiryDatas() != null){
            for (int i=0;i<campaignDBModel.get().getCampaignInquiry().getInquiryDatas().size();i++){
                campaignDataWSDTOS.add(new CampaignDataWSDTO(campaignDBModel.get().getCampaignInquiry().getInquiryDatas().get(i)));
            }
        }
        return campaignDataWSDTOS;
    }

    public CampaignDataWSDTO getCampaignInquiryDataService(long userId, String campaignId, String dataId) {

        Optional<CampaignDBModel>campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignDBModel.isPresent() && campaignDBModel.get().getCampaignInquiry() != null && campaignDBModel.get().getCampaignInquiry().getInquiryDatas() != null){
            for (int i=0;i<campaignDBModel.get().getCampaignInquiry().getInquiryDatas().size();i++){
                if (campaignDBModel.get().getCampaignInquiry().getInquiryDatas().get(i).getDataId().equalsIgnoreCase(dataId)){
                    return new CampaignDataWSDTO(campaignDBModel.get().getCampaignInquiry().getInquiryDatas().get(i));
                }
            }
        }
        return null;
    }

    public CampaignDataWSDTO createCampaignInquiryDataService(long userId, String campaignId, long typeId, String value) {

        Optional<CampaignDBModel>campaignDBModel = campaignRepository.findById(campaignId);
        Optional<DataTypeDBModel> dataTypeDBModel = dataTypeRepository.findById(typeId);
        if (dataTypeDBModel.isPresent() && campaignDBModel.isPresent() &&  campaignDBModel.get().getCampaignInquiry() != null){

            CampaignDataDAO campaignDataDAO = new CampaignDataDAO();
            campaignDataDAO.setDataId(appUtils.generateUUID());
            campaignDataDAO.setDataType(dataTypeDBModel.get().getDataType());
            campaignDataDAO.setValue(value);
            campaignDataDAO.setcDate(appUtils.getCurrentTimeStamp());
            campaignDataDAO.setStatus(1);

            if (campaignDBModel.get().getCampaignInquiry().getInquiryDatas() == null){
                List<CampaignDataDAO> campaignDataDAOS = new ArrayList<>();
                campaignDataDAOS.add(campaignDataDAO);
                campaignDBModel.get().getCampaignInquiry().setInquiryDatas(campaignDataDAOS);
            }else {
                campaignDBModel.get().getCampaignInquiry().getInquiryDatas().add(campaignDataDAO);
            }
            campaignDBModel.get().getCampaignInquiry().setuDate(appUtils.getCurrentTimeStamp());
            campaignDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            campaignRepository.save(campaignDBModel.get());

            return new CampaignDataWSDTO(campaignDataDAO);
        }
        return null;
    }

    public CampaignDataWSDTO updateCampaignInquiryDataService(long userId, String campaignId, String dataId, long typeId, String value) {

        Optional<CampaignDBModel>campaignDBModel = campaignRepository.findById(campaignId);
        Optional<DataTypeDBModel> dataTypeDBModel = dataTypeRepository.findById(typeId);
        if (dataTypeDBModel.isPresent() && campaignDBModel.isPresent() &&  campaignDBModel.get().getCampaignInquiry() != null && campaignDBModel.get().getCampaignInquiry().getInquiryDatas() != null){
            for (int i=0;i<campaignDBModel.get().getCampaignInquiry().getInquiryDatas().size();i++){
                if (campaignDBModel.get().getCampaignInquiry().getInquiryDatas().get(i).getDataId().equalsIgnoreCase(dataId)){

                    campaignDBModel.get().getCampaignInquiry().getInquiryDatas().get(i).setDataType(dataTypeDBModel.get().getDataType());
                    campaignDBModel.get().getCampaignInquiry().getInquiryDatas().get(i).setValue(value);
                    campaignDBModel.get().getCampaignInquiry().getInquiryDatas().get(i).setcDate(appUtils.getCurrentTimeStamp());
                    campaignDBModel.get().getCampaignInquiry().getInquiryDatas().get(i).setStatus(1);
                    campaignDBModel.get().getCampaignInquiry().setuDate(appUtils.getCurrentTimeStamp());
                    campaignDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                    campaignRepository.save(campaignDBModel.get());

                    return new CampaignDataWSDTO(campaignDBModel.get().getCampaignInquiry().getInquiryDatas().get(i));
                }
            }
        }
        return null;
    }

    public CampaignDataWSDTO removeCampaignInquiryDataService(long userId, String campaignId, String dataId) {

        Optional<CampaignDBModel>campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignDBModel.isPresent() &&  campaignDBModel.get().getCampaignInquiry() != null && campaignDBModel.get().getCampaignInquiry().getInquiryDatas() != null){
            for (int i=0;i<campaignDBModel.get().getCampaignInquiry().getInquiryDatas().size();i++){
                if (campaignDBModel.get().getCampaignInquiry().getInquiryDatas().get(i).getDataId().equalsIgnoreCase(dataId)){

                    CampaignDataDAO campaignDataDAO = campaignDBModel.get().getCampaignInquiry().getInquiryDatas().get(i);
                    campaignDBModel.get().getCampaignInquiry().getInquiryDatas().remove(i);
                    campaignDBModel.get().getCampaignInquiry().setuDate(appUtils.getCurrentTimeStamp());
                    campaignDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                    campaignRepository.save(campaignDBModel.get());

                    return new CampaignDataWSDTO(campaignDataDAO);
                }
            }
        }
        return null;
    }



}
