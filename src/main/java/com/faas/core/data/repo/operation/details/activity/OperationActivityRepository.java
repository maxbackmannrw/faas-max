package com.faas.core.data.repo.operation.details.activity;

import com.faas.core.data.db.operation.details.activity.OperationActivityDBModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationActivityRepository extends PagingAndSortingRepository<OperationActivityDBModel, Long> {

    List<OperationActivityDBModel> findByOperationId(String operationId);
    List<OperationActivityDBModel> findByOperationIdAndAgentId(String operationId, long agentId);
    List<OperationActivityDBModel> findByCampaignId(String campaignId);
    List<OperationActivityDBModel> findByCampaignIdAndAgentId(String campaignId, long agentId);


}
