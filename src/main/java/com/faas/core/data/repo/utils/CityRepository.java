package com.faas.core.data.repo.utils;

import com.faas.core.data.db.utils.CityDBModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends PagingAndSortingRepository<CityDBModel, Long> {

    List<CityDBModel> findByStatus(int status);

    List<CityDBModel> findByCountry(String country);

    List<CityDBModel> findByCityAndCountry(String city, String country);

    boolean existsByCityAndCountry(String city, String country);

}
