package com.faas.core.data.repo.client.intel;

import com.faas.core.data.db.client.intel.ClientIntelDBModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientIntelRepository extends PagingAndSortingRepository<ClientIntelDBModel, Long> {

    List<ClientIntelDBModel> findByClientId(long clientId);

}
