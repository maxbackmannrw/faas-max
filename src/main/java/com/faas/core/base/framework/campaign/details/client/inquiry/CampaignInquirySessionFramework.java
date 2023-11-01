package com.faas.core.base.framework.campaign.details.client.inquiry;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.operation.details.inquiry.OperationInquiryDBModel;
import com.faas.core.base.model.db.client.session.SessionDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.user.content.UserDBModel;
import com.faas.core.base.model.ws.campaign.details.client.inquiry.CampaignInquirySessionRequest;
import com.faas.core.base.model.ws.campaign.details.client.inquiry.dto.CampaignInquirySessionRequestDTO;
import com.faas.core.base.model.ws.campaign.details.client.inquiry.dto.CampaignInquirySessionWSDTO;
import com.faas.core.base.model.ws.operation.inquiry.dto.OperationInquirySessionWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.operation.details.inquiry.OperationInquiryRepository;
import com.faas.core.base.repo.client.session.SessionRepository;
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
    OperationInquiryRepository operationInquiryRepository;

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

       if (!operationInquiryRepository.existsByClientIdAndCampaignId(inquirySessionRequest.getClientId(),inquirySessionRequest.getCampaignId())){

            Optional<ClientDBModel> clientDBModel = clientRepository.findById(inquirySessionRequest.getClientId());
            Optional<UserDBModel> agentDBModel = userRepository.findById(inquirySessionRequest.getAgentId());
            Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(inquirySessionRequest.getCampaignId());
            if (clientDBModel.isPresent() && clientDBModel.get().getClientState().equalsIgnoreCase(AppConstant.READY_CLIENT) && agentDBModel.isPresent() && campaignDBModel.isPresent() ){

                clientDBModel.get().setClientState(AppConstant.BUSY_CLIENT);
                clientDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                ClientDBModel updatedClient = clientRepository.save(clientDBModel.get());

                SessionDBModel sessionDBModel = sessionRepository.save(inquiryHelper.mapInquirySession(updatedClient,agentDBModel.get(),campaignDBModel.get()));
                OperationDBModel operationDBModel = operationRepository.save(inquiryHelper.mapInquiryOperation(sessionDBModel));
                operationInquiryRepository.save(inquiryHelper.mapOperationInquiryDBModel(sessionDBModel));

                activityHelper.createOperationActivity(sessionDBModel.getId(),operationDBModel.getId(),AppConstant.CREATE_SESSION_ACTIVITY,AppConstant.SESSION_ACTIVITY,String.valueOf(sessionDBModel.getAgentId()),AppConstant.USER_TYPE,String.valueOf(sessionDBModel.getId()),AppConstant.SESSION_TYPE);
                activityHelper.createOperationActivity(sessionDBModel.getId(),operationDBModel.getId(),AppConstant.CREATE_OPERATION_ACTIVITY,AppConstant.OPERATION_ACTIVITY,String.valueOf(sessionDBModel.getAgentId()),AppConstant.USER_TYPE,String.valueOf(sessionDBModel.getId()),AppConstant.OPERATION_TYPE);

                return inquiryHelper.createInquirySessionWSDTO(sessionDBModel);
            }
        }
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

        List<OperationInquiryDBModel> operationInquiryDBModels = operationInquiryRepository.findBySessionId(sessionId);
        Optional<SessionDBModel> sessionDBModel = sessionRepository.findById(sessionId);
        if (!operationInquiryDBModels.isEmpty() && sessionDBModel.isPresent()) {

            Optional<ClientDBModel> clientDBModel = clientRepository.findById(sessionDBModel.get().getClientId());
            if (clientDBModel.isPresent()) {
                clientDBModel.get().setClientState(AppConstant.READY_CLIENT);
                clientDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                clientRepository.save(clientDBModel.get());
            }

            OperationInquirySessionWSDTO deletedInquirySession = inquiryHelper.createInquirySessionWSDTO(sessionDBModel.get());
            sessionRepository.delete(sessionDBModel.get());
            operationRepository.deleteAll(operationRepository.findBySessionIdAndClientId(sessionDBModel.get().getId(), sessionDBModel.get().getClientId()));
            operationInquiryRepository.deleteAll(operationInquiryDBModels);

            return deletedInquirySession;
        }
        return null;
    }


}