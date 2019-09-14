package com.wiredbrain.friends.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class Friend {
    public Friend(@NotBlank String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Friend() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Generated value sends it to DB
    private int id;

    //Throw an error if there is no first name
    @NotBlank
    @JsonProperty("first-name")
    private String firstName;
    @JsonProperty("last-name")
    private String lastName;

    int age;

    @JsonIgnore
    boolean married;

    //Since we want a list of addresses
    @OneToMany(cascade = CascadeType.ALL)
    List<Address> addresses;

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
    //    @Embedded
//    Address address;
//
//    public Address getAddress() {
//        return address;
//    }
//
//    public void setAddress(Address address) {
//        this.address = address;
//    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
