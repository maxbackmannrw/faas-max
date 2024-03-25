package com.faas.core.base.repo.process.details.trigger;

import com.faas.core.base.model.db.process.details.channel.trigger.ProcessWappMessageTriggerDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProcessWappMessageTriggerRepository extends MongoRepository<ProcessWappMessageTriggerDBModel, String> {

    List<ProcessWappMessageTriggerDBModel>findByStatus(int status);
    List<ProcessWappMessageTriggerDBModel>findByProcessId(String processId);
    List<ProcessWappMessageTriggerDBModel>findByIdAndProcessId(String triggerId, String processId);
}

