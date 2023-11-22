package com.faas.core.base.repo.process.details.trigger;

import com.faas.core.base.model.db.process.details.trigger.SmsMessageTriggerDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SmsMessageTriggerRepository extends MongoRepository<SmsMessageTriggerDBModel, String> {

    List<SmsMessageTriggerDBModel>findByStatus(int status);
    List<SmsMessageTriggerDBModel>findByProcessId(String processId);
    List<SmsMessageTriggerDBModel>findByIdAndProcessId(String triggerId, String processId);
}

