package com.faas.core.data.repo.scenario.settings;

import com.faas.core.data.db.scenario.settings.ScenarioTypeDBModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScenarioTypeRepository extends PagingAndSortingRepository<ScenarioTypeDBModel, Long> {

    List<ScenarioTypeDBModel> findByStatus(int status);

    List<ScenarioTypeDBModel> findByBaseType(String baseType);

}
