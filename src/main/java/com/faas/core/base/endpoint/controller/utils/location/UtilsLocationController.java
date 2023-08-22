package com.faas.core.base.endpoint.controller.utils.location;

import com.faas.core.base.middleware.utils.location.UtilsLocationMiddleware;
import com.faas.core.base.model.ws.utils.location.CityWSModel;
import com.faas.core.base.model.ws.utils.location.CountryWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/utils/location/")
public class UtilsLocationController {


    @Autowired
    UtilsLocationMiddleware utilsLocationMiddleware;


    @RequestMapping(value = BaseRoute.GET_ALL_CITIES, method = RequestMethod.POST)
    public ResponseEntity<?> getAllCities(@RequestParam long userId) {

        CityWSModel response = utilsLocationMiddleware.getAllCities(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_CITY, method = RequestMethod.POST)
    public ResponseEntity<?> getCity(@RequestParam long userId,
                                     @RequestParam long cityId) {

        CityWSModel response = utilsLocationMiddleware.getCity(userId,cityId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_CITY, method = RequestMethod.POST)
    public ResponseEntity<?> createCity(@RequestParam long userId,
                                        @RequestParam String city,
                                        @RequestParam String country) {

        CityWSModel response = utilsLocationMiddleware.createCity(userId,city,country);

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

        CityWSModel response = utilsLocationMiddleware.updateCity(userId,cityId,city,country);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_CITY, method = RequestMethod.POST)
    public ResponseEntity<?> removeCity(@RequestParam long userId,
                                        @RequestParam long cityId) {

        CityWSModel response = utilsLocationMiddleware.removeCity(userId,cityId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = BaseRoute.GET_ALL_COUNTRIES, method = RequestMethod.POST)
    public ResponseEntity<?> getAllCountries(@RequestParam long userId) {

        CountryWSModel response = utilsLocationMiddleware.getAllCountries(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_COUNTRY, method = RequestMethod.POST)
    public ResponseEntity<?> getCountry(@RequestParam long userId,
                                        @RequestParam long countryId) {

        CountryWSModel response = utilsLocationMiddleware.getCountry(userId,countryId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_COUNTRY, method = RequestMethod.POST)
    public ResponseEntity<?> createCountry(@RequestParam long userId,
                                           @RequestParam String country) {

        CountryWSModel response = utilsLocationMiddleware.createCountry(userId,country);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_COUNTRY, method = RequestMethod.POST)
    public ResponseEntity<?> updateCountry(@RequestParam long userId,
                                           @RequestParam long countryId,
                                           @RequestParam String country) {

        CountryWSModel response = utilsLocationMiddleware.updateCountry(userId,countryId,country);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_COUNTRY, method = RequestMethod.POST)
    public ResponseEntity<?> removeCountry(@RequestParam long userId,
                                           @RequestParam long countryId) {

        CountryWSModel response = utilsLocationMiddleware.removeCountry(userId, countryId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
