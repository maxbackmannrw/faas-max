package com.faas.core.misc.helpers.campaign;

import com.faas.core.api.model.ws.campaign.content.dto.ApiCampaignSummary;
import com.faas.core.api.model.ws.campaign.content.dto.ApiCampaignWSDTO;
import com.faas.core.data.db.campaign.content.CampaignDBModel;
import com.faas.core.data.db.campaign.content.dao.CampaignFlowDAO;
import com.faas.core.data.db.campaign.content.dao.CampaignInquiryDAO;
import com.faas.core.data.db.campaign.details.agent.CampaignAgentDBModel;
import com.faas.core.data.db.campaign.details.channel.CampaignChannelDBModel;
import com.faas.core.data.db.campaign.details.remote.CampaignRemoteDBModel;
import com.faas.core.data.db.campaign.details.temp.EmailTempDBModel;
import com.faas.core.data.db.campaign.details.temp.PushTempDBModel;
import com.faas.core.data.db.campaign.details.temp.SmsTempDBModel;
import com.faas.core.data.db.campaign.details.temp.WappMessageTempDBModel;
import com.faas.core.data.db.campaign.details.trigger.*;
import com.faas.core.data.db.user.content.UserDBModel;
import com.faas.core.base.model.ws.campaign.content.dto.CampaignWSDTO;
import com.faas.core.base.model.ws.campaign.details.agent.dto.CampaignAgentWSDTO;
import com.faas.core.base.model.ws.campaign.details.channel.dto.*;
import com.faas.core.base.model.ws.campaign.details.content.dto.CampaignDetailsWSDTO;
import com.faas.core.base.model.ws.campaign.details.remote.dto.CampaignRemoteWSDTO;
import com.faas.core.base.model.ws.campaign.details.temp.content.dto.CampaignTempWSDTO;
import com.faas.core.base.model.ws.campaign.details.temp.details.dto.CampaignEmailTempWSDTO;
import com.faas.core.base.model.ws.campaign.details.temp.details.dto.CampaignPushTempWSDTO;
import com.faas.core.base.model.ws.campaign.details.temp.details.dto.CampaignSmsTempWSDTO;
import com.faas.core.base.model.ws.campaign.details.temp.details.dto.CampaignWappMessageTempWSDTO;
import com.faas.core.base.model.ws.campaign.details.trigger.content.dto.CampaignTriggerWSDTO;
import com.faas.core.base.model.ws.campaign.details.trigger.details.dto.*;
import com.faas.core.base.model.ws.campaign.manager.content.dto.CampaignManagerDetailsWSDTO;
import com.faas.core.base.model.ws.campaign.manager.content.dto.CampaignManagerWSDTO;
import com.faas.core.base.model.ws.campaign.manager.content.dto.CampaignSummaryWSDTO;
import com.faas.core.data.repo.campaign.details.agent.CampaignAgentRepository;
import com.faas.core.data.repo.campaign.details.channel.CampaignChannelRepository;
import com.faas.core.data.repo.campaign.details.remote.CampaignRemoteRepository;
import com.faas.core.data.repo.campaign.details.temp.EmailTempRepository;
import com.faas.core.data.repo.campaign.details.temp.PushTempRepository;
import com.faas.core.data.repo.campaign.details.temp.SmsTempRepository;
import com.faas.core.data.repo.campaign.details.temp.WappMessageTempRepository;
import com.faas.core.data.repo.campaign.details.trigger.*;
import com.faas.core.data.repo.operation.content.OperationRepository;
import com.faas.core.data.repo.remote.details.RemoteUrlRepository;
import com.faas.core.data.repo.user.content.UserRepository;
import com.faas.core.misc.config.AppConstant;
import com.faas.core.misc.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class CampaignHelper {


    @Autowired
    UserRepository userRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    CampaignRemoteRepository campaignRemoteRepository;

    @Autowired
    CampaignChannelRepository campaignChannelRepository;

    @Autowired
    CampaignAgentRepository campaignAgentRepository;

    @Autowired
    EmailTempRepository emailTempRepository;

    @Autowired
    PushTempRepository pushTempRepository;

    @Autowired
    SmsTempRepository smsTempRepository;

    @Autowired
    WappMessageTempRepository wappMessageTempRepository;

    @Autowired
    EmailTriggerRepository emailTriggerRepository;

    @Autowired
    SipTriggerRepository sipTriggerRepository;

    @Autowired
    SmsTriggerRepository smsTriggerRepository;

    @Autowired
    WappCallTriggerRepository wappCallTriggerRepository;

    @Autowired
    WappMessageTriggerRepository wappMessageTriggerRepository;

    @Autowired
    RemoteUrlRepository remoteUrlRepository;

    @Autowired
    AppUtils appUtils;


    public CampaignWSDTO getCampaignWSDTO(CampaignDBModel campaignDBModel) {

        CampaignWSDTO campaignWSDTO = new CampaignWSDTO();
        campaignWSDTO.setCampaign(campaignDBModel);

        return campaignWSDTO;
    }

    public CampaignDetailsWSDTO getCampaignDetailsWSDTO(CampaignDBModel campaignDBModel) {

        CampaignDetailsWSDTO campaignDetailsWSDTO = new CampaignDetailsWSDTO();
        campaignDetailsWSDTO.setCampaign(campaignDBModel);
        campaignDetailsWSDTO.setCampaignAgents(getCampaignAgentWSDTOS(campaignDBModel.getId()));
        campaignDetailsWSDTO.setCampaignTemp(getCampaignTempWSDTO(campaignDBModel.getId()));
        campaignDetailsWSDTO.setCampaignChannel(getCampaignChannelWSDTO(campaignDBModel.getId()));
        campaignDetailsWSDTO.setCampaignTrigger(getCampaignTriggerWSDTO(campaignDBModel.getId()));
        campaignDetailsWSDTO.setCampaignRemotes(getCampaignRemoteWSDTOS(campaignDBModel));

        return campaignDetailsWSDTO;
    }


    public CampaignInquiryDAO createCampaignInquiryDAO(String campaignInquiry) {

        CampaignInquiryDAO campaignInquiryDAO = new CampaignInquiryDAO();
        campaignInquiryDAO.setInquiryId(appUtils.generateUUID());
        campaignInquiryDAO.setCampaignInquiry(campaignInquiry);
        campaignInquiryDAO.setInquiryDatas(new ArrayList<>());
        campaignInquiryDAO.setInquiryState(AppConstant.PASSIVE_STATE);
        campaignInquiryDAO.setuDate(appUtils.getCurrentTimeStamp());
        campaignInquiryDAO.setcDate(appUtils.getCurrentTimeStamp());
        campaignInquiryDAO.setStatus(1);

        return campaignInquiryDAO;
    }

    public CampaignFlowDAO createCampaignFlowDAO(String campaignFlow) {

        CampaignFlowDAO campaignFlowDAO = new CampaignFlowDAO();
        campaignFlowDAO.setFlowId(appUtils.generateUUID());
        campaignFlowDAO.setCampaignFlow(campaignFlow);
        campaignFlowDAO.setFlowDatas(new ArrayList<>());
        campaignFlowDAO.setFlowState(AppConstant.PASSIVE_STATE);
        campaignFlowDAO.setuDate(appUtils.getCurrentTimeStamp());
        campaignFlowDAO.setcDate(appUtils.getCurrentTimeStamp());
        campaignFlowDAO.setStatus(1);

        return campaignFlowDAO;
    }


    public CampaignTriggerWSDTO getCampaignTriggerWSDTO(String campaignId) {

        CampaignTriggerWSDTO campaignTriggerWSDTO = new CampaignTriggerWSDTO();
        campaignTriggerWSDTO.setCampaignEmailTriggers(getCampaignEmailTriggerWSDTOS(campaignId));
        campaignTriggerWSDTO.setCampaignSipTriggers(getCampaignSipTriggerWSDTOS(campaignId));
        campaignTriggerWSDTO.setCampaignSmsTriggers(getCampaignSmsTriggerWSDTOS(campaignId));
        campaignTriggerWSDTO.setCampaignWappCallTriggers(getCampaignWappCallTriggerWSDTOS(campaignId));
        campaignTriggerWSDTO.setCampaignWappMessageTriggers(getCampaignWappMessageTriggerWSDTOS(campaignId));

        return campaignTriggerWSDTO;
    }


    public List<CampaignEmailTriggerWSDTO> getCampaignEmailTriggerWSDTOS(String campaignId) {

        List<CampaignEmailTriggerWSDTO> campaignEmailTriggerWSDTOS = new ArrayList<>();
        List<EmailTriggerDBModel> emailTriggerDBModels = emailTriggerRepository.findByCampaignId(campaignId);
        for (EmailTriggerDBModel emailTriggerDBModel : emailTriggerDBModels) {
            campaignEmailTriggerWSDTOS.add(new CampaignEmailTriggerWSDTO(emailTriggerDBModel));
        }
        return campaignEmailTriggerWSDTOS;
    }

    public List<CampaignSipTriggerWSDTO> getCampaignSipTriggerWSDTOS(String campaignId) {

        List<CampaignSipTriggerWSDTO> campaignSipTriggerWSDTOS = new ArrayList<>();
        List<SipTriggerDBModel> sipTriggerDBModels = sipTriggerRepository.findByCampaignId(campaignId);
        for (SipTriggerDBModel sipTriggerDBModel : sipTriggerDBModels) {
            campaignSipTriggerWSDTOS.add(new CampaignSipTriggerWSDTO(sipTriggerDBModel));
        }
        return campaignSipTriggerWSDTOS;
    }

    public List<CampaignSmsTriggerWSDTO> getCampaignSmsTriggerWSDTOS(String campaignId) {

        List<CampaignSmsTriggerWSDTO> campaignSmsTriggerWSDTOS = new ArrayList<>();
        List<SmsTriggerDBModel> smsTriggerDBModels = smsTriggerRepository.findByCampaignId(campaignId);
        for (SmsTriggerDBModel smsTriggerDBModel : smsTriggerDBModels) {
            campaignSmsTriggerWSDTOS.add(new CampaignSmsTriggerWSDTO(smsTriggerDBModel));
        }
        return campaignSmsTriggerWSDTOS;
    }

    public List<CampaignWappCallTriggerWSDTO> getCampaignWappCallTriggerWSDTOS(String campaignId) {

        List<CampaignWappCallTriggerWSDTO> campaignWappCallTriggerWSDTOS = new ArrayList<>();
        List<WappCallTriggerDBModel> wappCallTriggerDBModels = wappCallTriggerRepository.findByCampaignId(campaignId);
        for (WappCallTriggerDBModel wappCallTriggerDBModel : wappCallTriggerDBModels) {
            campaignWappCallTriggerWSDTOS.add(new CampaignWappCallTriggerWSDTO(wappCallTriggerDBModel));
        }
        return campaignWappCallTriggerWSDTOS;
    }

    public List<CampaignWappMessageTriggerWSDTO> getCampaignWappMessageTriggerWSDTOS(String campaignId) {

        List<CampaignWappMessageTriggerWSDTO> campaignWappMessageTriggerWSDTOS = new ArrayList<>();
        List<WappMessageTriggerDBModel> wappMessageTriggerDBModels = wappMessageTriggerRepository.findByCampaignId(campaignId);
        for (WappMessageTriggerDBModel wappMessageTriggerDBModel : wappMessageTriggerDBModels) {
            campaignWappMessageTriggerWSDTOS.add(new CampaignWappMessageTriggerWSDTO(wappMessageTriggerDBModel));
        }
        return campaignWappMessageTriggerWSDTOS;
    }



    public List<CampaignRemoteWSDTO> getCampaignRemoteWSDTOS(CampaignDBModel campaignDBModel) {

        List<CampaignRemoteWSDTO> campaignRemoteWSDTOS = new ArrayList<>();
        List<CampaignRemoteDBModel> campaignRemoteDBModels = campaignRemoteRepository.findByCampaignId(campaignDBModel.getId());
        for (CampaignRemoteDBModel campaignRemoteDBModel : campaignRemoteDBModels) {
            campaignRemoteWSDTOS.add(createCampaignRemoteWSDTO(campaignRemoteDBModel));
        }
        return campaignRemoteWSDTOS;
    }

    public CampaignRemoteWSDTO createCampaignRemoteWSDTO(CampaignRemoteDBModel campaignRemoteDBModel) {

        CampaignRemoteWSDTO campaignRemoteWSDTO = new CampaignRemoteWSDTO();
        campaignRemoteWSDTO.setCampaignRemote(campaignRemoteDBModel);
        campaignRemoteWSDTO.setRemoteUrls(remoteUrlRepository.findByRemoteId(campaignRemoteDBModel.getRemoteId()));

        return campaignRemoteWSDTO;
    }


    public List<CampaignAgentWSDTO> getCampaignAgentWSDTOS(String campaignId) {

        List<CampaignAgentWSDTO> campaignAgentWSDTOS = new ArrayList<>();
        List<CampaignAgentDBModel> campaignAgentDBModels = campaignAgentRepository.findByCampaignId(campaignId);
        for (CampaignAgentDBModel campaignAgentDBModel : campaignAgentDBModels) {
            Optional<UserDBModel> agentDBModel = userRepository.findById(campaignAgentDBModel.getAgentId());
            if (agentDBModel.isPresent()) {
                agentDBModel.get().setPassword("");
                CampaignAgentWSDTO campaignAgentWSDTO = new CampaignAgentWSDTO();
                campaignAgentWSDTO.setAgentUser(agentDBModel.get());
                campaignAgentWSDTO.setCampaignAgent(campaignAgentDBModel);
                campaignAgentWSDTOS.add(campaignAgentWSDTO);
            }
        }
        return campaignAgentWSDTOS;
    }


    public CampaignTempWSDTO getCampaignTempWSDTO(String campaignId) {

        CampaignTempWSDTO campaignTempWSDTO = new CampaignTempWSDTO();

        List<EmailTempDBModel> emailTempDBModels = emailTempRepository.findByCampaignId(campaignId);
        List<CampaignEmailTempWSDTO> campaignEmailTempWSDTOS = new ArrayList<>();
        for (EmailTempDBModel emailTempDBModel : emailTempDBModels) {
            campaignEmailTempWSDTOS.add(new CampaignEmailTempWSDTO(emailTempDBModel));
        }
        campaignTempWSDTO.setCampaignEmailTemps(campaignEmailTempWSDTOS);

        List<PushTempDBModel> pushTempDBModels = pushTempRepository.findByCampaignId(campaignId);
        List<CampaignPushTempWSDTO> campaignPushTempWSDTOS = new ArrayList<>();
        for (PushTempDBModel pushTempDBModel : pushTempDBModels) {
            campaignPushTempWSDTOS.add(new CampaignPushTempWSDTO(pushTempDBModel));
        }
        campaignTempWSDTO.setCampaignPushTemps(campaignPushTempWSDTOS);

        List<SmsTempDBModel> smsTempDBModels = smsTempRepository.findByCampaignId(campaignId);
        List<CampaignSmsTempWSDTO> campaignSmsTempWSDTOS = new ArrayList<>();
        for (SmsTempDBModel smsTempDBModel : smsTempDBModels) {
            campaignSmsTempWSDTOS.add(new CampaignSmsTempWSDTO(smsTempDBModel));
        }
        campaignTempWSDTO.setCampaignSmsTemps(campaignSmsTempWSDTOS);

        List<WappMessageTempDBModel> wappMessageTempDBModels = wappMessageTempRepository.findByCampaignId(campaignId);
        List<CampaignWappMessageTempWSDTO> campaignWappMessageTempWSDTOS = new ArrayList<>();
        for (WappMessageTempDBModel wappMessageTempDBModel : wappMessageTempDBModels) {
            campaignWappMessageTempWSDTOS.add(new CampaignWappMessageTempWSDTO(wappMessageTempDBModel));
        }
        campaignTempWSDTO.setCampaignWappMessageTemps(campaignWappMessageTempWSDTOS);

        return campaignTempWSDTO;
    }


    public CampaignChannelWSDTO getCampaignChannelWSDTO(String campaignId) {

        CampaignChannelWSDTO campaignChannelWSDTO = new CampaignChannelWSDTO();
        List<CampaignChannelDBModel> campaignChannelDBModels = campaignChannelRepository.findByCampaignId(campaignId);
        if (!campaignChannelDBModels.isEmpty()) {
            if (campaignChannelDBModels.get(0).getSipChannel() != null) {
                campaignChannelWSDTO.setSipChannel(new CampaignSipChannelWSDTO(campaignChannelDBModels.get(0).getSipChannel()));
            }
            if (campaignChannelDBModels.get(0).getSmsChannel() != null) {
                campaignChannelWSDTO.setSmsChannel(new CampaignSmsChannelWSDTO(campaignChannelDBModels.get(0).getSmsChannel()));
            }
            if (campaignChannelDBModels.get(0).getWappChannel() != null) {
                campaignChannelWSDTO.setWappChannel(new CampaignWappChannelWSDTO(campaignChannelDBModels.get(0).getWappChannel()));
            }
            if (campaignChannelDBModels.get(0).getEmailChannel() != null) {
                campaignChannelWSDTO.setEmailChannel(new CampaignEmailChannelWSDTO(campaignChannelDBModels.get(0).getEmailChannel()));
            }
            if (campaignChannelDBModels.get(0).getPushChannel() != null) {
                campaignChannelWSDTO.setPushChannel(new CampaignPushChannelWSDTO(campaignChannelDBModels.get(0).getPushChannel()));
            }
        }
        return campaignChannelWSDTO;
    }


    public ApiCampaignWSDTO getApiCampaignWSDTO(long agentId, CampaignDBModel campaignDBModel) {

        ApiCampaignWSDTO campaignWSDTO = new ApiCampaignWSDTO();
        campaignWSDTO.setCampaign(campaignDBModel);
        campaignWSDTO.setCampaignSummary(getApiCampaignSummary(agentId, campaignDBModel.getId()));

        return campaignWSDTO;
    }

    public ApiCampaignSummary getApiCampaignSummary(long agentId, String campaignId) {

        ApiCampaignSummary campaignSummary = new ApiCampaignSummary();
        campaignSummary.setReadyOperationCount(operationRepository.countByAgentIdAndCampaignIdAndOperationState(agentId,campaignId,AppConstant.READY_STATE));
        campaignSummary.setActiveOperationCount(operationRepository.countByAgentIdAndCampaignIdAndOperationState(agentId,campaignId,AppConstant.ACTIVE_STATE));
        campaignSummary.setTotalOperationCount(operationRepository.countByAgentIdAndCampaignId(agentId,campaignId));

        return campaignSummary;
    }


    public CampaignChannelDBModel createCampaignChannelDBModel(CampaignDBModel campaignDBModel) {

        List<CampaignChannelDBModel> campaignChannelDBModels = campaignChannelRepository.findByCampaignId(campaignDBModel.getId());
        if (!campaignChannelDBModels.isEmpty()) {
            campaignChannelRepository.deleteAll(campaignChannelDBModels);
        }
        CampaignChannelDBModel campaignChannelDBModel = new CampaignChannelDBModel();
        campaignChannelDBModel.setCampaignId(campaignDBModel.getId());
        campaignChannelDBModel.setuDate(appUtils.getCurrentTimeStamp());
        campaignChannelDBModel.setcDate(appUtils.getCurrentTimeStamp());
        campaignChannelDBModel.setStatus(1);

        return campaignChannelRepository.save(campaignChannelDBModel);
    }


    public CampaignManagerWSDTO getCampaignManagerWSDTO(CampaignDBModel campaignDBModel) {

        CampaignManagerWSDTO campaignManagerWSDTO = new CampaignManagerWSDTO();
        campaignManagerWSDTO.setCampaign(campaignDBModel);
        campaignManagerWSDTO.setCampaignSummary(getCampaignSummaryWSDTO(campaignDBModel.getId()));

        return campaignManagerWSDTO;
    }

    public CampaignManagerDetailsWSDTO getCampaignManagerDetailsWSDTO(CampaignDBModel campaignDBModel) {

        CampaignManagerDetailsWSDTO campaignManagerDetailsWSDTO = new CampaignManagerDetailsWSDTO();
        campaignManagerDetailsWSDTO.setCampaign(campaignDBModel);
        campaignManagerDetailsWSDTO.setCampaignSummary(getCampaignSummaryWSDTO(campaignDBModel.getId()));
        campaignManagerDetailsWSDTO.setCampaignAgents(getCampaignAgentWSDTOS(campaignDBModel.getId()));
        campaignManagerDetailsWSDTO.setCampaignTemp(getCampaignTempWSDTO(campaignDBModel.getId()));
        campaignManagerDetailsWSDTO.setCampaignChannel(getCampaignChannelWSDTO(campaignDBModel.getId()));
        campaignManagerDetailsWSDTO.setCampaignTrigger(getCampaignTriggerWSDTO(campaignDBModel.getId()));
        campaignManagerDetailsWSDTO.setCampaignRemotes(getCampaignRemoteWSDTOS(campaignDBModel));

        return campaignManagerDetailsWSDTO;
    }

    public CampaignSummaryWSDTO getCampaignSummaryWSDTO(String campaignId) {

        CampaignSummaryWSDTO campaignSummaryWSDTO = new CampaignSummaryWSDTO();
        campaignSummaryWSDTO.setReadyOperationCount(operationRepository.countByCampaignIdAndOperationState(campaignId, AppConstant.READY_STATE));
        campaignSummaryWSDTO.setActiveOperationCount(operationRepository.countByCampaignIdAndOperationState(campaignId, AppConstant.ACTIVE_STATE));
        campaignSummaryWSDTO.setTotalOperationCount(operationRepository.countByCampaignId(campaignId));
        campaignSummaryWSDTO.setTotalAgentCount(campaignAgentRepository.countByCampaignId(campaignId));

        return campaignSummaryWSDTO;
    }

    public CampaignDBModel updateCampaignManagerStateHelper(CampaignDBModel campaignDBModel, String campaignState) {

        if (campaignState.equalsIgnoreCase(AppConstant.PASSIVE_CAMPAIGN)) {
            if (campaignDBModel.getCampaignCategory().equalsIgnoreCase(AppConstant.INQUIRY_CAMPAIGN)) {
                campaignDBModel.getCampaignInquiry().setInquiryState(AppConstant.PASSIVE_STATE);
                campaignDBModel.getCampaignInquiry().setuDate(appUtils.getCurrentTimeStamp());
            }
            if (campaignDBModel.getCampaignCategory().equalsIgnoreCase(AppConstant.AUTOMATIC_CAMPAIGN)) {
                campaignDBModel.getCampaignFlow().setFlowState(AppConstant.PASSIVE_STATE);
                campaignDBModel.getCampaignFlow().setuDate(appUtils.getCurrentTimeStamp());
            }
        }
        campaignDBModel.setCampaignState(campaignState);
        campaignDBModel.setuDate(appUtils.getCurrentTimeStamp());

        return campaignDBModel;
    }

    public CampaignDBModel updateCampaignManagerInquiryStateHelper(CampaignDBModel campaignDBModel, String inquiryState) {

        if (campaignDBModel.getCampaignState().equalsIgnoreCase(AppConstant.ACTIVE_CAMPAIGN)) {
            campaignDBModel.getCampaignInquiry().setInquiryState(inquiryState);
            campaignDBModel.getCampaignInquiry().setuDate(appUtils.getCurrentTimeStamp());
        } else {
            campaignDBModel.getCampaignInquiry().setInquiryState(AppConstant.PASSIVE_STATE);
            campaignDBModel.getCampaignInquiry().setuDate(appUtils.getCurrentTimeStamp());
        }
        campaignDBModel.setuDate(appUtils.getCurrentTimeStamp());

        return campaignDBModel;
    }

    public CampaignDBModel updateCampaignManagerFlowStateHelper(CampaignDBModel campaignDBModel, String flowState) {

        if (campaignDBModel.getCampaignState().equalsIgnoreCase(AppConstant.ACTIVE_CAMPAIGN)) {
            campaignDBModel.getCampaignFlow().setFlowState(flowState);
            campaignDBModel.getCampaignFlow().setuDate(appUtils.getCurrentTimeStamp());
        } else {
            campaignDBModel.getCampaignFlow().setFlowState(AppConstant.PASSIVE_STATE);
            campaignDBModel.getCampaignFlow().setuDate(appUtils.getCurrentTimeStamp());
        }
        campaignDBModel.setuDate(appUtils.getCurrentTimeStamp());

        return campaignDBModel;
    }


}
