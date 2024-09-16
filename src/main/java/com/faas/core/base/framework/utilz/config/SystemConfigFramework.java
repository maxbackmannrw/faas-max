package com.faas.core.base.framework.utilz.config;

import com.faas.core.data.db.utilz.CityDBModel;
import com.faas.core.data.db.utilz.CountryDBModel;
import com.faas.core.data.db.utilz.DataTypeDBModel;
import com.faas.core.data.ws.base.utilz.config.dto.CityWSDTO;
import com.faas.core.data.ws.base.utilz.config.dto.CountryWSDTO;
import com.faas.core.data.ws.base.utilz.config.dto.DataTypeWSDTO;
import com.faas.core.data.repo.remote.details.RemoteUrlRepository;
import com.faas.core.data.repo.utilz.CityRepository;
import com.faas.core.data.repo.utilz.CountryRepository;
import com.faas.core.data.repo.utilz.DataTypeRepository;
import com.faas.core.misc.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class SystemConfigFramework {


    @Autowired
    DataTypeRepository dataTypeRepository;

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    CityRepository cityRepository;

    @Autowired
    RemoteUrlRepository remoteUrlRepository;

    @Autowired
    AppUtils appUtils;


    public DataTypeWSDTO fillDataTypeWSDTO(DataTypeDBModel dataTypeDBModel) {

        DataTypeWSDTO dataTypeWSDTO = new DataTypeWSDTO();
        dataTypeWSDTO.setDataType(dataTypeDBModel);
        return dataTypeWSDTO;
    }


    public List<DataTypeWSDTO> getAllDataTypesService(long userId) {

        List<DataTypeWSDTO> dataTypeWSDTOS = new ArrayList<>();
        List<DataTypeDBModel> dataTypeDBModels = dataTypeRepository.findByStatus(1);
        for (DataTypeDBModel dataTypeDBModel : dataTypeDBModels) {
            dataTypeWSDTOS.add(fillDataTypeWSDTO(dataTypeDBModel));
        }
        return dataTypeWSDTOS;
    }


    public List<DataTypeWSDTO> getBaseDataTypesService(String baseType) {

        List<DataTypeWSDTO> dataTypeWSDTOS = new ArrayList<>();
        List<DataTypeDBModel> dataTypeDBModels = dataTypeRepository.findByBaseType(baseType);
        for (DataTypeDBModel dataTypeDBModel : dataTypeDBModels) {
            dataTypeWSDTOS.add(fillDataTypeWSDTO(dataTypeDBModel));
        }
        return dataTypeWSDTOS;
    }

    public DataTypeWSDTO getDataTypeService(long typeId) {

        Optional<DataTypeDBModel> dataTypeDBModel = dataTypeRepository.findById(typeId);
        if (dataTypeDBModel.isPresent()) {
            return fillDataTypeWSDTO(dataTypeDBModel.get());
        }
        return null;
    }

    public DataTypeWSDTO createDataTypeService(String dataType, String baseType) {

        DataTypeDBModel dataTypeDBModel = new DataTypeDBModel();
        dataTypeDBModel.setDataType(dataType);
        dataTypeDBModel.setBaseType(baseType);
        dataTypeDBModel.setuDate(appUtils.getCurrentTimeStamp());
        dataTypeDBModel.setcDate(appUtils.getCurrentTimeStamp());
        dataTypeDBModel.setStatus(1);

        return fillDataTypeWSDTO(dataTypeRepository.save(dataTypeDBModel));
    }

    public DataTypeWSDTO updateDataTypeService(long typeId, String dataType, String baseType) {

        Optional<DataTypeDBModel> dataTypeDBModel = dataTypeRepository.findById(typeId);
        if (dataTypeDBModel.isPresent()) {
            dataTypeDBModel.get().setDataType(dataType);
            dataTypeDBModel.get().setBaseType(baseType);
            dataTypeDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            dataTypeDBModel.get().setStatus(1);

            return fillDataTypeWSDTO(dataTypeRepository.save(dataTypeDBModel.get()));
        }
        return null;
    }

    public DataTypeWSDTO removeDataTypeService(long typeId) {

        Optional<DataTypeDBModel> dataTypeDBModel = dataTypeRepository.findById(typeId);
        if (dataTypeDBModel.isPresent()) {
            dataTypeRepository.delete(dataTypeDBModel.get());
            return fillDataTypeWSDTO(dataTypeDBModel.get());
        }
        return null;
    }


    public List<CityWSDTO> getAllCitiesService(long userId) {

        List<CityWSDTO> cityWSDTOS = new ArrayList<>();
        List<CityDBModel> cityDBModels = cityRepository.findByStatus(1);
        for (CityDBModel cityDBModel : cityDBModels) {
            cityWSDTOS.add(new CityWSDTO(cityDBModel));
        }
        return cityWSDTOS;
    }

    public List<CityWSDTO> getCitiesByCountryService(long userId, String country) {

        List<CityWSDTO> cityWSDTOS = new ArrayList<>();
        List<CityDBModel> cityDBModels = cityRepository.findByCountry(country);
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
