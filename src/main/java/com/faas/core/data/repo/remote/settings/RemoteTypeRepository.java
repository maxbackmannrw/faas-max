package com.faas.core.data.repo.remote.settings;

import com.faas.core.data.db.remote.settings.RemoteTypeDBModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RemoteTypeRepository extends PagingAndSortingRepository<RemoteTypeDBModel, Long> {

    List<RemoteTypeDBModel> findByStatus(int status);

    List<RemoteTypeDBModel> findByBaseType(String baseType);

}
