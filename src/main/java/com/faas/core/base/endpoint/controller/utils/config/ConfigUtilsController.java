package com.faas.core.base.endpoint.controller.utils.config;

import com.faas.core.base.middleware.utils.config.ConfigUtilsMiddleware;
import com.faas.core.base.model.ws.utils.config.CityWSModel;
import com.faas.core.base.model.ws.utils.config.CountryWSModel;
import com.faas.core.base.model.ws.utils.config.DataTypeWSModel;
import com.faas.core.base.model.ws.utils.config.UrlWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/utils/config/")
public class ConfigUtilsController {


    @Autowired
    ConfigUtilsMiddleware configUtilsMiddleware;


    @RequestMapping(value = BaseRoute.GET_ALL_DATA_TYPES, method = RequestMethod.POST)
    public ResponseEntity<?> getAllDataTypes(@RequestParam long userId) {

        DataTypeWSModel response = configUtilsMiddleware.getAllDataTypes(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_BASE_DATA_TYPES, method = RequestMethod.POST)
    public ResponseEntity<?> getBaseDataTypes(@RequestParam long userId,
                                              @RequestParam String baseType) {

        DataTypeWSModel response = configUtilsMiddleware.getBaseDataTypes(userId, baseType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_DATA_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> getDataType(@RequestParam long userId,
                                         @RequestParam long typeId) {

        DataTypeWSModel response = configUtilsMiddleware.getDataType(userId, typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_DATA_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> createDataType(@RequestParam long userId,
                                            @RequestParam String dataType,
                                            @RequestParam String baseType) {

        DataTypeWSModel response = configUtilsMiddleware.createDataType(userId,dataType,baseType);

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

        DataTypeWSModel response = configUtilsMiddleware.updateDataType(userId,typeId,dataType,baseType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_DATA_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> removeDataType(@RequestParam long userId,
                                            @RequestParam long typeId) {

        DataTypeWSModel response = configUtilsMiddleware.removeDataType(userId,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_ALL_CITIES, method = RequestMethod.POST)
    public ResponseEntity<?> getAllCities(@RequestParam long userId) {

        CityWSModel response = configUtilsMiddleware.getAllCities(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_CITY, method = RequestMethod.POST)
    public ResponseEntity<?> getCity(@RequestParam long userId,
                                     @RequestParam long cityId) {

        CityWSModel response = configUtilsMiddleware.getCity(userId,cityId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_CITY, method = RequestMethod.POST)
    public ResponseEntity<?> createCity(@RequestParam long userId,
                                        @RequestParam String city,
                                        @RequestParam String country) {

        CityWSModel response = configUtilsMiddleware.createCity(userId,city,country);

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

        CityWSModel response = configUtilsMiddleware.updateCity(userId,cityId,city,country);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_CITY, method = RequestMethod.POST)
    public ResponseEntity<?> removeCity(@RequestParam long userId,
                                        @RequestParam long cityId) {

        CityWSModel response = configUtilsMiddleware.removeCity(userId,cityId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_ALL_COUNTRIES, method = RequestMethod.POST)
    public ResponseEntity<?> getAllCountries(@RequestParam long userId) {

        CountryWSModel response = configUtilsMiddleware.getAllCountries(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_COUNTRY, method = RequestMethod.POST)
    public ResponseEntity<?> getCountry(@RequestParam long userId,
                                        @RequestParam long countryId) {

        CountryWSModel response = configUtilsMiddleware.getCountry(userId,countryId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_COUNTRY, method = RequestMethod.POST)
    public ResponseEntity<?> createCountry(@RequestParam long userId,
                                           @RequestParam String country) {

        CountryWSModel response = configUtilsMiddleware.createCountry(userId,country);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_COUNTRY, method = RequestMethod.POST)
    public ResponseEntity<?> updateCountry(@RequestParam long userId,
                                           @RequestParam long countryId,
                                           @RequestParam String country) {

        CountryWSModel response = configUtilsMiddleware.updateCountry(userId,countryId,country);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_COUNTRY, method = RequestMethod.POST)
    public ResponseEntity<?> removeCountry(@RequestParam long userId,
                                           @RequestParam long countryId) {

        CountryWSModel response = configUtilsMiddleware.removeCountry(userId, countryId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_ALL_URLS, method = RequestMethod.POST)
    public ResponseEntity<?> getAllUrls(@RequestParam long userId) {

        UrlWSModel response = configUtilsMiddleware.getAllUrls(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_URLS_BY_BASE_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> getUrlsByBaseType(@RequestParam long userId,
                                               @RequestParam String baseType) {

        UrlWSModel response = configUtilsMiddleware.getUrlsByBaseType(userId,baseType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_URLS_BY_OWNER_ID, method = RequestMethod.POST)
    public ResponseEntity<?> getUrlsByOwnerId(@RequestParam long userId,
                                              @RequestParam String baseType,
                                              @RequestParam String ownerId) {

        UrlWSModel response = configUtilsMiddleware.getUrlsByOwnerId(userId,baseType,ownerId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_URL, method = RequestMethod.POST)
    public ResponseEntity<?> getUrl(@RequestParam long userId,
                                    @RequestParam long urlId) {

        UrlWSModel response = configUtilsMiddleware.getUrl(userId,urlId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_URL, method = RequestMethod.POST)
    public ResponseEntity<?> createUrl(@RequestParam long userId,
                                       @RequestParam String url,
                                       @RequestParam String urlType,
                                       @RequestParam String baseType,
                                       @RequestParam String ownerId) {

        UrlWSModel response = configUtilsMiddleware.createUrl(userId,url,urlType,baseType,ownerId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_URL, method = RequestMethod.POST)
    public ResponseEntity<?> updateUrl(@RequestParam long userId,
                                       @RequestParam long urlId,
                                       @RequestParam String url,
                                       @RequestParam String urlType,
                                       @RequestParam String ownerId) {

        UrlWSModel response = configUtilsMiddleware.updateUrl(userId,urlId,url,urlType,ownerId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_URL, method = RequestMethod.POST)
    public ResponseEntity<?> removeUrl(@RequestParam long userId,
                                       @RequestParam long urlId) {

        UrlWSModel response = configUtilsMiddleware.removeUrl(userId,urlId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
