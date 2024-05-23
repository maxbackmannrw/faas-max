package com.faas.core.base.repo.process.details.trigger;

import com.faas.core.base.model.db.process.details.trigger.WappCallTriggerTempDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WappCallTriggerTempRepository extends MongoRepository<WappCallTriggerTempDBModel, String> {

    List<WappCallTriggerTempDBModel>findByStatus(int status);
    List<WappCallTriggerTempDBModel>findByProcessId(String processId);
    List<WappCallTriggerTempDBModel>findByIdAndProcessId(String triggerId, String processId);
}

