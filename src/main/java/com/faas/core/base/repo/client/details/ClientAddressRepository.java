package com.faas.core.base.repo.client.details;

import com.faas.core.base.model.db.client.details.ClientAddressDBModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ClientAddressRepository extends PagingAndSortingRepository<ClientAddressDBModel, Long> {

    List<ClientAddressDBModel>findByStatus(int status);
    List<ClientAddressDBModel>findByClientId(long clientId);

}
