package com.faas.core.base.repo.scenario.temp;

import com.faas.core.base.model.db.scenario.temp.AutomationTempDBModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutomationTempRepository extends PagingAndSortingRepository<AutomationTempDBModel, Long> {

    List<AutomationTempDBModel> findByStatus(int status);


}
