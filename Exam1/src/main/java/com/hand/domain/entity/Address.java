package com.hand.domain.entity;

import javax.persistence.Id;
import java.util.Date;

public class Address {

    @Id
    private Integer addressId;

    private String address;

    private String district;

    private Integer cityId;

    private String postalCode;

    private String phone;

    private Date lastUpdate;

    public Address() {
    }

    public Address(String address) {
        this.address = address;
    }

    public Address(Integer addressId, String address, String district, Integer cityId, String postalCode, String phone, Date lastUpdate) {
        this.addressId = addressId;
        this.address = address;
        this.district = district;
        this.cityId = cityId;
        this.postalCode = postalCode;
        this.phone = phone;
        this.lastUpdate = lastUpdate;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
