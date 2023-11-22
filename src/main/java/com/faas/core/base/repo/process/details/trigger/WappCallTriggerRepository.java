package com.faas.core.base.repo.process.details.trigger;

import com.faas.core.base.model.db.process.details.trigger.WappCallTriggerDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WappCallTriggerRepository extends MongoRepository<WappCallTriggerDBModel, String> {

    List<WappCallTriggerDBModel>findByStatus(int status);
    List<WappCallTriggerDBModel>findByProcessId(String processId);
    List<WappCallTriggerDBModel>findByIdAndProcessId(String triggerId, String processId);
}

