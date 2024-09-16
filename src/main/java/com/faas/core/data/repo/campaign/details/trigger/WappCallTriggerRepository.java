package com.faas.core.data.repo.campaign.details.trigger;

import com.faas.core.data.db.campaign.details.trigger.WappCallTriggerDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WappCallTriggerRepository extends MongoRepository<WappCallTriggerDBModel, String> {

    List<WappCallTriggerDBModel> findByStatus(int status);

    List<WappCallTriggerDBModel> findByCampaignId(String campaignId);

    List<WappCallTriggerDBModel> findByIdAndCampaignId(String triggerId, String campaignId);
}

