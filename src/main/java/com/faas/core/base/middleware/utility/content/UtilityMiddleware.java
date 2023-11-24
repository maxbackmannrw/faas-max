package com.faas.core.base.middleware.utility.content;

import com.faas.core.base.framework.utility.content.UtilityFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.utility.content.CityWSModel;
import com.faas.core.base.model.ws.utility.content.CountryWSModel;
import com.faas.core.base.model.ws.utility.content.DataTypeWSModel;
import com.faas.core.base.model.ws.utility.content.dto.CityWSDTO;
import com.faas.core.base.model.ws.utility.content.dto.CountryWSDTO;
import com.faas.core.base.model.ws.utility.content.dto.DataTypeWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class UtilityMiddleware {


    @Autowired
    UtilityFramework utilityFramework;


    public DataTypeWSModel getAllDataTypes(long userId) {

        DataTypeWSModel response = new DataTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<DataTypeWSDTO> dataTypeWSDTOS = utilityFramework.getAllDataTypesService(userId);
        if (dataTypeWSDTOS != null){
            response.setDataTypes(dataTypeWSDTOS);
        }

        general.setOperation("getAllDataTypes");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public DataTypeWSModel getBaseDataTypes(long userId, String baseType) {

        DataTypeWSModel response = new DataTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<DataTypeWSDTO> dataTypeWSDTOS = utilityFramework.getBaseDataTypesService(baseType);
        if (dataTypeWSDTOS != null){
            response.setDataTypes(dataTypeWSDTOS);
        }

        general.setOperation("getBaseDataTypes");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public DataTypeWSModel getDataType(long userId, long typeId) {

        DataTypeWSModel response = new DataTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<DataTypeWSDTO> dataTypeWSDTOS = new ArrayList<>();

        DataTypeWSDTO dataTypeWSDTO = utilityFramework.getDataTypeService(typeId);
        if (dataTypeWSDTO != null){
            dataTypeWSDTOS.add(dataTypeWSDTO);
        }

        response.setDataTypes(dataTypeWSDTOS);
        general.setOperation("getDataType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public DataTypeWSModel createDataType(long userId,String dataType,String baseType) {

        DataTypeWSModel response = new DataTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<DataTypeWSDTO> dataTypeWSDTOS = new ArrayList<>();

        DataTypeWSDTO dataTypeWSDTO = utilityFramework.createDataTypeService(dataType,baseType);
        if (dataTypeWSDTO != null) {
            dataTypeWSDTOS.add(dataTypeWSDTO);
        }

        response.setDataTypes(dataTypeWSDTOS);
        general.setOperation("createDataType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public DataTypeWSModel updateDataType(long userId,long typeId,String dataType,String baseType) {

        DataTypeWSModel response = new DataTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<DataTypeWSDTO> dataTypeWSDTOS = new ArrayList<>();

        DataTypeWSDTO dataTypeWSDTO = utilityFramework.updateDataTypeService(typeId,dataType,baseType);
        if (dataTypeWSDTO != null) {
            dataTypeWSDTOS.add(dataTypeWSDTO);
        }

        response.setDataTypes(dataTypeWSDTOS);
        general.setOperation("updateDataType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public DataTypeWSModel removeDataType(long userId,long typeId) {

        DataTypeWSModel response = new DataTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<DataTypeWSDTO> dataTypeWSDTOS = new ArrayList<>();

        DataTypeWSDTO dataTypeWSDTO = utilityFramework.removeDataTypeService(typeId);
        if (dataTypeWSDTO != null) {
            dataTypeWSDTOS.add(dataTypeWSDTO);
        }

        response.setDataTypes(dataTypeWSDTOS);
        general.setOperation("removeDataType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public CityWSModel getAllCities(long userId) {

        CityWSModel response = new CityWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<CityWSDTO> cityWSDTOS = utilityFramework.getAllCitiesService(userId);
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

        CityWSDTO cityWSDTO = utilityFramework.getCityService(cityId);
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

        CityWSDTO cityWSDTO = utilityFramework.createCityService(city,country);
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

        CityWSDTO cityWSDTO = utilityFramework.updateCityService(cityId,city,country);
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

        CityWSDTO cityWSDTO = utilityFramework.removeCityService(cityId);
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

        List<CountryWSDTO> countryWSDTOS = utilityFramework.getAllCountriesService(userId);
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

        CountryWSDTO countryWSDTO = utilityFramework.getCountryService(countryId);
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

        CountryWSDTO countryWSDTO = utilityFramework.createCountryService(country);
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

        CountryWSDTO countryWSDTO = utilityFramework.updateCountryService(countryId,country);
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

        CountryWSDTO countryWSDTO = utilityFramework.removeCountryService(countryId);
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
