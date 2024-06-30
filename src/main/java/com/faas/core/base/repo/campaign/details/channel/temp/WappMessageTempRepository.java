package com.faas.core.base.repo.campaign.details.channel.temp;

import com.faas.core.base.model.db.campaign.details.channel.temp.WappMessageTempDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WappMessageTempRepository extends MongoRepository<WappMessageTempDBModel, String> {

    List<WappMessageTempDBModel> findByStatus(int status);

    List<WappMessageTempDBModel> findByCampaignId(String campaignId);

    List<WappMessageTempDBModel> findByIdAndCampaignId(String tempId, String campaignId);
}
