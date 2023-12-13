package com.faas.core.base.repo.process.details.trigger;

import com.faas.core.base.model.db.process.details.trigger.ProcessSmsMessageTriggerDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SmsMessageTriggerRepository extends MongoRepository<ProcessSmsMessageTriggerDBModel, String> {

    List<ProcessSmsMessageTriggerDBModel>findByStatus(int status);
    List<ProcessSmsMessageTriggerDBModel>findByProcessId(String processId);
    List<ProcessSmsMessageTriggerDBModel>findByIdAndProcessId(String triggerId, String processId);
}

