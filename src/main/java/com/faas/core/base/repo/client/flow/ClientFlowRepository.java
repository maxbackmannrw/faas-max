package com.faas.core.base.repo.client.flow;

import com.faas.core.base.model.db.client.flow.ClientFlowDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientFlowRepository extends MongoRepository<ClientFlowDBModel,String> {


}
