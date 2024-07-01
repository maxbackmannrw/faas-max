package com.faas.core.base.repo.campaign.details.temp;

import com.faas.core.base.model.db.campaign.details.temp.SmsTempDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SmsTempRepository extends MongoRepository<SmsTempDBModel, String> {

    List<SmsTempDBModel> findByStatus(int status);

    List<SmsTempDBModel> findByCampaignId(String campaignId);

    List<SmsTempDBModel> findByIdAndCampaignId(String tempId, String campaignId);
}
