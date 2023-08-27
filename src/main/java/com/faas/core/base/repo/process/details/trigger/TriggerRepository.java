package com.faas.core.base.repo.process.details.trigger;

import com.faas.core.base.model.db.process.details.trigger.TriggerDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TriggerRepository extends MongoRepository<TriggerDBModel, String> {

    List<TriggerDBModel>findByStatus(int status);
    List<TriggerDBModel>findByProcessId(String processId);
    List<TriggerDBModel>findByIdAndProcessId(String triggerId, String processId);
    List<TriggerDBModel>findByProcessIdAndBaseType(String processId,String baseType);
}

