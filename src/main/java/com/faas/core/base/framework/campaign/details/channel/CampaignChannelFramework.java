package com.faas.core.base.framework.campaign.details.channel;

import com.faas.core.data.db.campaign.details.channel.CampaignChannelDBModel;
import com.faas.core.data.db.campaign.details.channel.dao.*;
import com.faas.core.data.db.channel.account.EmailAccountDBModel;
import com.faas.core.data.db.channel.account.PushAccountDBModel;
import com.faas.core.data.db.channel.account.SmsAccountDBModel;
import com.faas.core.base.model.ws.campaign.details.channel.dto.*;
import com.faas.core.data.repo.campaign.details.channel.CampaignChannelRepository;
import com.faas.core.data.repo.channel.account.EmailAccountRepository;
import com.faas.core.data.repo.channel.account.PushAccountRepository;
import com.faas.core.data.repo.channel.account.SmsAccountRepository;
import com.faas.core.misc.config.AppUtils;
import com.faas.core.misc.helpers.channel.ChannelHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CampaignChannelFramework {


    @Autowired
    ChannelHelper channelHelper;

    @Autowired
    CampaignChannelRepository campaignChannelRepository;

    @Autowired
    SmsAccountRepository smsAccountRepository;

    @Autowired
    EmailAccountRepository emailAccountRepository;

    @Autowired
    PushAccountRepository pushAccountRepository;

    @Autowired
    AppUtils appUtils;


    public CampaignChannelWSDTO getCampaignChannelsService(long userId, String campaignId) {

        List<CampaignChannelDBModel> campaignChannelDBModels = campaignChannelRepository.findByCampaignId(campaignId);
        if (!campaignChannelDBModels.isEmpty()) {
            CampaignChannelWSDTO campaignChannelWSDTO = new CampaignChannelWSDTO();
            if (campaignChannelDBModels.get(0).getWappChannel() != null) {
                campaignChannelWSDTO.setWappChannel(new CampaignWappChannelWSDTO(campaignChannelDBModels.get(0).getWappChannel()));
            }
            if (campaignChannelDBModels.get(0).getSmsChannel() != null) {
                campaignChannelWSDTO.setSmsChannel(new CampaignSmsChannelWSDTO(campaignChannelDBModels.get(0).getSmsChannel()));
            }
            if (campaignChannelDBModels.get(0).getSipChannel() != null) {
                campaignChannelWSDTO.setSipChannel(new CampaignSipChannelWSDTO(campaignChannelDBModels.get(0).getSipChannel()));
            }
            if (campaignChannelDBModels.get(0).getEmailChannel() != null) {
                campaignChannelWSDTO.setEmailChannel(new CampaignEmailChannelWSDTO(campaignChannelDBModels.get(0).getEmailChannel()));
            }
            if (campaignChannelDBModels.get(0).getPushChannel() != null) {
                campaignChannelWSDTO.setPushChannel(new CampaignPushChannelWSDTO(campaignChannelDBModels.get(0).getPushChannel()));
            }
            return campaignChannelWSDTO;
        }
        return null;
    }


    public CampaignSipChannelWSDTO getCampaignSipChannelService(long userId, String campaignId) {

        List<CampaignChannelDBModel> campaignChannelDBModels = campaignChannelRepository.findByCampaignId(campaignId);
        if (!campaignChannelDBModels.isEmpty() && campaignChannelDBModels.get(0).getSipChannel() != null) {
            return new CampaignSipChannelWSDTO(campaignChannelDBModels.get(0).getSipChannel());
        }
        return null;
    }

    public CampaignSipChannelWSDTO createCampaignSipChannelService(long userId, String campaignId, String callerId, String state) {

        List<CampaignChannelDBModel> campaignChannelDBModels = campaignChannelRepository.findByCampaignId(campaignId);
        if (!campaignChannelDBModels.isEmpty()) {

            CampaignSipChannelDAO campaignSipChannelDAO = new CampaignSipChannelDAO();
            campaignSipChannelDAO.setId(appUtils.generateUUID());
            campaignSipChannelDAO.setCallerId(callerId);
            campaignSipChannelDAO.setState(state);
            campaignSipChannelDAO.setuDate(appUtils.getCurrentTimeStamp());
            campaignSipChannelDAO.setcDate(appUtils.getCurrentTimeStamp());
            campaignSipChannelDAO.setStatus(1);

            campaignChannelDBModels.get(0).setSipChannel(campaignSipChannelDAO);
            campaignChannelDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
            campaignChannelRepository.save(campaignChannelDBModels.get(0));

            return new CampaignSipChannelWSDTO(campaignSipChannelDAO);
        }
        return null;
    }

    public CampaignSipChannelWSDTO removeCampaignSipChannelService(long userId, String campaignId) {

        List<CampaignChannelDBModel> campaignChannelDBModels = campaignChannelRepository.findByCampaignId(campaignId);
        if (!campaignChannelDBModels.isEmpty() && campaignChannelDBModels.get(0).getSipChannel() != null) {

            CampaignSipChannelDAO campaignSipChannelDAO = campaignChannelDBModels.get(0).getSipChannel();
            campaignChannelDBModels.get(0).setSipChannel(null);
            campaignChannelDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
            campaignChannelRepository.save(campaignChannelDBModels.get(0));

            return new CampaignSipChannelWSDTO(campaignSipChannelDAO);
        }
        return null;
    }


    public CampaignSmsChannelWSDTO getCampaignSmsChannelService(long userId, String campaignId) {

        List<CampaignChannelDBModel> campaignChannelDBModels = campaignChannelRepository.findByCampaignId(campaignId);
        if (!campaignChannelDBModels.isEmpty() && campaignChannelDBModels.get(0).getSmsChannel() != null) {
            return new CampaignSmsChannelWSDTO(campaignChannelDBModels.get(0).getSmsChannel());
        }
        return null;
    }

    public CampaignSmsChannelWSDTO createCampaignSmsChannelService(long userId, String campaignId, String accountId, String state) {

        Optional<SmsAccountDBModel> smsAccountDBModel = smsAccountRepository.findById(accountId);
        List<CampaignChannelDBModel> campaignChannelDBModels = campaignChannelRepository.findByCampaignId(campaignId);
        if (smsAccountDBModel.isPresent() && !campaignChannelDBModels.isEmpty()) {

            campaignChannelDBModels.get(0).setSmsChannel(channelHelper.createCampaignSmsChannelDAO(smsAccountDBModel.get(), state));
            campaignChannelDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
            campaignChannelRepository.save(campaignChannelDBModels.get(0));

            return new CampaignSmsChannelWSDTO(campaignChannelDBModels.get(0).getSmsChannel());
        }
        return null;
    }

    public CampaignSmsChannelWSDTO removeCampaignSmsChannelService(String campaignId) {

        List<CampaignChannelDBModel> campaignChannelDBModels = campaignChannelRepository.findByCampaignId(campaignId);
        if (!campaignChannelDBModels.isEmpty() && campaignChannelDBModels.get(0).getSmsChannel() != null) {

            CampaignSmsChannelDAO campaignSmsChannelDAO = campaignChannelDBModels.get(0).getSmsChannel();
            campaignChannelDBModels.get(0).setSmsChannel(null);
            campaignChannelDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
            campaignChannelRepository.save(campaignChannelDBModels.get(0));

            return new CampaignSmsChannelWSDTO(campaignSmsChannelDAO);
        }
        return null;
    }


    public CampaignWappChannelWSDTO getCampaignWappChannelService(long userId, String campaignId) {

        List<CampaignChannelDBModel> campaignChannelDBModels = campaignChannelRepository.findByCampaignId(campaignId);
        if (!campaignChannelDBModels.isEmpty() && campaignChannelDBModels.get(0).getWappChannel() != null) {
            return new CampaignWappChannelWSDTO(campaignChannelDBModels.get(0).getWappChannel());
        }
        return null;
    }

    public CampaignWappChannelWSDTO createCampaignWappChannelService(long userId, String campaignId, String callState, String messageState) {

        List<CampaignChannelDBModel> campaignChannelDBModels = campaignChannelRepository.findByCampaignId(campaignId);
        if (!campaignChannelDBModels.isEmpty()) {

            CampaignWappChannelDAO campaignWappChannelDAO = new CampaignWappChannelDAO();
            campaignWappChannelDAO.setId(appUtils.generateUUID());
            campaignWappChannelDAO.setCallState(callState);
            campaignWappChannelDAO.setMessageState(messageState);
            campaignWappChannelDAO.setuDate(appUtils.getCurrentTimeStamp());
            campaignWappChannelDAO.setcDate(appUtils.getCurrentTimeStamp());
            campaignWappChannelDAO.setStatus(1);

            campaignChannelDBModels.get(0).setWappChannel(campaignWappChannelDAO);
            campaignChannelDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
            campaignChannelRepository.save(campaignChannelDBModels.get(0));

            return new CampaignWappChannelWSDTO(campaignChannelDBModels.get(0).getWappChannel());
        }
        return null;
    }

    public CampaignWappChannelWSDTO removeCampaignWappChannelService(long userId, String campaignId) {

        List<CampaignChannelDBModel> campaignChannelDBModels = campaignChannelRepository.findByCampaignId(campaignId);
        if (!campaignChannelDBModels.isEmpty() && campaignChannelDBModels.get(0).getWappChannel() != null) {

            CampaignWappChannelDAO campaignWappChannelDAO = campaignChannelDBModels.get(0).getWappChannel();
            campaignChannelDBModels.get(0).setWappChannel(null);
            campaignChannelDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
            campaignChannelRepository.save(campaignChannelDBModels.get(0));

            return new CampaignWappChannelWSDTO(campaignWappChannelDAO);
        }
        return null;
    }


    public CampaignEmailChannelWSDTO getCampaignEmailChannelService(long userId, String campaignId) {

        List<CampaignChannelDBModel> campaignChannelDBModels = campaignChannelRepository.findByCampaignId(campaignId);
        if (!campaignChannelDBModels.isEmpty() && campaignChannelDBModels.get(0).getEmailChannel() != null) {
            return new CampaignEmailChannelWSDTO(campaignChannelDBModels.get(0).getEmailChannel());
        }
        return null;
    }

    public CampaignEmailChannelWSDTO createCampaignEmailChannelService(long userId, String campaignId, String accountId, String state) {

        Optional<EmailAccountDBModel> emailAccountDBModel = emailAccountRepository.findById(accountId);
        List<CampaignChannelDBModel> campaignChannelDBModels = campaignChannelRepository.findByCampaignId(campaignId);
        if (emailAccountDBModel.isPresent() && !campaignChannelDBModels.isEmpty()) {

            campaignChannelDBModels.get(0).setEmailChannel(channelHelper.createCampaignEmailChannelDAO(emailAccountDBModel.get(), state));
            campaignChannelDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
            campaignChannelRepository.save(campaignChannelDBModels.get(0));

            return new CampaignEmailChannelWSDTO(campaignChannelDBModels.get(0).getEmailChannel());
        }
        return null;
    }

    public CampaignEmailChannelWSDTO removeCampaignEmailChannelService(long userId, String campaignId) {

        List<CampaignChannelDBModel> campaignChannelDBModels = campaignChannelRepository.findByCampaignId(campaignId);
        if (!campaignChannelDBModels.isEmpty() && campaignChannelDBModels.get(0).getEmailChannel() != null) {

            CampaignEmailChannelDAO campaignEmailChannelDAO = campaignChannelDBModels.get(0).getEmailChannel();
            campaignChannelDBModels.get(0).setEmailChannel(null);
            campaignChannelDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
            campaignChannelRepository.save(campaignChannelDBModels.get(0));

            return new CampaignEmailChannelWSDTO(campaignEmailChannelDAO);
        }
        return null;
    }


    public CampaignPushChannelWSDTO getCampaignPushChannelService(long userId, String campaignId) {

        List<CampaignChannelDBModel> campaignChannelDBModels = campaignChannelRepository.findByCampaignId(campaignId);
        if (!campaignChannelDBModels.isEmpty() && campaignChannelDBModels.get(0).getPushChannel() != null) {
            return new CampaignPushChannelWSDTO(campaignChannelDBModels.get(0).getPushChannel());
        }
        return null;
    }

    public CampaignPushChannelWSDTO createCampaignPushChannelService(long userId, String campaignId, String accountId, String state) {

        Optional<PushAccountDBModel> pushAccountDBModel = pushAccountRepository.findById(accountId);
        List<CampaignChannelDBModel> campaignChannelDBModels = campaignChannelRepository.findByCampaignId(campaignId);
        if (pushAccountDBModel.isPresent() && !campaignChannelDBModels.isEmpty()) {

            campaignChannelDBModels.get(0).setPushChannel(channelHelper.createCampaignPushChannelDAO(pushAccountDBModel.get(), state));
            campaignChannelDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
            campaignChannelRepository.save(campaignChannelDBModels.get(0));

            return new CampaignPushChannelWSDTO(campaignChannelDBModels.get(0).getPushChannel());

        }
        return null;
    }

    public CampaignPushChannelWSDTO removeCampaignPushChannelService(long userId, String campaignId) {

        List<CampaignChannelDBModel> campaignChannelDBModels = campaignChannelRepository.findByCampaignId(campaignId);
        if (!campaignChannelDBModels.isEmpty() && campaignChannelDBModels.get(0).getPushChannel() != null) {

            CampaignPushChannelDAO campaignPushChannelDAO = campaignChannelDBModels.get(0).getPushChannel();
            campaignChannelDBModels.get(0).setPushChannel(null);
            campaignChannelDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
            campaignChannelRepository.save(campaignChannelDBModels.get(0));

            return new CampaignPushChannelWSDTO(campaignPushChannelDAO);
        }
        return null;
    }


}
