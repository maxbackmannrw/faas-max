package com.faas.core.data.repo.campaign.details.remote;

import com.faas.core.data.db.campaign.details.remote.CampaignRemoteDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CampaignRemoteRepository extends MongoRepository<CampaignRemoteDBModel, String> {

    List<CampaignRemoteDBModel> findByStatus(int status);

    List<CampaignRemoteDBModel> findByCampaignId(String campaignId);

    List<CampaignRemoteDBModel> findByIdAndCampaignId(String campaignRemoteId, String campaignId);

    List<CampaignRemoteDBModel> findByCampaignIdAndRemoteId(String campaignId, String remoteId);

    List<CampaignRemoteDBModel> findByCampaignIdAndRemoteCategory(String campaignId, String remoteCategory);

}
