package com.faas.core.base.repo.process.details.flow;

import com.faas.core.base.model.db.process.details.flow.ProcessFlowDBModel;
import com.faas.core.base.model.db.process.details.scenario.ProcessScenarioDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProcessFlowRepository extends MongoRepository<ProcessFlowDBModel, String> {

    List<ProcessFlowDBModel> findByStatus(int status);
    List<ProcessFlowDBModel>findByProcessId(String processId);
    List<ProcessFlowDBModel>findByIdAndProcessId(String flowId,String processId);


}
