package com.faas.core.base.repo.client.details;

import com.faas.core.base.model.db.client.details.ClientDataDBModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ClientDataRepository extends PagingAndSortingRepository<ClientDataDBModel, Long> {

    List<ClientDataDBModel>findByClientId(long clientId);
    List<ClientDataDBModel>findByIdAndClientId(long dataId,long clientId);

}
