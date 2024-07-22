package com.faas.core.utility.helpers.campaign;

import com.faas.core.api.model.ws.campaign.content.dto.ApiAgentCampaignSummary;
import com.faas.core.api.model.ws.campaign.content.dto.ApiCampaignWSDTO;
import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.campaign.content.dao.CampaignFlowDAO;
import com.faas.core.base.model.db.campaign.content.dao.CampaignInquiryDAO;
import com.faas.core.base.model.db.campaign.details.agent.CampaignAgentDBModel;
import com.faas.core.base.model.db.campaign.details.channel.CampaignChannelDBModel;
import com.faas.core.base.model.db.campaign.details.temp.EmailTempDBModel;
import com.faas.core.base.model.db.campaign.details.temp.PushTempDBModel;
import com.faas.core.base.model.db.campaign.details.temp.SmsTempDBModel;
import com.faas.core.base.model.db.campaign.details.temp.WappMessageTempDBModel;
import com.faas.core.base.model.db.campaign.details.remote.CampaignRemoteDBModel;
import com.faas.core.base.model.db.campaign.details.scenario.CampaignScenarioDBModel;
import com.faas.core.base.model.db.campaign.details.trigger.*;
import com.faas.core.base.model.db.user.content.UserDBModel;
import com.faas.core.base.model.ws.campaign.content.dto.CampaignWSDTO;
import com.faas.core.base.model.ws.campaign.details.agent.dto.CampaignAgentWSDTO;
import com.faas.core.base.model.ws.campaign.details.channel.dto.*;
import com.faas.core.base.model.ws.campaign.details.temp.content.dto.CampaignTempWSDTO;
import com.faas.core.base.model.ws.campaign.details.temp.details.dto.CampaignEmailTempWSDTO;
import com.faas.core.base.model.ws.campaign.details.temp.details.dto.CampaignPushTempWSDTO;
import com.faas.core.base.model.ws.campaign.details.temp.details.dto.CampaignSmsTempWSDTO;
import com.faas.core.base.model.ws.campaign.details.temp.details.dto.CampaignWappMessageTempWSDTO;
import com.faas.core.base.model.ws.campaign.details.content.dto.CampaignDetailsWSDTO;
import com.faas.core.base.model.ws.campaign.details.remote.dto.CampaignRemoteWSDTO;
import com.faas.core.base.model.ws.campaign.details.scenario.dto.CampaignScenarioWSDTO;
import com.faas.core.base.model.ws.campaign.details.trigger.content.dto.CampaignTriggerWSDTO;
import com.faas.core.base.model.ws.campaign.details.trigger.details.dto.CampaignEmailTriggerWSDTO;
import com.faas.core.base.model.ws.campaign.details.trigger.details.dto.CampaignSipTriggerWSDTO;
import com.faas.core.base.model.ws.campaign.details.trigger.details.dto.CampaignSmsTriggerWSDTO;
import com.faas.core.base.model.ws.campaign.details.trigger.details.dto.CampaignWappCallTriggerWSDTO;
import com.faas.core.base.model.ws.campaign.details.trigger.details.dto.CampaignWappMessageTriggerWSDTO;
import com.faas.core.base.repo.campaign.details.agent.CampaignAgentRepository;
import com.faas.core.base.repo.campaign.details.channel.CampaignChannelRepository;
import com.faas.core.base.repo.campaign.details.temp.EmailTempRepository;
import com.faas.core.base.repo.campaign.details.temp.PushTempRepository;
import com.faas.core.base.repo.campaign.details.temp.SmsTempRepository;
import com.faas.core.base.repo.campaign.details.temp.WappMessageTempRepository;
import com.faas.core.base.repo.campaign.details.remote.CampaignRemoteRepository;
import com.faas.core.base.repo.campaign.details.scenario.CampaignScenarioRepository;
import com.faas.core.base.repo.campaign.details.trigger.*;
import com.faas.core.base.repo.scenario.content.ScenarioRepository;
import com.faas.core.base.repo.user.content.UserRepository;
import com.faas.core.base.repo.utils.UrlRepository;
import com.faas.core.utility.config.AppConstant;
import com.faas.core.utility.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class CampaignHelpers {


    @Autowired
    UserRepository userRepository;

    @Autowired
    ScenarioRepository scenarioRepository;

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
    CampaignScenarioRepository campaignScenarioRepository;

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
    UrlRepository urlRepository;

    @Autowired
    AppUtils appUtils;


    public CampaignWSDTO getCampaignWSDTO(CampaignDBModel campaignDBModel) {

        CampaignWSDTO campaignWSDTO = new CampaignWSDTO();
        campaignWSDTO.setCampaign(campaignDBModel);
        return campaignWSDTO;
    }


    public CampaignDetailsWSDTO createCampaignDetailsWSDTO(CampaignDBModel campaignDBModel) {

        CampaignDetailsWSDTO campaignDetailsWSDTO = new CampaignDetailsWSDTO();
        campaignDetailsWSDTO.setCampaign(campaignDBModel);
        campaignDetailsWSDTO.setCampaignAgents(createCampaignAgentWSDTOS(campaignDBModel.getId()));
        campaignDetailsWSDTO.setCampaignTemp(createCampaignTempWSDTO(campaignDBModel.getId()));
        campaignDetailsWSDTO.setCampaignChannel(createCampaignChannelWSDTO(campaignDBModel.getId()));
        campaignDetailsWSDTO.setCampaignTrigger(createCampaignTriggerWSDTO(campaignDBModel.getId()));
        campaignDetailsWSDTO.setCampaignScenarios(createCampaignScenarioWSDTOS(campaignDBModel));
        campaignDetailsWSDTO.setCampaignRemotes(createCampaignRemoteWSDTOS(campaignDBModel));

        return campaignDetailsWSDTO;
    }


    public CampaignInquiryDAO createCampaignInquiryDAO(String campaignInquiry){

        CampaignInquiryDAO campaignInquiryDAO = new CampaignInquiryDAO();
        campaignInquiryDAO.setInquiryId(appUtils.generateUUID());
        campaignInquiryDAO.setCampaignInquiry(campaignInquiry);
        campaignInquiryDAO.setInquiryDatas(new ArrayList<>());
        campaignInquiryDAO.setuDate(appUtils.getCurrentTimeStamp());
        campaignInquiryDAO.setcDate(appUtils.getCurrentTimeStamp());
        campaignInquiryDAO.setStatus(1);

        return campaignInquiryDAO;
    }

    public CampaignFlowDAO createCampaignFlowDAO(String campaignFlow){

        CampaignFlowDAO campaignFlowDAO = new CampaignFlowDAO();
        campaignFlowDAO.setFlowId(appUtils.generateUUID());
        campaignFlowDAO.setCampaignFlow(campaignFlow);
        campaignFlowDAO.setFlowDatas(new ArrayList<>());
        campaignFlowDAO.setuDate(appUtils.getCurrentTimeStamp());
        campaignFlowDAO.setcDate(appUtils.getCurrentTimeStamp());
        campaignFlowDAO.setStatus(1);

        return campaignFlowDAO;
    }


    public CampaignTriggerWSDTO createCampaignTriggerWSDTO(String campaignId){

        CampaignTriggerWSDTO campaignTriggerWSDTO = new CampaignTriggerWSDTO();
        campaignTriggerWSDTO.setCampaignEmailTriggers(createCampaignEmailTriggerWSDTOS(campaignId));
        campaignTriggerWSDTO.setCampaignSipTriggers(createCampaignSipTriggerWSDTOS(campaignId));
        campaignTriggerWSDTO.setCampaignSmsTriggers(createCampaignSmsTriggerWSDTOS(campaignId));
        campaignTriggerWSDTO.setCampaignWappCallTriggers(createCampaignWappCallTriggerWSDTOS(campaignId));
        campaignTriggerWSDTO.setCampaignWappMessageTriggers(createCampaignWappMessageTriggerWSDTOS(campaignId));

        return campaignTriggerWSDTO;
    }


    public List<CampaignEmailTriggerWSDTO> createCampaignEmailTriggerWSDTOS(String campaignId) {

        List<CampaignEmailTriggerWSDTO> campaignEmailTriggerWSDTOS = new ArrayList<>();
        List<EmailTriggerDBModel> emailTriggerDBModels = emailTriggerRepository.findByCampaignId(campaignId);
        for (EmailTriggerDBModel emailTriggerDBModel : emailTriggerDBModels) {
            campaignEmailTriggerWSDTOS.add(new CampaignEmailTriggerWSDTO(emailTriggerDBModel));
        }
        return campaignEmailTriggerWSDTOS;
    }

    public List<CampaignSipTriggerWSDTO> createCampaignSipTriggerWSDTOS(String campaignId) {

        List<CampaignSipTriggerWSDTO> campaignSipTriggerWSDTOS = new ArrayList<>();
        List<SipTriggerDBModel> sipTriggerDBModels = sipTriggerRepository.findByCampaignId(campaignId);
        for (SipTriggerDBModel sipTriggerDBModel : sipTriggerDBModels) {
            campaignSipTriggerWSDTOS.add(new CampaignSipTriggerWSDTO(sipTriggerDBModel));
        }
        return campaignSipTriggerWSDTOS;
    }

    public List<CampaignSmsTriggerWSDTO> createCampaignSmsTriggerWSDTOS(String campaignId) {

        List<CampaignSmsTriggerWSDTO> campaignSmsTriggerWSDTOS = new ArrayList<>();
        List<SmsTriggerDBModel> smsTriggerDBModels = smsTriggerRepository.findByCampaignId(campaignId);
        for (SmsTriggerDBModel smsTriggerDBModel : smsTriggerDBModels) {
            campaignSmsTriggerWSDTOS.add(new CampaignSmsTriggerWSDTO(smsTriggerDBModel));
        }
        return campaignSmsTriggerWSDTOS;
    }

    public List<CampaignWappCallTriggerWSDTO> createCampaignWappCallTriggerWSDTOS(String campaignId) {

        List<CampaignWappCallTriggerWSDTO> campaignWappCallTriggerWSDTOS = new ArrayList<>();
        List<WappCallTriggerDBModel> wappCallTriggerDBModels = wappCallTriggerRepository.findByCampaignId(campaignId);
        for (WappCallTriggerDBModel wappCallTriggerDBModel : wappCallTriggerDBModels) {
            campaignWappCallTriggerWSDTOS.add(new CampaignWappCallTriggerWSDTO(wappCallTriggerDBModel));
        }
        return campaignWappCallTriggerWSDTOS;
    }

    public List<CampaignWappMessageTriggerWSDTO> createCampaignWappMessageTriggerWSDTOS(String campaignId) {

        List<CampaignWappMessageTriggerWSDTO> campaignWappMessageTriggerWSDTOS = new ArrayList<>();
        List<WappMessageTriggerDBModel> wappMessageTriggerDBModels = wappMessageTriggerRepository.findByCampaignId(campaignId);
        for (WappMessageTriggerDBModel wappMessageTriggerDBModel : wappMessageTriggerDBModels) {
            campaignWappMessageTriggerWSDTOS.add(new CampaignWappMessageTriggerWSDTO(wappMessageTriggerDBModel));
        }
        return campaignWappMessageTriggerWSDTOS;
    }



    public List<CampaignScenarioWSDTO> createCampaignScenarioWSDTOS(CampaignDBModel campaignDBModel){

        List<CampaignScenarioWSDTO> campaignScenarioWSDTOS = new ArrayList<>();
        List<CampaignScenarioDBModel> campaignScenarioDBModels = campaignScenarioRepository.findByCampaignId(campaignDBModel.getId());
        for (CampaignScenarioDBModel campaignScenarioDBModel : campaignScenarioDBModels) {
            campaignScenarioWSDTOS.add(new CampaignScenarioWSDTO(campaignScenarioDBModel));
        }
        return campaignScenarioWSDTOS;
    }


    public List<CampaignRemoteWSDTO> createCampaignRemoteWSDTOS(CampaignDBModel campaignDBModel){

        List<CampaignRemoteWSDTO> campaignRemoteWSDTOS = new ArrayList<>();
        List<CampaignRemoteDBModel> campaignRemoteDBModels = campaignRemoteRepository.findByCampaignId(campaignDBModel.getId());
        for (CampaignRemoteDBModel campaignRemoteDBModel : campaignRemoteDBModels) {
            campaignRemoteWSDTOS.add(createCampaignRemoteWSDTO(campaignRemoteDBModel));
        }
        return campaignRemoteWSDTOS;
    }

    public CampaignRemoteWSDTO createCampaignRemoteWSDTO(CampaignRemoteDBModel campaignRemoteDBModel){

        CampaignRemoteWSDTO campaignRemoteWSDTO = new CampaignRemoteWSDTO();
        campaignRemoteWSDTO.setCampaignRemote(campaignRemoteDBModel);
        campaignRemoteWSDTO.setRemoteUrls(urlRepository.findByBaseTypeAndOwnerId(AppConstant.REMOTE_URL, campaignRemoteDBModel.getRemoteId()));

        return campaignRemoteWSDTO;
    }


    public List<CampaignAgentWSDTO> createCampaignAgentWSDTOS(String campaignId){

        List<CampaignAgentWSDTO> campaignAgentWSDTOS = new ArrayList<>();
        List<CampaignAgentDBModel> campaignAgentDBModels = campaignAgentRepository.findByCampaignId(campaignId);
        for (CampaignAgentDBModel campaignAgentDBModel : campaignAgentDBModels) {
            Optional<UserDBModel> userDBModel = userRepository.findById(campaignAgentDBModel.getAgentId());
            if (userDBModel.isPresent()){
                campaignAgentWSDTOS.add(new CampaignAgentWSDTO(userDBModel.get()));
            }
        }
        return campaignAgentWSDTOS;
    }


    public CampaignTempWSDTO createCampaignTempWSDTO(String campaignId){

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

        List<SmsTempDBModel>smsTempDBModels = smsTempRepository.findByCampaignId(campaignId);
        List<CampaignSmsTempWSDTO> campaignSmsTempWSDTOS = new ArrayList<>();
        for (SmsTempDBModel smsTempDBModel : smsTempDBModels) {
            campaignSmsTempWSDTOS.add(new CampaignSmsTempWSDTO(smsTempDBModel));
        }
        campaignTempWSDTO.setCampaignSmsTemps(campaignSmsTempWSDTOS);

        List<WappMessageTempDBModel>wappMessageTempDBModels = wappMessageTempRepository.findByCampaignId(campaignId);
        List<CampaignWappMessageTempWSDTO> campaignWappMessageTempWSDTOS = new ArrayList<>();
        for (WappMessageTempDBModel wappMessageTempDBModel : wappMessageTempDBModels) {
            campaignWappMessageTempWSDTOS.add(new CampaignWappMessageTempWSDTO(wappMessageTempDBModel));
        }
        campaignTempWSDTO.setCampaignWappMessageTemps(campaignWappMessageTempWSDTOS);

        return campaignTempWSDTO;
    }


    public CampaignChannelWSDTO createCampaignChannelWSDTO(String campaignId){

        CampaignChannelWSDTO campaignChannelWSDTO = new CampaignChannelWSDTO();
        List<CampaignChannelDBModel> campaignChannelDBModels = campaignChannelRepository.findByCampaignId(campaignId);
        if (!campaignChannelDBModels.isEmpty()){
            if (campaignChannelDBModels.get(0).getSipChannel() != null){
                campaignChannelWSDTO.setSipChannel(new CampaignSipChannelWSDTO(campaignChannelDBModels.get(0).getSipChannel()));
            }
            if (campaignChannelDBModels.get(0).getSmsChannel() != null){
                campaignChannelWSDTO.setSmsChannel(new CampaignSmsChannelWSDTO(campaignChannelDBModels.get(0).getSmsChannel()));
            }
            if (campaignChannelDBModels.get(0).getWappChannel() != null){
                campaignChannelWSDTO.setWappChannel(new CampaignWappChannelWSDTO(campaignChannelDBModels.get(0).getWappChannel()));
            }
            if (campaignChannelDBModels.get(0).getEmailChannel() != null){
                campaignChannelWSDTO.setEmailChannel(new CampaignEmailChannelWSDTO(campaignChannelDBModels.get(0).getEmailChannel()));
            }
            if (campaignChannelDBModels.get(0).getPushChannel() != null){
                campaignChannelWSDTO.setPushChannel(new CampaignPushChannelWSDTO(campaignChannelDBModels.get(0).getPushChannel()));
            }
        }
        return campaignChannelWSDTO;
    }


    public List<CampaignAgentWSDTO> mapCampaignAgentWSDTOS(List<CampaignAgentDBModel> agentDBModels) {

        List<CampaignAgentWSDTO>campaignAgentWSDTOS = new ArrayList<>();
        for (CampaignAgentDBModel agentDBModel : agentDBModels) {
            CampaignAgentWSDTO campaignAgentWSDTO = mapCampaignAgentWSDTO(agentDBModel);
            if (campaignAgentWSDTO != null) {
                campaignAgentWSDTOS.add(campaignAgentWSDTO);
            }
        }
        return campaignAgentWSDTOS;
    }

    public CampaignAgentWSDTO mapCampaignAgentWSDTO(UserDBModel agentDBModel) {

        CampaignAgentWSDTO campaignAgentWSDTO = new CampaignAgentWSDTO();
        campaignAgentWSDTO.setCampaignAgent(agentDBModel);
        return campaignAgentWSDTO;
    }


    public CampaignAgentWSDTO mapCampaignAgentWSDTO(CampaignAgentDBModel agentDBModels) {

        Optional<UserDBModel> agentDBModel = userRepository.findById(agentDBModels.getAgentId());
        if (agentDBModel.isPresent()){
            agentDBModel.get().setPassword("");
        }
        return null;
    }





    public ApiCampaignWSDTO getApiCampaignWSDTO(long agentId, CampaignDBModel campaignDBModel){

        ApiCampaignWSDTO campaignWSDTO = new ApiCampaignWSDTO();
        campaignWSDTO.setCampaign(campaignDBModel);
        campaignWSDTO.setCampaignSummary(getApiAgentCampaignSummary(agentId, campaignDBModel.getId()));

        return campaignWSDTO;
    }

    public ApiAgentCampaignSummary getApiAgentCampaignSummary(long agentId, String campaignId){

        ApiAgentCampaignSummary agentCampaignSummary = new ApiAgentCampaignSummary();

        return agentCampaignSummary;
    }

    public CampaignChannelDBModel createCampaignChannelDBModel(CampaignDBModel campaignDBModel){

        List<CampaignChannelDBModel> campaignChannelDBModels = campaignChannelRepository.findByCampaignId(campaignDBModel.getId());
        if (!campaignChannelDBModels.isEmpty()){
            campaignChannelRepository.deleteAll(campaignChannelDBModels);
        }

        CampaignChannelDBModel campaignChannelDBModel = new CampaignChannelDBModel();
        campaignChannelDBModel.setCampaignId(campaignDBModel.getId());
        campaignChannelDBModel.setuDate(appUtils.getCurrentTimeStamp());
        campaignChannelDBModel.setcDate(appUtils.getCurrentTimeStamp());
        campaignChannelDBModel.setStatus(1);

        return campaignChannelRepository.save(campaignChannelDBModel);
    }


}
