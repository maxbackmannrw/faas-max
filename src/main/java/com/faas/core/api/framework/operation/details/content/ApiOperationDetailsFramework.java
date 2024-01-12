package com.faas.core.api.framework.operation.details.content;

import com.faas.core.api.model.ws.campaign.details.dto.ApiCampaignDetailsWSDTO;
import com.faas.core.api.model.ws.general.ApiSummaryWSDTO;
import com.faas.core.api.model.ws.operation.details.content.dto.ApiOperationCampaignWSDTO;
import com.faas.core.api.model.ws.operation.details.content.dto.ApiOperationDetailsWSDTO;
import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.OperationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class ApiOperationDetailsFramework {

    @Autowired
    OperationHelper operationHelper;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    AppUtils appUtils;


    public ApiOperationDetailsWSDTO apiGetOperationDetailsService(long agentId, long sessionId, long clientId, String campaignId, String processId, String operationId) {

        List<OperationDBModel> operationDBModels = operationRepository.findBySessionId(sessionId);
        List<SessionDBModel> sessionDBModels = sessionRepository.findByIdAndClientId(sessionId, clientId);
        Optional<ClientDBModel> clientDBModel = clientRepository.findById(clientId);
        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);
        if (clientDBModel.isPresent() && campaignDBModel.isPresent() && processDBModel.isPresent()) {
            return operationHelper.mapApiOperationDetailsWSDTO(sessionDBModels.get(0), clientDBModel.get(), operationDBModels.get(0), campaignDBModel.get(), processDBModel.get());
        }
        return null;
    }

    public ApiCampaignDetailsWSDTO apiGetOperationCampaignService(long sessionId, long clientId, String campaignId, String processId) {

        List<CampaignDBModel> campaignDBModels = campaignRepository.findByIdAndStatus(campaignId,1);
        List<ProcessDBModel> processDBModels = processRepository.findByIdAndStatus(processId,1);
        if (!campaignDBModels.isEmpty() && !processDBModels.isEmpty()){

            ApiOperationCampaignWSDTO campaignWSDTO = new ApiOperationCampaignWSDTO();
            campaignWSDTO.setOperationCampaign(campaignDBModels.get(0));
            campaignWSDTO.setOperationProcess(processDBModels.get(0));

        }
        return null;
    }

    public List<ApiSummaryWSDTO> apiGetOperationSummaryService(long agentId) {
        return operationHelper.getApiOperationSummary(agentId);
    }


}
