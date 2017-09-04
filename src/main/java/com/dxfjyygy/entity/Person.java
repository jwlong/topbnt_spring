package com.dxfjyygy.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by longjinwen on 2017/3/17.
 */
public class Person implements Serializable {
    private Integer id;
    private String name;
    private Name nameObj;
    private Name name2;
    private Integer age;
    //    private Address address;
    private Set<Address> addresses = new HashSet<Address>();  //单向1 -N Person 1的一端
    public  Person(){};
    public Person(Integer id, String name, Name nameObj, Name name2, Integer age, Set<Address> addresses) {
        this.id = id;
        this.name = name;
        this.nameObj = nameObj;
        this.name2 = name2;
        this.age = age;
        this.addresses = addresses;
    }

    public Name getName2() {
        return name2;
    }

    public void setName2(Name name2) {
        this.name2 = name2;
    }

    public Name getNameObj() {
        return nameObj;
    }

    public void setNameObj(Name nameObj) {
        this.nameObj = nameObj;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
