package com.faas.core.base.repo.campaign.details.scenario;

import com.faas.core.base.model.db.campaign.details.scenario.CampaignScenarioDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampaignScenarioRepository extends MongoRepository<CampaignScenarioDBModel, String> {

    boolean existsByCampaignIdAndScenarioId(String campaignId,String scenarioId);
    List<CampaignScenarioDBModel> findByStatus(int status);
    List<CampaignScenarioDBModel> findByCampaignId(String campaignId);
    List<CampaignScenarioDBModel> findByScenarioId(String scenarioId);
    List<CampaignScenarioDBModel> findByCampaignIdAndScenarioId(String campaignId, String scenarioId);
    List<CampaignScenarioDBModel> findByIdAndCampaignId(String campaignScenarioId, String campaignId);


}
