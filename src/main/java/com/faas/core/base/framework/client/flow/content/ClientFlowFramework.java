package com.faas.core.base.framework.client.flow.content;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.client.flow.ClientFlowDBModel;
import com.faas.core.base.model.ws.campaign.content.dto.CampaignWSDTO;
import com.faas.core.base.model.ws.client.flow.dto.FlowCampaignWSDTO;
import com.faas.core.base.model.ws.client.flow.dto.ClientFlowWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.campaign.details.CampaignAgentRepository;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.client.flow.ClientFlowRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.client.session.SessionRepository;
import com.faas.core.base.repo.user.content.UserRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.FlowHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ClientFlowFramework {

    @Autowired
    FlowHelper flowHelper;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    CampaignAgentRepository campaignAgentRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ClientFlowRepository clientFlowRepository;

    @Autowired
    AppUtils appUtils;


    public List<FlowCampaignWSDTO> getFlowCampaignsService(long userId,int reqPage,int reqSize) {

        List<FlowCampaignWSDTO>flowCampaignWSDTOS = new ArrayList<>();
        List<CampaignDBModel> campaignDBModels = campaignRepository.findByCampaignCategory(AppConstant.AUTOMATIC_CAMPAIGN);
        if (campaignDBModels.size()>0){
            for (CampaignDBModel campaignDBModel : campaignDBModels) {

                FlowCampaignWSDTO flowCampaignWSDTO = new FlowCampaignWSDTO();
                flowCampaignWSDTO.setCampaign(new CampaignWSDTO(campaignDBModel));
            //    Page<FlowDBModel> flowModelPage = flowRepository.findAllByCampaignId(campaignDBModel.getId(), PageRequest.of(reqPage, reqSize));
            //    flowCampaignWSDTO.setPagination(flowHelper.createFlowPagination(flowModelPage));
           //     flowCampaignWSDTO.setFlows(flowHelper.createFlowWSDTOS(flowModelPage.getContent()));
                flowCampaignWSDTOS.add(flowCampaignWSDTO);
            }
        }
        return flowCampaignWSDTOS;
    }


    public FlowCampaignWSDTO getFlowCampaignService(long userId,String campaignId,int reqPage,int reqSize) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignDBModel.isPresent()){

            FlowCampaignWSDTO flowCampaignWSDTO = new FlowCampaignWSDTO();
            flowCampaignWSDTO.setCampaign(new CampaignWSDTO(campaignDBModel.get()));
        //    Page<FlowDBModel> flowModelPage = flowRepository.findAllByCampaignId(campaignId,PageRequest.of(reqPage,reqSize));
      //      flowCampaignWSDTO.setPagination(flowHelper.createFlowPagination(flowModelPage));
      //      flowCampaignWSDTO.setFlows(flowHelper.createFlowWSDTOS(flowModelPage.getContent()));

            return flowCampaignWSDTO;
        }
        return null;
    }



    public ClientFlowWSDTO getFlowService(long userId, long flowId, long clientId) {

     //   List<FlowDBModel> flowDBModels = flowRepository.findByIdAndClientId(flowId,clientId);
  //      if (flowDBModels.size()>0){
//            return new FlowWSDTO(flowDBModels.get(0));
//        }
        return null;
    }


    public List<ClientFlowWSDTO> getAllFlowsService(long userId, int reqPage, int reqSize) {

        List<ClientFlowWSDTO> clientFlowWSDTOS = new ArrayList<>();
        Page<ClientFlowDBModel> flowModelPage = clientFlowRepository.findAll(PageRequest.of(reqPage,reqSize));
        for (int i=0;i<flowModelPage.getContent().size();i++){
            clientFlowWSDTOS.add(new ClientFlowWSDTO(flowModelPage.getContent().get(i)));
        }
        return clientFlowWSDTOS;
    }


    public List<ClientFlowWSDTO> getFlowsByStateService(long userId, String flowState, int reqPage, int reqSize) {

        List<ClientFlowWSDTO> clientFlowWSDTOS = new ArrayList<>();
    //    Page<FlowDBModel> flowModelPage = flowRepository.findAllByFlowState(flowState,PageRequest.of(reqPage,reqSize));
   //     for (int i=0;i<flowModelPage.getContent().size();i++){
//            flowWSDTOS.add(new FlowWSDTO(flowModelPage.getContent().get(i)));
//        }
        return clientFlowWSDTOS;
    }


    public ClientFlowWSDTO createFlowService(long userId, long clientId, long agentId, String campaignId) {

        return null;
    }


    public ClientFlowWSDTO updateFlowService(long userId, long flowId, long clientId) {

     //   List<FlowDBModel> flowDBModels = flowRepository.findByIdAndClientId(flowId,clientId);
    //    if (flowDBModels.size()>0){
    //        return new FlowWSDTO(flowDBModels.get(0));
   //     }
        return null;
    }


    public ClientFlowWSDTO removeFlowService(long userId, long flowId, long clientId) {

  //      List<FlowDBModel> flowDBModels = flowRepository.findByIdAndClientId(flowId,clientId);
//        if (flowDBModels.size()>0){
 //           flowRepository.delete(flowDBModels.get(0));
 //           return new FlowWSDTO(flowDBModels.get(0));
 //       }
        return null;
    }


}