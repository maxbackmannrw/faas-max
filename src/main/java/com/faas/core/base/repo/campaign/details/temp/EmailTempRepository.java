package com.faas.core.base.repo.campaign.details.temp;

import com.faas.core.base.model.db.campaign.details.temp.EmailTempDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailTempRepository extends MongoRepository<EmailTempDBModel, String> {

    List<EmailTempDBModel> findByStatus(int status);

    List<EmailTempDBModel> findByCampaignId(String campaignId);

    List<EmailTempDBModel> findByIdAndCampaignId(String emailTempId, String campaignId);
}
