package com.faas.core.base.repo.channel.settings;

import com.faas.core.base.model.db.channel.settings.WappServerDBModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WappServerRepository extends PagingAndSortingRepository<WappServerDBModel, Long> {

    List<WappServerDBModel> findByStatus(int status);


}
