package com.faas.core.base.framework.campaign.details.temp.details;

import com.faas.core.data.db.campaign.details.temp.WappMessageTempDBModel;
import com.faas.core.data.db.channel.settings.MessageTypeDBModel;
import com.faas.core.data.ws.base.campaign.details.temp.details.dto.CampaignWappMessageTempWSDTO;
import com.faas.core.data.repo.campaign.details.temp.WappMessageTempRepository;
import com.faas.core.data.repo.channel.settings.MessageTypeRepository;
import com.faas.core.misc.config.AppUtils;
import com.faas.core.misc.helpers.campaign.CampaignHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CampaignWappTempFramework {


    @Autowired
    CampaignHelpers campaignHelpers;

    @Autowired
    WappMessageTempRepository wappMessageTempRepository;

    @Autowired
    MessageTypeRepository messageTypeRepository;

    @Autowired
    AppUtils appUtils;


    public List<CampaignWappMessageTempWSDTO> getCampaignWappMessageTempsService(long userId, String campaignId) {

        List<CampaignWappMessageTempWSDTO> campaignWappMessageTempWSDTOS = new ArrayList<>();
        List<WappMessageTempDBModel> wappMessageTempDBModels = wappMessageTempRepository.findByCampaignId(campaignId);
        for (WappMessageTempDBModel wappMessageTempDBModel : wappMessageTempDBModels) {
            campaignWappMessageTempWSDTOS.add(new CampaignWappMessageTempWSDTO(wappMessageTempDBModel));
        }
        return campaignWappMessageTempWSDTOS;
    }

    public CampaignWappMessageTempWSDTO getCampaignWappMessageTempService(long userId, String tempId) {

        Optional<WappMessageTempDBModel> wappMessageTempDBModel = wappMessageTempRepository.findById(tempId);
        if (wappMessageTempDBModel.isPresent()) {
            return new CampaignWappMessageTempWSDTO(wappMessageTempDBModel.get());
        }
        return null;
    }


    public CampaignWappMessageTempWSDTO createCampaignWappMessageTempService(long userId, String campaignId, String wappTitle, String wappBody, long typeId) {

        Optional<MessageTypeDBModel> messageTypeDBModel = messageTypeRepository.findById(typeId);
        if (messageTypeDBModel.isPresent()) {

            WappMessageTempDBModel wappMessageTempDBModel = new WappMessageTempDBModel();
            wappMessageTempDBModel.setCampaignId(campaignId);
            wappMessageTempDBModel.setWappTitle(wappTitle);
            wappMessageTempDBModel.setWappBody(wappBody);
            wappMessageTempDBModel.setTypeId(typeId);
            wappMessageTempDBModel.setMessageType(messageTypeDBModel.get().getMessageType());
            wappMessageTempDBModel.setTempDatas(new ArrayList<>());
            wappMessageTempDBModel.setTempAssets(new ArrayList<>());
            wappMessageTempDBModel.setuDate(appUtils.getCurrentTimeStamp());
            wappMessageTempDBModel.setcDate(appUtils.getCurrentTimeStamp());
            wappMessageTempDBModel.setStatus(1);

            return new CampaignWappMessageTempWSDTO(wappMessageTempRepository.save(wappMessageTempDBModel));
        }
        return null;
    }

    public CampaignWappMessageTempWSDTO updateCampaignWappMessageTempService(long userId, String tempId, String wappTitle, String wappBody, long typeId) {

        Optional<MessageTypeDBModel> messageTypeDBModel = messageTypeRepository.findById(typeId);
        Optional<WappMessageTempDBModel> wappMessageTempDBModel = wappMessageTempRepository.findById(tempId);
        if (messageTypeDBModel.isPresent() && wappMessageTempDBModel.isPresent()) {

            wappMessageTempDBModel.get().setWappTitle(wappTitle);
            wappMessageTempDBModel.get().setWappBody(wappBody);
            wappMessageTempDBModel.get().setTypeId(typeId);
            wappMessageTempDBModel.get().setMessageType(messageTypeDBModel.get().getMessageType());
            wappMessageTempDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            wappMessageTempDBModel.get().setStatus(1);

            return new CampaignWappMessageTempWSDTO(wappMessageTempRepository.save(wappMessageTempDBModel.get()));
        }
        return null;
    }

    public CampaignWappMessageTempWSDTO removeCampaignWappMessageTempService(String tempId) {

        Optional<WappMessageTempDBModel> wappMessageTempDBModel = wappMessageTempRepository.findById(tempId);
        if (wappMessageTempDBModel.isPresent()) {
            wappMessageTempRepository.delete(wappMessageTempDBModel.get());
            return new CampaignWappMessageTempWSDTO(wappMessageTempDBModel.get());
        }
        return null;
    }


}
