package com.faas.core.data.ws.base.client.content.dto;

public class CreateClientRequestDTO {

    private long userId;
    private String clientName;
    private String nationalId;
    private String phoneNumber;
    private String emailAddress;
    private String clientCity;
    private String clientCountry;
    private String clientType;

    public CreateClientRequestDTO() {
    }

    public CreateClientRequestDTO(long userId, String clientName, String nationalId, String phoneNumber, String emailAddress, String clientCity, String clientCountry, String clientType) {
        this.userId = userId;
        this.clientName = clientName;
        this.nationalId = nationalId;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.clientCity = clientCity;
        this.clientCountry = clientCountry;
        this.clientType = clientType;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getClientCity() {
        return clientCity;
    }

    public void setClientCity(String clientCity) {
        this.clientCity = clientCity;
    }

    public String getClientCountry() {
        return clientCountry;
    }

    public void setClientCountry(String clientCountry) {
        this.clientCountry = clientCountry;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }
}
