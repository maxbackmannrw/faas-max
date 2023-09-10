package com.faas.core.base.repo.process.details.trigger;

import com.faas.core.base.model.db.process.details.trigger.ProcessTriggerDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProcessTriggerRepository extends MongoRepository<ProcessTriggerDBModel, String> {

    List<ProcessTriggerDBModel>findByStatus(int status);
    List<ProcessTriggerDBModel>findByProcessId(String processId);
    List<ProcessTriggerDBModel>findByIdAndProcessId(String triggerId, String processId);
    List<ProcessTriggerDBModel>findByProcessIdAndBaseType(String processId, String baseType);
}

