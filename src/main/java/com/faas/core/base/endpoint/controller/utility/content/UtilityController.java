package com.faas.core.base.endpoint.controller.utility.content;

import com.faas.core.base.middleware.utility.content.UtilityMiddleware;
import com.faas.core.base.model.ws.utility.content.CityWSModel;
import com.faas.core.base.model.ws.utility.content.CountryWSModel;
import com.faas.core.base.model.ws.utility.content.DataTypeWSModel;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.BaseRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/base/utility/")
public class UtilityController {


    @Autowired
    UtilityMiddleware utilityMiddleware;


    @RequestMapping(value = BaseRoute.GET_ALL_DATA_TYPES, method = RequestMethod.POST)
    public ResponseEntity<?> getAllDataTypes(@RequestParam long userId) {

        DataTypeWSModel response = utilityMiddleware.getAllDataTypes(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_BASE_DATA_TYPES, method = RequestMethod.POST)
    public ResponseEntity<?> getBaseDataTypes(@RequestParam long userId,
                                              @RequestParam String baseType) {

        DataTypeWSModel response = utilityMiddleware.getBaseDataTypes(userId, baseType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_DATA_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> getDataType(@RequestParam long userId,
                                         @RequestParam long typeId) {

        DataTypeWSModel response = utilityMiddleware.getDataType(userId, typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_DATA_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> createDataType(@RequestParam long userId,
                                            @RequestParam String dataType,
                                            @RequestParam String baseType) {

        DataTypeWSModel response = utilityMiddleware.createDataType(userId,dataType,baseType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_DATA_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> updateDataType(@RequestParam long userId,
                                            @RequestParam long typeId,
                                            @RequestParam String dataType,
                                            @RequestParam String baseType) {

        DataTypeWSModel response = utilityMiddleware.updateDataType(userId,typeId,dataType,baseType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_DATA_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> removeDataType(@RequestParam long userId,
                                            @RequestParam long typeId) {

        DataTypeWSModel response = utilityMiddleware.removeDataType(userId,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_ALL_CITIES, method = RequestMethod.POST)
    public ResponseEntity<?> getAllCities(@RequestParam long userId) {

        CityWSModel response = utilityMiddleware.getAllCities(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_CITY, method = RequestMethod.POST)
    public ResponseEntity<?> getCity(@RequestParam long userId,
                                     @RequestParam long cityId) {

        CityWSModel response = utilityMiddleware.getCity(userId,cityId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_CITY, method = RequestMethod.POST)
    public ResponseEntity<?> createCity(@RequestParam long userId,
                                        @RequestParam String city,
                                        @RequestParam String country) {

        CityWSModel response = utilityMiddleware.createCity(userId,city,country);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_CITY, method = RequestMethod.POST)
    public ResponseEntity<?> updateCity(@RequestParam long userId,
                                        @RequestParam long cityId,
                                        @RequestParam String city,
                                        @RequestParam String country) {

        CityWSModel response = utilityMiddleware.updateCity(userId,cityId,city,country);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_CITY, method = RequestMethod.POST)
    public ResponseEntity<?> removeCity(@RequestParam long userId,
                                        @RequestParam long cityId) {

        CityWSModel response = utilityMiddleware.removeCity(userId,cityId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = BaseRoute.GET_ALL_COUNTRIES, method = RequestMethod.POST)
    public ResponseEntity<?> getAllCountries(@RequestParam long userId) {

        CountryWSModel response = utilityMiddleware.getAllCountries(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_COUNTRY, method = RequestMethod.POST)
    public ResponseEntity<?> getCountry(@RequestParam long userId,
                                        @RequestParam long countryId) {

        CountryWSModel response = utilityMiddleware.getCountry(userId,countryId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_COUNTRY, method = RequestMethod.POST)
    public ResponseEntity<?> createCountry(@RequestParam long userId,
                                           @RequestParam String country) {

        CountryWSModel response = utilityMiddleware.createCountry(userId,country);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_COUNTRY, method = RequestMethod.POST)
    public ResponseEntity<?> updateCountry(@RequestParam long userId,
                                           @RequestParam long countryId,
                                           @RequestParam String country) {

        CountryWSModel response = utilityMiddleware.updateCountry(userId,countryId,country);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_COUNTRY, method = RequestMethod.POST)
    public ResponseEntity<?> removeCountry(@RequestParam long userId,
                                           @RequestParam long countryId) {

        CountryWSModel response = utilityMiddleware.removeCountry(userId, countryId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
