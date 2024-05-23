package com.faas.core.base.repo.process.details.trigger;

import com.faas.core.base.model.db.process.details.trigger.SipTriggerTempDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SipTriggerTempRepository extends MongoRepository<SipTriggerTempDBModel, String> {

    List<SipTriggerTempDBModel>findByStatus(int status);
    List<SipTriggerTempDBModel>findByProcessId(String processId);
    List<SipTriggerTempDBModel>findByIdAndProcessId(String triggerId, String processId);
}

