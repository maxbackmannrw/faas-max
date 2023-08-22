package com.faas.core.base.repo.client.details;

import com.faas.core.base.model.db.client.details.ClientEmailDBModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ClientEmailRepository extends PagingAndSortingRepository<ClientEmailDBModel, Long> {

    List<ClientEmailDBModel>findByStatus(int status);
    List<ClientEmailDBModel>findByClientId(long clientId);
}
