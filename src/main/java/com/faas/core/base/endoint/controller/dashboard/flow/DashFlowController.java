package com.faas.core.base.endoint.controller.dashboard.flow;

import com.faas.core.base.middleware.dashboard.flow.DashFlowMiddleware;
import com.faas.core.base.model.ws.dashboard.flow.DashboardFlowWSModel;
import com.faas.core.misc.config.AppConstant;
import com.faas.core.misc.config.BaseRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/base/dashboard/flow/")
public class DashFlowController {


    @Autowired
    DashFlowMiddleware dashFlowMiddleware;


    @RequestMapping(value = BaseRoute.GET_ALL_CLIENTS, method = RequestMethod.POST)
    public ResponseEntity<?> getDashboardFlows(@RequestParam long userId,
                                               @RequestParam int reqPage,
                                               @RequestParam int reqSize) {

        DashboardFlowWSModel response = dashFlowMiddleware.getDashboardFlows(userId, reqPage, reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
