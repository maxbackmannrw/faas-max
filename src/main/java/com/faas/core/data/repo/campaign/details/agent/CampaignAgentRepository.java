package com.faas.core.data.repo.campaign.details.agent;

import com.faas.core.data.db.campaign.details.agent.CampaignAgentDBModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampaignAgentRepository extends PagingAndSortingRepository<CampaignAgentDBModel, Long> {

    boolean existsByAgentIdAndCampaignId(long agentId, String campaignId);

    long countByAgentId(long agentId);

    long countByAgentIdAndAgentState(long agentId, String agentState);

    long countByCampaignId(String campaignId);

    List<CampaignAgentDBModel> findByAgentId(long agentId);

    List<CampaignAgentDBModel> findByCampaignId(String campaignId);

    List<CampaignAgentDBModel>findByAgentIdAndAgentState(long agentId, String agentState);

    List<CampaignAgentDBModel> findByAgentIdAndCampaignId(long agentId, String campaignId);

    List<CampaignAgentDBModel> findByCampaignIdAndAgentId(String campaignId, long agentId);

    List<CampaignAgentDBModel> findByCampaignIdAndAgentIdAndAgentState(String campaignId, long agentId, String agentState);

    List<CampaignAgentDBModel> findByStatus(int status);


}
