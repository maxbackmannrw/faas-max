package com.faas.core.data.ws.base.utilz.config.dto;

import com.faas.core.data.db.utilz.DataTypeDBModel;


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
