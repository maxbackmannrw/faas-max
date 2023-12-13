package com.faas.core.base.repo.action;

import com.faas.core.base.model.db.action.ActionDBModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActionRepository extends PagingAndSortingRepository<ActionDBModel, Long> {

    List<ActionDBModel> findByStatus(int status);
}
