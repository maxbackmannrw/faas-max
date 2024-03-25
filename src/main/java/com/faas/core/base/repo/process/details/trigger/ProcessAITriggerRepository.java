package com.faas.core.base.repo.process.details.trigger;

import com.faas.core.base.model.db.process.details.channel.trigger.ProcessAITriggerDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProcessAITriggerRepository extends MongoRepository<ProcessAITriggerDBModel, String> {

    List<ProcessAITriggerDBModel>findByStatus(int status);
    List<ProcessAITriggerDBModel>findByProcessId(String processId);
    List<ProcessAITriggerDBModel>findByIdAndProcessId(String triggerId, String processId);
}

