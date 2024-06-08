package com.faas.core.base.repo.utils;

import com.faas.core.base.model.db.utils.DataTypeDBModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataTypeRepository extends PagingAndSortingRepository<DataTypeDBModel, Long> {

    List<DataTypeDBModel> findByStatus(int status);

    List<DataTypeDBModel> findByBaseType(String baseType);
}
