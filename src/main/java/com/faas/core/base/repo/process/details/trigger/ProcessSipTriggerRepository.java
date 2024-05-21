package com.faas.core.base.repo.process.details.trigger;

import com.faas.core.base.model.db.process.details.trigger.ProcessSipTriggerDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProcessSipTriggerRepository extends MongoRepository<ProcessSipTriggerDBModel, String> {

    List<ProcessSipTriggerDBModel>findByStatus(int status);
    List<ProcessSipTriggerDBModel>findByProcessId(String processId);
    List<ProcessSipTriggerDBModel>findByIdAndProcessId(String triggerId, String processId);
}

