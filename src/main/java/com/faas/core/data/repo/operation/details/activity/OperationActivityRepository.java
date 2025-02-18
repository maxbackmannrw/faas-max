package com.faas.core.data.repo.operation.details.activity;

import com.faas.core.data.db.operation.details.activity.OperationActivityDBModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationActivityRepository extends PagingAndSortingRepository<OperationActivityDBModel, Long> {

    List<OperationActivityDBModel> findByOperationId(String operationId);
    List<OperationActivityDBModel> findByAgentId(long agentId);
    List<OperationActivityDBModel> findByAgentIdAndStatus(long agentId, int status);
    List<OperationActivityDBModel> findByOperationIdAndAgentId(String operationId, long agentId);

}
