package com.faas.core.base.model.ws.utils.config.dto;

import com.faas.core.data.db.utils.CountryDBModel;

public class CountryWSDTO {

    private CountryDBModel country;

    public CountryWSDTO() {
    }

    public CountryWSDTO(CountryDBModel country) {
        this.country = country;
    }

    public CountryDBModel getCountry() {
        return country;
    }

    public void setCountry(CountryDBModel country) {
        this.country = country;
    }
}
