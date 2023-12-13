package com.faas.core.base.repo.process.details.channel.temp;

import com.faas.core.base.model.db.process.details.channel.temp.ProcessWappMessageTempDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProcessWappMessageTempRepository extends MongoRepository<ProcessWappMessageTempDBModel, String> {

    List<ProcessWappMessageTempDBModel> findByStatus(int status);

    List<ProcessWappMessageTempDBModel> findByProcessId(String processId);

    List<ProcessWappMessageTempDBModel>findByIdAndProcessId(String tempId, String processId);
}
