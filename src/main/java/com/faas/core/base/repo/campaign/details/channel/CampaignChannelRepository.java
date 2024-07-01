package com.faas.core.base.repo.campaign.details.channel;

import com.faas.core.base.model.db.campaign.details.channel.CampaignChannelDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampaignChannelRepository extends MongoRepository<CampaignChannelDBModel, String> {

    List<CampaignChannelDBModel>findByStatus(int status);
    List<CampaignChannelDBModel>findByCampaignId(String campaignId);

}
