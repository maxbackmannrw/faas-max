package com.faas.core.data.repo.channel.settings;

import com.faas.core.data.db.channel.settings.MessageTypeDBModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageTypeRepository extends PagingAndSortingRepository<MessageTypeDBModel, Long> {

    List<MessageTypeDBModel> findByStatus(int status);

    List<MessageTypeDBModel> findByMainType(String mainType);

}
