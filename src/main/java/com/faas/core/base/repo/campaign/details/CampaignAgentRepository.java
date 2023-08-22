package com.faas.core.base.repo.campaign.details;

import com.faas.core.base.model.db.campaign.details.CampaignAgentDBModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampaignAgentRepository extends PagingAndSortingRepository<CampaignAgentDBModel, Long> {

    long countByAgentId(long agentId);
    List<CampaignAgentDBModel>findByAgentId(long agentId);
    List<CampaignAgentDBModel> findByCampaignId(String campaignId);
    List<CampaignAgentDBModel> findByAgentIdAndCampaignId(long agentId,String campaignId);
    List<CampaignAgentDBModel> findByCampaignIdAndAgentId(String campaignId, long agentId);
    List<CampaignAgentDBModel> findByStatus(int status);


}
