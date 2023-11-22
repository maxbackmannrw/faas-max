package com.faas.core.base.repo.process.details.trigger;

import com.faas.core.base.model.db.process.details.trigger.AiTriggerDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AiTriggerRepository extends MongoRepository<AiTriggerDBModel, String> {

    List<AiTriggerDBModel>findByStatus(int status);
    List<AiTriggerDBModel>findByProcessId(String processId);
    List<AiTriggerDBModel>findByIdAndProcessId(String triggerId, String processId);
}

