package com.faas.core.base.framework.utils.datatype;

import com.faas.core.base.model.db.utils.datatype.DataTypeDBModel;
import com.faas.core.base.model.ws.utils.datatype.dto.DataTypeWSDTO;
import com.faas.core.base.repo.utils.datatype.DataTypeRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class UtilsDataTypeFramework {


    @Autowired
    DataTypeRepository dataTypeRepository;

    @Autowired
    AppUtils appUtils;


    public DataTypeWSDTO fillDataTypeWSDTO(DataTypeDBModel dataTypeDBModel) {

        DataTypeWSDTO dataTypeWSDTO = new DataTypeWSDTO();
        dataTypeWSDTO.setDataType(dataTypeDBModel);
        return dataTypeWSDTO;
    }


    public DataTypeDBModel createDataTypeService(String dataType,String baseType) {

        DataTypeDBModel dataTypeDBModel = new DataTypeDBModel();
        dataTypeDBModel.setDataType(dataType);
        dataTypeDBModel.setBaseType(baseType);
        dataTypeDBModel.setuDate(appUtils.getCurrentTimeStamp());
        dataTypeDBModel.setcDate(appUtils.getCurrentTimeStamp());
        dataTypeDBModel.setStatus(1);

        return dataTypeRepository.save(dataTypeDBModel);
    }

    public DataTypeDBModel updateDataTypeService(long typeId,String dataType,String baseType) {

        Optional<DataTypeDBModel> dataTypeDBModel = dataTypeRepository.findById(typeId);
        if (dataTypeDBModel.isPresent()) {
            dataTypeDBModel.get().setDataType(dataType);
            dataTypeDBModel.get().setBaseType(baseType);
            dataTypeDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            dataTypeDBModel.get().setStatus(1);
            return dataTypeRepository.save(dataTypeDBModel.get());
        }
        return null;
    }


    public DataTypeDBModel removeDataTypeService(long typeId) {

        Optional<DataTypeDBModel> dataTypeDBModel = dataTypeRepository.findById(typeId);
        if (dataTypeDBModel.isPresent()) {
            dataTypeRepository.delete(dataTypeDBModel.get());
            return dataTypeDBModel.get();
        }
        return null;
    }

}
