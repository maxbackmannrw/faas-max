package com.faas.core.base.repo.process.details.trigger;

import com.faas.core.base.model.db.process.details.trigger.EmailTriggerTempDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailTriggerTempRepository extends MongoRepository<EmailTriggerTempDBModel, String> {

    List<EmailTriggerTempDBModel>findByStatus(int status);
    List<EmailTriggerTempDBModel>findByProcessId(String processId);
    List<EmailTriggerTempDBModel>findByIdAndProcessId(String triggerId, String processId);
}

