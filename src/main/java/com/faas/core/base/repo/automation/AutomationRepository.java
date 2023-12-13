package com.faas.core.base.repo.automation;

import com.faas.core.base.model.db.automation.AutomationDBModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutomationRepository extends PagingAndSortingRepository<AutomationDBModel, Long> {

    List<AutomationDBModel> findByStatus(int status);


}
