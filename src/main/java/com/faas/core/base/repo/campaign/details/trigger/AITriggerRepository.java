package com.faas.core.base.repo.campaign.details.trigger;

import com.faas.core.base.model.db.campaign.details.trigger.AITriggerDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AITriggerRepository extends MongoRepository<AITriggerDBModel, String> {

    List<AITriggerDBModel>findByStatus(int status);
    List<AITriggerDBModel>findByCampaignId(String campaignId);
    List<AITriggerDBModel>findByIdAndCampaignId(String triggerId, String campaignId);
}

