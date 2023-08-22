package com.faas.core.base.framework.utils.location;

import com.faas.core.base.model.db.utils.location.CityDBModel;
import com.faas.core.base.model.db.utils.location.CountryDBModel;
import com.faas.core.base.model.ws.utils.location.dto.CityWSDTO;
import com.faas.core.base.model.ws.utils.location.dto.CountryWSDTO;
import com.faas.core.base.repo.utils.location.CityRepository;
import com.faas.core.base.repo.utils.location.CountryRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class UtilsLocationFramework {


    @Autowired
    CountryRepository countryRepository;

    @Autowired
    CityRepository cityRepository;

    @Autowired
    AppUtils appUtils;


    public List<CityWSDTO> getAllCitiesService(long userId) {

        List<CityWSDTO> cityWSDTOS = new ArrayList<>();
        List<CityDBModel> cityDBModels = cityRepository.findByStatus(1);
        for (CityDBModel cityDBModel : cityDBModels) {
            cityWSDTOS.add(new CityWSDTO(cityDBModel));
        }
        return cityWSDTOS;
    }

    public CityWSDTO getCityService(long cityId) {

        Optional<CityDBModel> cityDBModel = cityRepository.findById(cityId);
        if (cityDBModel.isPresent()) {
            return new CityWSDTO(cityDBModel.get());
        }
        return null;
    }

    public CityWSDTO createCityService(String city, String country) {

        if (!cityRepository.existsByCityAndCountry(city.toUpperCase(), country.toUpperCase())) {

            CityDBModel cityDBModel = new CityDBModel();
            cityDBModel.setCity(city.toUpperCase());
            cityDBModel.setCountry(country.toUpperCase());
            cityDBModel.setuDate(appUtils.getCurrentTimeStamp());
            cityDBModel.setcDate(appUtils.getCurrentTimeStamp());
            cityDBModel.setStatus(1);

            return new CityWSDTO(cityRepository.save(cityDBModel));
        }
        return null;
    }

    public CityWSDTO updateCityService(long cityId, String city, String country) {

        if (!cityRepository.existsByCityAndCountry(city.toUpperCase(), country.toUpperCase())) {
            Optional<CityDBModel> cityDBModel = cityRepository.findById(cityId);
            if (cityDBModel.isPresent()) {
                cityDBModel.get().setCity(city.toUpperCase());
                cityDBModel.get().setCountry(country.toUpperCase());
                cityDBModel.get().setuDate(appUtils.getCurrentTimeStamp());

                return new CityWSDTO(cityRepository.save(cityDBModel.get()));
            }
        }
        return null;
    }

    public CityWSDTO removeCityService(long cityId) {

        Optional<CityDBModel> cityDBModel = cityRepository.findById(cityId);
        if (cityDBModel.isPresent()) {
            cityRepository.delete(cityDBModel.get());
            return new CityWSDTO(cityDBModel.get());
        }
        return null;
    }


    public List<CountryWSDTO> getAllCountriesService(long userId) {

        List<CountryWSDTO> countryWSDTOS = new ArrayList<>();
        List<CountryDBModel> countryDBModels = countryRepository.findByStatus(1);
        for (CountryDBModel countryDBModel : countryDBModels) {
            countryWSDTOS.add(new CountryWSDTO(countryDBModel));
        }
        return countryWSDTOS;
    }

    public CountryWSDTO getCountryService(long countryId) {

        Optional<CountryDBModel> countryDBModel = countryRepository.findById(countryId);
        if (countryDBModel.isPresent()) {
            return new CountryWSDTO(countryDBModel.get());
        }
        return null;
    }

    public CountryWSDTO createCountryService(String country) {

        if (!countryRepository.existsByCountry(country.toUpperCase())) {
            CountryDBModel countryDBModel = new CountryDBModel();
            countryDBModel.setCountry(country.toUpperCase());
            countryDBModel.setuDate(appUtils.getCurrentTimeStamp());
            countryDBModel.setcDate(appUtils.getCurrentTimeStamp());
            countryDBModel.setStatus(1);

            return new CountryWSDTO(countryRepository.save(countryDBModel));
        }
        return null;
    }

    public CountryWSDTO updateCountryService(long countryId, String country) {

        if (!countryRepository.existsByCountry(country.toUpperCase())) {
            Optional<CountryDBModel> countryDBModel = countryRepository.findById(countryId);
            if (countryDBModel.isPresent()) {
                countryDBModel.get().setCountry(country.toUpperCase());
                countryDBModel.get().setuDate(appUtils.getCurrentTimeStamp());

                return new CountryWSDTO(countryRepository.save(countryDBModel.get()));
            }
        }
        return null;
    }

    public CountryWSDTO removeCountryService(long countryId) {

        Optional<CountryDBModel> countryDBModel = countryRepository.findById(countryId);
        if (countryDBModel.isPresent()) {
            countryRepository.delete(countryDBModel.get());
            return new CountryWSDTO(countryDBModel.get());
        }
        return null;
    }



}
