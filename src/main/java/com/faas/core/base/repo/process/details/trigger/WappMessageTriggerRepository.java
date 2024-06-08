package com.faas.core.base.repo.process.details.trigger;

import com.faas.core.base.model.db.process.details.trigger.WappMessageTriggerDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WappMessageTriggerRepository extends MongoRepository<WappMessageTriggerDBModel, String> {

    List<WappMessageTriggerDBModel>findByStatus(int status);
    List<WappMessageTriggerDBModel>findByProcessId(String processId);
    List<WappMessageTriggerDBModel>findByIdAndProcessId(String triggerId, String processId);
}

