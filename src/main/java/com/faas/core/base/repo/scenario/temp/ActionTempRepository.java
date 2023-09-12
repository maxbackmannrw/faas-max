package com.faas.core.base.repo.scenario.temp;

import com.faas.core.base.model.db.scenario.temp.ActionTempDBModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActionTempRepository extends PagingAndSortingRepository<ActionTempDBModel, Long> {

    List<ActionTempDBModel> findByStatus(int status);
}
