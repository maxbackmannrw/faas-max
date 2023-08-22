package com.faas.core.base.repo.operation.scenario;

import com.faas.core.base.model.db.operation.scenario.ScenarioExecutionDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScenarioExecutionRepository extends MongoRepository<ScenarioExecutionDBModel, String> {

    List<ScenarioExecutionDBModel>findByIdAndSessionId(String executionId,long sessionId);
    List<ScenarioExecutionDBModel>findByScenarioId(String scenarioId);
    List<ScenarioExecutionDBModel>findBySessionIdAndProcessId(long sessionId,String processId);
    List<ScenarioExecutionDBModel>findBySessionIdAndCampaignIdAndProcessId(long sessionId,String campaignId,String processId);

}
