package com.faas.core.data.repo.utilz;

import com.faas.core.data.db.utilz.DataTypeDBModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataTypeRepository extends PagingAndSortingRepository<DataTypeDBModel, Long> {

    List<DataTypeDBModel> findByStatus(int status);

    List<DataTypeDBModel> findByBaseType(String baseType);
}
