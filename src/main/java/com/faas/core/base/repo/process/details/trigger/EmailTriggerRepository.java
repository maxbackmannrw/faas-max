package com.faas.core.base.repo.process.details.trigger;

import com.faas.core.base.model.db.process.details.trigger.EmailTriggerDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailTriggerRepository extends MongoRepository<EmailTriggerDBModel, String> {

    List<EmailTriggerDBModel>findByStatus(int status);
    List<EmailTriggerDBModel>findByProcessId(String processId);
    List<EmailTriggerDBModel>findByIdAndProcessId(String triggerId, String processId);
}

