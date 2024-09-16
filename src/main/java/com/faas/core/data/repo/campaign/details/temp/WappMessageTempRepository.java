package com.faas.core.data.repo.campaign.details.temp;

import com.faas.core.data.db.campaign.details.temp.WappMessageTempDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WappMessageTempRepository extends MongoRepository<WappMessageTempDBModel, String> {

    List<WappMessageTempDBModel> findByStatus(int status);

    List<WappMessageTempDBModel> findByCampaignId(String campaignId);

    List<WappMessageTempDBModel> findByIdAndCampaignId(String tempId, String campaignId);
}
