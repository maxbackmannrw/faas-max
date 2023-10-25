package com.faas.core.base.repo.scenario.content;

import com.faas.core.base.model.db.scenario.content.ScenarioDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScenarioRepository extends MongoRepository<ScenarioDBModel, String> {

    List<ScenarioDBModel> findByStatus(int status);
    List<ScenarioDBModel>findByScenarioType(String scenarioType);


}
