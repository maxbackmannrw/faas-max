package com.faas.core.base.repo.process.details.trigger;

import com.faas.core.base.model.db.process.details.trigger.SipCallTriggerDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SipCallTriggerRepository extends MongoRepository<SipCallTriggerDBModel, String> {

    List<SipCallTriggerDBModel>findByStatus(int status);
    List<SipCallTriggerDBModel>findByProcessId(String processId);
    List<SipCallTriggerDBModel>findByIdAndProcessId(String triggerId, String processId);
}

