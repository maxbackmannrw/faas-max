package com.faas.core.data.repo.operation.details.activity;

import com.faas.core.data.db.client.intel.ClientIntelDBModel;
import com.faas.core.data.db.operation.details.activity.OperationActivityDBModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationActivityRepository extends PagingAndSortingRepository<OperationActivityDBModel, Long> {

    List<ClientIntelDBModel> findByClientId(long clientId);

}
