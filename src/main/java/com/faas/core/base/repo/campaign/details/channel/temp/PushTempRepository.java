package com.faas.core.base.repo.campaign.details.channel.temp;

import com.faas.core.base.model.db.campaign.details.channel.temp.PushTempDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PushTempRepository extends MongoRepository<PushTempDBModel, String> {

    List<PushTempDBModel> findByStatus(int status);

    List<PushTempDBModel> findByCampaignId(String campaignId);

    List<PushTempDBModel> findByIdAndCampaignId(String pushTempId, String campaignId);
}
