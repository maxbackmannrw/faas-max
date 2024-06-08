package com.faas.core.base.repo.utils.config;

import com.faas.core.base.model.db.utils.config.UrlDBModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UrlRepository extends PagingAndSortingRepository<UrlDBModel, Long> {

    List<UrlDBModel> findByStatus(int status);
    List<UrlDBModel>findByBaseType(String baseType);
    List<UrlDBModel>findByBaseTypeAndOwnerId(String baseType, String ownerId);

}
