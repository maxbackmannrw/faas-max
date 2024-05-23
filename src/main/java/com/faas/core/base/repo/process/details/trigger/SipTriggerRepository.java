package com.faas.core.base.repo.process.details.trigger;

import com.faas.core.base.model.db.process.details.trigger.SipTriggerDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SipTriggerRepository extends MongoRepository<SipTriggerDBModel, String> {

    List<SipTriggerDBModel>findByStatus(int status);
    List<SipTriggerDBModel>findByProcessId(String processId);
    List<SipTriggerDBModel>findByIdAndProcessId(String triggerId, String processId);
}

