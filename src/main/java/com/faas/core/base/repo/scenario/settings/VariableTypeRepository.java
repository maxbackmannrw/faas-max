package com.faas.core.base.repo.scenario.settings;

import com.faas.core.base.model.db.scenario.settings.VariableTypeDBModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VariableTypeRepository extends PagingAndSortingRepository<VariableTypeDBModel, Long> {

    List<VariableTypeDBModel>findByStatus(int status);
    List<VariableTypeDBModel>findByCategory(String category);


}
