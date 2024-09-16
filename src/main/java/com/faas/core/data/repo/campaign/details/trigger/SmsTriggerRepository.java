package com.faas.core.data.repo.campaign.details.trigger;

import com.faas.core.data.db.campaign.details.trigger.SmsTriggerDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SmsTriggerRepository extends MongoRepository<SmsTriggerDBModel, String> {

    List<SmsTriggerDBModel> findByStatus(int status);

    List<SmsTriggerDBModel> findByCampaignId(String campaignId);

    List<SmsTriggerDBModel> findByIdAndCampaignId(String triggerId, String campaignId);
}

