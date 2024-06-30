package com.faas.core.base.repo.campaign.details.trigger;

import com.faas.core.base.model.db.campaign.details.trigger.EmailTriggerDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailTriggerRepository extends MongoRepository<EmailTriggerDBModel, String> {

    List<EmailTriggerDBModel>findByStatus(int status);
    List<EmailTriggerDBModel>findByCampaignId(String campaignId);
    List<EmailTriggerDBModel>findByIdAndCampaignId(String triggerId, String campaignId);
}

