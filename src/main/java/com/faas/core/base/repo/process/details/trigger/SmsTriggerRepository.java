package com.faas.core.base.repo.process.details.trigger;

import com.faas.core.base.model.db.process.details.trigger.SmsTriggerDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SmsTriggerRepository extends MongoRepository<SmsTriggerDBModel, String> {

    List<SmsTriggerDBModel>findByStatus(int status);
    List<SmsTriggerDBModel>findByProcessId(String processId);
    List<SmsTriggerDBModel>findByIdAndProcessId(String triggerId, String processId);
}

