package com.faas.core.base.endpoint.controller.utils.content;

import com.faas.core.base.middleware.utils.content.UtilsContentMiddleware;
import com.faas.core.base.model.ws.utils.content.ContentTypeWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/utils/content/")
public class UtilsContentController {


    @Autowired
    UtilsContentMiddleware utilsContentMiddleware;


    @RequestMapping(value = BaseRoute.GET_ALL_CONTENT_TYPES, method = RequestMethod.POST)
    public ResponseEntity<?> getAllContentTypes(@RequestParam long userId) {

        ContentTypeWSModel response = utilsContentMiddleware.getAllContentTypes(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_CONTENT_TYPES_BY_BASE_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> getContentTypesByBaseType(@RequestParam long userId,
                                                       @RequestParam String baseType) {

        ContentTypeWSModel response = utilsContentMiddleware.getContentTypesByBaseType(userId,baseType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_CONTENT_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> getContentType(@RequestParam long userId,
                                            @RequestParam long typeId) {

        ContentTypeWSModel response = utilsContentMiddleware.getContentType(userId,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_CONTENT_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> createContentType(@RequestParam long userId,
                                               @RequestParam String contentType,
                                               @RequestParam String baseType) {

        ContentTypeWSModel response = utilsContentMiddleware.createContentType(userId,contentType,baseType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_CONTENT_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> updateContentType(@RequestParam long userId,
                                               @RequestParam long typeId,
                                               @RequestParam String contentType,
                                               @RequestParam String baseType) {

        ContentTypeWSModel response = utilsContentMiddleware.updateContentType(userId,typeId,contentType,baseType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_CONTENT_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> removeContentType(@RequestParam long userId,
                                               @RequestParam long typeId) {

        ContentTypeWSModel response = utilsContentMiddleware.removeContentType(userId, typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
