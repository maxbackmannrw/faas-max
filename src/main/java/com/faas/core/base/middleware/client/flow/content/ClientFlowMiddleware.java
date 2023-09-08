package com.faas.core.base.middleware.client.flow.content;

import com.faas.core.base.framework.client.flow.content.ClientFlowFramework;
import com.faas.core.base.model.ws.client.flow.FlowCampaignWSModel;
import com.faas.core.base.model.ws.client.flow.FlowWSModel;
import com.faas.core.base.model.ws.client.flow.dto.FlowCampaignWSDTO;
import com.faas.core.base.model.ws.client.flow.dto.FlowWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ClientFlowMiddleware {


    @Autowired
    ClientFlowFramework clientFlowFramework;


    public FlowCampaignWSModel getFlowCampaigns(long userId,int reqPage,int reqSize) {

        FlowCampaignWSModel response = new FlowCampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<FlowCampaignWSDTO> flowCampaignWSDTOS = clientFlowFramework.getFlowCampaignsService(userId,reqPage,reqSize);
        if (flowCampaignWSDTOS != null){
            response.setFlowCampaigns(flowCampaignWSDTOS);
        }

        general.setOperation("getFlowCampaigns");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public FlowCampaignWSModel getFlowCampaign(long userId,String campaignId,int reqPage,int reqSize) {

        FlowCampaignWSModel response = new FlowCampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<FlowCampaignWSDTO>flowCampaignWSDTOS = new ArrayList<>();

        FlowCampaignWSDTO flowCampaignWSDTO = clientFlowFramework.getFlowCampaignService(userId,campaignId,reqPage,reqSize);
        if (flowCampaignWSDTO != null){
            flowCampaignWSDTOS.add(flowCampaignWSDTO);
        }

        response.setFlowCampaigns(flowCampaignWSDTOS);
        general.setOperation("getFlowCampaign");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public FlowWSModel getAllFlows(long userId, int reqPage, int reqSize) {

        FlowWSModel response = new FlowWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<FlowWSDTO> flowWSDTOS = clientFlowFramework.getAllFlowsService(userId,reqPage,reqSize);
        if (flowWSDTOS != null){
            response.setFlows(flowWSDTOS);
        }

        general.setOperation("getAllClientFlows");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public FlowWSModel getFlowsByState(long userId, String flowState, int reqPage, int reqSize) {

        FlowWSModel response = new FlowWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<FlowWSDTO> flowWSDTOS = clientFlowFramework.getFlowsByStateService(userId,flowState,reqPage,reqSize);
        if (flowWSDTOS != null){
            response.setFlows(flowWSDTOS);
        }

        general.setOperation("getFlowsByState");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public FlowWSModel getFlow(long userId, long flowId, long clientId) {

        FlowWSModel response = new FlowWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<FlowWSDTO> flowWSDTOS = new ArrayList<>();

        FlowWSDTO flowWSDTO = clientFlowFramework.getFlowService(userId,flowId,clientId);
        if (flowWSDTO != null){
            flowWSDTOS.add(flowWSDTO);
        }

        response.setFlows(flowWSDTOS);
        general.setOperation("getFlow");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public FlowWSModel createFlow(long userId,long clientId,long agentId, String campaignId) {

        FlowWSModel response = new FlowWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<FlowWSDTO> flowWSDTOS = new ArrayList<>();

        FlowWSDTO flowWSDTO = clientFlowFramework.createFlowService(userId,clientId,agentId,campaignId);
        if (flowWSDTO != null){
            flowWSDTOS.add(flowWSDTO);
        }

        response.setFlows(flowWSDTOS);
        general.setOperation("createFlow");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public FlowWSModel updateFlow(long userId, long flowId, long clientId) {

        FlowWSModel response = new FlowWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<FlowWSDTO> flowWSDTOS = new ArrayList<>();

        FlowWSDTO flowWSDTO = clientFlowFramework.updateFlowService(userId,flowId,clientId);
        if (flowWSDTO != null){
            flowWSDTOS.add(flowWSDTO);
        }

        response.setFlows(flowWSDTOS);
        general.setOperation("updateFlow");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public FlowWSModel removeFlow(long userId, long flowId, long clientId) {

        FlowWSModel response = new FlowWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<FlowWSDTO> flowWSDTOS = new ArrayList<>();

        FlowWSDTO flowWSDTO = clientFlowFramework.removeFlowService(userId,flowId,clientId);
        if (flowWSDTO != null){
            flowWSDTOS.add(flowWSDTO);
        }

        response.setFlows(flowWSDTOS);
        general.setOperation("removeFlow");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }
}
