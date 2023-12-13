package com.faas.core.base.repo.process.details.trigger;

import com.faas.core.base.model.db.process.details.trigger.ProcessAiTriggerDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AiTriggerRepository extends MongoRepository<ProcessAiTriggerDBModel, String> {

    List<ProcessAiTriggerDBModel>findByStatus(int status);
    List<ProcessAiTriggerDBModel>findByProcessId(String processId);
    List<ProcessAiTriggerDBModel>findByIdAndProcessId(String triggerId, String processId);
}

