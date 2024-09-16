package com.faas.core.data.repo.campaign.settings;

import com.faas.core.data.db.campaign.settings.CampaignTypeDBModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampaignTypeRepository extends PagingAndSortingRepository<CampaignTypeDBModel, Long> {

    List<CampaignTypeDBModel> findByStatus(int status);


}
