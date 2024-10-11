package com.faas.core.data.repo.utilz;

import com.faas.core.data.db.utilz.ActivityDBModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends PagingAndSortingRepository<ActivityDBModel, Long> {

    List<ActivityDBModel> findByOperationId(String operationId);
    List<ActivityDBModel> findByOperationIdAndAgentId(String operationId, long agentId);

}
