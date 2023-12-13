package com.faas.core.base.repo.process.details.trigger;

import com.faas.core.base.model.db.process.details.trigger.ProcessSipCallTriggerDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SipCallTriggerRepository extends MongoRepository<ProcessSipCallTriggerDBModel, String> {

    List<ProcessSipCallTriggerDBModel>findByStatus(int status);
    List<ProcessSipCallTriggerDBModel>findByProcessId(String processId);
    List<ProcessSipCallTriggerDBModel>findByIdAndProcessId(String triggerId, String processId);
}

