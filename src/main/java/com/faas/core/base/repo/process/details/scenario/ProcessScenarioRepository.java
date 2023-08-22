package com.faas.core.base.repo.process.details.scenario;

import com.faas.core.base.model.db.process.details.scenario.ProcessScenarioDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProcessScenarioRepository extends MongoRepository<ProcessScenarioDBModel, String> {

    boolean existsByProcessIdAndScenarioId(String processId,String scenarioId);
    List<ProcessScenarioDBModel> findByStatus(int status);
    List<ProcessScenarioDBModel>findByProcessId(String processId);
    List<ProcessScenarioDBModel>findByScenarioId(String scenarioId);
    List<ProcessScenarioDBModel>findByProcessIdAndScenarioId(String processId,String scenarioId);
    List<ProcessScenarioDBModel>findByIdAndProcessId(String processScenarioId,String processId);


}
