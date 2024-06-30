package com.faas.core.base.repo.campaign.details.trigger;

import com.faas.core.base.model.db.campaign.details.trigger.WappCallTriggerDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WappCallTriggerRepository extends MongoRepository<WappCallTriggerDBModel, String> {

    List<WappCallTriggerDBModel>findByStatus(int status);
    List<WappCallTriggerDBModel>findByCampaignId(String campaignId);
    List<WappCallTriggerDBModel>findByIdAndCampaignId(String triggerId, String campaignId);
}

