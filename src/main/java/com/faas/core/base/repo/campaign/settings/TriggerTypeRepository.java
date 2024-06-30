package com.faas.core.base.repo.campaign.settings;

import com.faas.core.base.model.db.campaign.settings.TriggerTypeDBModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TriggerTypeRepository extends PagingAndSortingRepository<TriggerTypeDBModel, Long> {

    List<TriggerTypeDBModel> findByStatus(int status);
    List<TriggerTypeDBModel>findByBaseType(String baseType);


}
