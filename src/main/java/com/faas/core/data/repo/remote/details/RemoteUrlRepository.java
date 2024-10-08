package com.faas.core.data.repo.remote.details;

import com.faas.core.data.db.remote.details.RemoteUrlDBModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RemoteUrlRepository extends PagingAndSortingRepository<RemoteUrlDBModel, Long> {

    List<RemoteUrlDBModel> findByStatus(int status);

    List<RemoteUrlDBModel> findByRemoteId(String remoteId);

}
