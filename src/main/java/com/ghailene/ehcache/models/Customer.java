package com.ghailene.ehcache.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Customer implements Serializable {
    private String cin;
    private String firstname;
    private String lastName;

    private ContactInformation contact;
    private Date birthdate;

    public Customer(String cin, String firstname, String lastName, ContactInformation contact, Date birthdate) {
        this.cin = cin;
        this.firstname = firstname;
        this.lastName = lastName;
        this.contact = contact;
        this.birthdate = birthdate;
    }


    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        cin = cin;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ContactInformation getContact() {
        return contact;
    }

    public void setContact(ContactInformation contact) {
        this.contact = contact;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }
}
