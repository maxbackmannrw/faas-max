package com.faas.core.base.repo.process.details.channel.content;

import com.faas.core.base.model.db.process.details.channel.content.ProcessPushChannelDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProcessPushChannelRepository extends MongoRepository<ProcessPushChannelDBModel, String> {

    List<ProcessPushChannelDBModel>findByStatus(int status);
    List<ProcessPushChannelDBModel>findByProcessId(String processId);
}
