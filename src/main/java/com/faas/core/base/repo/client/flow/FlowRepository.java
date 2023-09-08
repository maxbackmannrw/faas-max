package com.faas.core.base.repo.client.flow;

import com.faas.core.base.model.db.client.flow.FlowDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlowRepository extends MongoRepository<FlowDBModel,String> {


}
