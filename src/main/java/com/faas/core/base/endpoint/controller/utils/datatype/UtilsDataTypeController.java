package com.faas.core.base.endpoint.controller.utils.datatype;

import com.faas.core.base.middleware.utils.datatype.UtilsDataTypeMiddleware;
import com.faas.core.base.model.ws.utils.datatype.DataTypeWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/utils/datatype/")
public class UtilsDataTypeController {


    @Autowired
    UtilsDataTypeMiddleware utilsDataTypeMiddleware;


    @RequestMapping(value = BaseRoute.GET_ALL_DATA_TYPES, method = RequestMethod.POST)
    public ResponseEntity<?> getAllDataTypes(@RequestParam long userId) {

        DataTypeWSModel response = utilsDataTypeMiddleware.getAllDataTypes(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_BASE_DATA_TYPES, method = RequestMethod.POST)
    public ResponseEntity<?> getBaseDataTypes(@RequestParam long userId,
                                              @RequestParam String baseType) {

        DataTypeWSModel response = utilsDataTypeMiddleware.getBaseDataTypes(userId, baseType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_DATA_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> getDataType(@RequestParam long userId,
                                         @RequestParam long typeId) {

        DataTypeWSModel response = utilsDataTypeMiddleware.getDataType(userId, typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_DATA_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> createDataType(@RequestParam long userId,
                                            @RequestParam String dataType,
                                            @RequestParam String baseType) {

        DataTypeWSModel response = utilsDataTypeMiddleware.createDataType(userId,dataType,baseType);

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

        DataTypeWSModel response = utilsDataTypeMiddleware.updateDataType(userId,typeId,dataType,baseType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_DATA_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> removeDataType(@RequestParam long userId,
                                            @RequestParam long typeId) {

        DataTypeWSModel response = utilsDataTypeMiddleware.removeDataType(userId,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
