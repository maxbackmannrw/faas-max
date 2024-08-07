package com.faas.core.base.endpoint.controller.utils.config;

import com.faas.core.base.middleware.utils.config.SystemConfigMiddleware;
import com.faas.core.base.model.ws.utils.config.CityWSModel;
import com.faas.core.base.model.ws.utils.config.CountryWSModel;
import com.faas.core.base.model.ws.utils.config.DataTypeWSModel;
import com.faas.core.base.model.ws.utils.config.UrlWSModel;
import com.faas.core.utility.config.AppConstant;
import com.faas.core.utility.config.BaseRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/base/utils/config/")
public class SystemConfigController {


    @Autowired
    SystemConfigMiddleware systemConfigMiddleware;


    @RequestMapping(value = BaseRoute.GET_ALL_DATA_TYPES, method = RequestMethod.POST)
    public ResponseEntity<?> getAllDataTypes(@RequestParam long userId) {

        DataTypeWSModel response = systemConfigMiddleware.getAllDataTypes(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_BASE_DATA_TYPES, method = RequestMethod.POST)
    public ResponseEntity<?> getBaseDataTypes(@RequestParam long userId,
                                              @RequestParam String baseType) {

        DataTypeWSModel response = systemConfigMiddleware.getBaseDataTypes(userId, baseType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_DATA_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> getDataType(@RequestParam long userId,
                                         @RequestParam long typeId) {

        DataTypeWSModel response = systemConfigMiddleware.getDataType(userId, typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_DATA_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> createDataType(@RequestParam long userId,
                                            @RequestParam String dataType,
                                            @RequestParam String baseType) {

        DataTypeWSModel response = systemConfigMiddleware.createDataType(userId,dataType,baseType);

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

        DataTypeWSModel response = systemConfigMiddleware.updateDataType(userId,typeId,dataType,baseType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_DATA_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> removeDataType(@RequestParam long userId,
                                            @RequestParam long typeId) {

        DataTypeWSModel response = systemConfigMiddleware.removeDataType(userId,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = BaseRoute.GET_ALL_CITIES, method = RequestMethod.POST)
    public ResponseEntity<?> getAllCities(@RequestParam long userId) {

        CityWSModel response = systemConfigMiddleware.getAllCities(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_CITY, method = RequestMethod.POST)
    public ResponseEntity<?> getCity(@RequestParam long userId,
                                     @RequestParam long cityId) {

        CityWSModel response = systemConfigMiddleware.getCity(userId,cityId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_CITY, method = RequestMethod.POST)
    public ResponseEntity<?> createCity(@RequestParam long userId,
                                        @RequestParam String city,
                                        @RequestParam String country) {

        CityWSModel response = systemConfigMiddleware.createCity(userId,city,country);

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

        CityWSModel response = systemConfigMiddleware.updateCity(userId,cityId,city,country);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_CITY, method = RequestMethod.POST)
    public ResponseEntity<?> removeCity(@RequestParam long userId,
                                        @RequestParam long cityId) {

        CityWSModel response = systemConfigMiddleware.removeCity(userId,cityId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = BaseRoute.GET_ALL_COUNTRIES, method = RequestMethod.POST)
    public ResponseEntity<?> getAllCountries(@RequestParam long userId) {

        CountryWSModel response = systemConfigMiddleware.getAllCountries(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_COUNTRY, method = RequestMethod.POST)
    public ResponseEntity<?> getCountry(@RequestParam long userId,
                                        @RequestParam long countryId) {

        CountryWSModel response = systemConfigMiddleware.getCountry(userId,countryId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_COUNTRY, method = RequestMethod.POST)
    public ResponseEntity<?> createCountry(@RequestParam long userId,
                                           @RequestParam String country) {

        CountryWSModel response = systemConfigMiddleware.createCountry(userId,country);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_COUNTRY, method = RequestMethod.POST)
    public ResponseEntity<?> updateCountry(@RequestParam long userId,
                                           @RequestParam long countryId,
                                           @RequestParam String country) {

        CountryWSModel response = systemConfigMiddleware.updateCountry(userId,countryId,country);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_COUNTRY, method = RequestMethod.POST)
    public ResponseEntity<?> removeCountry(@RequestParam long userId,
                                           @RequestParam long countryId) {

        CountryWSModel response = systemConfigMiddleware.removeCountry(userId, countryId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = BaseRoute.GET_ALL_URLS, method = RequestMethod.POST)
    public ResponseEntity<?> getAllUrls(@RequestParam long userId) {

        UrlWSModel response = systemConfigMiddleware.getAllUrls(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_URLS_BY_BASE_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> getUrlsByBaseType(@RequestParam long userId,
                                               @RequestParam String baseType) {

        UrlWSModel response = systemConfigMiddleware.getUrlsByBaseType(userId,baseType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_URLS_BY_OWNER_ID, method = RequestMethod.POST)
    public ResponseEntity<?> getUrlsByOwnerId(@RequestParam long userId,
                                              @RequestParam String baseType,
                                              @RequestParam String ownerId) {

        UrlWSModel response = systemConfigMiddleware.getUrlsByOwnerId(userId,baseType,ownerId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_URL, method = RequestMethod.POST)
    public ResponseEntity<?> getUrl(@RequestParam long userId,
                                    @RequestParam long urlId) {

        UrlWSModel response = systemConfigMiddleware.getUrl(userId,urlId);

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

        UrlWSModel response = systemConfigMiddleware.createUrl(userId,url,urlType,baseType,ownerId);

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

        UrlWSModel response = systemConfigMiddleware.updateUrl(userId,urlId,url,urlType,ownerId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_URL, method = RequestMethod.POST)
    public ResponseEntity<?> removeUrl(@RequestParam long userId,
                                       @RequestParam long urlId) {

        UrlWSModel response = systemConfigMiddleware.removeUrl(userId,urlId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
