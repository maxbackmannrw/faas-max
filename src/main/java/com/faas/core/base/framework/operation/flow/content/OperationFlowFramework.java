package com.faas.core.base.framework.operation.flow.content;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.operation.flow.OperationFlowDBModel;
import com.faas.core.base.model.ws.campaign.content.dto.CampaignWSDTO;
import com.faas.core.base.model.ws.operation.flow.dto.OperationFlowCampaignWSDTO;
import com.faas.core.base.model.ws.operation.flow.dto.OperationFlowWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.campaign.details.CampaignAgentRepository;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.operation.flow.OperationFlowRepository;
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
public class OperationFlowFramework {

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
    OperationFlowRepository operationFlowRepository;

    @Autowired
    AppUtils appUtils;


    public List<OperationFlowCampaignWSDTO> getFlowCampaignsService(long userId, int reqPage, int reqSize) {

        List<OperationFlowCampaignWSDTO> operationFlowCampaignWSDTOS = new ArrayList<>();
        List<CampaignDBModel> campaignDBModels = campaignRepository.findByCampaignCategory(AppConstant.AUTOMATIC_CAMPAIGN);
        if (campaignDBModels.size()>0){
            for (CampaignDBModel campaignDBModel : campaignDBModels) {

                OperationFlowCampaignWSDTO operationFlowCampaignWSDTO = new OperationFlowCampaignWSDTO();
                operationFlowCampaignWSDTO.setCampaign(new CampaignWSDTO(campaignDBModel));
            //    Page<FlowDBModel> flowModelPage = flowRepository.findAllByCampaignId(campaignDBModel.getId(), PageRequest.of(reqPage, reqSize));
            //    flowCampaignWSDTO.setPagination(flowHelper.createFlowPagination(flowModelPage));
           //     flowCampaignWSDTO.setFlows(flowHelper.createFlowWSDTOS(flowModelPage.getContent()));
                operationFlowCampaignWSDTOS.add(operationFlowCampaignWSDTO);
            }
        }
        return operationFlowCampaignWSDTOS;
    }


    public OperationFlowCampaignWSDTO getFlowCampaignService(long userId, String campaignId, int reqPage, int reqSize) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignDBModel.isPresent()){

            OperationFlowCampaignWSDTO operationFlowCampaignWSDTO = new OperationFlowCampaignWSDTO();
            operationFlowCampaignWSDTO.setCampaign(new CampaignWSDTO(campaignDBModel.get()));
        //    Page<FlowDBModel> flowModelPage = flowRepository.findAllByCampaignId(campaignId,PageRequest.of(reqPage,reqSize));
      //      flowCampaignWSDTO.setPagination(flowHelper.createFlowPagination(flowModelPage));
      //      flowCampaignWSDTO.setFlows(flowHelper.createFlowWSDTOS(flowModelPage.getContent()));

            return operationFlowCampaignWSDTO;
        }
        return null;
    }



    public OperationFlowWSDTO getFlowService(long userId, long flowId, long clientId) {

     //   List<FlowDBModel> flowDBModels = flowRepository.findByIdAndClientId(flowId,clientId);
  //      if (flowDBModels.size()>0){
//            return new FlowWSDTO(flowDBModels.get(0));
//        }
        return null;
    }


    public List<OperationFlowWSDTO> getAllFlowsService(long userId, int reqPage, int reqSize) {

        List<OperationFlowWSDTO> operationFlowWSDTOS = new ArrayList<>();
        Page<OperationFlowDBModel> flowModelPage = operationFlowRepository.findAll(PageRequest.of(reqPage,reqSize));
        for (int i=0;i<flowModelPage.getContent().size();i++){
            operationFlowWSDTOS.add(new OperationFlowWSDTO(flowModelPage.getContent().get(i)));
        }
        return operationFlowWSDTOS;
    }


    public List<OperationFlowWSDTO> getFlowsByStateService(long userId, String flowState, int reqPage, int reqSize) {

        List<OperationFlowWSDTO> operationFlowWSDTOS = new ArrayList<>();
    //    Page<FlowDBModel> flowModelPage = flowRepository.findAllByFlowState(flowState,PageRequest.of(reqPage,reqSize));
   //     for (int i=0;i<flowModelPage.getContent().size();i++){
//            flowWSDTOS.add(new FlowWSDTO(flowModelPage.getContent().get(i)));
//        }
        return operationFlowWSDTOS;
    }


    public OperationFlowWSDTO createFlowService(long userId, long clientId, long agentId, String campaignId) {

        return null;
    }


    public OperationFlowWSDTO updateFlowService(long userId, long flowId, long clientId) {

     //   List<FlowDBModel> flowDBModels = flowRepository.findByIdAndClientId(flowId,clientId);
    //    if (flowDBModels.size()>0){
    //        return new FlowWSDTO(flowDBModels.get(0));
   //     }
        return null;
    }


    public OperationFlowWSDTO removeFlowService(long userId, long flowId, long clientId) {

  //      List<FlowDBModel> flowDBModels = flowRepository.findByIdAndClientId(flowId,clientId);
//        if (flowDBModels.size()>0){
 //           flowRepository.delete(flowDBModels.get(0));
 //           return new FlowWSDTO(flowDBModels.get(0));
 //       }
        return null;
    }


}
