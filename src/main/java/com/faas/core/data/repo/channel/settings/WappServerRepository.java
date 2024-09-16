package com.faas.core.data.repo.channel.settings;

import com.faas.core.data.db.channel.settings.WappServerDBModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WappServerRepository extends PagingAndSortingRepository<WappServerDBModel, Long> {

    List<WappServerDBModel> findByStatus(int status);


}
