package com.faas.core.data.repo.campaign.details.trigger;

import com.faas.core.data.db.campaign.details.trigger.SipTriggerDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SipTriggerRepository extends MongoRepository<SipTriggerDBModel, String> {

    List<SipTriggerDBModel> findByStatus(int status);

    List<SipTriggerDBModel> findByCampaignId(String campaignId);

    List<SipTriggerDBModel> findByIdAndCampaignId(String triggerId, String campaignId);
}

