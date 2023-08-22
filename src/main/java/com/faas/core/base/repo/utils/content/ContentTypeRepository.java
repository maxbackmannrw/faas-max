package com.faas.core.base.repo.utils.content;

import com.faas.core.base.model.db.utils.content.ContentTypeDBModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentTypeRepository extends PagingAndSortingRepository<ContentTypeDBModel, Long> {

    List<ContentTypeDBModel> findByStatus(int status);

    List<ContentTypeDBModel> findByBaseType(String baseType);
}
