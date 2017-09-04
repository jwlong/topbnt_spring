package com.dxfjyygy.entity;

import java.io.Serializable;

/**
 * Hibernate N-1
 * this is 1
 * N is Person
 * Created by longjinwen on 2017/3/20.
 */
public class Address implements Serializable {
    private Integer addressId;
    private String addressDetail;
    private Person person;
    public  Address(){};
    public Address(String addressDetail){
        this.addressDetail = addressDetail;
    }
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }
}
