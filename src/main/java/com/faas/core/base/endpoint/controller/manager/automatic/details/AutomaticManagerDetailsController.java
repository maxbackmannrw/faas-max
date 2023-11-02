package com.faas.core.base.endpoint.controller.manager.automatic.details;

import com.faas.core.base.middleware.manager.automatic.details.AutomaticManagerDetailsMiddleware;
import com.faas.core.base.model.ws.manager.automatic.AutomaticOperationListWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/manager/automatic/details/")
public class AutomaticManagerDetailsController {


    @Autowired
    AutomaticManagerDetailsMiddleware automaticManagerDetailsMiddleware;


    @RequestMapping(value = BaseRoute.GET_AUTOMATIC_OPERATIONS, method = RequestMethod.POST)
    public ResponseEntity<?> getAutomaticOperations(@RequestParam long userId,
                                                    @RequestParam String sessionState,
                                                    @RequestParam int reqPage,
                                                    @RequestParam int reqSize) {

        AutomaticOperationListWSModel response = automaticManagerDetailsMiddleware.getAutomaticOperations(userId,sessionState,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
