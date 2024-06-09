package com.faas.core.base.endpoint.controller.dashboard.session;

import com.faas.core.base.middleware.dashboard.session.DashSessionMiddleware;
import com.faas.core.base.model.ws.dashboard.session.DashboardSessionWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/dashboard/session/")
public class DashSessionController {


    @Autowired
    DashSessionMiddleware dashSessionMiddleware;


    @RequestMapping(value = BaseRoute.GET_ALL_CLIENTS, method = RequestMethod.POST)
    public ResponseEntity<?> getDashboardSessions(@RequestParam long userId,
                                                   @RequestParam int reqPage,
                                                   @RequestParam int reqSize) {

        DashboardSessionWSModel response = dashSessionMiddleware.getDashboardSessions(userId,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
