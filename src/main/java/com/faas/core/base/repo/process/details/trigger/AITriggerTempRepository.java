package com.faas.core.base.repo.process.details.trigger;

import com.faas.core.base.model.db.process.details.trigger.AITriggerTempDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AITriggerTempRepository extends MongoRepository<AITriggerTempDBModel, String> {

    List<AITriggerTempDBModel>findByStatus(int status);
    List<AITriggerTempDBModel>findByProcessId(String processId);
    List<AITriggerTempDBModel>findByIdAndProcessId(String triggerId, String processId);
}

