package com.faas.core.base.framework.campaign.details.client.inquiry;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.user.content.UserDBModel;
import com.faas.core.base.model.ws.campaign.details.client.inquiry.CampaignInquirySessionRequest;
import com.faas.core.base.model.ws.campaign.details.client.inquiry.dto.CampaignInquirySessionRequestDTO;
import com.faas.core.base.model.ws.campaign.details.client.inquiry.dto.CampaignInquirySessionWSDTO;
import com.faas.core.base.model.ws.operation.details.content.dto.OperationInquirySessionWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.base.repo.user.content.UserRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.ActivityHelper;
import com.faas.core.utils.helpers.InquiryHelper;
import com.faas.core.utils.helpers.OperationHelper;
import com.faas.core.utils.helpers.SessionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class CampaignInquirySessionFramework {


    @Autowired
    InquiryHelper inquiryHelper;

    @Autowired
    ActivityHelper activityHelper;

    @Autowired
    SessionHelper sessionHelper;

    @Autowired
    OperationHelper operationHelper;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    AppUtils appUtils;


    public CampaignInquirySessionWSDTO searchCampaignInquirySessionsService(long userId, String campaignId, String city, String country, int reqPage, int reqSize) {

        Page<SessionDBModel> sessionDBModelPage = sessionRepository.findAllByCampaignIdAndClientCityAndClientCountry(campaignId,city,country, PageRequest.of(reqPage,reqSize));
        if (sessionDBModelPage != null){
            CampaignInquirySessionWSDTO campaignInquirySessionWSDTO = new CampaignInquirySessionWSDTO();
            campaignInquirySessionWSDTO.setInquirySessions(inquiryHelper.createInquirySessionWSDTOS(sessionDBModelPage.getContent()));
            campaignInquirySessionWSDTO.setPagination(inquiryHelper.createInquirySessionPagination(sessionDBModelPage));

            return campaignInquirySessionWSDTO;
        }
        return null;
    }

    public CampaignInquirySessionWSDTO getCampaignInquirySessionsService(long userId, String campaignId, int reqPage, int reqSize) {

        Page<SessionDBModel> sessionDBModelPage = sessionRepository.findAllByCampaignId(campaignId, PageRequest.of(reqPage,reqSize));
        if (sessionDBModelPage != null){
            CampaignInquirySessionWSDTO campaignInquirySessionWSDTO = new CampaignInquirySessionWSDTO();
            campaignInquirySessionWSDTO.setInquirySessions(inquiryHelper.createInquirySessionWSDTOS(sessionDBModelPage.getContent()));
            campaignInquirySessionWSDTO.setPagination(inquiryHelper.createInquirySessionPagination(sessionDBModelPage));

            return campaignInquirySessionWSDTO;
        }
        return null;
    }


    public OperationInquirySessionWSDTO getCampaignInquirySessionService(long userId, long sessionId) {

        Optional<SessionDBModel> sessionDBModel = sessionRepository.findById(sessionId);
        return sessionDBModel.map(dbModel -> inquiryHelper.createInquirySessionWSDTO(dbModel)).orElse(null);
    }

    public List<OperationInquirySessionWSDTO> createCampaignInquirySessionService(CampaignInquirySessionRequest inquirySessionRequest) {

        List<OperationInquirySessionWSDTO> operationInquirySessionWSDTOS = new ArrayList<>();
        for (int i = 0; i< inquirySessionRequest.getSessionRequests().size(); i++){
            OperationInquirySessionWSDTO operationInquirySessionWSDTO = createCampaignInquirySession(inquirySessionRequest.getSessionRequests().get(i));
            if (operationInquirySessionWSDTO != null){
                operationInquirySessionWSDTOS.add(operationInquirySessionWSDTO);
            }
        }
        return operationInquirySessionWSDTOS;
    }


    public OperationInquirySessionWSDTO createCampaignInquirySession(CampaignInquirySessionRequestDTO inquirySessionRequest) {

        return null;
    }


    public OperationInquirySessionWSDTO updateCampaignInquirySessionService(long userId, long sessionId, long agentId, String campaignId, String inquiryState) {

      /*  List<InquiryDBModel> inquiryDBModels = inquiryRepository.findByIdAndClientId(inquiryId,clientId);
        if (!inquiryDBModels.isEmpty()){
            inquiryDBModels.get(0).setInquiryState(inquiryState);
            inquiryDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
            return new InquiryWSDTO(inquiryRepository.save(inquiryDBModels.get(0)));
        }
       */
        return null;
    }


    public OperationInquirySessionWSDTO removeCampaignInquirySessionService(long userId, long sessionId) {

        Optional<SessionDBModel> sessionDBModel = sessionRepository.findById(sessionId);
        if (sessionDBModel.isPresent()) {
            OperationInquirySessionWSDTO inquirySessionWSDTO = inquiryHelper.createInquirySessionWSDTO(sessionDBModel.get());
            Optional<ClientDBModel> clientDBModel = clientRepository.findById(sessionDBModel.get().getClientId());
            if (clientDBModel.isPresent()) {
                clientDBModel.get().setClientState(AppConstant.READY_CLIENT);
                clientDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                clientRepository.save(clientDBModel.get());
            }
            List<OperationDBModel> operationDBModels = operationRepository.findBySessionId(sessionId);
            if (!operationDBModels.isEmpty()){
                operationRepository.delete(operationDBModels.get(0));
            }

            sessionRepository.delete(sessionDBModel.get());
            return inquirySessionWSDTO;
        }
        return null;
    }



}