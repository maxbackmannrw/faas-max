package com.faas.core.base.model.ws.utilz.config;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.utilz.config.dto.DataTypeWSDTO;

import java.util.List;

public class DataTypeWSModel {

    private GeneralWSModel general;
    private List<DataTypeWSDTO> dataTypes;


    public DataTypeWSModel() {
    }

    public DataTypeWSModel(GeneralWSModel general, List<DataTypeWSDTO> dataTypes) {
        this.general = general;
        this.dataTypes = dataTypes;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<DataTypeWSDTO> getDataTypes() {
        return dataTypes;
    }

    public void setDataTypes(List<DataTypeWSDTO> dataTypes) {
        this.dataTypes = dataTypes;
    }
}
