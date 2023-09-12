package com.faas.core.base.repo.scenario.settings;

import com.faas.core.base.model.db.scenario.settings.AutomationTypeDBModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutomationTypeRepository extends PagingAndSortingRepository<AutomationTypeDBModel, Long> {

    List<AutomationTypeDBModel> findByStatus(int status);


}
