package com.faas.core.base.model.db.common;

public class PositionValueDAO {

    private String valueId;
    private long valueTypeId;
    private String valueType;
    private String baseType;
    private String value;


    public PositionValueDAO() {
    }

    public PositionValueDAO(String valueId, long valueTypeId, String valueType, String baseType, String value) {
        this.valueId = valueId;
        this.valueTypeId = valueTypeId;
        this.valueType = valueType;
        this.baseType = baseType;
        this.value = value;
    }

    public String getValueId() {
        return valueId;
    }

    public void setValueId(String valueId) {
        this.valueId = valueId;
    }

    public long getValueTypeId() {
        return valueTypeId;
    }

    public void setValueTypeId(long valueTypeId) {
        this.valueTypeId = valueTypeId;
    }

    public String getValueType() {
        return valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }

    public String getBaseType() {
        return baseType;
    }

    public void setBaseType(String baseType) {
        this.baseType = baseType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

