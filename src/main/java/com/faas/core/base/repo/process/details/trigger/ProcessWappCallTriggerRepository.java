package com.faas.core.base.repo.process.details.trigger;

import com.faas.core.base.model.db.process.details.trigger.ProcessWappCallTriggerDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProcessWappCallTriggerRepository extends MongoRepository<ProcessWappCallTriggerDBModel, String> {

    List<ProcessWappCallTriggerDBModel>findByStatus(int status);
    List<ProcessWappCallTriggerDBModel>findByProcessId(String processId);
    List<ProcessWappCallTriggerDBModel>findByIdAndProcessId(String triggerId, String processId);
}

