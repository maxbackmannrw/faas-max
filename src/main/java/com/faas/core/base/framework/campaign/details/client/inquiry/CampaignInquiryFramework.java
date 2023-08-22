package com.faas.core.base.framework.campaign.details.client.inquiry;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.inquiry.InquiryDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.model.db.user.content.UserDBModel;
import com.faas.core.base.model.ws.campaign.details.client.inquiry.dto.CampaignInquiryWSDTO;
import com.faas.core.base.model.ws.inquiry.InquiryRequest;
import com.faas.core.base.model.ws.inquiry.dto.InquiryRequestDTO;
import com.faas.core.base.model.ws.inquiry.dto.InquiryWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.inquiry.InquiryRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.base.repo.session.SessionRepository;
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
public class CampaignInquiryFramework {


    @Autowired
    ActivityHelper activityHelper;

    @Autowired
    InquiryHelper inquiryHelper;

    @Autowired
    SessionHelper sessionHelper;

    @Autowired
    OperationHelper operationHelper;

    @Autowired
    InquiryRepository inquiryRepository;

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


    public CampaignInquiryWSDTO searchCampaignInquiriesService(long userId, String campaignId,String clientCity,String clientCountry,int reqPage,int reqSize) {

        Page<InquiryDBModel> inquiryDBModelPage = inquiryRepository.findAllByCampaignIdAndClientCityAndClientCountry(campaignId,clientCity,clientCountry, PageRequest.of(reqPage,reqSize));
        if (inquiryDBModelPage != null){
            CampaignInquiryWSDTO campaignInquiryWSDTO = new CampaignInquiryWSDTO();
            campaignInquiryWSDTO.setPagination(inquiryHelper.createInquiryPagination(inquiryDBModelPage));
            campaignInquiryWSDTO.setInquiries(inquiryHelper.createInquiryWSDTOS(inquiryDBModelPage.getContent()));
            return campaignInquiryWSDTO;
        }
        return null;
    }


    public CampaignInquiryWSDTO getCampaignInquiriesService(long userId,String campaignId,int reqPage,int reqSize) {

        Page<InquiryDBModel> inquiryDBModelPage = inquiryRepository.findAllByCampaignId(campaignId, PageRequest.of(reqPage,reqSize));
        if (inquiryDBModelPage != null){

            CampaignInquiryWSDTO campaignInquiryWSDTO = new CampaignInquiryWSDTO();
            campaignInquiryWSDTO.setPagination(inquiryHelper.createInquiryPagination(inquiryDBModelPage));
            campaignInquiryWSDTO.setInquiries(inquiryHelper.createInquiryWSDTOS(inquiryDBModelPage.getContent()));

            return campaignInquiryWSDTO;
        }
        return null;
    }


    public InquiryWSDTO getCampaignInquiryService(long userId, long inquiryId, long clientId) {

        List<InquiryDBModel> inquiryDBModels = inquiryRepository.findByIdAndClientId(inquiryId,clientId);
        if (!inquiryDBModels.isEmpty()){
            return new InquiryWSDTO(inquiryDBModels.get(0));
        }
        return null;
    }


    public List<InquiryWSDTO> createCampaignInquiryService(InquiryRequest inquiryRequest) {

        List<InquiryWSDTO>inquiryWSDTOS = new ArrayList<>();
        for (int i=0;i<inquiryRequest.getInquiryRequests().size();i++){
            InquiryWSDTO inquiryWSDTO = createCampaignInquiry(inquiryRequest.getInquiryRequests().get(i));
            if (inquiryWSDTO != null){
                inquiryWSDTOS.add(inquiryWSDTO);
            }
        }
        return inquiryWSDTOS;
    }


    public InquiryWSDTO createCampaignInquiry(InquiryRequestDTO inquiryRequestDTO) {

        if (!inquiryRepository.existsByClientIdAndCampaignId(inquiryRequestDTO.getClientId(),inquiryRequestDTO.getCampaignId())){
            Optional<ClientDBModel> clientDBModel = clientRepository.findById(inquiryRequestDTO.getClientId());
            Optional<UserDBModel> agentDBModel = userRepository.findById(inquiryRequestDTO.getAgentId());
            Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(inquiryRequestDTO.getCampaignId());
            if (clientDBModel.isPresent() && agentDBModel.isPresent() && campaignDBModel.isPresent() ){

                clientDBModel.get().setClientState(AppConstant.BUSY_CLIENT);
                clientDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                clientRepository.save(clientDBModel.get());

                SessionDBModel sessionDBModel = sessionRepository.save(inquiryHelper.mapInquirySession(clientDBModel.get(),agentDBModel.get(),campaignDBModel.get()));
                OperationDBModel operationDBModel = operationRepository.save(inquiryHelper.mapInquiryOperation(sessionDBModel));

                activityHelper.createOperationActivity(sessionDBModel.getId(),operationDBModel.getId(),AppConstant.CREATE_SESSION_ACTIVITY,AppConstant.SESSION_ACTIVITY,String.valueOf(sessionDBModel.getAgentId()),AppConstant.USER_TYPE,String.valueOf(sessionDBModel.getId()),AppConstant.SESSION_TYPE);
                activityHelper.createOperationActivity(sessionDBModel.getId(),operationDBModel.getId(),AppConstant.CREATE_OPERATION_ACTIVITY,AppConstant.OPERATION_ACTIVITY,String.valueOf(sessionDBModel.getAgentId()),AppConstant.USER_TYPE,String.valueOf(sessionDBModel.getId()),AppConstant.OPERATION_TYPE);

                return new InquiryWSDTO(inquiryRepository.save(inquiryHelper.mapInquiryDBModel(sessionDBModel)));
            }
        }
        return null;
    }



    public InquiryWSDTO updateCampaignInquiryService(long userId, long inquiryId, long clientId, String inquiryState) {

        List<InquiryDBModel> inquiryDBModels = inquiryRepository.findByIdAndClientId(inquiryId,clientId);
        if (!inquiryDBModels.isEmpty()){
            inquiryDBModels.get(0).setInquiryState(inquiryState);
            inquiryDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
            return new InquiryWSDTO(inquiryRepository.save(inquiryDBModels.get(0)));
        }
        return null;
    }


    public InquiryWSDTO removeCampaignInquiryService(long userId, long inquiryId, long clientId) {

        List<InquiryDBModel> inquiryDBModels = inquiryRepository.findByIdAndClientId(inquiryId,clientId);
        if (!inquiryDBModels.isEmpty()) {
            inquiryRepository.delete(inquiryDBModels.get(0));
            Optional<SessionDBModel>sessionDBModel = sessionRepository.findById(inquiryDBModels.get(0).getSessionId());
            if(sessionDBModel.isPresent()){
                sessionRepository.delete(sessionDBModel.get());
                operationRepository.deleteAll(operationRepository.findBySessionIdAndClientId(sessionDBModel.get().getId(),clientId));
            }
            Optional<ClientDBModel> clientDBModel = clientRepository.findById(clientId);
            if (clientDBModel.isPresent()){
                clientDBModel.get().setClientState(AppConstant.READY_CLIENT);
                clientDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                clientRepository.save(clientDBModel.get());
            }
            return new InquiryWSDTO(inquiryDBModels.get(0));
        }
        return null;
    }


}
