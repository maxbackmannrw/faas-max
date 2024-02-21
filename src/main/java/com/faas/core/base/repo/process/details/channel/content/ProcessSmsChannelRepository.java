package com.faas.core.base.repo.process.details.channel.content;

import com.faas.core.base.model.db.process.details.channel.content.ProcessSmsChannelDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProcessSmsChannelRepository extends MongoRepository<ProcessSmsChannelDBModel, String> {

    List<ProcessSmsChannelDBModel>findByStatus(int status);
    List<ProcessSmsChannelDBModel>findByProcessId(String processId);

}
