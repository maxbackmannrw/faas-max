package com.faas.core.base.model.ws.utils.config.dto;

import com.faas.core.data.db.utils.DataTypeDBModel;


public class DataTypeWSDTO {

    private DataTypeDBModel dataType;

    public DataTypeWSDTO() {
    }

    public DataTypeWSDTO(DataTypeDBModel dataType) {
        this.dataType = dataType;
    }

    public DataTypeDBModel getDataType() {
        return dataType;
    }

    public void setDataType(DataTypeDBModel dataType) {
        this.dataType = dataType;
    }
}
