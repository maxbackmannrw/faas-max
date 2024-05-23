package com.faas.core.base.repo.process.details.trigger;

import com.faas.core.base.model.db.process.details.trigger.WappMessageTriggerTempDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WappMessageTriggerTempRepository extends MongoRepository<WappMessageTriggerTempDBModel, String> {

    List<WappMessageTriggerTempDBModel>findByStatus(int status);
    List<WappMessageTriggerTempDBModel>findByProcessId(String processId);
    List<WappMessageTriggerTempDBModel>findByIdAndProcessId(String triggerId, String processId);
}

