package com.faas.core.base.repo.process.details.channel.content;

import com.faas.core.base.model.db.process.details.channel.content.ProcessSipChannelDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProcessSipChannelRepository extends MongoRepository<ProcessSipChannelDBModel, String> {

    List<ProcessSipChannelDBModel>findByStatus(int status);
    List<ProcessSipChannelDBModel>findByProcessId(String processId);
    List<ProcessSipChannelDBModel>findByProcessIdAndChannelState(String processId,String channelState);

}
