package com.faas.core.base.repo.automation.settings;

import com.faas.core.base.model.db.automation.settings.AutomationTypeDBModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutomationTypeRepository extends PagingAndSortingRepository<AutomationTypeDBModel, Long> {

    List<AutomationTypeDBModel> findByStatus(int status);


}
