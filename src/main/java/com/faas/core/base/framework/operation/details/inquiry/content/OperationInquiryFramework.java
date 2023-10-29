package com.faas.core.base.framework.operation.details.inquiry.content;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.operation.inquiry.OperationInquiryDBModel;
import com.faas.core.base.model.ws.campaign.content.dto.CampaignWSDTO;
import com.faas.core.base.model.ws.operation.inquiry.dto.OperationInquiryCampaignWSDTO;
import com.faas.core.base.model.ws.operation.inquiry.dto.OperationInquiryWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.operation.inquiry.OperationInquiryRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.InquiryHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class OperationInquiryFramework {


    @Autowired
    InquiryHelper inquiryHelper;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    OperationInquiryRepository operationInquiryRepository;

    @Autowired
    AppUtils appUtils;


    public List<OperationInquiryCampaignWSDTO> getInquiryCampaignsService(long userId, int reqPage, int reqSize) {

        List<OperationInquiryCampaignWSDTO> operationInquiryCampaignWSDTOS = new ArrayList<>();
        List<CampaignDBModel> campaignDBModels = campaignRepository.findByCampaignCategory(AppConstant.INQUIRY_CAMPAIGN);
        for (CampaignDBModel campaignDBModel : campaignDBModels) {

            OperationInquiryCampaignWSDTO operationInquiryCampaignWSDTO = new OperationInquiryCampaignWSDTO();
            operationInquiryCampaignWSDTO.setCampaign(new CampaignWSDTO(campaignDBModel));
     //       Page<InquiryDBModel> clientInquiryModelPage = inquiryRepository.findAllByCampaignId(campaignDBModel.getId(), PageRequest.of(reqPage, reqSize));
     //       inquiryCampaignWSDTO.setInquiries(inquiryHelper.createInquiryWSDTOS(clientInquiryModelPage.getContent()));
     //       inquiryCampaignWSDTO.setPagination(inquiryHelper.createInquiryPagination(clientInquiryModelPage));

            operationInquiryCampaignWSDTOS.add(operationInquiryCampaignWSDTO);
        }
        return operationInquiryCampaignWSDTOS;
    }


    public OperationInquiryCampaignWSDTO getInquiryCampaignService(long userId, String campaignId, int reqPage, int reqSize) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignDBModel.isPresent()){

            OperationInquiryCampaignWSDTO operationInquiryCampaignWSDTO = new OperationInquiryCampaignWSDTO();
            operationInquiryCampaignWSDTO.setCampaign(new CampaignWSDTO(campaignDBModel.get()));
   //         Page<InquiryDBModel> clientInquiryModelPage = inquiryRepository.findAllByCampaignId(campaignDBModel.get().getId(), PageRequest.of(reqPage, reqSize));
   //         inquiryCampaignWSDTO.setPagination(inquiryHelper.createInquiryPagination(clientInquiryModelPage));
  //          inquiryCampaignWSDTO.setInquiries(inquiryHelper.createInquiryWSDTOS(clientInquiryModelPage.getContent()));

            return operationInquiryCampaignWSDTO;
        }
        return null;
    }


    public List<OperationInquiryWSDTO> getAllInquiriesService(long userId, int reqPage, int reqSize) {

        List<OperationInquiryWSDTO> operationInquiryWSDTOS = new ArrayList<>();
        Page<OperationInquiryDBModel> inquiryModelPage = operationInquiryRepository.findAll(PageRequest.of(reqPage,reqSize));
        for (int i=0;i<inquiryModelPage.getContent().size();i++){
            operationInquiryWSDTOS.add(new OperationInquiryWSDTO(inquiryModelPage.getContent().get(i)));
        }
        return operationInquiryWSDTOS;
    }


    public List<OperationInquiryWSDTO> getInquiriesByStateService(long userId, String inquiryState, int reqPage, int reqSize) {

        List<OperationInquiryWSDTO> operationInquiryWSDTOS = new ArrayList<>();
    //    Page<InquiryDBModel> inquiryModelPage = inquiryRepository.findAllByInquiryState(inquiryState,PageRequest.of(reqPage,reqSize));
   //     for (int i=0;i<inquiryModelPage.getContent().size();i++){
  //          inquiryWSDTOS.add(new InquiryWSDTO(inquiryModelPage.getContent().get(i)));
 //       }
        return operationInquiryWSDTOS;
    }


    public OperationInquiryWSDTO getInquiryService(long userId, long inquiryId, long clientId) {

  //      List<InquiryDBModel> inquiryDBModels = inquiryRepository.findByIdAndClientId(inquiryId,clientId);
  //      if (inquiryDBModels.size()>0){
  //          return new InquiryWSDTO(inquiryDBModels.get(0));
  //      }
        return null;
    }


    public OperationInquiryWSDTO createInquiryService(long userId, long clientId, long agentId, String campaignId) {

   //     if (!(inquiryRepository.existsByClientIdAndCampaignId(clientId,campaignId))){
   //         Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
   //         Optional<ClientDBModel> clientDBModel = clientRepository.findById(clientId);
   //         if (campaignDBModel.isPresent() && clientDBModel.isPresent()){
    //            InquiryDBModel inquiryDBModel = inquiryHelper.mapInquiryDBModel(null);
    //            if (inquiryDBModel != null){
    //                return new InquiryWSDTO(inquiryRepository.save(inquiryDBModel));
    //            }
    //        }
   //     }
        return null;
    }


    public OperationInquiryWSDTO updateInquiryService(long userId, long inquiryId, long clientId) {

   //     List<InquiryDBModel> inquiryDBModels = inquiryRepository.findByIdAndClientId(inquiryId,clientId);
  //      if (inquiryDBModels.size()>0){
  //          return new InquiryWSDTO(inquiryDBModels.get(0));
 //       }
        return null;
    }


    public OperationInquiryWSDTO removeInquiryService(long userId, long inquiryId, long clientId) {

    //    List<InquiryDBModel> inquiryDBModels = inquiryRepository.findByIdAndClientId(inquiryId,clientId);
 //       if (inquiryDBModels.size()>0){
 //           inquiryRepository.delete(inquiryDBModels.get(0));
//            return new InquiryWSDTO(inquiryDBModels.get(0));
//        }
        return null;
    }

}
