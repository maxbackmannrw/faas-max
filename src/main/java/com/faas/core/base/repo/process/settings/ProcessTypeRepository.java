package com.faas.core.base.repo.process.settings;

import com.faas.core.base.model.db.process.settings.ProcessTypeDBModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProcessTypeRepository extends PagingAndSortingRepository<ProcessTypeDBModel, Long> {

    List<ProcessTypeDBModel> findByStatus(int status);


}
