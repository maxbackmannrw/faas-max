package com.faas.core.utility.helpers.remote;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.campaign.details.remote.CampaignRemoteDBModel;
import com.faas.core.base.model.db.remote.content.RemoteDBModel;
import com.faas.core.base.model.db.remote.content.dao.RemoteDataDAO;
import com.faas.core.base.model.db.remote.details.RemoteUrlDBModel;
import com.faas.core.base.model.ws.remote.content.dto.RemoteWSDTO;
import com.faas.core.base.repo.campaign.details.remote.CampaignRemoteRepository;
import com.faas.core.base.repo.remote.details.RemoteUrlRepository;
import com.faas.core.utility.config.AppConstant;
import com.faas.core.utility.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class RemoteHelpers {


    @Autowired
    CampaignRemoteRepository campaignRemoteRepository;

    @Autowired
    RemoteUrlRepository remoteUrlRepository;

    @Autowired
    AppUtils appUtils;


    public RemoteWSDTO mapRemoteWSDTOHelper(RemoteDBModel remoteDBModel){

        RemoteWSDTO remoteWSDTO = new RemoteWSDTO();
        remoteWSDTO.setRemote(remoteDBModel);
        remoteWSDTO.setRemoteUrls(remoteUrlRepository.findByRemoteId(remoteDBModel.getId()));

        return remoteWSDTO;
    }


    public CampaignRemoteDBModel createCampaignRemoteDBModel(CampaignDBModel campaignDBModel, RemoteDBModel remoteDBModel, String remoteCategory){

        CampaignRemoteDBModel campaignRemoteDBModel = new CampaignRemoteDBModel();
        campaignRemoteDBModel.setCampaignId(campaignDBModel.getId());
        campaignRemoteDBModel.setRemoteId(remoteDBModel.getId());
        campaignRemoteDBModel.setRemote(remoteDBModel.getRemote());
        campaignRemoteDBModel.setRemoteDesc(remoteDBModel.getRemoteDesc());
        campaignRemoteDBModel.setVersion(remoteDBModel.getVersion());
        if (remoteDBModel.getRemoteDatas() != null) {
            campaignRemoteDBModel.setRemoteDatas(remoteDBModel.getRemoteDatas());
        }else {
            campaignRemoteDBModel.setRemoteDatas(new ArrayList<>());
        }
        campaignRemoteDBModel.setRemoteCategory(remoteCategory);
        campaignRemoteDBModel.setTypeId(remoteDBModel.getTypeId());
        campaignRemoteDBModel.setRemoteType(remoteDBModel.getRemoteType());
        campaignRemoteDBModel.setBaseType(remoteDBModel.getBaseType());
        campaignRemoteDBModel.setuDate(appUtils.getCurrentTimeStamp());
        campaignRemoteDBModel.setcDate(appUtils.getCurrentTimeStamp());
        campaignRemoteDBModel.setStatus(1);

        return campaignRemoteRepository.save(campaignRemoteDBModel);
    }


    public RemoteDataDAO createRemoteDataDAO(String dataId, String dataType, String value){

        RemoteDataDAO remoteDataDAO = new RemoteDataDAO();
        remoteDataDAO.setDataId(dataId);
        remoteDataDAO.setDataType(dataType);
        remoteDataDAO.setValue(value);
        remoteDataDAO.setcDate(appUtils.getCurrentTimeStamp());
        remoteDataDAO.setStatus(1);

        return remoteDataDAO;
    }


    public RemoteUrlDBModel createRemoteUrlHelper(String remoteId, String remoteUrl, String urlType) {

        RemoteUrlDBModel remoteUrlDBModel = new RemoteUrlDBModel();
        remoteUrlDBModel.setRemoteId(remoteId);
        remoteUrlDBModel.setRemoteUrl(remoteUrl);
        remoteUrlDBModel.setUrlType(urlType);
        remoteUrlDBModel.setuDate(appUtils.getCurrentTimeStamp());
        remoteUrlDBModel.setcDate(appUtils.getCurrentTimeStamp());
        remoteUrlDBModel.setStatus(1);

        return remoteUrlDBModel;
    }

}
