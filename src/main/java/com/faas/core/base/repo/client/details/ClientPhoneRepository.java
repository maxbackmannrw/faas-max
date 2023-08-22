package com.faas.core.base.repo.client.details;

import com.faas.core.base.model.db.client.details.ClientPhoneDBModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ClientPhoneRepository extends PagingAndSortingRepository<ClientPhoneDBModel, Long> {

    List<ClientPhoneDBModel>findByStatus(int status);
    List<ClientPhoneDBModel>findByClientId(long clientId);
}
