package com.robosh.model.entity;

import com.robosh.model.entity.enums.DriverStatus;
import com.robosh.model.entity.enums.Role;

import java.util.Objects;

public class Driver extends Person {
    private DriverStatus driverStatus;
    private Car car;
    private String middleName;

    public Driver() {
        this.role = Role.DRIVER;
    }

    public com.robosh.model.entity.Car getCar() {
        return car;
    }

    public void setCar(com.robosh.model.entity.Car car) {
        this.car = car;
    }

    public DriverStatus getDriverStatus() {
        return driverStatus;
    }

    public void setDriverStatus(DriverStatus driverStatus) {
        this.driverStatus = driverStatus;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "driverStatus=" + driverStatus +
                ", car=" + car +
                ", middleName='" + middleName + '\'' +
                ", personId=" + personId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Driver)) return false;
        if (!super.equals(o)) return false;
        Driver driver = (Driver) o;
        return getDriverStatus() == driver.getDriverStatus() && Objects.equals(getCar(),
                driver.getCar()) && Objects.equals(getMiddleName(), driver.getMiddleName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getDriverStatus(), getCar(), getMiddleName());
    }
}
