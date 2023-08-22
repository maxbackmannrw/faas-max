package com.faas.core.base.middleware.utils.datatype;

import com.faas.core.base.framework.utils.datatype.UtilsDataTypeFramework;
import com.faas.core.base.model.db.utils.datatype.DataTypeDBModel;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.utils.datatype.DataTypeWSModel;
import com.faas.core.base.model.ws.utils.datatype.dto.DataTypeWSDTO;
import com.faas.core.base.repo.utils.datatype.DataTypeRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class UtilsDataTypeMiddleware {


    @Autowired
    UtilsDataTypeFramework utilsDataTypeFramework;

    @Autowired
    DataTypeRepository dataTypeRepository;

    @Autowired
    AppUtils appUtils;


    public DataTypeWSModel getAllDataTypes(long userId) {

        DataTypeWSModel response = new DataTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<DataTypeWSDTO> dataTypeWSDTOS = new ArrayList<>();

        List<DataTypeDBModel> dataTypeDBModels = dataTypeRepository.findByStatus(1);
        if (dataTypeDBModels.size() > 0) {
            for (DataTypeDBModel dataTypeDBModel : dataTypeDBModels) {
                dataTypeWSDTOS.add(utilsDataTypeFramework.fillDataTypeWSDTO(dataTypeDBModel));
            }
        }

        response.setDataTypes(dataTypeWSDTOS);
        general.setOperation("getAllDataTypes");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public DataTypeWSModel getBaseDataTypes(long userId, String baseType) {

        DataTypeWSModel response = new DataTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<DataTypeWSDTO> dataTypeWSDTOS = new ArrayList<>();

        List<DataTypeDBModel> dataTypeDBModels = dataTypeRepository.findByBaseType(baseType);
        if (dataTypeDBModels.size() > 0) {
            for (DataTypeDBModel dataTypeDBModel : dataTypeDBModels) {
                dataTypeWSDTOS.add(utilsDataTypeFramework.fillDataTypeWSDTO(dataTypeDBModel));
            }
        }

        response.setDataTypes(dataTypeWSDTOS);
        general.setOperation("getBaseDataTypes");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public DataTypeWSModel getDataType(long userId, long typeId) {

        DataTypeWSModel response = new DataTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<DataTypeWSDTO> dataTypeWSDTOS = new ArrayList<>();

        Optional<DataTypeDBModel> dataTypeDBModel = dataTypeRepository.findById(typeId);
        if (dataTypeDBModel.isPresent()) {
            dataTypeWSDTOS.add(utilsDataTypeFramework.fillDataTypeWSDTO(dataTypeDBModel.get()));
        }

        response.setDataTypes(dataTypeWSDTOS);
        general.setOperation("getDataType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public DataTypeWSModel createDataType(long userId,String dataType,String baseType) {

        DataTypeWSModel response = new DataTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<DataTypeWSDTO> dataTypeWSDTOS = new ArrayList<>();

        DataTypeDBModel dataTypeDBModel = utilsDataTypeFramework.createDataTypeService(dataType,baseType);
        if (dataTypeDBModel != null) {
            dataTypeWSDTOS.add(utilsDataTypeFramework.fillDataTypeWSDTO(dataTypeDBModel));
        }

        response.setDataTypes(dataTypeWSDTOS);
        general.setOperation("createDataType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public DataTypeWSModel updateDataType(long userId,long typeId,String dataType,String baseType) {

        DataTypeWSModel response = new DataTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<DataTypeWSDTO> dataTypeWSDTOS = new ArrayList<>();

        DataTypeDBModel dataTypeDBModel = utilsDataTypeFramework.updateDataTypeService(typeId,dataType,baseType);
        if (dataTypeDBModel != null) {
            dataTypeWSDTOS.add(utilsDataTypeFramework.fillDataTypeWSDTO(dataTypeDBModel));
        }

        response.setDataTypes(dataTypeWSDTOS);
        general.setOperation("updateDataType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public DataTypeWSModel removeDataType(long userId,long typeId) {

        DataTypeWSModel response = new DataTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<DataTypeWSDTO> dataTypeWSDTOS = new ArrayList<>();

        DataTypeDBModel dataTypeDBModel = utilsDataTypeFramework.removeDataTypeService(typeId);
        if (dataTypeDBModel != null) {
            dataTypeWSDTOS.add(utilsDataTypeFramework.fillDataTypeWSDTO(dataTypeDBModel));
        }

        response.setDataTypes(dataTypeWSDTOS);
        general.setOperation("removeDataType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
