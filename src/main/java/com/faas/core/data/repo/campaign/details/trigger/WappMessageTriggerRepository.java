package com.faas.core.data.repo.campaign.details.trigger;

import com.faas.core.data.db.campaign.details.trigger.WappMessageTriggerDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WappMessageTriggerRepository extends MongoRepository<WappMessageTriggerDBModel, String> {

    List<WappMessageTriggerDBModel> findByStatus(int status);

    List<WappMessageTriggerDBModel> findByCampaignId(String campaignId);

    List<WappMessageTriggerDBModel> findByIdAndCampaignId(String triggerId, String campaignId);
}

