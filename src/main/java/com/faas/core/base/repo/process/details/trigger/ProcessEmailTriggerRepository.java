package com.faas.core.base.repo.process.details.trigger;

import com.faas.core.base.model.db.process.details.trigger.ProcessEmailTriggerDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProcessEmailTriggerRepository extends MongoRepository<ProcessEmailTriggerDBModel, String> {

    List<ProcessEmailTriggerDBModel>findByStatus(int status);
    List<ProcessEmailTriggerDBModel>findByProcessId(String processId);
    List<ProcessEmailTriggerDBModel>findByIdAndProcessId(String triggerId, String processId);
}

