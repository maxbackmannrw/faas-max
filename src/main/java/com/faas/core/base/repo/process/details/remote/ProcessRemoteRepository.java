package com.faas.core.base.repo.process.details.remote;

import com.faas.core.base.model.db.process.details.channel.content.ProcessEmailChannelDBModel;
import com.faas.core.base.model.db.process.details.remote.ProcessRemoteDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProcessRemoteRepository extends MongoRepository<ProcessRemoteDBModel, String> {

    List<ProcessRemoteDBModel>findByStatus(int status);
    List<ProcessRemoteDBModel>findByProcessId(String processId);
    List<ProcessRemoteDBModel>findByIdAndProcessId(String processRemoteId,String processId);
    List<ProcessRemoteDBModel>findByProcessIdAndRemoteCategory(String processId, String remoteCategory);

}
