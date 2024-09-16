package com.faas.core.base.framework.campaign.details.temp.details;

import com.faas.core.data.db.campaign.details.temp.PushTempDBModel;
import com.faas.core.data.db.channel.settings.PushTypeDBModel;
import com.faas.core.data.ws.base.campaign.details.temp.details.dto.CampaignPushTempWSDTO;
import com.faas.core.data.repo.campaign.details.temp.PushTempRepository;
import com.faas.core.data.repo.channel.settings.PushTypeRepository;
import com.faas.core.misc.config.AppUtils;
import com.faas.core.misc.helpers.campaign.CampaignHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CampaignPushTempFramework {


    @Autowired
    CampaignHelpers campaignHelpers;

    @Autowired
    PushTempRepository pushTempRepository;

    @Autowired
    PushTypeRepository pushTypeRepository;

    @Autowired
    AppUtils appUtils;


    public List<CampaignPushTempWSDTO> getCampaignPushTempsService(long userId, String campaignId) {

        List<CampaignPushTempWSDTO> campaignPushTempWSDTOS = new ArrayList<>();
        List<PushTempDBModel> pushTempDBModels = pushTempRepository.findByCampaignId(campaignId);
        for (PushTempDBModel pushTempDBModel : pushTempDBModels) {
            campaignPushTempWSDTOS.add(new CampaignPushTempWSDTO(pushTempDBModel));
        }
        return campaignPushTempWSDTOS;
    }

    public CampaignPushTempWSDTO getCampaignPushTempService(long userId, String tempId) {

        Optional<PushTempDBModel> pushTempDBModel = pushTempRepository.findById(tempId);
        if (pushTempDBModel.isPresent()) {
            return new CampaignPushTempWSDTO(pushTempDBModel.get());
        }
        return null;
    }

    public CampaignPushTempWSDTO createCampaignPushTempService(long userId, String campaignId, String pushHeader, String pushBody, String pushSender, long typeId) {

        Optional<PushTypeDBModel> pushTypeDBModel = pushTypeRepository.findById(typeId);
        if (pushTypeDBModel.isPresent()) {

            PushTempDBModel pushTempDBModel = new PushTempDBModel();
            pushTempDBModel.setCampaignId(campaignId);
            pushTempDBModel.setPushHeader(pushHeader);
            pushTempDBModel.setPushBody(pushBody);
            pushTempDBModel.setPushSender(pushSender);
            pushTempDBModel.setTypeId(pushTypeDBModel.get().getId());
            pushTempDBModel.setPushType(pushTypeDBModel.get().getPushType());
            pushTempDBModel.setTempDatas(new ArrayList<>());
            pushTempDBModel.setTempAssets(new ArrayList<>());
            pushTempDBModel.setuDate(appUtils.getCurrentTimeStamp());
            pushTempDBModel.setcDate(appUtils.getCurrentTimeStamp());
            pushTempDBModel.setStatus(1);

            return new CampaignPushTempWSDTO(pushTempRepository.save(pushTempDBModel));
        }
        return null;
    }

    public CampaignPushTempWSDTO updateCampaignPushTempService(long userId, String tempId, String pushHeader, String pushBody, String pushSender, long typeId) {

        Optional<PushTempDBModel> pushTempDBModel = pushTempRepository.findById(tempId);
        Optional<PushTypeDBModel> pushTypeDBModel = pushTypeRepository.findById(typeId);
        if (pushTempDBModel.isPresent() && pushTypeDBModel.isPresent()) {

            pushTempDBModel.get().setPushHeader(pushHeader);
            pushTempDBModel.get().setPushBody(pushBody);
            pushTempDBModel.get().setPushSender(pushSender);
            pushTempDBModel.get().setTypeId(pushTypeDBModel.get().getId());
            pushTempDBModel.get().setPushType(pushTypeDBModel.get().getPushType());
            pushTempDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            pushTempDBModel.get().setStatus(1);

            return new CampaignPushTempWSDTO(pushTempRepository.save(pushTempDBModel.get()));
        }
        return null;
    }

    public CampaignPushTempWSDTO removeCampaignPushTempService(String tempId) {

        Optional<PushTempDBModel> pushTempDBModel = pushTempRepository.findById(tempId);
        if (pushTempDBModel.isPresent()) {
            pushTempRepository.delete(pushTempDBModel.get());
            return new CampaignPushTempWSDTO(pushTempDBModel.get());
        }
        return null;
    }


}
