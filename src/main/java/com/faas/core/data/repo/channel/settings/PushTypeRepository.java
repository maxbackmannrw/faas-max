package com.faas.core.data.repo.channel.settings;

import com.faas.core.data.db.channel.settings.PushTypeDBModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PushTypeRepository extends PagingAndSortingRepository<PushTypeDBModel, Long> {

    List<PushTypeDBModel> findByStatus(int status);

    List<PushTypeDBModel> findByMainType(String mainType);

}
