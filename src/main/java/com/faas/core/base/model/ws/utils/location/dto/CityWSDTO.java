package com.faas.core.base.model.ws.utils.location.dto;

import com.faas.core.base.model.db.utils.location.CityDBModel;

public class CityWSDTO {

   private CityDBModel city;

    public CityWSDTO() {
    }

    public CityWSDTO(CityDBModel city) {
        this.city = city;
    }

    public CityDBModel getCity() {
        return city;
    }

    public void setCity(CityDBModel city) {
        this.city = city;
    }
}
