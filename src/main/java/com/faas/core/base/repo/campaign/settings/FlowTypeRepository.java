package com.faas.core.base.repo.campaign.settings;

import com.faas.core.base.model.db.campaign.settings.FlowTypeDBModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlowTypeRepository extends PagingAndSortingRepository<FlowTypeDBModel, Long> {

    List<FlowTypeDBModel> findByStatus(int status);

}
