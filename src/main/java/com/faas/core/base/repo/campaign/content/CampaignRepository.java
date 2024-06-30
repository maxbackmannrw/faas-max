package com.faas.core.base.repo.campaign.content;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampaignRepository extends MongoRepository<CampaignDBModel, String> {

    List<CampaignDBModel>findByIdAndCampaignState(String campaignId, String campaignState);

    List<CampaignDBModel>findByCampaignState(String campaignState);

    List<CampaignDBModel> findByStatus(int status);

    List<CampaignDBModel>findByIdAndStatus(String campaignId, int status);

    List<CampaignDBModel> findByCampaignType(String campaignType);

    List<CampaignDBModel>findByCampaignCategory(String campaignCategory);

}

