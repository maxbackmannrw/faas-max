package com.faas.core.base.repo.operation.scenario;

import com.faas.core.base.model.db.operation.scenario.OperationScenarioDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationScenarioRepository extends MongoRepository<OperationScenarioDBModel, String> {

    List<OperationScenarioDBModel>findByIdAndSessionId(String executionId, long sessionId);
    List<OperationScenarioDBModel>findByScenarioId(String scenarioId);
    List<OperationScenarioDBModel>findBySessionIdAndProcessId(long sessionId, String processId);
    List<OperationScenarioDBModel>findBySessionIdAndCampaignIdAndProcessId(long sessionId, String campaignId, String processId);

}
