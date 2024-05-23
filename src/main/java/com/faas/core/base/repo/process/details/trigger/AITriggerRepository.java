package com.faas.core.base.repo.process.details.trigger;

import com.faas.core.base.model.db.process.details.trigger.AITriggerDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AITriggerRepository extends MongoRepository<AITriggerDBModel, String> {

    List<AITriggerDBModel>findByStatus(int status);
    List<AITriggerDBModel>findByProcessId(String processId);
    List<AITriggerDBModel>findByIdAndProcessId(String triggerId, String processId);
}

