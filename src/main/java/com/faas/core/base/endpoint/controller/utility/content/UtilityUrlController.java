package com.faas.core.base.endpoint.controller.utility.content;

import com.faas.core.base.middleware.utility.content.UtilityUrlMiddleware;
import com.faas.core.base.model.ws.utility.content.UrlWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/utility/url/")
public class UtilityUrlController {


    @Autowired
    UtilityUrlMiddleware utilityUrlMiddleware;


    @RequestMapping(value = BaseRoute.GET_ALL_URLS, method = RequestMethod.POST)
    public ResponseEntity<?> getAllUrls(@RequestParam long userId) {

        UrlWSModel response = utilityUrlMiddleware.getAllUrls(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_URLS_BY_BASE_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> getUrlsByBaseType(@RequestParam long userId,
                                               @RequestParam String baseType) {

        UrlWSModel response = utilityUrlMiddleware.getUrlsByBaseType(userId,baseType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_URLS_BY_OWNER_ID, method = RequestMethod.POST)
    public ResponseEntity<?> getUrlsByOwnerId(@RequestParam long userId,
                                              @RequestParam String baseType,
                                              @RequestParam String ownerId) {

        UrlWSModel response = utilityUrlMiddleware.getUrlsByOwnerId(userId,baseType,ownerId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_URL, method = RequestMethod.POST)
    public ResponseEntity<?> getUrl(@RequestParam long userId,
                                    @RequestParam long urlId) {

        UrlWSModel response = utilityUrlMiddleware.getUrl(userId,urlId);

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

        UrlWSModel response = utilityUrlMiddleware.createUrl(userId,url,urlType,baseType,ownerId);

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

        UrlWSModel response = utilityUrlMiddleware.updateUrl(userId,urlId,url,urlType,ownerId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_URL, method = RequestMethod.POST)
    public ResponseEntity<?> removeUrl(@RequestParam long userId,
                                       @RequestParam long urlId) {

        UrlWSModel response = utilityUrlMiddleware.removeUrl(userId,urlId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
