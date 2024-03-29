package com.faas.core.base.repo.process.details.trigger;

import com.faas.core.base.model.db.process.details.trigger.ProcessSmsTriggerDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProcessSmsTriggerRepository extends MongoRepository<ProcessSmsTriggerDBModel, String> {

    List<ProcessSmsTriggerDBModel>findByStatus(int status);
    List<ProcessSmsTriggerDBModel>findByProcessId(String processId);
    List<ProcessSmsTriggerDBModel>findByIdAndProcessId(String triggerId, String processId);
}

