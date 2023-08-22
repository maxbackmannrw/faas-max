package com.faas.core.base.repo.automation.content;

import com.faas.core.base.model.db.automation.content.AutomationTempDBModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutomationTempRepository extends PagingAndSortingRepository<AutomationTempDBModel, Long> {

    List<AutomationTempDBModel> findByStatus(int status);


}
