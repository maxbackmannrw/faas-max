package com.faas.core.base.repo.flow;

import com.faas.core.base.model.db.flow.FlowDBModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlowRepository extends PagingAndSortingRepository<FlowDBModel,Long> {

    boolean existsByClientIdAndCampaignIdAndFlowState(long clientId,String campaignId,String flowState);
    boolean existsByClientIdAndCampaignId(long clientId,String campaignId);
    List<FlowDBModel>findByStatus(int status);
    List<FlowDBModel>findBySessionId(long sessionId);
    List<FlowDBModel>findByIdAndClientId(long flowId, long clientId);
    List<FlowDBModel>findByFlowState(String flowState);
    List<FlowDBModel>findByCampaignIdAndFlowState(String campaignId, String flowState);
    List<FlowDBModel>findByCampaignIdAndAgentIdAndFlowState(String campaignId, long agentId, String flowState);
    List<FlowDBModel>findBySessionIdAndClientId(long sessionId, long clientId);
    Page<FlowDBModel>findAllByCampaignId(String campaignId, Pageable pageable);
    Page<FlowDBModel>findAllByFlowState(String flowState, Pageable pageable);
    Page<FlowDBModel>findAllByCampaignIdAndClientCityAndClientCountry(String campaignId,String clientCity,String clientCountry, Pageable pageable);

}
