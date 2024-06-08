package com.faas.core.base.repo.utils.config;

import com.faas.core.base.model.db.utils.config.CityDBModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends PagingAndSortingRepository<CityDBModel, Long> {

    List<CityDBModel> findByStatus(int status);
    List<CityDBModel>findByCityAndCountry(String city,String country);
    boolean existsByCityAndCountry(String city,String country);

}
