package com.faas.core.base.repo.process.details.trigger;

import com.faas.core.base.model.db.process.details.trigger.SmsTriggerTempDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SmsTriggerTempRepository extends MongoRepository<SmsTriggerTempDBModel, String> {

    List<SmsTriggerTempDBModel>findByStatus(int status);
    List<SmsTriggerTempDBModel>findByProcessId(String processId);
    List<SmsTriggerTempDBModel>findByIdAndProcessId(String triggerId, String processId);
}

