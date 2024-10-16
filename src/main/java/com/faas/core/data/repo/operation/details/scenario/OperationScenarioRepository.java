package com.faas.core.data.repo.operation.details.scenario;

import com.faas.core.data.db.operation.details.scenario.OperationScenarioDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationScenarioRepository extends MongoRepository<OperationScenarioDBModel, String> {

    List<OperationScenarioDBModel> findByOperationId(String operationId);

    List<OperationScenarioDBModel> findByOperationIdAndAgentId(String operationId, long agentId);

    List<OperationScenarioDBModel> findByClientId(long clientId);

    List<OperationScenarioDBModel> findByIdAndOperationId(String emailId, String operationId);

}
