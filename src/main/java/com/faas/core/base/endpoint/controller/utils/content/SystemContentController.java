package com.faas.core.base.endpoint.controller.utils.content;

import com.faas.core.base.middleware.utils.content.SystemContentMiddleware;
import com.faas.core.base.model.ws.utils.content.SystemContentWSModel;
import com.faas.core.base.model.ws.utils.content.SystemInitWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/utils/content/")
public class SystemContentController {


    @Autowired
    SystemContentMiddleware systemContentMiddleware;


    @RequestMapping(value = BaseRoute.INIT_SYSTEM_CONTENT, method = RequestMethod.POST)
    public ResponseEntity<?> initSystemContent(@RequestParam String initType) {

        SystemInitWSModel response = systemContentMiddleware.initSystemContent(initType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_SYSTEM_CONTENTS, method = RequestMethod.POST)
    public ResponseEntity<?> getSystemContents(@RequestParam long userId) {

        SystemContentWSModel response = systemContentMiddleware.getSystemContents(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.RECOVER_SYSTEM_CONTENT, method = RequestMethod.POST)
    public ResponseEntity<?> recoverSystemContent(@RequestParam long userId,
                                                  @RequestParam String contentType) {

        SystemContentWSModel response = systemContentMiddleware.recoverSystemContent(userId,contentType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_SYSTEM_CONTENT, method = RequestMethod.POST)
    public ResponseEntity<?> removeSystemContent(@RequestParam long userId,
                                                 @RequestParam String contentType) {

        SystemContentWSModel response = systemContentMiddleware.removeSystemContent(userId,contentType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
