package com.robosh.model.entity;

import com.robosh.model.entity.enums.Role;

import java.util.Objects;

public abstract class Person {
    protected int personId;
    protected String name;
    protected String surname;
    protected String password;
    protected String phoneNumber;
    protected Role role;

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return getPersonId() == person.getPersonId() &&
                Objects.equals(getName(), person.getName()) &&
                Objects.equals(getSurname(), person.getSurname()) &&
                Objects.equals(getPassword(), person.getPassword()) &&
                Objects.equals(getPhoneNumber(), person.getPhoneNumber()) &&
                getRole() == person.getRole();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPersonId(), getName(), getSurname(), getPassword(), getPhoneNumber(), getRole());
    }
}
