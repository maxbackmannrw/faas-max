package com.faas.core.base.middleware.utils.location;

import com.faas.core.base.framework.utils.location.UtilsLocationFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.utils.location.CityWSModel;
import com.faas.core.base.model.ws.utils.location.CountryWSModel;
import com.faas.core.base.model.ws.utils.location.dto.CityWSDTO;
import com.faas.core.base.model.ws.utils.location.dto.CountryWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class UtilsLocationMiddleware {


    @Autowired
    UtilsLocationFramework utilsLocationFramework;


    public CityWSModel getAllCities(long userId) {

        CityWSModel response = new CityWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<CityWSDTO> cityWSDTOS = utilsLocationFramework.getAllCitiesService(userId);
        if (cityWSDTOS != null){
            response.setCities(cityWSDTOS);
        }

        general.setOperation("getAllCities");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public CityWSModel getCity(long userId, long cityId) {

        CityWSModel response = new CityWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CityWSDTO>cityWSDTOS = new ArrayList<>();

        CityWSDTO cityWSDTO = utilsLocationFramework.getCityService(cityId);
        if (cityWSDTO != null){
            cityWSDTOS.add(cityWSDTO);
        }

        response.setCities(cityWSDTOS);
        general.setOperation("getCity");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public CityWSModel createCity(long userId,String city,String country) {

        CityWSModel response = new CityWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CityWSDTO>cityWSDTOS = new ArrayList<>();

        CityWSDTO cityWSDTO = utilsLocationFramework.createCityService(city,country);
        if (cityWSDTO != null){
            cityWSDTOS.add(cityWSDTO);
        }

        response.setCities(cityWSDTOS);
        general.setOperation("createCity");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public CityWSModel updateCity(long userId,long cityId,String city,String country) {

        CityWSModel response = new CityWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CityWSDTO>cityWSDTOS = new ArrayList<>();

        CityWSDTO cityWSDTO = utilsLocationFramework.updateCityService(cityId,city,country);
        if (cityWSDTO != null){
            cityWSDTOS.add(cityWSDTO);
        }

        response.setCities(cityWSDTOS);
        general.setOperation("updateCity");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CityWSModel removeCity(long userId, long cityId) {

        CityWSModel response = new CityWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CityWSDTO>cityWSDTOS = new ArrayList<>();

        CityWSDTO cityWSDTO = utilsLocationFramework.removeCityService(cityId);
        if (cityWSDTO != null){
            cityWSDTOS.add(cityWSDTO);
        }

        response.setCities(cityWSDTOS);
        general.setOperation("removeCity");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public CountryWSModel getAllCountries(long userId) {

        CountryWSModel response = new CountryWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<CountryWSDTO> countryWSDTOS = utilsLocationFramework.getAllCountriesService(userId);
        if (countryWSDTOS != null){
            response.setCountries(countryWSDTOS);
        }

        general.setOperation("getAllCountries");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public CountryWSModel getCountry(long userId, long countryId) {

        CountryWSModel response = new CountryWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CountryWSDTO> countryWSDTOS = new ArrayList<>();

        CountryWSDTO countryWSDTO = utilsLocationFramework.getCountryService(countryId);
        if (countryWSDTO != null){
            countryWSDTOS.add(countryWSDTO);
        }

        response.setCountries(countryWSDTOS);
        general.setOperation("getCountry");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public CountryWSModel createCountry(long userId,String country) {

        CountryWSModel response = new CountryWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CountryWSDTO> countryWSDTOS = new ArrayList<>();

        CountryWSDTO countryWSDTO = utilsLocationFramework.createCountryService(country);
        if (countryWSDTO != null){
            countryWSDTOS.add(countryWSDTO);
        }

        response.setCountries(countryWSDTOS);
        general.setOperation("createCountry");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public CountryWSModel updateCountry(long userId,long countryId,String country) {

        CountryWSModel response = new CountryWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CountryWSDTO> countryWSDTOS = new ArrayList<>();

        CountryWSDTO countryWSDTO = utilsLocationFramework.updateCountryService(countryId,country);
        if (countryWSDTO != null){
            countryWSDTOS.add(countryWSDTO);
        }

        response.setCountries(countryWSDTOS);
        general.setOperation("updateCountry");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public CountryWSModel removeCountry(long userId,long countryId) {

        CountryWSModel response = new CountryWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CountryWSDTO> countryWSDTOS = new ArrayList<>();

        CountryWSDTO countryWSDTO = utilsLocationFramework.removeCountryService(countryId);
        if (countryWSDTO != null){
            countryWSDTOS.add(countryWSDTO);
        }

        response.setCountries(countryWSDTOS);
        general.setOperation("removeCountry");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

}
