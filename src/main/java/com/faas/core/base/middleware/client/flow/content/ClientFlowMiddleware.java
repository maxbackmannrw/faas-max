package com.faas.core.base.middleware.client.flow.content;

import com.faas.core.base.framework.client.flow.content.ClientFlowFramework;
import com.faas.core.base.model.ws.client.flow.FlowCampaignWSModel;
import com.faas.core.base.model.ws.client.flow.ClientFlowWSModel;
import com.faas.core.base.model.ws.client.flow.dto.FlowCampaignWSDTO;
import com.faas.core.base.model.ws.client.flow.dto.ClientFlowWSDTO;
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


    public ClientFlowWSModel getAllFlows(long userId, int reqPage, int reqSize) {

        ClientFlowWSModel response = new ClientFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ClientFlowWSDTO> clientFlowWSDTOS = clientFlowFramework.getAllFlowsService(userId,reqPage,reqSize);
        if (clientFlowWSDTOS != null){
            response.setClientFlows(clientFlowWSDTOS);
        }

        general.setOperation("getAllClientFlows");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientFlowWSModel getFlowsByState(long userId, String flowState, int reqPage, int reqSize) {

        ClientFlowWSModel response = new ClientFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ClientFlowWSDTO> clientFlowWSDTOS = clientFlowFramework.getFlowsByStateService(userId,flowState,reqPage,reqSize);
        if (clientFlowWSDTOS != null){
            response.setClientFlows(clientFlowWSDTOS);
        }

        general.setOperation("getFlowsByState");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientFlowWSModel getFlow(long userId, long flowId, long clientId) {

        ClientFlowWSModel response = new ClientFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientFlowWSDTO> clientFlowWSDTOS = new ArrayList<>();

        ClientFlowWSDTO clientFlowWSDTO = clientFlowFramework.getFlowService(userId,flowId,clientId);
        if (clientFlowWSDTO != null){
            clientFlowWSDTOS.add(clientFlowWSDTO);
        }

        response.setClientFlows(clientFlowWSDTOS);
        general.setOperation("getFlow");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientFlowWSModel createFlow(long userId, long clientId, long agentId, String campaignId) {

        ClientFlowWSModel response = new ClientFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientFlowWSDTO> clientFlowWSDTOS = new ArrayList<>();

        ClientFlowWSDTO clientFlowWSDTO = clientFlowFramework.createFlowService(userId,clientId,agentId,campaignId);
        if (clientFlowWSDTO != null){
            clientFlowWSDTOS.add(clientFlowWSDTO);
        }

        response.setClientFlows(clientFlowWSDTOS);
        general.setOperation("createFlow");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientFlowWSModel updateFlow(long userId, long flowId, long clientId) {

        ClientFlowWSModel response = new ClientFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientFlowWSDTO> clientFlowWSDTOS = new ArrayList<>();

        ClientFlowWSDTO clientFlowWSDTO = clientFlowFramework.updateFlowService(userId,flowId,clientId);
        if (clientFlowWSDTO != null){
            clientFlowWSDTOS.add(clientFlowWSDTO);
        }

        response.setClientFlows(clientFlowWSDTOS);
        general.setOperation("updateFlow");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientFlowWSModel removeFlow(long userId, long flowId, long clientId) {

        ClientFlowWSModel response = new ClientFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientFlowWSDTO> clientFlowWSDTOS = new ArrayList<>();

        ClientFlowWSDTO clientFlowWSDTO = clientFlowFramework.removeFlowService(userId,flowId,clientId);
        if (clientFlowWSDTO != null){
            clientFlowWSDTOS.add(clientFlowWSDTO);
        }

        response.setClientFlows(clientFlowWSDTOS);
        general.setOperation("removeFlow");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
