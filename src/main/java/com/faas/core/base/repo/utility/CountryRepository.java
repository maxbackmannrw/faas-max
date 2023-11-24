package com.faas.core.base.repo.utility;

import com.faas.core.base.model.db.utility.CountryDBModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends PagingAndSortingRepository<CountryDBModel, Long> {

    List<CountryDBModel> findByStatus(int status);
    List<CountryDBModel>findByCountry(String country);
    boolean existsByCountry(String country);

}
